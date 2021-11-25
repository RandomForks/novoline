package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import net.cT;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.BossBarStorage;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$7 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(PlayerPackets$7::lambda$registerMap$0);
      this.a(PlayerPackets$7::lambda$registerMap$1);
      this.a(PlayerPackets$7::lambda$registerMap$2);
   }

   private static void lambda$registerMap$2(PacketWrapper var0) throws Exception {
      cT var1 = (cT)var0.user().b(cT.class);
      var1.c(((Integer)var0.get(Type.INT, 0)).intValue());
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      ((BossBarStorage)var0.user().b(BossBarStorage.class)).updateLocation();
      ((BossBarStorage)var0.user().b(BossBarStorage.class)).changeWorld();
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ((EntityTracker)var0.user().b(EntityTracker.class)).setPlayerGamemode(((Short)var0.get(Type.UNSIGNED_BYTE, 1)).shortValue());
   }
}
