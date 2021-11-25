package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.anx;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.items.ItemRewriter;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;

class EntityPackets$1$1 implements PacketHandler {
   final anx a;

   EntityPackets$1$1(anx var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      Item var2 = (Item)var1.get(axZ.c, 0);
      ItemRewriter.toClient(var2);
      var1.set(axZ.c, 0, var2);
   }
}
