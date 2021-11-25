package viaversion.viarewind.replacement;

import java.util.HashMap;
import net.acE;
import viaversion.viarewind.replacement.Replacement;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.minecraft.item.Item;

public class ReplacementRegistry {
   private HashMap itemReplacements = new HashMap();
   private HashMap blockReplacements = new HashMap();
   private static boolean b;

   public void registerItem(int var1, Replacement var2) {
      this.registerItem(var1, -1, var2);
   }

   public void registerBlock(int var1, Replacement var2) {
      this.registerBlock(var1, -1, var2);
   }

   public void registerItemBlock(int var1, Replacement var2) {
      this.registerItemBlock(var1, -1, var2);
   }

   public void registerItem(int var1, int var2, Replacement var3) {
      this.itemReplacements.put(Integer.valueOf(combine(var1, var2)), var3);
   }

   public void registerBlock(int var1, int var2, Replacement var3) {
      this.blockReplacements.put(Integer.valueOf(combine(var1, var2)), var3);
   }

   public void registerItemBlock(int var1, int var2, Replacement var3) {
      this.registerItem(var1, var2, var3);
      this.registerBlock(var1, var2, var3);
   }

   public Item replace(Item var1) {
      b();
      Replacement var3 = (Replacement)this.itemReplacements.get(Integer.valueOf(combine(var1.getIdentifier(), var1.getData())));
      if(var3 == null) {
         var3 = (Replacement)this.itemReplacements.get(Integer.valueOf(combine(var1.getIdentifier(), -1)));
      }

      Item var10000 = var3 == null?var1:var3.replace(var1);
      if(acE.b() == null) {
         b(false);
      }

      return var10000;
   }

   public BlockState replace(BlockState var1) {
      a();
      Replacement var3 = (Replacement)this.blockReplacements.get(Integer.valueOf(combine(var1.getId(), var1.getData())));
      if(var3 == null) {
         var3 = (Replacement)this.blockReplacements.get(Integer.valueOf(combine(var1.getId(), -1)));
      }

      return var3 == null?var1:var3.replace(var1);
   }

   private static int combine(int var0, int var1) {
      return var0 << 16 | var1 & '\uffff';
   }

   public static void b(boolean var0) {
      b = var0;
   }

   public static boolean b() {
      return b;
   }

   public static boolean a() {
      boolean var0 = b();
      return true;
   }

   static {
      if(!a()) {
         b(true);
      }

   }
}
