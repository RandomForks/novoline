package viaversion.viaversion.protocols.protocol1_13_1to1_13.packets;

import net.HR;
import net.aKS;
import net.aKu;
import net.aQU;
import net.aRw;
import net.acE;
import net.amt;
import net.q1;
import net.uN;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.type.Type;

public class InventoryPackets {
   public static void a(aRw var0) {
      HR.b();
      aQU var2 = new aQU(var0, InventoryPackets::toClient, InventoryPackets::toServer);
      var2.a((ClientboundPacketType)q1.SET_SLOT, Type.FLAT_ITEM);
      var2.b((ClientboundPacketType)q1.WINDOW_ITEMS, Type.FLAT_ITEM_ARRAY);
      var2.c(q1.ADVANCEMENTS, Type.FLAT_ITEM);
      var2.a((ClientboundPacketType)q1.COOLDOWN);
      var0.a(q1.PLUGIN_MESSAGE, new aKu());
      var2.f(q1.ENTITY_EQUIPMENT, Type.FLAT_ITEM);
      amt var3 = new amt(var0, InventoryPackets::toClient);
      var0.a(q1.DECLARE_RECIPES, new aKS(var3));
      var2.a((ServerboundPacketType)uN.CLICK_WINDOW, Type.FLAT_ITEM);
      var2.b((ServerboundPacketType)uN.CREATIVE_INVENTORY_ACTION, Type.FLAT_ITEM);
      var2.a(q1.SPAWN_PARTICLE, Type.FLAT_ITEM, Type.FLOAT);
   }

   public static void toClient(Item var0) {
      acE[] var1 = HR.b();
      if(var0 != null) {
         var0.setIdentifier(aRw.j.getNewItemId(var0.getIdentifier()));
      }
   }

   public static void toServer(Item var0) {
      acE[] var1 = HR.b();
      if(var0 != null) {
         var0.setIdentifier(aRw.j.getOldItemId(var0.getIdentifier()));
      }
   }
}
