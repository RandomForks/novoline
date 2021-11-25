package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import java.util.Objects;
import net.bgR;
import net.cA;

public class PlayerPosition extends cA {
   private double i;
   private double h;
   private double g;
   private float f;
   private float e;
   private boolean onGround;
   private int confirmId = -1;

   public PlayerPosition(bgR var1, double var2, double var4, double var6, float var8, float var9, boolean var10, int var11) {
      super(var1);
      this.i = var2;
      this.h = var4;
      this.g = var6;
      this.f = var8;
      this.e = var9;
      this.onGround = var10;
      this.confirmId = var11;
   }

   public PlayerPosition(bgR var1) {
      super(var1);
   }

   public void setPos(double var1, double var3, double var5) {
      this.i = var1;
      this.h = var3;
      this.g = var5;
   }

   public void b(float var1) {
      this.f = var1 % 360.0F;
   }

   public void a(float var1) {
      this.e = var1 % 360.0F;
   }

   public double c() {
      return this.i;
   }

   public void c(double var1) {
      this.i = var1;
   }

   public double g() {
      return this.h;
   }

   public void a(double var1) {
      this.h = var1;
   }

   public double e() {
      return this.g;
   }

   public void b(double var1) {
      this.g = var1;
   }

   public float a() {
      return this.f;
   }

   public float f() {
      return this.e;
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
         return Double.compare(var3.i, this.i) == 0 && Double.compare(var3.h, this.h) == 0 && Double.compare(var3.g, this.g) == 0 && Float.compare(var3.f, this.f) == 0 && Float.compare(var3.e, this.e) == 0 && this.onGround == var3.onGround && this.confirmId == var3.confirmId;
      }
   }

   public int hashCode() {
      String[] var1 = EntityTracker.d();
      return Objects.hash(new Object[]{Double.valueOf(this.i), Double.valueOf(this.h), Double.valueOf(this.g), Float.valueOf(this.f), Float.valueOf(this.e), Boolean.valueOf(this.onGround), Integer.valueOf(this.confirmId)});
   }

   public String toString() {
      return "PlayerPosition{posX=" + this.i + ", posY=" + this.h + ", posZ=" + this.g + ", yaw=" + this.f + ", pitch=" + this.e + ", onGround=" + this.onGround + ", confirmId=" + this.confirmId + '}';
   }
}
