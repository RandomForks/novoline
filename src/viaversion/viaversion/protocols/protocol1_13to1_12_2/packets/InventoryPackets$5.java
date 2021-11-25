package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aQU;
import net.acE;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$5 extends acE {
   final aQU c;

   InventoryPackets$5(aQU var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(Type.ITEM, Type.FLAT_ITEM);
      this.a(this.c.a(Type.FLAT_ITEM));
   }
}
