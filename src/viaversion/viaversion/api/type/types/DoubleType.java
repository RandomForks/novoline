package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import net.Gh;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;

public class DoubleType extends Type implements TypeConverter {
   public DoubleType() {
      super("Double", Double.class);
   }

   public Double read(ByteBuf var1) {
      return Double.valueOf(var1.readDouble());
   }

   public void write(ByteBuf var1, Double var2) {
      var1.writeDouble(var2.doubleValue());
   }

   public Double from(Object var1) {
      String var2 = Gh.b();
      return var1 instanceof Number?Double.valueOf(((Number)var1).doubleValue()):(var1 instanceof Boolean?Double.valueOf(((Boolean)var1).booleanValue()?1.0D:0.0D):(Double)var1);
   }
}
