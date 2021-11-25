package viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import java.util.UUID;
import net.acE;
import net.axs;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.storage.EntityTracker1_16;

final class EntityPackets$1 extends acE {
   public void registerMap() {
      this.a(EntityPackets$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.passthrough(Type.VAR_INT)).intValue();
      ((EntityTracker1_16)var0.user().b(EntityTracker1_16.class)).addEntity(var1, axs.LIGHTNING_BOLT);
      var0.write(Type.UUID, UUID.randomUUID());
      var0.write(Type.VAR_INT, Integer.valueOf(axs.LIGHTNING_BOLT.getId()));
      var0.read(Type.BYTE);
      var0.passthrough(Type.DOUBLE);
      var0.passthrough(Type.DOUBLE);
      var0.passthrough(Type.DOUBLE);
      var0.write(Type.BYTE, Byte.valueOf((byte)0));
      var0.write(Type.BYTE, Byte.valueOf((byte)0));
      var0.write(Type.INT, Integer.valueOf(0));
      var0.write(Type.SHORT, Short.valueOf((short)0));
      var0.write(Type.SHORT, Short.valueOf((short)0));
      var0.write(Type.SHORT, Short.valueOf((short)0));
   }
}
