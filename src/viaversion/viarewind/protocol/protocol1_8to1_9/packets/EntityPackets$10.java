package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

final class EntityPackets$10 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(EntityPackets$10::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(Type.BOOLEAN, Boolean.valueOf(true));
   }
}
