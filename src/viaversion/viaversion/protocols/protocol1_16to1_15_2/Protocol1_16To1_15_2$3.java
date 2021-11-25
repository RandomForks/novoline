package viaversion.viaversion.protocols.protocol1_16to1_15_2;

import com.google.gson.JsonElement;
import net.acE;
import net.km;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;

class Protocol1_16To1_15_2$3 extends acE {
   final km c;
   final Protocol1_16To1_15_2 this$0;

   Protocol1_16To1_15_2$3(Protocol1_16To1_15_2 var1, km var2) {
      this.this$0 = var1;
      this.c = var2;
   }

   public void registerMap() {
      this.a(Type.COMPONENT);
      this.a(Type.BYTE);
      this.a(Protocol1_16To1_15_2$3::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(km var0, PacketWrapper var1) throws Exception {
      var0.processText((JsonElement)var1.get(Type.COMPONENT, 0));
      var1.write(Type.UUID, Protocol1_16To1_15_2.access$000());
   }
}
