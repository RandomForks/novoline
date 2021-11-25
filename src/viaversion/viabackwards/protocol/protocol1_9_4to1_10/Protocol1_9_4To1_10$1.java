package viaversion.viabackwards.protocol.protocol1_9_4to1_10;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_9_4To1_10$1 extends ValueTransformer {
   Protocol1_9_4To1_10$1(Type var1) {
      super(var1);
   }

   public Short transform(PacketWrapper var1, Float var2) throws Exception {
      return Short.valueOf((short)Math.round(var2.floatValue() * 63.5F));
   }
}
