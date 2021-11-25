package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.ShortTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.ReplacementRegistry1_7_6_10to1_8;
import de.gerrygames.viarewind.utils.ChatUtil;
import java.util.ArrayList;
import java.util.List;
import net.aMz;
import net.vL;

public class ItemRewriter {
   public static aMz a(aMz var0) {
      boolean var1 = ReplacementRegistry1_7_6_10to1_8.a();
      if(var0 == null) {
         return null;
      } else {
         CompoundTag var2 = var0.d();
         if(var2 == null) {
            var0.a(var2 = new CompoundTag(""));
         }

         CompoundTag var3 = new CompoundTag("ViaRewind1_7_6_10to1_8");
         var2.put(var3);
         var3.put(new ShortTag("id", (short)var0.e()));
         var3.put(new ShortTag("data", var0.c()));
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
               if(var10 == 8) {
                  String var12 = "§r§7Depth Strider ";
                  var5.remove(var9);
                  var12 = var12 + (String)vL.c.getOrDefault(Short.valueOf(var11), "enchantment.level." + var11);
                  var7.add(new StringTag("", var12));
                  break;
               }
            }

            if(!var7.isEmpty()) {
               if(var4 == null) {
                  var2.put(var4 = new CompoundTag("display"));
                  var3.put(new ByteTag("noDisplay"));
               }

               ListTag var17 = (ListTag)var4.get("Lore");
               if(var17 == null) {
                  var4.put(var17 = new ListTag("Lore", StringTag.class));
               }

               var7.addAll(var17.getValue());
               var17.setValue(var7);
            }
         }

         if(var0.e() == 387 && var2.contains("pages")) {
            ListTag var13 = (ListTag)var2.get("pages");
            ListTag var14 = new ListTag("pages", StringTag.class);
            var3.put(var14);
            int var15 = 0;
            if(var15 < var13.size()) {
               StringTag var18 = (StringTag)var13.get(var15);
               String var19 = var18.getValue();
               var14.add(new StringTag(var18.getName(), var19));
               var19 = ChatUtil.jsonToLegacy(var19);
               var18.setValue(var19);
               ++var15;
            }
         }

         ReplacementRegistry1_7_6_10to1_8.a(var0);
         if(var3.size() == 2 && ((Short)var3.get("id").getValue()).shortValue() == var0.e() && ((Short)var3.get("data").getValue()).shortValue() == var0.c()) {
            var0.d().remove("ViaRewind1_7_6_10to1_8");
            if(var0.d().isEmpty()) {
               var0.a((CompoundTag)null);
            }
         }

         return var0;
      }
   }

   public static aMz b(aMz var0) {
      boolean var1 = ReplacementRegistry1_7_6_10to1_8.a();
      if(var0 == null) {
         return null;
      } else {
         CompoundTag var2 = var0.d();
         if(var2 != null && var0.d().contains("ViaRewind1_7_6_10to1_8")) {
            CompoundTag var3 = (CompoundTag)var2.remove("ViaRewind1_7_6_10to1_8");
            var0.a((int)((Short)var3.get("id").getValue()).shortValue());
            var0.a(((Short)var3.get("data").getValue()).shortValue());
            if(var3.contains("noDisplay")) {
               var2.remove("display");
            }

            if(var3.contains("displayName")) {
               CompoundTag var4 = (CompoundTag)var2.get("display");
               if(var4 == null) {
                  var2.put(var4 = new CompoundTag("display"));
               }

               StringTag var5 = (StringTag)var4.get("Name");
               if(var5 == null) {
                  var4.put(new StringTag("Name", (String)var3.get("displayName").getValue()));
               }

               var5.setValue((String)var3.get("displayName").getValue());
            }

            if(var2.contains("display")) {
               ((CompoundTag)var2.get("display")).remove("Name");
            }

            if(var0.e() == 387) {
               ListTag var6 = (ListTag)var3.get("pages");
               var2.remove("pages");
               var2.put(var6);
            }

            return var0;
         } else {
            return var0;
         }
      }
   }
}
