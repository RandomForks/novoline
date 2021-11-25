package viaversion.viabackwards.protocol.protocol1_15_2to1_16;

import com.google.gson.JsonElement;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_15_2To1_16$2 extends acE {
   final Protocol1_15_2To1_16 this$0;

   Protocol1_15_2To1_16$2(Protocol1_15_2To1_16 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
      this.a(Type.BYTE);
      this.a(Type.UUID, Type.NOTHING);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      Protocol1_15_2To1_16.access$000(this.this$0).processText((JsonElement)var1.passthrough(Type.COMPONENT));
   }
}
