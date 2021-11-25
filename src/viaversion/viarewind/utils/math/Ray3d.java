package viaversion.viarewind.utils.math;

import viaversion.viarewind.utils.math.Vector3d;

public class Ray3d {
   Vector3d start;
   Vector3d dir;

   public Ray3d(Vector3d var1, Vector3d var2) {
      this.start = var1;
      this.dir = var2;
   }

   public Vector3d getStart() {
      return this.start;
   }

   public Vector3d getDir() {
      return this.dir;
   }
}
