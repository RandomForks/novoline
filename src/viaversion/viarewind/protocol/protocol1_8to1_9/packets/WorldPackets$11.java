package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$11 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.BYTE);
      this.a(WorldPackets$11::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Boolean var10000 = (Boolean)var0.read(Type.BOOLEAN);
   }
}
