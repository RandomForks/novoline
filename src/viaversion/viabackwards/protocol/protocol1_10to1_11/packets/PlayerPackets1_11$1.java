package viaversion.viabackwards.protocol.protocol1_10to1_11.packets;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets1_11$1 extends ValueTransformer {
   PlayerPackets1_11$1(Type var1) {
      super(var1);
   }

   public Float transform(PacketWrapper var1, Short var2) throws Exception {
      return Float.valueOf((float)var2.shortValue() / 15.0F);
   }
}
