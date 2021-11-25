package viaversion.viarewind.storage;

import net.acE;

public class BlockState {
   private int id;
   private int data;
   private static String c;

   public BlockState(int var1, int var2) {
      b();
      this.id = var1;
      this.data = var2;
      if(acE.b() == null) {
         b("Kb6D6b");
      }

   }

   public static BlockState rawToState(int var0) {
      return new BlockState(var0 >> 4, var0 & 15);
   }

   public static int stateToRaw(BlockState var0) {
      return var0.getId() << 4 | var0.getData() & 15;
   }

   public int getId() {
      return this.id;
   }

   public int getData() {
      return this.data;
   }

   public String toString() {
      String var1 = b();
      return "BlockState{id: " + this.id + ", data: " + this.data + "}";
   }

   public static void b(String var0) {
      c = var0;
   }

   public static String b() {
      return c;
   }

   static {
      b((String)null);
   }
}
