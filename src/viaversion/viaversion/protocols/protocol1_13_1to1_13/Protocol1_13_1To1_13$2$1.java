package viaversion.viaversion.protocols.protocol1_13_1to1_13;

import net.aKi;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13_1to1_13.packets.InventoryPackets;

class Protocol1_13_1To1_13$2$1 implements PacketHandler {
   final aKi a;

   Protocol1_13_1To1_13$2$1(aKi var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      Item var2 = (Item)var1.get(Type.FLAT_ITEM, 0);
      InventoryPackets.toServer(var2);
   }
}
