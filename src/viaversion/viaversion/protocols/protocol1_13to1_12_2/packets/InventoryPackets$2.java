package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aQU;
import net.acE;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$2 extends acE {
   final aQU c;

   InventoryPackets$2(aQU var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.ITEM_ARRAY, Type.FLAT_ITEM_ARRAY);
      this.a(this.c.b(Type.FLAT_ITEM_ARRAY));
   }
}
