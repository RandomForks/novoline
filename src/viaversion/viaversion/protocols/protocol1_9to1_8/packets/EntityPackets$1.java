package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class EntityPackets$1 extends ValueTransformer {
   EntityPackets$1(Type var1) {
      super(var1);
   }

   public Short transform(PacketWrapper var1, Byte var2) {
      return Short.valueOf((short)(var2.byteValue() * 128));
   }
}
