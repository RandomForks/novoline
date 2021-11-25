package viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.cA;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;

public class BackwardsBlockStorage extends cA {
   private static final IntSet WHITELIST = new IntOpenHashSet(779);
   private final Map blocks = new ConcurrentHashMap();
   private static boolean d;

   public BackwardsBlockStorage(UserConnection var1) {
      super(var1);
   }

   public void checkAndStore(Position var1, int var2) {
      boolean var3 = e();
      if(!WHITELIST.contains(var2)) {
         this.blocks.remove(var1);
      } else {
         this.blocks.put(var1, Integer.valueOf(var2));
      }
   }

   public boolean isWelcome(int var1) {
      return WHITELIST.contains(var1);
   }

   public Integer get(Position var1) {
      return (Integer)this.blocks.get(var1);
   }

   public int remove(Position var1) {
      return ((Integer)this.blocks.remove(var1)).intValue();
   }

   public void clear() {
      this.blocks.clear();
   }

   public Map getBlocks() {
      return this.blocks;
   }

   static {
      a(false);

      for(int var0 = 5265; var0 <= 5286; ++var0) {
         WHITELIST.add(var0);
      }

      for(int var1 = 0; var1 < 256; ++var1) {
         WHITELIST.add(748 + var1);
      }

      for(int var2 = 6854; var2 <= 7173; ++var2) {
         WHITELIST.add(var2);
      }

      WHITELIST.add(1647);

      for(int var3 = 5447; var3 <= 5566; ++var3) {
         WHITELIST.add(var3);
      }

      for(int var4 = 1028; var4 <= 1039; ++var4) {
         WHITELIST.add(var4);
      }

      for(int var5 = 1047; var5 <= 1082; ++var5) {
         WHITELIST.add(var5);
      }

      for(int var6 = 1099; var6 <= 1110; ++var6) {
         WHITELIST.add(var6);
      }

   }

   public static void a(boolean var0) {
      d = var0;
   }

   public static boolean d() {
      return d;
   }

   public static boolean e() {
      boolean var0 = d();
      return true;
   }
}
