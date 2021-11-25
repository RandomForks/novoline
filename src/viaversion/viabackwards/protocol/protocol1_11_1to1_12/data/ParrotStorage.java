package viaversion.viabackwards.protocol.protocol1_11_1to1_12.data;

import net.acE;
import viaversion.viabackwards.api.entities.storage.EntityStorage;
import viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.ShoulderTracker;

public class ParrotStorage implements EntityStorage {
   private boolean tamed;
   private boolean sitting;

   public ParrotStorage() {
      int var10000 = ShoulderTracker.d();
      super();
      int var1 = var10000;
      this.tamed = true;
      this.sitting = true;
      if(acE.b() == null) {
         ++var1;
         ShoulderTracker.b(var1);
      }

   }

   public boolean isTamed() {
      return this.tamed;
   }

   public void setTamed(boolean var1) {
      this.tamed = var1;
   }

   public boolean isSitting() {
      return this.sitting;
   }

   public void setSitting(boolean var1) {
      this.sitting = var1;
   }
}
