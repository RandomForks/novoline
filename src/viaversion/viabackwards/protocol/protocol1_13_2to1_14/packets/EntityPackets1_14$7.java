package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.N0;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_14$7 extends acE {
   final EntityPackets1_14 this$0;

   EntityPackets1_14$7(EntityPackets1_14 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.BYTE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      this.this$0.addTrackedEntity(var1, ((Integer)var1.get(Type.VAR_INT, 0)).intValue(), N0.LIGHTNING_BOLT);
   }
}
