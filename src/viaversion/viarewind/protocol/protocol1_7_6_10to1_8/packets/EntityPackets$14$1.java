package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.an5;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets$14$1 implements PacketHandler {
   final an5 a;

   EntityPackets$14$1(an5 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      var1.read(Type.BYTE);
   }
}
