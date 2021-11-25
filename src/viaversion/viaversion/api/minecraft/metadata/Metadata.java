package viaversion.viaversion.api.minecraft.metadata;

import java.util.Objects;
import net.acE;
import viaversion.viaversion.api.minecraft.metadata.MetaType;

public class Metadata {
   private int id;
   private MetaType metaType;
   private Object value;
   private static acE[] d;

   public Metadata(int var1, MetaType var2, Object var3) {
      this.id = var1;
      this.metaType = var2;
      this.value = var3;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public MetaType getMetaType() {
      return this.metaType;
   }

   public void setMetaType(MetaType var1) {
      this.metaType = var1;
   }

   public Object getValue() {
      return this.value;
   }

   public Object getCastedValue() {
      return this.value;
   }

   public void setValue(Object var1) {
      this.value = var1;
   }

   public boolean equals(Object var1) {
      acE[] var2 = b();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Metadata var3 = (Metadata)var1;
         return this.id != var3.id?false:(!Objects.equals(this.metaType, var3.metaType)?false:Objects.equals(this.value, var3.value));
      } else {
         return false;
      }
   }

   public int hashCode() {
      b();
      int var2 = this.id;
      var2 = 31 * var2 + (this.metaType != null?this.metaType.hashCode():0);
      var2 = 31 * var2 + (this.value != null?this.value.hashCode():0);
      return var2;
   }

   public String toString() {
      acE[] var1 = b();
      String var10000 = "Metadata{id=" + this.id + ", metaType=" + this.metaType + ", value=" + this.value + '}';
      if(acE.b() == null) {
         b(new acE[5]);
      }

      return var10000;
   }

   public static void b(acE[] var0) {
      d = var0;
   }

   public static acE[] b() {
      return d;
   }

   static {
      b(new acE[4]);
   }
}
