package viaversion.viaversion.api.protocol;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Level;
import net.JL;
import net.a66;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingData;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.PacketType;
import viaversion.viaversion.api.protocol.Protocol$1;
import viaversion.viaversion.api.protocol.Protocol$2;
import viaversion.viaversion.api.protocol.Protocol$Packet;
import viaversion.viaversion.api.protocol.Protocol$ProtocolPacket;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.exception.InformativeException;
import viaversion.viaversion.packets.Direction;

public abstract class Protocol {
   private final Map incoming;
   private final Map outgoing;
   private final Map storedObjects;
   protected final Class oldClientboundPacketEnum;
   protected final Class newClientboundPacketEnum;
   protected final Class oldServerboundPacketEnum;
   protected final Class newServerboundPacketEnum;
   private static acE[] g;

   protected Protocol() {
      this((Class)null, (Class)null, (Class)null, (Class)null);
   }

   protected Protocol(@Nullable Class var1, @Nullable Class var2, @Nullable Class var3, @Nullable Class var4) {
      this.incoming = new HashMap();
      this.outgoing = new HashMap();
      this.storedObjects = new HashMap();
      this.oldClientboundPacketEnum = var1;
      this.newClientboundPacketEnum = var2;
      this.oldServerboundPacketEnum = var3;
      this.newServerboundPacketEnum = var4;
      this.registerPackets();
      if(var1 != var2) {
         this.registerOutgoingChannelIdChanges();
      }

      if(var3 != var4) {
         this.registerIncomingChannelIdChanges();
      }

   }

   protected void registerOutgoingChannelIdChanges() {
      ClientboundPacketType[] var1 = (ClientboundPacketType[])this.newClientboundPacketEnum.getEnumConstants();
      HashMap var2 = new HashMap(var1.length);

      for(ClientboundPacketType var6 : var1) {
         var2.put(var6.name(), var6);
      }

      for(ClientboundPacketType var12 : (ClientboundPacketType[])this.oldClientboundPacketEnum.getEnumConstants()) {
         ClientboundPacketType var7 = (ClientboundPacketType)var2.get(var12.name());
         int var8 = var12.ordinal();
         Preconditions.checkArgument(this.a(a66.PLAY, var8), "Packet " + var12 + " in " + this.getClass().getCanonicalName() + " has no mapping - it needs to be manually cancelled or remapped!");
      }

   }

   protected void registerIncomingChannelIdChanges() {
      ServerboundPacketType[] var1 = (ServerboundPacketType[])this.oldServerboundPacketEnum.getEnumConstants();
      HashMap var2 = new HashMap(var1.length);

      for(ServerboundPacketType var6 : var1) {
         var2.put(var6.name(), var6);
      }

      for(ServerboundPacketType var12 : (ServerboundPacketType[])this.newServerboundPacketEnum.getEnumConstants()) {
         ServerboundPacketType var7 = (ServerboundPacketType)var2.get(var12.name());
         int var8 = var12.ordinal();
         Preconditions.checkArgument(this.b(a66.PLAY, var8), "Packet " + var12 + " in " + this.getClass().getCanonicalName() + " has no mapping - it needs to be manually cancelled or remapped!");
      }

   }

   public boolean isFiltered(Class var1) {
      return false;
   }

   protected void filterPacket(UserConnection var1, Object var2, List var3) throws Exception {
      var3.add(var2);
   }

   protected void registerPackets() {
   }

   protected final void loadMappingData() {
      this.getMappingData().load();
      this.onMappingDataLoaded();
   }

   protected void onMappingDataLoaded() {
   }

   protected void a(JL var1) {
   }

   public void init(UserConnection var1) {
   }

   public void a(a66 var1, int var2, int var3) {
      this.a(var1, var2, var3, (acE)null);
   }

   public void a(a66 var1, int var2, int var3, acE var4) {
      this.b(var1, var2, var3, var4, false);
   }

   public void b(a66 var1, int var2, int var3, acE var4, boolean var5) {
      Protocol$ProtocolPacket var6 = new Protocol$ProtocolPacket(var1, var2, var3, var4);
      Protocol$Packet var7 = new Protocol$Packet(var1, var3);
      if(this.incoming.containsKey(var7)) {
         Via.getPlatform().getLogger().log(Level.WARNING, var7 + " already registered! If this override is intentional, set override to true. Stacktrace: ", new Exception());
      }

      this.incoming.put(var7, var6);
   }

   public void d(a66 var1, int var2, int var3) {
      this.a(var1, var2, var3, new Protocol$1(this));
   }

   public void c(a66 var1, int var2) {
      this.d(var1, -1, var2);
   }

   public void c(a66 var1, int var2, int var3) {
      this.b(var1, var2, var3, (acE)null);
   }

   public void b(a66 var1, int var2, int var3, acE var4) {
      this.a(var1, var2, var3, var4, false);
   }

   public void b(a66 var1, int var2, int var3) {
      this.b(var1, var2, var3, new Protocol$2(this));
   }

   public void d(a66 var1, int var2) {
      this.b(var1, var2, -1);
   }

   public void a(a66 var1, int var2, int var3, acE var4, boolean var5) {
      Protocol$ProtocolPacket var6 = new Protocol$ProtocolPacket(var1, var2, var3, var4);
      Protocol$Packet var7 = new Protocol$Packet(var1, var2);
      if(this.outgoing.containsKey(var7)) {
         Via.getPlatform().getLogger().log(Level.WARNING, var7 + " already registered! If override is intentional, set override to true. Stacktrace: ", new Exception());
      }

      this.outgoing.put(var7, var6);
   }

   public void a(ClientboundPacketType var1, @Nullable acE var2) {
      acE[] var3 = h();
      this.checkPacketType(var1, var1.getClass() == this.oldClientboundPacketEnum);
      ClientboundPacketType var4 = this.oldClientboundPacketEnum == this.newClientboundPacketEnum?var1:(ClientboundPacketType)Arrays.stream(this.newClientboundPacketEnum.getEnumConstants()).filter(Protocol::lambda$registerOutgoing$0).findAny().orElse((Object)null);
      Preconditions.checkNotNull(var4, "Packet type " + var1 + " in " + var1.getClass().getCanonicalName() + " could not be automatically mapped!");
      int var5 = var1.ordinal();
      int var6 = var4.ordinal();
      this.b(a66.PLAY, var5, var6, var2);
      if(acE.b() == null) {
         b(new acE[1]);
      }

   }

   public void a(ClientboundPacketType var1, @Nullable ClientboundPacketType var2, @Nullable acE var3) {
      acE[] var4 = h();
      this.checkPacketType(var1, var1.getClass() == this.oldClientboundPacketEnum);
      this.checkPacketType(var2, var2 == null || var2.getClass() == this.newClientboundPacketEnum);
      this.b(a66.PLAY, var1.ordinal(), var2 != null?var2.ordinal():-1, var3);
   }

   public void registerOutgoing(ClientboundPacketType var1, @Nullable ClientboundPacketType var2) {
      this.a((ClientboundPacketType)var1, (ClientboundPacketType)var2, (acE)null);
   }

   public void cancelOutgoing(ClientboundPacketType var1) {
      this.b(a66.PLAY, var1.ordinal(), var1.ordinal());
   }

   public void a(ServerboundPacketType var1, @Nullable acE var2) {
      acE[] var3 = h();
      this.checkPacketType(var1, var1.getClass() == this.newServerboundPacketEnum);
      ServerboundPacketType var4 = this.oldServerboundPacketEnum == this.newServerboundPacketEnum?var1:(ServerboundPacketType)Arrays.stream(this.oldServerboundPacketEnum.getEnumConstants()).filter(Protocol::lambda$registerIncoming$1).findAny().orElse((Object)null);
      Preconditions.checkNotNull(var4, "Packet type " + var1 + " in " + var1.getClass().getCanonicalName() + " could not be automatically mapped!");
      int var5 = var4.ordinal();
      int var6 = var1.ordinal();
      this.a(a66.PLAY, var5, var6, var2);
   }

   public void a(ServerboundPacketType var1, @Nullable ServerboundPacketType var2, @Nullable acE var3) {
      acE[] var4 = h();
      this.checkPacketType(var1, var1.getClass() == this.newServerboundPacketEnum);
      this.checkPacketType(var2, var2 == null || var2.getClass() == this.oldServerboundPacketEnum);
      this.a(a66.PLAY, var2 != null?var2.ordinal():-1, var1.ordinal(), var3);
   }

   public void cancelIncoming(ServerboundPacketType var1) {
      Preconditions.checkArgument(var1.getClass() == this.newServerboundPacketEnum);
      this.d(a66.PLAY, -1, var1.ordinal());
   }

   public boolean a(a66 var1, int var2) {
      Protocol$Packet var3 = new Protocol$Packet(var1, var2);
      return this.outgoing.containsKey(var3);
   }

   public boolean b(a66 var1, int var2) {
      Protocol$Packet var3 = new Protocol$Packet(var1, var2);
      return this.incoming.containsKey(var3);
   }

   public void a(Direction var1, a66 var2, PacketWrapper var3) throws Exception {
      h();
      Protocol$Packet var5 = new Protocol$Packet(var2, var3.getId());
      Map var6 = var1 == Direction.OUTGOING?this.outgoing:this.incoming;
      Protocol$ProtocolPacket var7 = (Protocol$ProtocolPacket)var6.get(var5);
   }

   private void a(Direction var1, a66 var2, int var3, int var4, InformativeException var5) throws InformativeException {
      acE[] var6 = h();
      if(var2 == a66.HANDSHAKE) {
         throw var5;
      } else {
         Class var7 = var2 == a66.PLAY?(var1 == Direction.OUTGOING?this.oldClientboundPacketEnum:this.newServerboundPacketEnum):null;
         if(var7 != null) {
            PacketType[] var8 = (PacketType[])var7.getEnumConstants();
            PacketType var9 = var3 < var8.length && var3 >= 0?var8[var3]:null;
            Via.getPlatform().getLogger().warning("ERROR IN " + this.getClass().getCanonicalName() + " IN REMAP OF " + var9 + " (" + this.toNiceHex(var3) + ")");
         }

         Via.getPlatform().getLogger().warning("ERROR IN " + this.getClass().getCanonicalName() + " IN REMAP OF " + this.toNiceHex(var3) + "->" + this.toNiceHex(var4));
         throw var5;
      }
   }

   private String toNiceHex(int var1) {
      h();
      String var3 = Integer.toHexString(var1).toUpperCase();
      return (var3.length() == 1?"0x0":"0x") + var3;
   }

   private void checkPacketType(PacketType var1, boolean var2) {
      throw new IllegalArgumentException("Packet type " + var1 + " in " + var1.getClass().getCanonicalName() + " is taken from the wrong enum");
   }

   @Nullable
   public Object get(Class var1) {
      return this.storedObjects.get(var1);
   }

   public void put(Object var1) {
      this.storedObjects.put(var1.getClass(), var1);
   }

   public boolean hasMappingDataToLoad() {
      return this.getMappingData() != null;
   }

   @Nullable
   public MappingData getMappingData() {
      return null;
   }

   public String toString() {
      return "Protocol:" + this.getClass().getCanonicalName();
   }

   private static boolean lambda$registerIncoming$1(ServerboundPacketType var0, ServerboundPacketType var1) {
      return var1.name().equals(var0.name());
   }

   private static boolean lambda$registerOutgoing$0(ClientboundPacketType var0, ClientboundPacketType var1) {
      return var1.name().equals(var0.name());
   }

   public static void b(acE[] var0) {
      g = var0;
   }

   public static acE[] h() {
      return g;
   }

   private static Exception b(Exception var0) {
      return var0;
   }

   static {
      b((acE[])null);
   }
}
