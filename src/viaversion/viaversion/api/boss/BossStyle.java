package viaversion.viaversion.api.boss;

public enum BossStyle {
   SOLID(0),
   SEGMENTED_6(1),
   SEGMENTED_10(2),
   SEGMENTED_12(3),
   SEGMENTED_20(4);

   private final int id;

   private BossStyle(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}
