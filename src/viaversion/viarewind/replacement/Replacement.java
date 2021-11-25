package viaversion.viarewind.replacement;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import viaversion.viarewind.replacement.ReplacementRegistry;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.minecraft.item.Item;

public class Replacement {
   private int id;
   private int data;
   private String name;
   private String d;
   private String c;

   public Replacement(int var1) {
      this(var1, -1);
   }

   public Replacement(int var1, int var2) {
      this(var1, var2, (String)null);
   }

   public Replacement(int var1, String var2) {
      this(var1, -1, var2);
   }

   public Replacement(int var1, int var2, String var3) {
      this.id = var1;
      this.data = var2;
      this.name = var3;
      this.d = "§r" + var3;
      this.c = " §r§7(" + var3 + "§r§7)";
   }

   public int getId() {
      return this.id;
   }

   public int getData() {
      return this.data;
   }

   public String getName() {
      return this.name;
   }

   public Item replace(Item var1) {
      ReplacementRegistry.a();
      var1.setIdentifier(this.id);
      if(this.data != -1) {
         var1.setData((short)this.data);
      }

      if(this.name != null) {
         CompoundTag var3 = var1.getTag() == null?new CompoundTag(""):var1.getTag();
         if(!var3.contains("display")) {
            var3.put(new CompoundTag("display"));
         }

         CompoundTag var4 = (CompoundTag)var3.get("display");
         if(var4.contains("Name")) {
            StringTag var5 = (StringTag)var4.get("Name");
            if(!var5.getValue().equals(this.d) && !var5.getValue().endsWith(this.c)) {
               var5.setValue(var5.getValue() + this.c);
            }
         }

         var4.put(new StringTag("Name", this.d));
         var1.setTag(var3);
      }

      return var1;
   }

   public BlockState replace(BlockState var1) {
      return new BlockState(this.id, this.data == -1?var1.getData():this.data);
   }
}
