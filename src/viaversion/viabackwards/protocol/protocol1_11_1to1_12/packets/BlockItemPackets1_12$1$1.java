package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import net.acx;
import net.aqw;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_12$1$1 implements PacketHandler {
   final acx a;

   BlockItemPackets1_12$1$1(acx var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      aqw.a();
      int var3 = ((Integer)var1.passthrough(Type.VAR_INT)).intValue();
      int var4 = 0;
      if(var4 < var3 * 3) {
         var1.passthrough(Type.BYTE);
         ++var4;
      }

   }
}
