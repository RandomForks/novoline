package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.aQU;
import net.acE;
import net.aqI;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_13$7 extends acE {
   final aQU d;
   final aqI c;

   BlockItemPackets1_13$7(aqI var1, aQU var2) {
      this.c = var1;
      this.d = var2;
   }

   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.FLAT_ITEM_ARRAY, Type.ITEM_ARRAY);
      this.a(this.d.b(Type.ITEM_ARRAY));
   }
}
