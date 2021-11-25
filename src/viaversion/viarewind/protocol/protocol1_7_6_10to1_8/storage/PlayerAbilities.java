package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.Objects;
import net.cA;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viaversion.api.data.UserConnection;

public class PlayerAbilities extends cA {
   private boolean sprinting;
   private boolean allowFly;
   private boolean flying;
   private boolean invincible;
   private boolean creative;
   private float flySpeed;
   private float walkSpeed;

   public PlayerAbilities(UserConnection var1) {
      super(var1);
   }

   public PlayerAbilities(UserConnection var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, float var7, float var8) {
      super(var1);
      this.sprinting = var2;
      this.allowFly = var3;
      this.flying = var4;
      this.invincible = var5;
      this.creative = var6;
      this.flySpeed = var7;
      this.walkSpeed = var8;
   }

   public byte getFlags() {
      EntityTracker.b();
      byte var2 = 0;
      if(this.invincible) {
         var2 = (byte)(var2 | 8);
      }

      if(this.allowFly) {
         var2 = (byte)(var2 | 4);
      }

      if(this.flying) {
         var2 = (byte)(var2 | 2);
      }

      if(this.creative) {
         var2 = (byte)(var2 | 1);
      }

      return var2;
   }

   public boolean isSprinting() {
      return this.sprinting;
   }

   public void setSprinting(boolean var1) {
      this.sprinting = var1;
   }

   public boolean isAllowFly() {
      return this.allowFly;
   }

   public void setAllowFly(boolean var1) {
      this.allowFly = var1;
   }

   public boolean isFlying() {
      return this.flying;
   }

   public void setFlying(boolean var1) {
      this.flying = var1;
   }

   public boolean isInvincible() {
      return this.invincible;
   }

   public void setInvincible(boolean var1) {
      this.invincible = var1;
   }

   public boolean isCreative() {
      return this.creative;
   }

   public void setCreative(boolean var1) {
      this.creative = var1;
   }

   public float getFlySpeed() {
      return this.flySpeed;
   }

   public void setFlySpeed(float var1) {
      this.flySpeed = var1;
   }

   public float getWalkSpeed() {
      return this.walkSpeed;
   }

   public void setWalkSpeed(float var1) {
      this.walkSpeed = var1;
   }

   public boolean equals(Object var1) {
      String var2 = EntityTracker.b();
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlayerAbilities)) {
         return false;
      } else {
         PlayerAbilities var3 = (PlayerAbilities)var1;
         return this.sprinting == var3.sprinting && this.allowFly == var3.allowFly && this.flying == var3.flying && this.invincible == var3.invincible && this.creative == var3.creative && Float.compare(var3.flySpeed, this.flySpeed) == 0 && Float.compare(var3.walkSpeed, this.walkSpeed) == 0;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{Boolean.valueOf(this.sprinting), Boolean.valueOf(this.allowFly), Boolean.valueOf(this.flying), Boolean.valueOf(this.invincible), Boolean.valueOf(this.creative), Float.valueOf(this.flySpeed), Float.valueOf(this.walkSpeed)});
   }

   public String toString() {
      return "PlayerAbilities{sprinting=" + this.sprinting + ", allowFly=" + this.allowFly + ", flying=" + this.flying + ", invincible=" + this.invincible + ", creative=" + this.creative + ", flySpeed=" + this.flySpeed + ", walkSpeed=" + this.walkSpeed + '}';
   }
}
