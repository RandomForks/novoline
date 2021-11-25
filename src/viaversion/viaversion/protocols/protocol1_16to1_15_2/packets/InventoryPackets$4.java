package viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import net.acE;
import net.adT;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$4 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(InventoryPackets$4::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.read(Type.VAR_INT)).intValue();
      var0.write(Type.BYTE, Byte.valueOf((byte)var1));
      adT.c((Item)var0.passthrough(Type.FLAT_VAR_INT_ITEM));
   }
}
