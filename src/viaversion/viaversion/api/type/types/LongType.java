package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import net.Gh;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.TypeConverter;

public class LongType extends Type implements TypeConverter {
   public LongType() {
      super("Long", Long.class);
   }

   public Long read(ByteBuf var1) {
      return Long.valueOf(var1.readLong());
   }

   public void write(ByteBuf var1, Long var2) {
      var1.writeLong(var2.longValue());
   }

   public Long from(Object var1) {
      String var2 = Gh.b();
      return var1 instanceof Number?Long.valueOf(((Number)var1).longValue()):(var1 instanceof Boolean?Long.valueOf(((Boolean)var1).booleanValue()?1L:0L):(Long)var1);
   }
}
