package viaversion.viaversion.protocols.protocol1_16_2to1_16_1;

import net.aRX;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_16_2To1_16_1$2 extends acE {
   final aRX c;

   Protocol1_16_2To1_16_1$2(aRX var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Protocol1_16_2To1_16_1$2::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      String var1 = (String)var0.read(Type.STRING);
      var0.write(Type.VAR_INT, Integer.valueOf(0));
      var0.write(Type.STRING, var1);
   }
}
