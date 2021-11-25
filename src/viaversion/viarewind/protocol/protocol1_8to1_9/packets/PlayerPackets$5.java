package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import net.cT;
import net.t4;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$5 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.BYTE);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(Type.BOOLEAN);
      this.a(PlayerPackets$5::lambda$registerMap$0);
      this.a(PlayerPackets$5::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      cT var1 = (cT)var0.user().b(cT.class);
      var1.c(((Byte)var0.get(Type.BYTE, 0)).byteValue());
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      EntityTracker var1 = (EntityTracker)var0.user().b(EntityTracker.class);
      var1.setPlayerId(((Integer)var0.get(Type.INT, 0)).intValue());
      var1.setPlayerGamemode(((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue());
      var1.getClientEntityTypes().put(Integer.valueOf(var1.getPlayerId()), t4.ENTITY_HUMAN);
   }
}
