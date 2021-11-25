package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import net.Gh;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;

public class UnsignedShortType extends Type implements TypeConverter {
   public UnsignedShortType() {
      super("Integer", Integer.class);
   }

   public Integer read(ByteBuf var1) {
      return Integer.valueOf(var1.readUnsignedShort());
   }

   public void write(ByteBuf var1, Integer var2) {
      var1.writeShort(var2.intValue());
   }

   public Integer from(Object var1) {
      String var2 = Gh.b();
      return var1 instanceof Number?Integer.valueOf(((Number)var1).intValue()):(var1 instanceof Boolean?Integer.valueOf(((Boolean)var1).booleanValue()?1:0):(Integer)var1);
   }
}
