package viaversion.viarewind.utils.math;

import viaversion.viarewind.utils.math.Vector3d;

public class AABB {
   Vector3d min;
   Vector3d max;

   public AABB(Vector3d var1, Vector3d var2) {
      this.min = var1;
      this.max = var2;
   }

   public Vector3d getMin() {
      return this.min;
   }

   public Vector3d getMax() {
      return this.max;
   }
}
