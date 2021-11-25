package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import net.aWC;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

class Protocol1_13To1_12_2$35$1 extends ValueTransformer {
   final aWC d;

   Protocol1_13To1_12_2$35$1(aWC var1, Type var2) {
      super(var2);
      this.d = var1;
   }

   public Byte transform(PacketWrapper var1, Integer var2) throws Exception {
      return Byte.valueOf((byte)(var2.intValue() + 1));
   }
}
