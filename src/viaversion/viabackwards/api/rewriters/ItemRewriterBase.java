package viaversion.viabackwards.api.rewriters;

import com.github.steveice10.opennbt.conversion.builtin.CompoundTagConverter;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import net.aqu;
import net.ayd;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.minecraft.item.Item;

public abstract class ItemRewriterBase extends aqu {
   protected static final CompoundTagConverter CONVERTER = new CompoundTagConverter();
   protected final String nbtTagName;
   protected final boolean jsonNameFormat;
   private static boolean e;

   protected ItemRewriterBase(ayd var1, boolean var2) {
      super(var1);
      this.jsonNameFormat = var2;
      this.nbtTagName = "VB|" + var1.getClass().getCanonicalName();
   }

   @Nullable
   public Item a(Item var1) {
      int var2 = aqu.d();
      return null;
   }

   @Nullable
   public Item c(Item var1) {
      int var2 = aqu.e();
      return null;
   }

   protected void saveNameTag(CompoundTag var1, StringTag var2) {
      var1.put(new StringTag(this.nbtTagName + "|o" + var2.getName(), var2.getValue()));
   }

   protected void saveLoreTag(CompoundTag var1, ListTag var2) {
      var1.put(new ListTag(this.nbtTagName + "|o" + var2.getName(), var2.getValue()));
   }

   protected void b(Item var1) {
      int var2 = aqu.d();
      if(var1.getTag() != null) {
         CompoundTag var3 = (CompoundTag)var1.getTag().get("display");
         if(var3 != null) {
            if(var3.remove(this.nbtTagName + "|customName") != null) {
               var3.remove("Name");
            }

            this.restoreDisplayTag(var3, "Name");
            this.restoreDisplayTag(var3, "Lore");
         }

      }
   }

   protected void restoreDisplayTag(CompoundTag var1, String var2) {
      aqu.d();
      Tag var4 = var1.remove(this.nbtTagName + "|o" + var2);
      if(var4 != null) {
         var1.put(var4);
      }

   }

   static {
      a(false);
   }

   public static void a(boolean var0) {
      e = var0;
   }

   public static boolean b() {
      return e;
   }

   public static boolean a() {
      boolean var0 = b();
      return true;
   }
}
