package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

public class StatisticData {
   private final int categoryId;
   private final int newId;
   private final int value;

   public StatisticData(int var1, int var2, int var3) {
      this.categoryId = var1;
      this.newId = var2;
      this.value = var3;
   }

   public int getCategoryId() {
      return this.categoryId;
   }

   public int getNewId() {
      return this.newId;
   }

   public int getValue() {
      return this.value;
   }
}
