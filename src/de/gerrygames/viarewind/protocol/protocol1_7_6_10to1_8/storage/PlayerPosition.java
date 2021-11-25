package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import net.bgR;
import net.cA;

public class PlayerPosition extends cA {
   private double d;
   private double i;
   private double j;
   private float h;
   private float e;
   private boolean f;
   private boolean g;
   private double receivedPosY;

   public PlayerPosition(bgR var1) {
      super(var1);
   }

   public void setPos(double var1, double var3, double var5) {
      this.d = var1;
      this.i = var3;
      this.j = var5;
   }

   public boolean d() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
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

   public boolean h() {
      return this.f;
   }

   public void c(boolean var1) {
      this.f = var1;
   }
}
