package viaversion.viafabric.platform;

import io.netty.buffer.ByteBuf;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import net.bgY;
import viaversion.viafabric.platform.VRBossBar;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.ViaAPI;
import viaversion.viaversion.api.boss.BossBar;
import viaversion.viaversion.api.boss.BossColor;
import viaversion.viaversion.api.boss.BossStyle;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ProtocolRegistry;

public class VRViaAPI implements ViaAPI {
   public int getPlayerVersion(UUID var1) {
      bgY.b();
      UserConnection var3 = Via.getManager().getConnection(var1);
      if(var3 != null) {
         return var3.getProtocolInfo().getProtocolVersion();
      } else {
         try {
            return Via.getManager().getInjector().getServerProtocolVersion();
         } catch (Exception var5) {
            throw new AssertionError(var5);
         }
      }
   }

   public boolean isInjected(UUID var1) {
      return Via.getManager().isClientConnected(var1);
   }

   public String getVersion() {
      return Via.getPlatform().getPluginVersion();
   }

   public void sendRawPacket(UUID var1, ByteBuf var2) throws IllegalArgumentException {
      UserConnection var3 = Via.getManager().getConnection(var1);
      var3.sendRawPacket(var2);
   }

   public BossBar createBossBar(String var1, BossColor var2, BossStyle var3) {
      return new VRBossBar(var1, 1.0F, var2, var3);
   }

   public BossBar createBossBar(String var1, float var2, BossColor var3, BossStyle var4) {
      return new VRBossBar(var1, var2, var3, var4);
   }

   public SortedSet getSupportedVersions() {
      TreeSet var1 = new TreeSet(ProtocolRegistry.getSupportedVersions());
      var1.removeAll(Via.getPlatform().getConf().getBlockedProtocols());
      return var1;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
