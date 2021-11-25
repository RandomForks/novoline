package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aMe;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.sounds.Effect;

class WorldPackets$2$1 implements PacketHandler {
   final aMe a;

   WorldPackets$2$1(aMe var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.get(Type.INT, 0)).intValue();
      var2 = Effect.getNewId(var2);
      var1.set(Type.INT, 0, Integer.valueOf(var2));
   }
}
