package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.Objects;
import net.bgR;
import net.cA;
import net.cf;

public class PlayerAbilities extends cA {
   private boolean i;
   private boolean g;
   private boolean d;
   private boolean f;
   private boolean h;
   private float e;
   private float c;

   public PlayerAbilities(bgR var1) {
      super(var1);
   }

   public PlayerAbilities(bgR var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, float var7, float var8) {
      super(var1);
      this.i = var2;
      this.g = var3;
      this.d = var4;
      this.f = var5;
      this.h = var6;
      this.e = var7;
      this.c = var8;
   }

   public byte f() {
      cf.b();
      byte var2 = 0;
      if(this.f) {
         var2 = (byte)(var2 | 8);
      }

      if(this.g) {
         var2 = (byte)(var2 | 4);
      }

      if(this.d) {
         var2 = (byte)(var2 | 2);
      }

      if(this.h) {
         var2 = (byte)(var2 | 1);
      }

      return var2;
   }

   public boolean h() {
      return this.i;
   }

   public void a(boolean var1) {
      this.i = var1;
   }

   public boolean e() {
      return this.g;
   }

   public void c(boolean var1) {
      this.g = var1;
   }

   public boolean d() {
      return this.d;
   }

   public void e(boolean var1) {
      this.d = var1;
   }

   public boolean j() {
      return this.f;
   }

   public void d(boolean var1) {
      this.f = var1;
   }

   public boolean g() {
      return this.h;
   }

   public void f(boolean var1) {
      this.h = var1;
   }

   public float a() {
      return this.e;
   }

   public void b(float var1) {
      this.e = var1;
   }

   public float i() {
      return this.c;
   }

   public void a(float var1) {
      this.c = var1;
   }

   public boolean equals(Object var1) {
      String var2 = cf.b();
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlayerAbilities)) {
         return false;
      } else {
         PlayerAbilities var3 = (PlayerAbilities)var1;
         return this.i == var3.i && this.g == var3.g && this.d == var3.d && this.f == var3.f && this.h == var3.h && Float.compare(var3.e, this.e) == 0 && Float.compare(var3.c, this.c) == 0;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{Boolean.valueOf(this.i), Boolean.valueOf(this.g), Boolean.valueOf(this.d), Boolean.valueOf(this.f), Boolean.valueOf(this.h), Float.valueOf(this.e), Float.valueOf(this.c)});
   }

   public String toString() {
      return "PlayerAbilities{sprinting=" + this.i + ", allowFly=" + this.g + ", flying=" + this.d + ", invincible=" + this.f + ", creative=" + this.h + ", flySpeed=" + this.e + ", walkSpeed=" + this.c + '}';
   }
}
