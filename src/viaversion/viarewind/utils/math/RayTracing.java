package viaversion.viarewind.utils.math;

import viaversion.viarewind.utils.math.AABB;
import viaversion.viarewind.utils.math.Ray3d;
import viaversion.viarewind.utils.math.Vector3d;

public class RayTracing {
   public static Vector3d trace(Ray3d var0, AABB var1, double var2) {
      Vector3d.e();
      Vector3d var5 = new Vector3d(1.0D / var0.dir.x, 1.0D / var0.dir.y, 1.0D / var0.dir.z);
      boolean var6 = var5.x < 0.0D;
      boolean var7 = var5.y < 0.0D;
      boolean var8 = var5.z < 0.0D;
      Vector3d var9 = var1.max;
      double var10 = (var9.x - var0.start.x) * var5.x;
      var9 = var1.min;
      double var12 = (var9.x - var0.start.x) * var5.x;
      var9 = var1.max;
      double var14 = (var9.y - var0.start.y) * var5.y;
      var9 = var1.min;
      double var16 = (var9.y - var0.start.y) * var5.y;
      if(var10 <= var16 && var14 <= var12) {
         if(var14 > var10) {
            var10 = var14;
         }

         if(var16 < var12) {
            var12 = var16;
         }

         var9 = var8?var1.max:var1.min;
         double var18 = (var9.z - var0.start.z) * var5.z;
         var9 = var1.min;
         double var20 = (var9.z - var0.start.z) * var5.z;
         if(var10 <= var20 && var18 <= var12) {
            if(var18 > var10) {
               var10 = var18;
            }

            if(var20 < var12) {
               var12 = var20;
            }

            return var10 <= var2 && var12 > 0.0D?var0.start.clone().add(var0.dir.clone().normalize().multiply(var10)):null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }
}
