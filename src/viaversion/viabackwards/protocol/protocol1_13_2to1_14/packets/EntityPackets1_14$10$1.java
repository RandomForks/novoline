package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.ao8;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_14$10$1 implements PacketHandler {
   final ao8 a;

   EntityPackets1_14$10$1(ao8 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      var1.write(Type.UNSIGNED_BYTE, Short.valueOf((short)0));
      var1.passthrough(Type.UNSIGNED_BYTE);
      var1.passthrough(Type.STRING);
      var1.read(Type.VAR_INT);
   }
}
