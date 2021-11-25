package viaversion.viaversion.protocols.protocol1_14to1_13_2.data;

import com.google.gson.JsonObject;
import net.kv;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.InventoryPackets;

public class ComponentRewriter1_14 extends kv {
   public ComponentRewriter1_14(Protocol var1) {
      super(var1);
   }

   protected void handleItem(Item var1) {
      InventoryPackets.toClient(var1);
   }

   protected void handleTranslate(JsonObject var1, String var2) {
   }
}
