package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_10To1_9_3_4$1 extends ValueTransformer {
   Protocol1_10To1_9_3_4$1(Type var1) {
      super(var1);
   }

   public Float transform(PacketWrapper var1, Short var2) throws Exception {
      return Float.valueOf((float)var2.shortValue() / 63.0F);
   }
}
