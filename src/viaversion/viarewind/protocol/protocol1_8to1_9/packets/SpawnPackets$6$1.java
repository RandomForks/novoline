package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.a7J;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class SpawnPackets$6$1 implements ValueCreator {
   final a7J a;

   SpawnPackets$6$1(a7J var1) {
      this.a = var1;
   }

   public void write(PacketWrapper var1) throws Exception {
      var1.write(Type.SHORT, Short.valueOf((short)0));
   }
}
