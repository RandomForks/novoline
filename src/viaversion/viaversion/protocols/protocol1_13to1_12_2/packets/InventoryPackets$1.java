package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aQU;
import net.acE;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$1 extends acE {
   final aQU c;

   InventoryPackets$1(aQU var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.BYTE);
      this.a(Type.SHORT);
      this.a(Type.ITEM, Type.FLAT_ITEM);
      this.a(this.c.a(Type.FLAT_ITEM));
   }
}
