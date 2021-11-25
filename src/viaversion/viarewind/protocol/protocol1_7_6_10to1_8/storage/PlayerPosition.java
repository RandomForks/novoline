package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import net.cA;
import viaversion.viaversion.api.data.UserConnection;

public class PlayerPosition extends cA {
   private double d;
   private double i;
   private double j;
   private float h;
   private float e;
   private boolean onGround;
   private boolean positionPacketReceived;
   private double receivedPosY;

   public PlayerPosition(UserConnection var1) {
      super(var1);
   }

   public void setPos(double var1, double var3, double var5) {
      this.d = var1;
      this.i = var3;
      this.j = var5;
   }

   public boolean isPositionPacketReceived() {
      return this.positionPacketReceived;
   }

   public void setPositionPacketReceived(boolean var1) {
      this.positionPacketReceived = var1;
   }

   public double getReceivedPosY() {
      return this.receivedPosY;
   }

   public void setReceivedPosY(double var1) {
      this.receivedPosY = var1;
   }

   public double g() {
      return this.d;
   }

   public void d(double var1) {
      this.d = var1;
   }

   public double f() {
      return this.i;
   }

   public void c(double var1) {
      this.i = var1;
   }

   public double e() {
      return this.j;
   }

   public void a(double var1) {
      this.j = var1;
   }

   public float c() {
      return this.h;
   }

   public void b(float var1) {
      this.h = var1;
   }

   public float a() {
      return this.e;
   }

   public void a(float var1) {
      this.e = var1;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public void setOnGround(boolean var1) {
      this.onGround = var1;
   }
}
