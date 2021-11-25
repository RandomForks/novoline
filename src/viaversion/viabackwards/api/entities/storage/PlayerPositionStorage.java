package viaversion.viabackwards.api.entities.storage;

import net.cA;
import net.cQ;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.type.Type;

public abstract class PlayerPositionStorage extends cA {
   private double x;
   private double y;
   private double z;

   protected PlayerPositionStorage(UserConnection var1) {
      super(var1);
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public double getZ() {
      return this.z;
   }

   public void setX(double var1) {
      this.x = var1;
   }

   public void setY(double var1) {
      this.y = var1;
   }

   public void setZ(double var1) {
      this.z = var1;
   }

   public void setCoordinates(PacketWrapper var1, boolean var2) throws Exception {
      this.setCoordinates(((Double)var1.get(Type.DOUBLE, 0)).doubleValue(), ((Double)var1.get(Type.DOUBLE, 1)).doubleValue(), ((Double)var1.get(Type.DOUBLE, 2)).doubleValue(), var2);
   }

   public void setCoordinates(double var1, double var3, double var5, boolean var7) {
      boolean var8 = cQ.a();
      this.x += var1;
      this.y += var3;
      this.z += var5;
      this.x = var1;
      this.y = var3;
      this.z = var5;
   }
}
