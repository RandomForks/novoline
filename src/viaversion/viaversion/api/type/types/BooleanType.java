package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import net.Gh;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;

public class BooleanType extends Type implements TypeConverter {
   public BooleanType() {
      super("Boolean", Boolean.class);
   }

   public Boolean read(ByteBuf var1) {
      return Boolean.valueOf(var1.readBoolean());
   }

   public void write(ByteBuf var1, Boolean var2) {
      var1.writeBoolean(var2.booleanValue());
   }

   public Boolean from(Object var1) {
      String var2 = Gh.b();
      return var1 instanceof Number?Boolean.valueOf(((Number)var1).intValue() == 1):(Boolean)var1;
   }
}
