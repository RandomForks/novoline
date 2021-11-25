package viaversion.viabackwards.protocol.protocol1_14_4to1_15.data;

import net.N0;
import net.cW;

public class EntityTypeMapping {
   public static int getOldEntityId(int var0) {
      String var1 = cW.b();
      return var0 == 4?N0.PUFFERFISH.getId():(var0 >= 5?var0 - 1:var0);
   }
}
