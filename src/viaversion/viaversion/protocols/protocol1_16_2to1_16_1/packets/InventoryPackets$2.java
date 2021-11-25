package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets.InventoryPackets;

final class InventoryPackets$2 extends acE {
   public void registerMap() {
      this.a(InventoryPackets$2::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      InventoryPackets.toServer((Item)var0.passthrough(Type.FLAT_VAR_INT_ITEM));
   }
}
