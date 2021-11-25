package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aWp;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.NamedSoundRewriter;

class WorldPackets$8$1 implements PacketHandler {
   final aWp a;

   WorldPackets$8$1(aWp var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      String var2 = NamedSoundRewriter.getNewId((String)var1.get(Type.STRING, 0));
      var1.set(Type.STRING, 0, var2);
   }
}
