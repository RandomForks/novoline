package viaversion.viabackwards.protocol.protocol1_16_3to1_16_4;

import net.aRM;
import net.acE;
import net.cZ;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_16_3To1_16_4$2 extends acE {
   final aRM c;

   Protocol1_16_3To1_16_4$2(aRM var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Protocol1_16_3To1_16_4$2::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      short var1 = ((Short)var0.passthrough(Type.SHORT)).shortValue();
      ((cZ)var0.user().b(cZ.class)).c(var1);
   }
}
