package viaversion.viaversion.api.minecraft;

public class VillagerData {
   private final int type;
   private final int profession;
   private final int level;

   public VillagerData(int var1, int var2, int var3) {
      this.type = var1;
      this.profession = var2;
      this.level = var3;
   }

   public int getType() {
      return this.type;
   }

   public int getProfession() {
      return this.profession;
   }

   public int getLevel() {
      return this.level;
   }
}
