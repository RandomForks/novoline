package viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$1 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(WorldPackets$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(Type.BOOLEAN, Boolean.valueOf(true));
   }
}
