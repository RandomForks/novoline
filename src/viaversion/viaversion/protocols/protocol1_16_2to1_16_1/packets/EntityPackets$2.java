package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import net.acE;
import net.dJ;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class EntityPackets$2 extends acE {
   public void registerMap() {
      this.a(EntityPackets$2::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      String var1 = (String)var0.read(Type.STRING);
      var0.write(Type.NBT, dJ.a(var1));
   }
}
