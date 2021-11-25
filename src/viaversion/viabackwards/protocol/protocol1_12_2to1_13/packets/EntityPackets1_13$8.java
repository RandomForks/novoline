package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.PlayerPositionStorage1_13;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_13$8 extends acE {
   final EntityPackets1_13 this$0;

   EntityPackets1_13$8(EntityPackets1_13 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(EntityPackets1_13$8::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ((PlayerPositionStorage1_13)var0.user().b(PlayerPositionStorage1_13.class)).setCoordinates(var0, false);
   }
}
