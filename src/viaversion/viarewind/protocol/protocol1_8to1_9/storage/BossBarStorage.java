package viaversion.viarewind.protocol.protocol1_8to1_9.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import net.acE;
import net.cA;
import viaversion.viarewind.protocol.protocol1_8to1_9.bossbar.WitherBossBar;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.PlayerPosition;
import viaversion.viaversion.api.data.UserConnection;

public class BossBarStorage extends cA {
   private Map bossBars = new HashMap();

   public BossBarStorage(UserConnection var1) {
      super(var1);
   }

   public void add(UUID var1, String var2, float var3) {
      WitherBossBar var5 = new WitherBossBar(this.d(), var1, var2, var3);
      EntityTracker.d();
      PlayerPosition var6 = (PlayerPosition)this.d().b(PlayerPosition.class);
      var5.setPlayerLocation(var6.getPosX(), var6.getPosY(), var6.getPosZ(), var6.getYaw(), var6.getPitch());
      var5.show();
      this.bossBars.put(var1, var5);
      if(acE.b() == null) {
         EntityTracker.b(new String[4]);
      }

   }

   public void remove(UUID var1) {
      EntityTracker.d();
      WitherBossBar var3 = (WitherBossBar)this.bossBars.remove(var1);
      if(var3 != null) {
         var3.hide();
      }
   }

   public void updateLocation() {
      PlayerPosition var1 = (PlayerPosition)this.d().b(PlayerPosition.class);
      this.bossBars.values().forEach(BossBarStorage::lambda$updateLocation$0);
   }

   public void changeWorld() {
      this.bossBars.values().forEach(BossBarStorage::lambda$changeWorld$1);
   }

   public void updateHealth(UUID var1, float var2) {
      EntityTracker.d();
      WitherBossBar var4 = (WitherBossBar)this.bossBars.get(var1);
      if(var4 != null) {
         var4.setHealth(var2);
      }
   }

   public void updateTitle(UUID var1, String var2) {
      EntityTracker.d();
      WitherBossBar var4 = (WitherBossBar)this.bossBars.get(var1);
      if(var4 != null) {
         var4.setTitle(var2);
      }
   }

   private static void lambda$changeWorld$1(WitherBossBar var0) {
      var0.hide();
      var0.show();
   }

   private static void lambda$updateLocation$0(PlayerPosition var0, WitherBossBar var1) {
      var1.setPlayerLocation(var0.getPosX(), var0.getPosY(), var0.getPosZ(), var0.getYaw(), var0.getPitch());
   }
}
