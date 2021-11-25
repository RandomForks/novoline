package de.gerrygames.viarewind.utils.math;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import java.util.Objects;

public class Vector3d {
   double x;
   double y;
   double z;
   private static int[] b;

   public Vector3d(double var1, double var3, double var5) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
   }

   public Vector3d() {
   }

   public void set(Vector3d var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
   }

   public Vector3d set(double var1, double var3, double var5) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
      return this;
   }

   public Vector3d multiply(double var1) {
      this.x *= var1;
      this.y *= var1;
      this.z *= var1;
      return this;
   }

   public Vector3d add(Vector3d var1) {
      this.x += var1.x;
      this.y += var1.y;
      this.z += var1.z;
      return this;
   }

   public Vector3d b(Vector3d var1) {
      e();
      this.x -= var1.x;
      this.y -= var1.y;
      this.z -= var1.z;
      if(PacketRemapper.b() == null) {
         b(new int[3]);
      }

      return this;
   }

   public double length() {
      return Math.sqrt(this.lengthSquared());
   }

   public double lengthSquared() {
      return this.x * this.x + this.y * this.y + this.z * this.z;
   }

   public Vector3d normalize() {
      double var1 = this.length();
      this.multiply(1.0D / var1);
      return this;
   }

   public Vector3d clone() {
      return new Vector3d(this.x, this.y, this.z);
   }

   public double getX() {
      return this.x;
   }

   public void setX(double var1) {
      this.x = var1;
   }

   public double getY() {
      return this.y;
   }

   public void setY(double var1) {
      this.y = var1;
   }

   public double getZ() {
      return this.z;
   }

   public void setZ(double var1) {
      this.z = var1;
   }

   public boolean equals(Object var1) {
      int[] var2 = e();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Vector3d var3 = (Vector3d)var1;
         return Double.compare(var3.x, this.x) == 0 && Double.compare(var3.y, this.y) == 0 && Double.compare(var3.z, this.z) == 0;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{Double.valueOf(this.x), Double.valueOf(this.y), Double.valueOf(this.z)});
   }

   public String toString() {
      return "Vector3d{x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
   }

   public static void b(int[] var0) {
      b = var0;
   }

   public static int[] e() {
      return b;
   }

   static {
      b((int[])null);
   }
}
