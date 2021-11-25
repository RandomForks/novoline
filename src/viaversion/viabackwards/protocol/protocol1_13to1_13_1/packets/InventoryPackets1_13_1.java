package viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets;

import net.aQU;
import net.aoy;
import net.aqN;
import net.q1;
import net.uN;
import viaversion.viabackwards.protocol.protocol1_13to1_13_1.Protocol1_13To1_13_1;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.type.Type;

public class InventoryPackets1_13_1 {
   public static void register(Protocol var0) {
      aQU var1 = new aQU(var0, InventoryPackets1_13_1::toClient, InventoryPackets1_13_1::toServer);
      var1.a((ClientboundPacketType)q1.COOLDOWN);
      var1.b((ClientboundPacketType)q1.WINDOW_ITEMS, Type.FLAT_ITEM_ARRAY);
      var1.a((ClientboundPacketType)q1.SET_SLOT, Type.FLAT_ITEM);
      var0.a((ClientboundPacketType)q1.PLUGIN_MESSAGE, new aoy());
      var1.f(q1.ENTITY_EQUIPMENT, Type.FLAT_ITEM);
      var1.a((ServerboundPacketType)uN.CLICK_WINDOW, Type.FLAT_ITEM);
      var1.b((ServerboundPacketType)uN.CREATIVE_INVENTORY_ACTION, Type.FLAT_ITEM);
      var1.a(q1.SPAWN_PARTICLE, Type.FLAT_ITEM, Type.FLOAT);
   }

   public static void toClient(Item var0) {
      String[] var1 = aqN.a();
      if(var0 != null) {
         var0.setIdentifier(Protocol1_13To1_13_1.MAPPINGS.getNewItemId(var0.getIdentifier()));
      }
   }

   public static void toServer(Item var0) {
      String[] var1 = aqN.a();
      if(var0 != null) {
         var0.setIdentifier(Protocol1_13To1_13_1.MAPPINGS.getOldItemId(var0.getIdentifier()));
      }
   }
}
