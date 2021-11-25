package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.google.gson.JsonElement;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;

class Protocol1_13To1_12_2$9 extends acE {
   final Protocol1_13To1_12_2 this$0;

   Protocol1_13To1_12_2$9(Protocol1_13To1_12_2 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(Protocol1_13To1_12_2$9::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ChatRewriter.processTranslate((JsonElement)var0.passthrough(Type.COMPONENT));
   }
}
