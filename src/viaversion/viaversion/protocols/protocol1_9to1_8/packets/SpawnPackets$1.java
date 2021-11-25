package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class SpawnPackets$1 extends ValueTransformer {
   SpawnPackets$1(Type var1) {
      super(var1);
   }

   public Double transform(PacketWrapper var1, Integer var2) {
      return Double.valueOf((double)var2.intValue() / 32.0D);
   }
}
