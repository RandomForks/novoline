package viaversion.viaversion.api.remapper;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueReader;
import viaversion.viaversion.api.remapper.ValueWriter;
import viaversion.viaversion.api.type.Type;

public class TypeRemapper implements ValueReader, ValueWriter {
   private final Type type;

   public TypeRemapper(Type var1) {
      this.type = var1;
   }

   public Object read(PacketWrapper var1) throws Exception {
      return var1.read(this.type);
   }

   public void write(PacketWrapper var1, Object var2) {
      var1.write(this.type, var2);
   }
}
