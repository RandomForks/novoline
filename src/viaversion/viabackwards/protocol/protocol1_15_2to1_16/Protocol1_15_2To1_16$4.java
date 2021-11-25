package viaversion.viabackwards.protocol.protocol1_15_2to1_16;

import java.util.UUID;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_15_2To1_16$4 extends acE {
   final Protocol1_15_2To1_16 this$0;

   Protocol1_15_2To1_16$4(Protocol1_15_2To1_16 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Protocol1_15_2To1_16$4::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      UUID var1 = (UUID)var0.read(Type.UUID_INT_ARRAY);
      var0.write(Type.STRING, var1.toString());
   }
}
