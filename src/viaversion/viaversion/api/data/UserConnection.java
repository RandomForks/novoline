package viaversion.viaversion.api.data;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import net.acE;
import net.cA;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.ViaVersionConfig;
import viaversion.viaversion.api.platform.ViaInjector;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.exception.CancelException;
import viaversion.viaversion.packets.Direction;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public class UserConnection {
   private static final AtomicLong IDS = new AtomicLong();
   private final long id;
   private final Channel channel;
   private final boolean clientSide;
   Map storedObjects;
   private ProtocolInfo protocolInfo;
   private boolean active;
   private boolean pendingDisconnect;
   private Object lastPacket;
   private long sentPackets;
   private long receivedPackets;
   private long startTime;
   private long intervalPackets;
   private long packetsPerSecond;
   private int secondsObserved;
   private int warnings;
   private static String[] d;

   public UserConnection(@Nullable Channel var1, boolean var2) {
      cA.c();
      this.id = IDS.incrementAndGet();
      this.storedObjects = new ConcurrentHashMap();
      this.active = true;
      this.packetsPerSecond = -1L;
      this.channel = var1;
      this.clientSide = var2;
   }

   public UserConnection(@Nullable Channel var1) {
      this(var1, false);
   }

   @Nullable
   public cA b(Class var1) {
      return (cA)this.storedObjects.get(var1);
   }

   public boolean has(Class var1) {
      return this.storedObjects.containsKey(var1);
   }

   public void a(cA var1) {
      this.storedObjects.put(var1.getClass(), var1);
   }

   public void clearStoredObjects() {
      this.storedObjects.clear();
   }

   public void sendRawPacket(ByteBuf var1, boolean var2) {
      cA.c();
      ChannelPipeline var4 = this.channel.pipeline();
      ViaInjector var5 = Via.getManager().getInjector();
      if(this.clientSide) {
         Runnable var10000 = UserConnection::lambda$sendRawPacket$0;
      }

      Runnable var6 = UserConnection::lambda$sendRawPacket$1;
      var6.run();
      UserConnection var9 = this;

      try {
         var9.channel.eventLoop().submit(var6);
      } catch (Throwable var8) {
         var1.release();
         var8.printStackTrace();
      }

   }

   public ChannelFuture sendRawPacketFuture(ByteBuf var1) {
      boolean var2 = cA.c();
      return this.clientSide?this.sendRawPacketFutureClientSide(var1):this.sendRawPacketFutureServerSide(var1);
   }

   private ChannelFuture sendRawPacketFutureServerSide(ByteBuf var1) {
      return this.channel.pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush(var1);
   }

   private ChannelFuture sendRawPacketFutureClientSide(ByteBuf var1) {
      this.getChannel().pipeline().context(Via.getManager().getInjector().getDecoderName()).fireChannelRead(var1);
      return this.getChannel().newSucceededFuture();
   }

   public void sendRawPacket(ByteBuf var1) {
      this.sendRawPacket(var1, false);
   }

   public void incrementSent() {
      ++this.sentPackets;
   }

   public boolean incrementReceived() {
      cA.b();
      long var2 = System.currentTimeMillis() - this.startTime;
      if(var2 >= 1000L) {
         this.packetsPerSecond = this.intervalPackets;
         this.startTime = System.currentTimeMillis();
         this.intervalPackets = 1L;
         return true;
      } else {
         ++this.intervalPackets;
         ++this.receivedPackets;
         if(acE.b() == null) {
            cA.b(false);
         }

         return false;
      }
   }

   public boolean exceedsMaxPPS() {
      boolean var1 = cA.c();
      if(this.clientSide) {
         return false;
      } else {
         ViaVersionConfig var2 = Via.getConfig();
         if(var2.getMaxPPS() > 0 && this.packetsPerSecond >= (long)var2.getMaxPPS()) {
            this.disconnect(var2.getMaxPPSKickMessage().replace("%pps", Long.toString(this.packetsPerSecond)));
            return true;
         } else {
            if(var2.getMaxWarnings() > 0 && var2.getTrackingPeriod() > 0) {
               if(this.secondsObserved > var2.getTrackingPeriod()) {
                  this.warnings = 0;
                  this.secondsObserved = 1;
               }

               ++this.secondsObserved;
               if(this.packetsPerSecond >= (long)var2.getWarningPPS()) {
                  ++this.warnings;
               }

               if(this.warnings >= var2.getMaxWarnings()) {
                  this.disconnect(var2.getMaxWarningsKickMessage().replace("%pps", Long.toString(this.packetsPerSecond)));
                  return true;
               }
            }

            return false;
         }
      }
   }

   public void disconnect(String var1) {
      boolean var2 = cA.b();
      if(this.channel.isOpen() && !this.pendingDisconnect) {
         this.pendingDisconnect = true;
         Via.getPlatform().runSync(this::lambda$disconnect$2);
      }
   }

   public void sendRawPacketToServer(ByteBuf var1, boolean var2) {
      boolean var3 = cA.c();
      if(this.clientSide) {
         this.sendRawPacketToServerClientSide(var1, var2);
      }

      this.sendRawPacketToServerServerSide(var1, var2);
   }

   private void sendRawPacketToServerServerSide(ByteBuf param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void sendRawPacketToServerClientSide(ByteBuf var1, boolean var2) {
      cA.b();
      Runnable var4 = this::lambda$sendRawPacketToServerClientSide$4;
      var4.run();
      UserConnection var10000 = this;

      try {
         var10000.channel.eventLoop().submit(var4);
      } catch (Throwable var6) {
         var6.printStackTrace();
         var1.release();
      }

   }

   public void sendRawPacketToServer(ByteBuf var1) {
      this.sendRawPacketToServer(var1, false);
   }

   public boolean checkIncomingPacket() {
      boolean var1 = cA.c();
      return this.clientSide?this.checkClientBound():this.checkServerBound();
   }

   private boolean checkClientBound() {
      this.incrementSent();
      return true;
   }

   private boolean checkServerBound() {
      boolean var1 = cA.b();
      return this.pendingDisconnect?false:!this.incrementReceived() || !this.exceedsMaxPPS();
   }

   public boolean checkOutgoingPacket() {
      boolean var1 = cA.b();
      return this.clientSide?this.checkServerBound():this.checkClientBound();
   }

   public boolean shouldTransformPacket() {
      return this.active;
   }

   public void transformOutgoing(ByteBuf var1, Function var2) throws Exception {
      if(var1.isReadable()) {
         this.transform(var1, this.clientSide?Direction.INCOMING:Direction.OUTGOING, var2);
      }
   }

   public void transformIncoming(ByteBuf var1, Function var2) throws Exception {
      if(var1.isReadable()) {
         this.transform(var1, this.clientSide?Direction.OUTGOING:Direction.INCOMING, var2);
      }
   }

   private void transform(ByteBuf var1, Direction var2, Function var3) throws Exception {
      int var4 = Type.VAR_INT.readPrimitive(var1);
      if(var4 != 1000) {
         PacketWrapper var5 = new PacketWrapper(var4, var1, this);

         try {
            this.protocolInfo.getPipeline().a(var2, this.protocolInfo.e(), var5);
         } catch (CancelException var11) {
            throw (Exception)var3.apply(var11);
         }

         ByteBuf var6 = var1.alloc().buffer();
         PacketWrapper var10000 = var5;
         ByteBuf var10001 = var6;

         try {
            var10000.writeToBuffer(var10001);
            var1.clear().writeBytes(var6);
         } finally {
            var6.release();
         }

      }
   }

   public long getId() {
      return this.id;
   }

   @Nullable
   public Channel getChannel() {
      return this.channel;
   }

   @Nullable
   public ProtocolInfo getProtocolInfo() {
      return this.protocolInfo;
   }

   public void setProtocolInfo(@Nullable ProtocolInfo var1) {
      cA.b();
      this.protocolInfo = var1;
      if(var1 != null) {
         this.storedObjects.put(ProtocolInfo.class, var1);
      }

      this.storedObjects.remove(ProtocolInfo.class);
   }

   public Map getStoredObjects() {
      return this.storedObjects;
   }

   public boolean isActive() {
      return this.active;
   }

   public void setActive(boolean var1) {
      this.active = var1;
   }

   public boolean isPendingDisconnect() {
      return this.pendingDisconnect;
   }

   public void setPendingDisconnect(boolean var1) {
      this.pendingDisconnect = var1;
   }

   @Nullable
   public Object getLastPacket() {
      return this.lastPacket;
   }

   public void setLastPacket(@Nullable Object var1) {
      this.lastPacket = var1;
   }

   public long getSentPackets() {
      return this.sentPackets;
   }

   public void setSentPackets(long var1) {
      this.sentPackets = var1;
   }

   public long getReceivedPackets() {
      return this.receivedPackets;
   }

   public void setReceivedPackets(long var1) {
      this.receivedPackets = var1;
   }

   public long getStartTime() {
      return this.startTime;
   }

   public void setStartTime(long var1) {
      this.startTime = var1;
   }

   public long getIntervalPackets() {
      return this.intervalPackets;
   }

   public void setIntervalPackets(long var1) {
      this.intervalPackets = var1;
   }

   public long getPacketsPerSecond() {
      return this.packetsPerSecond;
   }

   public void setPacketsPerSecond(long var1) {
      this.packetsPerSecond = var1;
   }

   public int getSecondsObserved() {
      return this.secondsObserved;
   }

   public void setSecondsObserved(int var1) {
      this.secondsObserved = var1;
   }

   public int getWarnings() {
      return this.warnings;
   }

   public void setWarnings(int var1) {
      this.warnings = var1;
   }

   public boolean equals(Object var1) {
      boolean var2 = cA.c();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         UserConnection var3 = (UserConnection)var1;
         return this.id == var3.id;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Long.hashCode(this.id);
   }

   public boolean isClientSide() {
      return this.clientSide;
   }

   public boolean o() {
      boolean var1 = cA.b();
      return !this.clientSide;
   }

   private void lambda$sendRawPacketToServerClientSide$4(ByteBuf var1) {
      this.channel.pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush(var1);
   }

   private void lambda$sendRawPacketToServerServerSide$3(ChannelHandlerContext var1, ByteBuf var2) {
      boolean var3 = cA.b();
      if(var1 != null) {
         var1.fireChannelRead(var2);
      }

      this.channel.pipeline().fireChannelRead(var2);
   }

   private void lambda$disconnect$2(String var1) {
      if(!Via.getPlatform().disconnect(this, ChatColor.translateAlternateColorCodes('&', var1))) {
         this.channel.close();
      }

   }

   private static void lambda$sendRawPacket$1(ChannelPipeline var0, ViaInjector var1, ByteBuf var2) {
      var0.context(var1.getEncoderName()).writeAndFlush(var2);
   }

   private static void lambda$sendRawPacket$0(ChannelPipeline var0, ViaInjector var1, ByteBuf var2) {
      var0.context(var1.getDecoderName()).fireChannelRead(var2);
   }

   static {
      b(new String[4]);
   }

   public static void b(String[] var0) {
      d = var0;
   }

   public static String[] r() {
      return d;
   }

   private static Throwable a(Throwable var0) {
      return var0;
   }
}
