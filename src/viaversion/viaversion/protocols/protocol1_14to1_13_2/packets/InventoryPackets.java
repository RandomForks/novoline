package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import net.aQU;
import net.aWG;
import net.aWT;
import net.aWX;
import net.aWh;
import net.acE;
import net.ahW;
import net.amt;
import net.km;
import net.kp;
import net.q1;
import net.md_5.bungee.api.ChatColor;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.WorldPackets;

public class InventoryPackets {
   private static final String b = "ViaVersion|Protocol1_14To1_13_2";
   private static final Set REMOVED_RECIPE_TYPES = Sets.newHashSet(new String[]{"crafting_special_banneraddpattern", "crafting_special_repairitem"});
   private static final km c = new kp();

   public static void register(Protocol var0) {
      aQU var1 = new aQU(var0, InventoryPackets::toClient, InventoryPackets::toServer);
      var1.a((ClientboundPacketType)q1.COOLDOWN);
      var1.c(q1.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
      var0.a((ClientboundPacketType)q1.OPEN_WINDOW, (ClientboundPacketType)null, (acE)(new aWX()));
      var1.b((ClientboundPacketType)q1.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
      var1.a((ClientboundPacketType)q1.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
      var0.a((ClientboundPacketType)q1.PLUGIN_MESSAGE, new aWG());
      var1.f(q1.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
      amt var2 = new amt(var0, InventoryPackets::toClient);
      var0.a((ClientboundPacketType)q1.DECLARE_RECIPES, new aWh(var2));
      var1.a((ServerboundPacketType)ahW.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
      var0.a((ServerboundPacketType)ahW.SELECT_TRADE, new aWT());
      var1.b((ServerboundPacketType)ahW.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
      var1.a(q1.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.FLOAT);
   }

   public static void toClient(Item var0) {
      int[] var1 = WorldPackets.b();
      if(var0 != null) {
         var0.setIdentifier(Protocol1_14To1_13_2.MAPPINGS.getNewItemId(var0.getIdentifier()));
         if(var0.getTag() != null) {
            Tag var2 = var0.getTag().get("display");
            if(var2 instanceof CompoundTag) {
               CompoundTag var3 = (CompoundTag)var2;
               Tag var4 = var3.get("Lore");
               if(var4 instanceof ListTag) {
                  ListTag var5 = (ListTag)var4;
                  var3.put(new ListTag("ViaVersion|Protocol1_14To1_13_2|Lore", var5.clone().getValue()));
                  Iterator var6 = var5.iterator();
                  if(var6.hasNext()) {
                     Tag var7 = (Tag)var6.next();
                     if(var7 instanceof StringTag) {
                        String var8 = ChatRewriter.fromLegacyTextAsString(((StringTag)var7).getValue(), ChatColor.WHITE, true);
                        ((StringTag)var7).setValue(var8);
                     }
                  }
               }
            }

         }
      }
   }

   public static void toServer(Item var0) {
      int[] var1 = WorldPackets.b();
      if(var0 != null) {
         var0.setIdentifier(Protocol1_14To1_13_2.MAPPINGS.getOldItemId(var0.getIdentifier()));
         if(var0.getTag() != null) {
            Tag var2 = var0.getTag().get("display");
            if(var2 instanceof CompoundTag) {
               CompoundTag var3 = (CompoundTag)var2;
               Tag var4 = var3.get("Lore");
               if(var4 instanceof ListTag) {
                  ListTag var5 = (ListTag)var4;
                  ListTag var6 = (ListTag)var3.remove("ViaVersion|Protocol1_14To1_13_2|Lore");
                  if(var6 != null) {
                     var3.put(new ListTag("Lore", var6.getValue()));
                  }

                  Iterator var7 = var5.iterator();
                  if(var7.hasNext()) {
                     Tag var8 = (Tag)var7.next();
                     if(var8 instanceof StringTag) {
                        ((StringTag)var8).setValue(ChatRewriter.jsonTextToLegacy(((StringTag)var8).getValue()));
                     }
                  }
               }
            }

         }
      }
   }

   static km a() {
      return c;
   }

   static Set access$100() {
      return REMOVED_RECIPE_TYPES;
   }
}
