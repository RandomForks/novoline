package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage$Property;
import viaversion.viarewind.utils.ChatUtil;
import viaversion.viaversion.api.minecraft.item.Item;

public class GameProfileStorage$GameProfile {
   public String name;
   public String displayName;
   public int b;
   public UUID uuid;
   public List properties = new ArrayList();
   public int gamemode = 0;

   public GameProfileStorage$GameProfile(UUID var1, String var2) {
      this.name = var2;
      this.uuid = var1;
   }

   public Item getSkull() {
      CompoundTag var2 = new CompoundTag("");
      EntityTracker.b();
      CompoundTag var3 = new CompoundTag("SkullOwner");
      var2.put(var3);
      var3.put(new StringTag("Id", this.uuid.toString()));
      CompoundTag var4 = new CompoundTag("Properties");
      var3.put(var4);
      ListTag var5 = new ListTag("textures", CompoundTag.class);
      var4.put(var5);
      Iterator var6 = this.properties.iterator();
      if(var6.hasNext()) {
         GameProfileStorage$Property var7 = (GameProfileStorage$Property)var6.next();
         if(var7.name.equals("textures")) {
            CompoundTag var8 = new CompoundTag("");
            var8.put(new StringTag("Value", var7.value));
            if(var7.signature != null) {
               var8.put(new StringTag("Signature", var7.signature));
            }

            var5.add(var8);
         }
      }

      return new Item(397, (byte)1, (short)3, var2);
   }

   public String getDisplayName() {
      String var1 = EntityTracker.b();
      String var2 = this.displayName == null?this.name:this.displayName;
      if(var2.length() > 16) {
         var2 = ChatUtil.removeUnusedColor(var2, 'f');
      }

      if(var2.length() > 16) {
         var2 = ChatColor.stripColor(var2);
      }

      if(var2.length() > 16) {
         var2 = var2.substring(0, 16);
      }

      return var2;
   }

   public void setDisplayName(String var1) {
      this.displayName = var1;
   }
}
