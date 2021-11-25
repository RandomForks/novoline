package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import com.google.gson.JsonElement;
import net.S3;
import net.acE;
import viaversion.viarewind.utils.ChatUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$20 extends acE {
   public void registerMap() {
      this.a(Type.POSITION);
      this.a(PlayerPackets$20::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      S3.b();
      int var2 = 0;
      if(var2 < 4) {
         var0.write(Type.STRING, ChatUtil.jsonToLegacy((JsonElement)var0.read(Type.COMPONENT)));
         ++var2;
      }

   }
}
