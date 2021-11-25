package viaversion.viarewind.protocol.protocol1_7_0_5to1_7_6_10;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_7_0_5to1_7_6_10$1 extends ValueTransformer {
   Protocol1_7_0_5to1_7_6_10$1(Type var1) {
      super(var1);
   }

   public String transform(PacketWrapper var1, String var2) {
      return var2.replace("-", "");
   }
}
