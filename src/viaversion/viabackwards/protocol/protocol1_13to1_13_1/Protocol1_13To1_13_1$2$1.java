package viaversion.viabackwards.protocol.protocol1_13to1_13_1;

import net.ao6;
import viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets.InventoryPackets1_13_1;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_13To1_13_1$2$1 implements PacketHandler {
   final ao6 a;

   Protocol1_13To1_13_1$2$1(ao6 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      InventoryPackets1_13_1.toServer((Item)var1.get(Type.FLAT_ITEM, 0));
      var1.write(Type.VAR_INT, Integer.valueOf(0));
   }
}
