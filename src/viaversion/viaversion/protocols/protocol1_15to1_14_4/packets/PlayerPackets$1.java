package viaversion.viaversion.protocols.protocol1_15to1_14_4.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$1 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(PlayerPackets$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(Type.LONG, Long.valueOf(0L));
   }
}
