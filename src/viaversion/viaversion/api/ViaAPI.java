package viaversion.viaversion.api;

import io.netty.buffer.ByteBuf;
import java.util.SortedSet;
import java.util.UUID;
import viaversion.viaversion.api.boss.BossBar;
import viaversion.viaversion.api.boss.BossColor;
import viaversion.viaversion.api.boss.BossStyle;

public interface ViaAPI {
   int getPlayerVersion(Object var1);

   int getPlayerVersion(UUID var1);

   /** @deprecated */
   @Deprecated
   default boolean isPorted(UUID var1) {
      return this.isInjected(var1);
   }

   boolean isInjected(UUID var1);

   String getVersion();

   void sendRawPacket(Object var1, ByteBuf var2);

   void sendRawPacket(UUID var1, ByteBuf var2);

   BossBar createBossBar(String var1, BossColor var2, BossStyle var3);

   BossBar createBossBar(String var1, float var2, BossColor var3, BossStyle var4);

   SortedSet getSupportedVersions();
}
