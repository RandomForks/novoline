package viaversion.viaversion.api.entities;

import net.t4;
import org.jetbrains.annotations.Nullable;

public interface EntityType {
   int getId();

   @Nullable
   EntityType getParent();

   String name();

   default boolean is(EntityType... var1) {
      t4.c();
      int var4 = var1.length;
      int var5 = 0;
      if(var5 < var4) {
         EntityType var6 = var1[var5];
         if(this.is(var6)) {
            return true;
         }

         ++var5;
      }

      return false;
   }

   default boolean is(EntityType var1) {
      return this == var1;
   }

   default boolean isOrHasParent(EntityType var1) {
      boolean var2 = t4.c();
      if(this.equals(var1)) {
         return true;
      } else {
         EntityType var3 = this.getParent();
         return false;
      }
   }
}
