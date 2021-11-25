package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.Objects;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;

public class Windows$Furnace {
   private short fuelLeft = 0;
   private short maxFuel = 0;
   private short progress = 0;
   private short maxProgress = 200;

   public Windows$Furnace() {
   }

   public Windows$Furnace(short var1, short var2, short var3, short var4) {
      this.fuelLeft = var1;
      this.maxFuel = var2;
      this.progress = var3;
      this.maxProgress = var4;
   }

   public short getFuelLeft() {
      return this.fuelLeft;
   }

   public void setFuelLeft(short var1) {
      this.fuelLeft = var1;
   }

   public short getMaxFuel() {
      return this.maxFuel;
   }

   public void setMaxFuel(short var1) {
      this.maxFuel = var1;
   }

   public short getProgress() {
      return this.progress;
   }

   public void setProgress(short var1) {
      this.progress = var1;
   }

   public short getMaxProgress() {
      return this.maxProgress;
   }

   public void setMaxProgress(short var1) {
      this.maxProgress = var1;
   }

   public boolean equals(Object var1) {
      String var2 = EntityTracker.b();
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof Windows$Furnace)) {
         return false;
      } else {
         Windows$Furnace var3 = (Windows$Furnace)var1;
         return this.fuelLeft == var3.fuelLeft && this.maxFuel == var3.maxFuel && this.progress == var3.progress && this.maxProgress == var3.maxProgress;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{Short.valueOf(this.fuelLeft), Short.valueOf(this.maxFuel), Short.valueOf(this.progress), Short.valueOf(this.maxProgress)});
   }

   public String toString() {
      return "Furnace{fuelLeft=" + this.fuelLeft + ", maxFuel=" + this.maxFuel + ", progress=" + this.progress + ", maxProgress=" + this.maxProgress + '}';
   }
}
