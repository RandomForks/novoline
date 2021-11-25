package viaversion.viabackwards.protocol.protocol1_10to1_11;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

public class PotionSplashHandler {
   private static final Int2IntMap DATA = new Int2IntOpenHashMap(14, 1.0F);

   public static int getOldData(int var0) {
      return DATA.get(var0);
   }

   static {
      DATA.defaultReturnValue(-1);
      DATA.put(2039713, 5);
      DATA.put(8356754, 7);
      DATA.put(2293580, 9);
      DATA.put(14981690, 12);
      DATA.put(8171462, 14);
      DATA.put(5926017, 17);
      DATA.put(3035801, 19);
      DATA.put(16262179, 21);
      DATA.put(4393481, 23);
      DATA.put(5149489, 25);
      DATA.put(13458603, 28);
      DATA.put(9643043, 31);
      DATA.put(4738376, 34);
      DATA.put(3381504, 36);
   }
}
