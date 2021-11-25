package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.items.ItemRewriter;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$9 extends acE {
   public void registerMap() {
      this.a(Type.SHORT);
      this.a(axZ.c, Type.ITEM);
      this.a(InventoryPackets$9::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Item var1 = (Item)var0.get(Type.ITEM, 0);
      ItemRewriter.toServer(var1);
      var0.set(Type.ITEM, 0, var1);
   }
}
