package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.acE;
import net.aq6;
import net.cK;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_14$14 extends acE {
   final aq6 c;

   BlockItemPackets1_14$14(aq6 var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(BlockItemPackets1_14$14::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.passthrough(Type.INT)).intValue();
      int var2 = ((Integer)var0.passthrough(Type.INT)).intValue();
      ((cK)var0.user().b(cK.class)).b(var1, var2);
   }
}
