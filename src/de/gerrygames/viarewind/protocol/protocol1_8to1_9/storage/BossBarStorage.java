package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.PlayerPosition;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import net.a2Z;
import net.bgR;
import net.cA;

public class BossBarStorage extends cA {
   private Map bossBars = new HashMap();

   public BossBarStorage(bgR var1) {
      super(var1);
   }

   public void add(UUID var1, String var2, float var3) {
      a2Z var5 = new a2Z(this.d(), var1, var2, var3);
      EntityTracker.d();
      PlayerPosition var6 = (PlayerPosition)this.d().b(PlayerPosition.class);
      var5.a(var6.c(), var6.g(), var6.e(), var6.a(), var6.f());
      var5.i();
      this.bossBars.put(var1, var5);
      if(PacketRemapper.b() == null) {
         EntityTracker.b(new String[4]);
      }

   }

   public void remove(UUID var1) {
      EntityTracker.d();
      a2Z var3 = (a2Z)this.bossBars.remove(var1);
      if(var3 != null) {
         var3.h();
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
      a2Z var4 = (a2Z)this.bossBars.get(var1);
      if(var4 != null) {
         var4.a(var2);
      }
   }

   public void updateTitle(UUID var1, String var2) {
      EntityTracker.d();
      a2Z var4 = (a2Z)this.bossBars.get(var1);
      if(var4 != null) {
         var4.a(var2);
      }
   }

   private static void lambda$changeWorld$1(a2Z var0) {
      var0.h();
      var0.i();
   }

   private static void lambda$updateLocation$0(PlayerPosition var0, a2Z var1) {
      var1.a(var0.c(), var0.g(), var0.e(), var0.a(), var0.f());
   }
}
