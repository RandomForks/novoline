package de.gerrygames.viarewind.replacement;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import net.Zx;
import net.aMz;
import net.amf;

public class Replacement {
   private int id;
   private int data;
   private String name;
   private String resetName;
   private String bracketName;

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
      this.resetName = "§r" + var3;
      this.bracketName = " §r§7(" + var3 + "§r§7)";
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

   public aMz a(aMz var1) {
      Zx.a();
      var1.a(this.id);
      if(this.data != -1) {
         var1.a((short)this.data);
      }

      if(this.name != null) {
         CompoundTag var3 = var1.d() == null?new CompoundTag(""):var1.d();
         if(!var3.contains("display")) {
            var3.put(new CompoundTag("display"));
         }

         CompoundTag var4 = (CompoundTag)var3.get("display");
         if(var4.contains("Name")) {
            StringTag var5 = (StringTag)var4.get("Name");
            if(!var5.getValue().equals(this.resetName) && !var5.getValue().endsWith(this.bracketName)) {
               var5.setValue(var5.getValue() + this.bracketName);
            }
         }

         var4.put(new StringTag("Name", this.resetName));
         var1.a(var3);
      }

      return var1;
   }

   public amf a(amf var1) {
      return new amf(this.id, this.data == -1?var1.a():this.data);
   }
}
