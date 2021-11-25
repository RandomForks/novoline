package viaversion.viaversion.api.minecraft.item;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import net.acE;
import org.jetbrains.annotations.Nullable;

public class Item {
   @SerializedName(
      value = "identifier",
      alternate = {"id"}
   )
   private int identifier;
   private byte amount;
   private short data;
   private CompoundTag tag;
   private static int[] d;

   public Item() {
   }

   public Item(int var1, byte var2, short var3, @Nullable CompoundTag var4) {
      this.identifier = var1;
      this.amount = var2;
      this.data = var3;
      this.tag = var4;
   }

   public Item(Item var1) {
      this(var1.getIdentifier(), var1.getAmount(), var1.getData(), var1.getTag());
   }

   public int getIdentifier() {
      return this.identifier;
   }

   public void setIdentifier(int var1) {
      this.identifier = var1;
   }

   public byte getAmount() {
      return this.amount;
   }

   public void setAmount(byte var1) {
      this.amount = var1;
   }

   public short getData() {
      return this.data;
   }

   public void setData(short var1) {
      this.data = var1;
   }

   @Nullable
   public CompoundTag getTag() {
      return this.tag;
   }

   public void setTag(@Nullable CompoundTag var1) {
      this.tag = var1;
   }

   public boolean equals(Object var1) {
      int[] var2 = b();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Item var3 = (Item)var1;
         return this.identifier != var3.identifier?false:(this.amount != var3.amount?false:(this.data != var3.data?false:Objects.equals(this.tag, var3.tag)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      b();
      int var2 = this.identifier;
      var2 = 31 * var2 + this.amount;
      var2 = 31 * var2 + this.data;
      var2 = 31 * var2 + (this.tag != null?this.tag.hashCode():0);
      return var2;
   }

   public String toString() {
      int[] var1 = b();
      String var10000 = "Item{identifier=" + this.identifier + ", amount=" + this.amount + ", data=" + this.data + ", tag=" + this.tag + '}';
      if(acE.b() == null) {
         b(new int[1]);
      }

      return var10000;
   }

   public static void b(int[] var0) {
      d = var0;
   }

   public static int[] b() {
      return d;
   }

   static {
      b((int[])null);
   }
}
