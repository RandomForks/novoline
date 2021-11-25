package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.google.gson.JsonObject;
import net.aMW;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.chat.ChatRewriter;

class PlayerPackets$1$1 implements PacketHandler {
   final aMW a;

   PlayerPackets$1$1(aMW var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      try {
         JsonObject var2 = (JsonObject)var1.get(Type.COMPONENT, 0);
         ChatRewriter.toClient(var2, var1.user());
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}
