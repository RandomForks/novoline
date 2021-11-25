package viaversion.viaversion.api.boss;

public enum BossColor {
   PINK(0),
   BLUE(1),
   RED(2),
   GREEN(3),
   YELLOW(4),
   PURPLE(5),
   WHITE(6);

   private final int id;

   private BossColor(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}
