package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import net.acE;
import net.aq3;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_15$4 extends acE {
   final aq3 c;

   EntityPackets1_15$4(aq3 var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.LONG, Type.NOTHING);
   }
}
