package viaversion.viaversion.api.minecraft;

import net.acE;
import viaversion.viaversion.api.minecraft.BlockFace;

public class Position {
   private final int x;
   private final short y;
   private final int z;
   private static String[] c;

   public Position(int var1, short var2, int var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   public Position(Position var1) {
      this(var1.getX(), var1.getY(), var1.getZ());
   }

   public Position getRelative(BlockFace var1) {
      return new Position(this.x + var1.getModX(), (short)(this.y + var1.getModY()), this.z + var1.getModZ());
   }

   public int getX() {
      return this.x;
   }

   public short getY() {
      return this.y;
   }

   public int getZ() {
      return this.z;
   }

   public boolean equals(Object var1) {
      String[] var2 = b();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Position var3 = (Position)var1;
         return this.x != var3.x?false:(this.y != var3.y?false:this.z == var3.z);
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.x;
      var1 = 31 * var1 + this.y;
      var1 = 31 * var1 + this.z;
      return var1;
   }

   public String toString() {
      String[] var1 = b();
      String var10000 = "Position{x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
      if(acE.b() == null) {
         b(new String[3]);
      }

      return var10000;
   }

   public static void b(String[] var0) {
      c = var0;
   }

   public static String[] b() {
      return c;
   }

   static {
      b(new String[1]);
   }
}
