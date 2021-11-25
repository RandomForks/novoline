package viaversion.viaversion.api.remapper;

import java.util.function.Function;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

class PacketRemapper$1 extends ValueTransformer {
   final Function val$transformer;
   final acE e;

   PacketRemapper$1(acE var1, Type var2, Function var3) {
      super(var2);
      this.e = var1;
      this.val$transformer = var3;
   }

   public Object transform(PacketWrapper var1, Object var2) throws Exception {
      return this.val$transformer.apply(var2);
   }
}
