package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.google.gson.JsonElement;
import net.aKt;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;

class Protocol1_13To1_12_2$23$1 implements PacketHandler {
   final aKt a;

   Protocol1_13To1_12_2$23$1(aKt var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      ChatRewriter.processTranslate((JsonElement)var1.passthrough(Type.COMPONENT));
      ChatRewriter.processTranslate((JsonElement)var1.passthrough(Type.COMPONENT));
   }
}
