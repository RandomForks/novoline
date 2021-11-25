package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import java.util.Map.Entry;
import java.util.function.Predicate;
import net.acE;
import net.aqI;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.BackwardsBlockStorage;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_13$4 extends acE {
   final aqI c;

   BlockItemPackets1_13$4(aqI var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(BlockItemPackets1_13$4::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.passthrough(Type.INT)).intValue() << 4;
      int var2 = ((Integer)var0.passthrough(Type.INT)).intValue() << 4;
      int var3 = var1 + 15;
      int var4 = var2 + 15;
      BackwardsBlockStorage var5 = (BackwardsBlockStorage)var0.user().b(BackwardsBlockStorage.class);
      var5.getBlocks().entrySet().removeIf(BlockItemPackets1_13$4::lambda$null$0);
   }

   private static boolean lambda$null$0(int var0, int var1, int var2, int var3, Entry var4) {
      aqI.a();
      Position var6 = (Position)var4.getKey();
      return var6.getX() >= var0 && var6.getZ() >= var1 && var6.getX() <= var2 && var6.getZ() <= var3;
   }
}
