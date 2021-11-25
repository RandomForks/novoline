package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aMo;
import net.aXe;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter;

class InventoryPackets$4$1 implements PacketHandler {
   final aMo a;

   InventoryPackets$4$1(aMo var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      aXe.b();
      Item[] var3 = (Item[])var1.get(Type.ITEM_ARRAY, 0);
      int var5 = var3.length;
      int var6 = 0;
      if(var6 < var5) {
         Item var7 = var3[var6];
         ItemRewriter.toClient(var7);
         ++var6;
      }

   }
}
