package viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_9_3To1_9_1_2$1 extends ValueTransformer {
   Protocol1_9_3To1_9_1_2$1(Type var1, Type var2) {
      super(var1, var2);
   }

   public Short transform(PacketWrapper var1, Short var2) throws Exception {
      return Short.valueOf((short)Math.round((float)var2.shortValue() / 63.5F * 63.0F));
   }
}
