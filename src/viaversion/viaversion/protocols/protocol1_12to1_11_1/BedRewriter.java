package viaversion.viaversion.protocols.protocol1_12to1_11_1;

import net.aRp;
import net.acE;
import viaversion.viaversion.api.minecraft.item.Item;

public class BedRewriter {
   public static void toClientItem(Item var0) {
      acE[] var1 = aRp.a();
      if(var0 != null) {
         if(var0.getIdentifier() == 355 && var0.getData() == 0) {
            var0.setData((short)14);
         }

      }
   }

   public static void toServerItem(Item var0) {
      acE[] var1 = aRp.a();
      if(var0 != null) {
         if(var0.getIdentifier() == 355 && var0.getData() == 14) {
            var0.setData((short)0);
         }

      }
   }
}
