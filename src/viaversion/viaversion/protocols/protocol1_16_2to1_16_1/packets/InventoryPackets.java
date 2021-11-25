package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import net.C4;
import net.aQU;
import net.aRX;
import net.acE;
import net.amd;
import net.lH;
import net.lx;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets.InventoryPackets$1;
import viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets.InventoryPackets$2;

public class InventoryPackets {
   public static void a(aRX var0) {
      aQU var2 = new aQU(var0, InventoryPackets::toClient, InventoryPackets::toServer);
      var2.a((ClientboundPacketType)C4.COOLDOWN);
      var2.b((ClientboundPacketType)C4.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
      var2.e(C4.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
      var2.a((ClientboundPacketType)C4.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
      lH.b();
      var2.d(C4.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
      var2.c(C4.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
      var0.a(C4.UNLOCK_RECIPES, new InventoryPackets$1());
      (new amd(var0, InventoryPackets::toClient)).registerDefaultHandler(C4.DECLARE_RECIPES);
      var2.a((ServerboundPacketType)lx.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
      var2.b((ServerboundPacketType)lx.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
      var0.a(lx.EDIT_BOOK, new InventoryPackets$2());
      var2.a(C4.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.DOUBLE);
   }

   public static void toClient(Item var0) {
      acE[] var1 = lH.b();
      if(var0 != null) {
         var0.setIdentifier(aRX.j.getNewItemId(var0.getIdentifier()));
      }
   }

   public static void toServer(Item var0) {
      acE[] var1 = lH.b();
      if(var0 != null) {
         var0.setIdentifier(aRX.j.getOldItemId(var0.getIdentifier()));
      }
   }
}
