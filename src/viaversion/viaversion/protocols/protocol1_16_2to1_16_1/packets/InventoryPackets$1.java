package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$1 extends acE {
   public void registerMap() {
      this.a(InventoryPackets$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.passthrough(Type.VAR_INT);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.passthrough(Type.BOOLEAN);
      var0.write(Type.BOOLEAN, Boolean.valueOf(false));
      var0.write(Type.BOOLEAN, Boolean.valueOf(false));
      var0.write(Type.BOOLEAN, Boolean.valueOf(false));
      var0.write(Type.BOOLEAN, Boolean.valueOf(false));
   }
}
