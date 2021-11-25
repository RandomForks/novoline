package viaversion.viabackwards.api.entities.storage;

import net.cQ;
import viaversion.viabackwards.api.entities.storage.EntityStorage;

public abstract class EntityPositionStorage implements EntityStorage {
   private double b;
   private double a;
   private double c;

   public double a() {
      return this.b;
   }

   public double c() {
      return this.a;
   }

   public double b() {
      return this.c;
   }

   public void a(double var1, double var3, double var5, boolean var7) {
      boolean var8 = cQ.d();
      this.b += var1;
      this.a += var3;
      this.c += var5;
      this.b = var1;
      this.a = var3;
      this.c = var5;
   }
}
