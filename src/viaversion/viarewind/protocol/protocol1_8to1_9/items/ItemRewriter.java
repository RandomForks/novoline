package viaversion.viarewind.protocol.protocol1_8to1_9.items;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.ShortTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.aRE;
import net.vL;
import viaversion.viarewind.protocol.protocol1_8to1_9.items.ReplacementRegistry1_8to1_9;
import viaversion.viaversion.api.minecraft.item.Item;

public class ItemRewriter {
   private static final Map ENTTIY_NAME_TO_ID = viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.ENTTIY_NAME_TO_ID;
   private static final Map ENTTIY_ID_TO_NAME = viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.ENTTIY_ID_TO_NAME;
   private static final Map POTION_NAME_TO_ID = viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.POTION_NAME_TO_ID;
   private static final Map POTION_ID_TO_NAME = viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.POTION_ID_TO_NAME;
   private static final Map POTION_NAME_INDEX = new HashMap();

   public static Item toClient(Item var0) {
      boolean var1 = ReplacementRegistry1_8to1_9.c();
      if(var0 == null) {
         return null;
      } else {
         CompoundTag var2 = var0.getTag();
         if(var2 == null) {
            var0.setTag(var2 = new CompoundTag(""));
         }

         CompoundTag var3 = new CompoundTag("ViaRewind1_8to1_9");
         var2.put(var3);
         var3.put(new ShortTag("id", (short)var0.getIdentifier()));
         var3.put(new ShortTag("data", var0.getData()));
         CompoundTag var4 = (CompoundTag)var2.get("display");
         if(var4 != null && var4.contains("Name")) {
            var3.put(new StringTag("displayName", (String)var4.get("Name").getValue()));
         }

         if(var4 != null && var4.contains("Lore")) {
            var3.put(new ListTag("lore", ((ListTag)var4.get("Lore")).getValue()));
         }

         if(var2.contains("ench") || var2.contains("StoredEnchantments")) {
            ListTag var5 = var2.contains("ench")?(ListTag)var2.get("ench"):(ListTag)var2.get("StoredEnchantments");
            List var6 = var5.getValue();
            ArrayList var7 = new ArrayList();

            for(Tag var9 : var6) {
               short var10 = ((Short)((CompoundTag)var9).get("id").getValue()).shortValue();
               short var11 = ((Short)((CompoundTag)var9).get("lvl").getValue()).shortValue();
               if(var10 == 70) {
                  String var12 = "§r§7Mending ";
               }

               if(var10 == 9) {
                  String var27 = "§r§7Frost Walker ";
                  var5.remove(var9);
                  var27 = var27 + (String)vL.c.getOrDefault(Short.valueOf(var11), "enchantment.level." + var11);
                  var7.add(new StringTag("", var27));
                  break;
               }
            }

            if(!var7.isEmpty()) {
               if(var4 == null) {
                  var2.put(var4 = new CompoundTag("display"));
                  var3.put(new ByteTag("noDisplay"));
               }

               ListTag var25 = (ListTag)var4.get("Lore");
               if(var25 == null) {
                  var4.put(var25 = new ListTag("Lore", StringTag.class));
               }

               var7.addAll(var25.getValue());
               var25.setValue(var7);
            }
         }

         if(var0.getData() != 0 && var2.contains("Unbreakable")) {
            ByteTag var13 = (ByteTag)var2.get("Unbreakable");
            if(var13.getValue().byteValue() != 0) {
               var3.put(new ByteTag("Unbreakable", var13.getValue().byteValue()));
               var2.remove("Unbreakable");
               if(var4 == null) {
                  var2.put(var4 = new CompoundTag("display"));
                  var3.put(new ByteTag("noDisplay"));
               }

               ListTag var17 = (ListTag)var4.get("Lore");
               if(var17 == null) {
                  var4.put(var17 = new ListTag("Lore", StringTag.class));
               }

               var17.add(new StringTag("", "§9Unbreakable"));
            }
         }

         if(var2.contains("AttributeModifiers")) {
            var3.put(var2.get("AttributeModifiers").clone());
         }

         if(var0.getIdentifier() == 383 && var0.getData() == 0) {
            int var14 = 0;
            if(var2.contains("EntityTag")) {
               CompoundTag var18 = (CompoundTag)var2.get("EntityTag");
               if(var18.contains("id")) {
                  StringTag var22 = (StringTag)var18.get("id");
                  if(ENTTIY_NAME_TO_ID.containsKey(var22.getValue())) {
                     var14 = ((Integer)ENTTIY_NAME_TO_ID.get(var22.getValue())).intValue();
                  }

                  if(var4 == null) {
                     var2.put(var4 = new CompoundTag("display"));
                     var3.put(new ByteTag("noDisplay"));
                     var4.put(new StringTag("Name", "§rSpawn " + var22.getValue()));
                  }
               }
            }

            var0.setData((short)var14);
         }

         ReplacementRegistry1_8to1_9.replace(var0);
         if(var0.getIdentifier() == 373 || var0.getIdentifier() == 438 || var0.getIdentifier() == 441) {
            int var15 = 0;
            if(var2.contains("Potion")) {
               StringTag var19 = (StringTag)var2.get("Potion");
               String var23 = var19.getValue().replace("minecraft:", "");
               if(POTION_NAME_TO_ID.containsKey(var23)) {
                  var15 = ((Integer)POTION_NAME_TO_ID.get(var23)).intValue();
               }

               if(var0.getIdentifier() == 438) {
                  var23 = var23 + "_splash";
               }

               if(var0.getIdentifier() == 441) {
                  var23 = var23 + "_lingering";
               }

               if((var4 == null || !var4.contains("Name")) && POTION_NAME_INDEX.containsKey(var23)) {
                  if(var4 == null) {
                     var2.put(var4 = new CompoundTag("display"));
                     var3.put(new ByteTag("noDisplay"));
                  }

                  var4.put(new StringTag("Name", (String)POTION_NAME_INDEX.get(var23)));
               }
            }

            if(var0.getIdentifier() == 438 || var0.getIdentifier() == 441) {
               var0.setIdentifier(373);
               var15 += 8192;
            }

            var0.setData((short)var15);
         }

         if(var2.contains("AttributeModifiers")) {
            ListTag var16 = (ListTag)var2.get("AttributeModifiers");
            int var20 = 0;
            if(var20 < var16.size()) {
               CompoundTag var24 = (CompoundTag)var16.get(var20);
               String var26 = (String)var24.get("AttributeName").getValue();
               if(!aRE.j.contains(var24)) {
                  var16.remove(var24);
                  --var20;
               }

               ++var20;
            }
         }

         if(var3.size() == 2 && ((Short)var3.get("id").getValue()).shortValue() == var0.getIdentifier() && ((Short)var3.get("data").getValue()).shortValue() == var0.getData()) {
            var0.getTag().remove("ViaRewind1_8to1_9");
            if(var0.getTag().isEmpty()) {
               var0.setTag((CompoundTag)null);
            }
         }

         return var0;
      }
   }

   public static Item toServer(Item var0) {
      boolean var1 = ReplacementRegistry1_8to1_9.c();
      if(var0 == null) {
         return null;
      } else {
         CompoundTag var2 = var0.getTag();
         if(var0.getIdentifier() == 383 && var0.getData() != 0) {
            if(var2 == null) {
               var0.setTag(var2 = new CompoundTag(""));
            }

            if(!var2.contains("EntityTag") && ENTTIY_ID_TO_NAME.containsKey(Integer.valueOf(var0.getData()))) {
               CompoundTag var3 = new CompoundTag("EntityTag");
               var3.put(new StringTag("id", (String)ENTTIY_ID_TO_NAME.get(Integer.valueOf(var0.getData()))));
               var2.put(var3);
            }

            var0.setData((short)0);
         }

         if(var0.getIdentifier() == 373 && (var2 == null || !var2.contains("Potion"))) {
            if(var2 == null) {
               var0.setTag(var2 = new CompoundTag(""));
            }

            if(var0.getData() >= 16384) {
               var0.setIdentifier(438);
               var0.setData((short)(var0.getData() - 8192));
            }

            String var6 = var0.getData() == 8192?"water":viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.potionNameFromDamage(var0.getData());
            var2.put(new StringTag("Potion", "minecraft:" + var6));
            var0.setData((short)0);
         }

         if(var2 != null && var0.getTag().contains("ViaRewind1_8to1_9")) {
            CompoundTag var7 = (CompoundTag)var2.remove("ViaRewind1_8to1_9");
            var0.setIdentifier(((Short)var7.get("id").getValue()).shortValue());
            var0.setData(((Short)var7.get("data").getValue()).shortValue());
            if(var7.contains("noDisplay")) {
               var2.remove("display");
            }

            if(var7.contains("Unbreakable")) {
               var2.put(var7.get("Unbreakable").clone());
            }

            if(var7.contains("displayName")) {
               CompoundTag var4 = (CompoundTag)var2.get("display");
               if(var4 == null) {
                  var2.put(var4 = new CompoundTag("display"));
               }

               StringTag var5 = (StringTag)var4.get("Name");
               if(var5 == null) {
                  var4.put(new StringTag("Name", (String)var7.get("displayName").getValue()));
               }

               var5.setValue((String)var7.get("displayName").getValue());
            }

            if(var2.contains("display")) {
               ((CompoundTag)var2.get("display")).remove("Name");
            }

            if(var7.contains("lore")) {
               CompoundTag var8 = (CompoundTag)var2.get("display");
               if(var8 == null) {
                  var2.put(var8 = new CompoundTag("display"));
               }

               ListTag var9 = (ListTag)var8.get("Lore");
               if(var9 == null) {
                  var8.put(new ListTag("Lore", (List)var7.get("lore").getValue()));
               }

               var9.setValue((List)var7.get("lore").getValue());
            }

            if(var2.contains("display")) {
               ((CompoundTag)var2.get("display")).remove("Lore");
            }

            var2.remove("AttributeModifiers");
            if(var7.contains("AttributeModifiers")) {
               var2.put(var7.get("AttributeModifiers"));
            }

            return var0;
         } else {
            return var0;
         }
      }
   }

   static {
      POTION_NAME_TO_ID.put("luck", Integer.valueOf(8203));
      POTION_NAME_INDEX.put("water", "§rWater Bottle");
      POTION_NAME_INDEX.put("mundane", "§rMundane Potion");
      POTION_NAME_INDEX.put("thick", "§rThick Potion");
      POTION_NAME_INDEX.put("awkward", "§rAwkward Potion");
      POTION_NAME_INDEX.put("water_splash", "§rSplash Water Bottle");
      POTION_NAME_INDEX.put("mundane_splash", "§rMundane Splash Potion");
      POTION_NAME_INDEX.put("thick_splash", "§rThick Splash Potion");
      POTION_NAME_INDEX.put("awkward_splash", "§rAwkward Splash Potion");
      POTION_NAME_INDEX.put("water_lingering", "§rLingering Water Bottle");
      POTION_NAME_INDEX.put("mundane_lingering", "§rMundane Lingering Potion");
      POTION_NAME_INDEX.put("thick_lingering", "§rThick Lingering Potion");
      POTION_NAME_INDEX.put("awkward_lingering", "§rAwkward Lingering Potion");
      POTION_NAME_INDEX.put("night_vision_lingering", "§rLingering Potion of Night Vision");
      POTION_NAME_INDEX.put("long_night_vision_lingering", "§rLingering Potion of Night Vision");
      POTION_NAME_INDEX.put("invisibility_lingering", "§rLingering Potion of Invisibility");
      POTION_NAME_INDEX.put("long_invisibility_lingering", "§rLingering Potion of Invisibility");
      POTION_NAME_INDEX.put("leaping_lingering", "§rLingering Potion of Leaping");
      POTION_NAME_INDEX.put("long_leaping_lingering", "§rLingering Potion of Leaping");
      POTION_NAME_INDEX.put("strong_leaping_lingering", "§rLingering Potion of Leaping");
      POTION_NAME_INDEX.put("fire_resistance_lingering", "§rLingering Potion of Fire Resistance");
      POTION_NAME_INDEX.put("long_fire_resistance_lingering", "§rLingering Potion of Fire Resistance");
      POTION_NAME_INDEX.put("swiftness_lingering", "§rLingering Potion of Swiftness");
      POTION_NAME_INDEX.put("long_swiftness_lingering", "§rLingering Potion of Swiftness");
      POTION_NAME_INDEX.put("strong_swiftness_lingering", "§rLingering Potion of Swiftness");
      POTION_NAME_INDEX.put("slowness_lingering", "§rLingering Potion of Slowness");
      POTION_NAME_INDEX.put("long_slowness_lingering", "§rLingering Potion of Slowness");
      POTION_NAME_INDEX.put("water_breathing_lingering", "§rLingering Potion of Water Breathing");
      POTION_NAME_INDEX.put("long_water_breathing_lingering", "§rLingering Potion of Water Breathing");
      POTION_NAME_INDEX.put("healing_lingering", "§rLingering Potion of Healing");
      POTION_NAME_INDEX.put("strong_healing_lingering", "§rLingering Potion of Healing");
      POTION_NAME_INDEX.put("harming_lingering", "§rLingering Potion of Harming");
      POTION_NAME_INDEX.put("strong_harming_lingering", "§rLingering Potion of Harming");
      POTION_NAME_INDEX.put("poison_lingering", "§rLingering Potion of Poisen");
      POTION_NAME_INDEX.put("long_poison_lingering", "§rLingering Potion of Poisen");
      POTION_NAME_INDEX.put("strong_poison_lingering", "§rLingering Potion of Poisen");
      POTION_NAME_INDEX.put("regeneration_lingering", "§rLingering Potion of Regeneration");
      POTION_NAME_INDEX.put("long_regeneration_lingering", "§rLingering Potion of Regeneration");
      POTION_NAME_INDEX.put("strong_regeneration_lingering", "§rLingering Potion of Regeneration");
      POTION_NAME_INDEX.put("strength_lingering", "§rLingering Potion of Strength");
      POTION_NAME_INDEX.put("long_strength_lingering", "§rLingering Potion of Strength");
      POTION_NAME_INDEX.put("strong_strength_lingering", "§rLingering Potion of Strength");
      POTION_NAME_INDEX.put("weakness_lingering", "§rLingering Potion of Weakness");
      POTION_NAME_INDEX.put("long_weakness_lingering", "§rLingering Potion of Weakness");
      POTION_NAME_INDEX.put("luck_lingering", "§rLingering Potion of Luck");
      POTION_NAME_INDEX.put("luck", "§rPotion of Luck");
      POTION_NAME_INDEX.put("luck_splash", "§rSplash Potion of Luck");
   }
}
