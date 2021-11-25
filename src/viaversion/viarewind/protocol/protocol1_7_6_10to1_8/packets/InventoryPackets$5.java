package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import java.util.function.Function;
import net.acE;
import net.afz;
import net.cB;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.Windows$Furnace;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$5 extends acE {
   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(InventoryPackets$5::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      short var2 = ((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue();
      afz.a();
      cB var3 = (cB)var0.user().b(cB.class);
      short var4 = var3.b(var2);
      short var5 = ((Short)var0.get(Type.SHORT, 0)).shortValue();
      short var6 = ((Short)var0.get(Type.SHORT, 1)).shortValue();
      if(var4 != -1) {
         if(var4 == 2) {
            Windows$Furnace var7 = (Windows$Furnace)var3.c.computeIfAbsent(Short.valueOf(var2), InventoryPackets$5::lambda$null$0);
            if(var5 == 0 || var5 == 1) {
               if(var5 == 0) {
                  var7.setFuelLeft(var6);
               }

               var7.setMaxFuel(var6);
               if(var7.getMaxFuel() == 0) {
                  var0.cancel();
                  return;
               }

               var6 = (short)(200 * var7.getFuelLeft() / var7.getMaxFuel());
               var0.set(Type.SHORT, 0, Short.valueOf((short)1));
               var0.set(Type.SHORT, 1, Short.valueOf(var6));
            }

            if(var5 == 2 || var5 == 3) {
               if(var5 == 2) {
                  var7.setProgress(var6);
               }

               var7.setMaxProgress(var6);
               if(var7.getMaxProgress() == 0) {
                  var0.cancel();
                  return;
               }

               var6 = (short)(200 * var7.getProgress() / var7.getMaxProgress());
               var0.set(Type.SHORT, 0, Short.valueOf((short)0));
               var0.set(Type.SHORT, 1, Short.valueOf(var6));
            }
         }

         if(var4 == 4) {
            if(var5 > 2) {
               var0.cancel();
               return;
            }
         } else if(var4 == 8) {
            var3.f = var6;
            var3.d = var2;
         }

      }
   }

   private static Windows$Furnace lambda$null$0(Short var0) {
      return new Windows$Furnace();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
