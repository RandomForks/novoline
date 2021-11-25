package viaversion.viafabric.protocol;

import net.anh;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

class ViaFabricHostnameProtocol$1$1 extends ValueTransformer {
   final anh d;

   ViaFabricHostnameProtocol$1$1(anh var1, Type var2) {
      super(var2);
      this.d = var1;
   }

   public String transform(PacketWrapper var1, String var2) {
      return var2;
   }
}
