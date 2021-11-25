package viaversion.viaversion.protocols.protocol1_16to1_15_2;

import java.util.UUID;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;

class Protocol1_16To1_15_2$1 extends acE {
   final Protocol1_16To1_15_2 this$0;

   Protocol1_16To1_15_2$1(Protocol1_16To1_15_2 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Protocol1_16To1_15_2$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      UUID var1 = UUID.fromString((String)var0.read(Type.STRING));
      var0.write(Type.UUID_INT_ARRAY, var1);
   }
}
