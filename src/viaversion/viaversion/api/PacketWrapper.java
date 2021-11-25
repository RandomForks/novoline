package viaversion.viaversion.api;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import net.a66;
import viaversion.viaversion.api.Pair;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;
import viaversion.viaversion.exception.CancelException;
import viaversion.viaversion.exception.InformativeException;
import viaversion.viaversion.packets.Direction;
import viaversion.viaversion.util.PipelineUtil;

public class PacketWrapper {
   public static final int PASSTHROUGH_ID = 1000;
   private static final Protocol[] PROTOCOL_ARRAY = new Protocol[0];
   private final ByteBuf inputBuffer;
   private final UserConnection userConnection;
   private boolean send;
   private int id;
   private final LinkedList readableObjects;
   private final List packetValues;
   private static boolean h;

   public PacketWrapper(int var1, ByteBuf var2, UserConnection var3) {
      k();
      super();
      this.send = true;
      this.id = -1;
      this.readableObjects = new LinkedList();
      this.packetValues = new ArrayList();
      this.id = var1;
      this.inputBuffer = var2;
      this.userConnection = var3;
   }

   public Object get(Type var1, int var2) throws Exception {
      f();
      int var4 = 0;
      Iterator var5 = this.packetValues.iterator();
      if(var5.hasNext()) {
         Pair var6 = (Pair)var5.next();
         if(var6.getKey() == var1) {
            if(var4 == var2) {
               return var6.getValue();
            }

            ++var4;
         }
      }

      ArrayIndexOutOfBoundsException var8 = new ArrayIndexOutOfBoundsException("Could not find type " + var1.getTypeName() + " at " + var2);
      throw (new InformativeException(var8)).set("Type", var1.getTypeName()).set("Index", Integer.valueOf(var2)).set("Packet ID", Integer.valueOf(this.getId())).set("Data", this.packetValues);
   }

   public boolean is(Type var1, int var2) {
      k();
      int var4 = 0;
      Iterator var5 = this.packetValues.iterator();
      if(var5.hasNext()) {
         Pair var6 = (Pair)var5.next();
         if(var6.getKey() == var1) {
            if(var4 == var2) {
               return true;
            }

            ++var4;
         }
      }

      return false;
   }

   public boolean isReadable(Type var1, int var2) {
      f();
      int var4 = 0;
      Iterator var5 = this.readableObjects.iterator();
      if(var5.hasNext()) {
         Pair var6 = (Pair)var5.next();
         if(((Type)var6.getKey()).getBaseClass() == var1.getBaseClass()) {
            if(var4 == var2) {
               return true;
            }

            ++var4;
         }
      }

      return false;
   }

   public void set(Type var1, int var2, Object var3) throws Exception {
      f();
      int var5 = 0;
      Iterator var6 = this.packetValues.iterator();
      if(var6.hasNext()) {
         Pair var7 = (Pair)var6.next();
         if(var7.getKey() == var1) {
            if(var5 == var2) {
               var7.setValue(var3);
               return;
            }

            ++var5;
         }
      }

      ArrayIndexOutOfBoundsException var9 = new ArrayIndexOutOfBoundsException("Could not find type " + var1.getTypeName() + " at " + var2);
      throw (new InformativeException(var9)).set("Type", var1.getTypeName()).set("Index", Integer.valueOf(var2)).set("Packet ID", Integer.valueOf(this.getId()));
   }

   public Object read(Type var1) throws Exception {
      boolean var2 = f();
      if(var1 == Type.NOTHING) {
         return null;
      } else if(this.readableObjects.isEmpty()) {
         Preconditions.checkNotNull(this.inputBuffer, "This packet does not have an input buffer.");

         try {
            return var1.read(this.inputBuffer);
         } catch (Exception var6) {
            throw (new InformativeException(var6)).set("Type", var1.getTypeName()).set("Packet ID", Integer.valueOf(this.getId())).set("Data", this.packetValues);
         }
      } else {
         Pair var3 = (Pair)this.readableObjects.poll();
         Type var4 = (Type)var3.getKey();
         if(!var4.equals(var1) && (!var1.getBaseClass().equals(var4.getBaseClass()) || !var1.getOutputClass().equals(var4.getOutputClass()))) {
            if(var4 == Type.NOTHING) {
               return this.read(var1);
            } else {
               IOException var5 = new IOException("Unable to read type " + var1.getTypeName() + ", found " + ((Type)var3.getKey()).getTypeName());
               throw (new InformativeException(var5)).set("Type", var1.getTypeName()).set("Packet ID", Integer.valueOf(this.getId())).set("Data", this.packetValues);
            }
         } else {
            return var3.getValue();
         }
      }
   }

   public void write(Type var1, Object var2) {
      boolean var3 = k();
      if(!var1.getOutputClass().isAssignableFrom(var2.getClass())) {
         if(var1 instanceof TypeConverter) {
            var2 = ((TypeConverter)var1).from(var2);
         }

         Via.getPlatform().getLogger().warning("Possible type mismatch: " + var2.getClass().getName() + " -> " + var1.getOutputClass());
      }

      this.packetValues.add(new Pair(var1, var2));
   }

   public Object passthrough(Type var1) throws Exception {
      Object var2 = this.read(var1);
      this.write(var1, var2);
      return var2;
   }

   public void passthroughAll() throws Exception {
      f();
      this.packetValues.addAll(this.readableObjects);
      this.readableObjects.clear();
      if(this.inputBuffer.readableBytes() > 0) {
         this.passthrough(Type.REMAINING_BYTES);
      }

   }

   public void writeToBuffer(ByteBuf var1) throws Exception {
      boolean var2 = k();
      if(this.id != -1) {
         Type.VAR_INT.writePrimitive(var1, this.id);
      }

      if(!this.readableObjects.isEmpty()) {
         this.packetValues.addAll(this.readableObjects);
         this.readableObjects.clear();
      }

      int var3 = 0;
      Iterator var4 = this.packetValues.iterator();
      if(var4.hasNext()) {
         Pair var5 = (Pair)var4.next();

         try {
            Object var6 = var5.getValue();
            if(var6 != null && !((Type)var5.getKey()).getOutputClass().isAssignableFrom(var6.getClass())) {
               if(var5.getKey() instanceof TypeConverter) {
                  var6 = ((TypeConverter)var5.getKey()).from(var6);
               }

               Via.getPlatform().getLogger().warning("Possible type mismatch: " + var6.getClass().getName() + " -> " + ((Type)var5.getKey()).getOutputClass());
            }

            ((Type)var5.getKey()).write(var1, var6);
         } catch (Exception var7) {
            throw (new InformativeException(var7)).set("Index", Integer.valueOf(var3)).set("Type", ((Type)var5.getKey()).getTypeName()).set("Packet ID", Integer.valueOf(this.getId())).set("Data", this.packetValues);
         }

         ++var3;
      }

      this.writeRemaining(var1);
   }

   public void clearInputBuffer() {
      boolean var1 = k();
      if(this.inputBuffer != null) {
         this.inputBuffer.clear();
      }

      this.readableObjects.clear();
   }

   public void clearPacket() {
      this.clearInputBuffer();
      this.packetValues.clear();
   }

   private void writeRemaining(ByteBuf var1) {
      boolean var2 = k();
      if(this.inputBuffer != null) {
         var1.writeBytes(this.inputBuffer, this.inputBuffer.readableBytes());
      }

   }

   public void send(Class var1, boolean var2) throws Exception {
      this.send(var1, var2, false);
   }

   public void send(Class var1, boolean var2, boolean var3) throws Exception {
      boolean var4 = k();
      if(!this.isCancelled()) {
         try {
            ByteBuf var5 = this.constructPacket(var1, var2, Direction.OUTGOING);
            this.user().sendRawPacket(var5, var3);
         } catch (Exception var6) {
            if(!PipelineUtil.containsCause(var6, CancelException.class)) {
               throw var6;
            }
         }
      }

   }

   private ByteBuf constructPacket(Class var1, boolean var2, Direction var3) throws Exception {
      k();
      Protocol[] var5 = (Protocol[])this.user().getProtocolInfo().getPipeline().pipes().toArray(PROTOCOL_ARRAY);
      boolean var6 = var3 == Direction.OUTGOING;
      int var7 = -1;
      int var8 = 0;
      if(var8 < var5.length) {
         if(var5[var8].getClass() == var1) {
            var7 = var8;
         }

         ++var8;
      }

      if(var7 == -1) {
         throw new NoSuchElementException(var1.getCanonicalName());
      } else {
         if(var2) {
            var7 = var6?var7 - 1:var7 + 1;
         }

         this.resetReader();
         this.a(var3, this.user().getProtocolInfo().e(), var7, var5, var6);
         ByteBuf var10 = this.inputBuffer == null?this.user().getChannel().alloc().buffer():this.inputBuffer.alloc().buffer();
         this.writeToBuffer(var10);
         return var10;
      }
   }

   public void send(Class var1) throws Exception {
      this.send(var1, true);
   }

   public ChannelFuture sendFuture(Class var1) throws Exception {
      boolean var2 = f();
      if(!this.isCancelled()) {
         ByteBuf var3 = this.constructPacket(var1, true, Direction.OUTGOING);
         return this.user().sendRawPacketFuture(var3);
      } else {
         return this.user().getChannel().newFailedFuture(new Exception("Cancelled packet"));
      }
   }

   /** @deprecated */
   @Deprecated
   public void j() throws Exception {
      boolean var1 = f();
      if(!this.isCancelled()) {
         ByteBuf var2 = this.inputBuffer == null?this.user().getChannel().alloc().buffer():this.inputBuffer.alloc().buffer();
         this.writeToBuffer(var2);
         this.user().sendRawPacket(var2);
      }

   }

   public PacketWrapper create(int var1) {
      return new PacketWrapper(var1, (ByteBuf)null, this.user());
   }

   public PacketWrapper create(int var1, ValueCreator var2) throws Exception {
      PacketWrapper var3 = this.create(var1);
      var2.write(var3);
      return var3;
   }

   public PacketWrapper a(Direction var1, a66 var2, int var3, List var4, boolean var5) throws Exception {
      k();
      Protocol[] var7 = (Protocol[])var4.toArray(PROTOCOL_ARRAY);
      return this.a(var1, var2, var5?var7.length - 1:var3, var7, var5);
   }

   public PacketWrapper a(Direction var1, a66 var2, int var3, List var4) throws Exception {
      return this.a(var1, var2, var3, (Protocol[])var4.toArray(PROTOCOL_ARRAY), false);
   }

   private PacketWrapper a(Direction var1, a66 var2, int var3, Protocol[] var4, boolean var5) throws Exception {
      boolean var6 = f();
      if(var5) {
         var4[var3].a(var1, var2, this);
         this.resetReader();
         int var7 = var3 - 1;
      }

      if(var3 < var4.length) {
         var4[var3].a(var1, var2, this);
         this.resetReader();
         int var8 = var3 + 1;
      }

      return this;
   }

   public void cancel() {
      this.send = false;
   }

   public boolean isCancelled() {
      boolean var1 = f();
      return !this.send;
   }

   public UserConnection user() {
      return this.userConnection;
   }

   public void resetReader() {
      this.packetValues.addAll(this.readableObjects);
      this.readableObjects.clear();
      this.readableObjects.addAll(this.packetValues);
      this.packetValues.clear();
   }

   /** @deprecated */
   @Deprecated
   public void g() throws Exception {
      boolean var1 = f();
      if(!this.isCancelled()) {
         ByteBuf var2 = this.inputBuffer == null?this.user().getChannel().alloc().buffer():this.inputBuffer.alloc().buffer();
         this.writeToBuffer(var2);
         this.user().sendRawPacketToServer(var2, true);
      }

   }

   public void sendToServer(Class var1, boolean var2, boolean var3) throws Exception {
      boolean var4 = k();
      if(!this.isCancelled()) {
         try {
            ByteBuf var5 = this.constructPacket(var1, var2, Direction.INCOMING);
            this.user().sendRawPacketToServer(var5, var3);
         } catch (Exception var6) {
            if(!PipelineUtil.containsCause(var6, CancelException.class)) {
               throw var6;
            }
         }
      }

   }

   public void sendToServer(Class var1, boolean var2) throws Exception {
      this.sendToServer(var1, var2, false);
   }

   public void sendToServer(Class var1) throws Exception {
      this.sendToServer(var1, true);
   }

   public int getId() {
      return this.id;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public String toString() {
      return "PacketWrapper{packetValues=" + this.packetValues + ", readableObjects=" + this.readableObjects + ", id=" + this.id + '}';
   }

   static {
      b(true);
   }

   public static void b(boolean var0) {
      h = var0;
   }

   public static boolean f() {
      return h;
   }

   public static boolean k() {
      boolean var0 = f();
      return true;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
