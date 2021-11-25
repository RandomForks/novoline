package viaversion.viaversion.api;

import java.util.Objects;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;

public class Triple {
   private final Object first;
   private final Object second;
   private final Object third;

   public Triple(@Nullable Object var1, @Nullable Object var2, @Nullable Object var3) {
      this.first = var1;
      this.second = var2;
      this.third = var3;
   }

   @Nullable
   public Object getFirst() {
      return this.first;
   }

   @Nullable
   public Object getSecond() {
      return this.second;
   }

   @Nullable
   public Object getThird() {
      return this.third;
   }

   public String toString() {
      return "Triple{" + this.first + ", " + this.second + ", " + this.third + '}';
   }

   public boolean equals(Object var1) {
      boolean var2 = PacketWrapper.k();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Triple var3 = (Triple)var1;
         return !Objects.equals(this.first, var3.first)?false:(!Objects.equals(this.second, var3.second)?false:Objects.equals(this.third, var3.third));
      } else {
         return false;
      }
   }

   public int hashCode() {
      boolean var1 = PacketWrapper.k();
      int var2 = this.first != null?this.first.hashCode():0;
      var2 = 31 * var2 + (this.second != null?this.second.hashCode():0);
      var2 = 31 * var2 + (this.third != null?this.third.hashCode():0);
      if(acE.b() == null) {
         PacketWrapper.b(false);
      }

      return var2;
   }
}
