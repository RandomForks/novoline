package viaversion.viarewind.protocol.protocol1_8to1_9;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_8TO1_9$1 extends ValueTransformer {
   Protocol1_8TO1_9$1(Type var1) {
      super(var1);
   }

   public Integer transform(PacketWrapper var1, Double var2) {
      return Integer.valueOf((int)(var2.doubleValue() * 32.0D));
   }
}
