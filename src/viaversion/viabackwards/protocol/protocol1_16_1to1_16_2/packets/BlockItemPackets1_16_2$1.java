package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import net.acE;
import net.aqG;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_16_2$1 extends acE {
   final aqG c;

   BlockItemPackets1_16_2$1(aqG var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(BlockItemPackets1_16_2$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.passthrough(Type.VAR_INT);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.read(Type.BOOLEAN);
      var0.read(Type.BOOLEAN);
      var0.read(Type.BOOLEAN);
      var0.read(Type.BOOLEAN);
   }
}
