package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;

public class VoidType extends Type implements TypeConverter {
   public VoidType() {
      super("Void", Void.class);
   }

   public Void read(ByteBuf var1) {
      return null;
   }

   public void write(ByteBuf var1, Void var2) {
   }

   public Void from(Object var1) {
      return null;
   }
}
