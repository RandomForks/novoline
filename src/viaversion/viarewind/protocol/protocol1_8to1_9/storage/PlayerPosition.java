package viaversion.viarewind.protocol.protocol1_8to1_9.storage;

import java.util.Objects;
import net.cA;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viaversion.api.data.UserConnection;

public class PlayerPosition extends cA {
   private double posX;
   private double posY;
   private double posZ;
   private float yaw;
   private float pitch;
   private boolean onGround;
   private int confirmId = -1;

   public PlayerPosition(UserConnection var1, double var2, double var4, double var6, float var8, float var9, boolean var10, int var11) {
      super(var1);
      this.posX = var2;
      this.posY = var4;
      this.posZ = var6;
      this.yaw = var8;
      this.pitch = var9;
      this.onGround = var10;
      this.confirmId = var11;
   }

   public PlayerPosition(UserConnection var1) {
      super(var1);
   }

   public void setPos(double var1, double var3, double var5) {
      this.posX = var1;
      this.posY = var3;
      this.posZ = var5;
   }

   public void setYaw(float var1) {
      this.yaw = var1 % 360.0F;
   }

   public void setPitch(float var1) {
      this.pitch = var1 % 360.0F;
   }

   public double getPosX() {
      return this.posX;
   }

   public void setPosX(double var1) {
      this.posX = var1;
   }

   public double getPosY() {
      return this.posY;
   }

   public void setPosY(double var1) {
      this.posY = var1;
   }

   public double getPosZ() {
      return this.posZ;
   }

   public void setPosZ(double var1) {
      this.posZ = var1;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public void setOnGround(boolean var1) {
      this.onGround = var1;
   }

   public int getConfirmId() {
      return this.confirmId;
   }

   public void setConfirmId(int var1) {
      this.confirmId = var1;
   }

   public boolean equals(Object var1) {
      String[] var2 = EntityTracker.d();
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlayerPosition)) {
         return false;
      } else {
         PlayerPosition var3 = (PlayerPosition)var1;
         return Double.compare(var3.posX, this.posX) == 0 && Double.compare(var3.posY, this.posY) == 0 && Double.compare(var3.posZ, this.posZ) == 0 && Float.compare(var3.yaw, this.yaw) == 0 && Float.compare(var3.pitch, this.pitch) == 0 && this.onGround == var3.onGround && this.confirmId == var3.confirmId;
      }
   }

   public int hashCode() {
      String[] var1 = EntityTracker.d();
      return Objects.hash(new Object[]{Double.valueOf(this.posX), Double.valueOf(this.posY), Double.valueOf(this.posZ), Float.valueOf(this.yaw), Float.valueOf(this.pitch), Boolean.valueOf(this.onGround), Integer.valueOf(this.confirmId)});
   }

   public String toString() {
      return "PlayerPosition{posX=" + this.posX + ", posY=" + this.posY + ", posZ=" + this.posZ + ", yaw=" + this.yaw + ", pitch=" + this.pitch + ", onGround=" + this.onGround + ", confirmId=" + this.confirmId + '}';
   }
}
