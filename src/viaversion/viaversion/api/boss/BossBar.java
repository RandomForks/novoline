package viaversion.viaversion.api.boss;

import java.util.Set;
import java.util.UUID;
import net.acE;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.boss.BossColor;
import viaversion.viaversion.api.boss.BossFlag;
import viaversion.viaversion.api.boss.BossStyle;
import viaversion.viaversion.api.data.UserConnection;

public abstract class BossBar {
   private static acE[] b;

   public abstract String getTitle();

   public abstract BossBar setTitle(String var1);

   public abstract float getHealth();

   public abstract BossBar setHealth(float var1);

   public abstract BossColor getColor();

   public abstract BossBar setColor(BossColor var1);

   public abstract BossStyle getStyle();

   public abstract BossBar setStyle(BossStyle var1);

   /** @deprecated */
   @Deprecated
   public BossBar b(Object var1) {
      throw new UnsupportedOperationException("This method is not implemented for the platform " + Via.getPlatform().getPlatformName());
   }

   public abstract BossBar b(UUID var1);

   public abstract BossBar addConnection(UserConnection var1);

   /** @deprecated */
   @Deprecated
   public BossBar addPlayers(Object... var1) {
      throw new UnsupportedOperationException("This method is not implemented for the platform " + Via.getPlatform().getPlatformName());
   }

   /** @deprecated */
   @Deprecated
   public BossBar a(Object var1) {
      throw new UnsupportedOperationException("This method is not implemented for the platform " + Via.getPlatform().getPlatformName());
   }

   public abstract BossBar a(UUID var1);

   public abstract BossBar removeConnection(UserConnection var1);

   public abstract BossBar addFlag(BossFlag var1);

   public abstract BossBar removeFlag(BossFlag var1);

   public abstract boolean hasFlag(BossFlag var1);

   public abstract Set getPlayers();

   public abstract Set getConnections();

   public abstract BossBar show();

   public abstract BossBar hide();

   public abstract boolean isVisible();

   public abstract UUID getId();

   public static void b(acE[] var0) {
      b = var0;
   }

   public static acE[] e() {
      return b;
   }

   static {
      b((acE[])null);
   }
}
