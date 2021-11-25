package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import com.google.gson.JsonElement;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets.ChatPackets1_12;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class ChatPackets1_12$2 extends acE {
   final ChatPackets1_12 this$0;

   ChatPackets1_12$2(ChatPackets1_12 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      JsonElement var2 = (JsonElement)var1.passthrough(Type.COMPONENT);
      ChatPackets1_12.a(this.this$0).processText(var2);
   }
}
