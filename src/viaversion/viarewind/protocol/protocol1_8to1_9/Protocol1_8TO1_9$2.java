package viaversion.viarewind.protocol.protocol1_8to1_9;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_8TO1_9$2 extends ValueTransformer {
   Protocol1_8TO1_9$2(Type var1) {
      super(var1);
   }

   public Byte transform(PacketWrapper var1, Float var2) throws Exception {
      return Byte.valueOf((byte)((int)(var2.floatValue() / 360.0F * 256.0F)));
   }
}
