package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.type.Type;

public class OptionalVarIntType extends Type {
   public OptionalVarIntType() {
      super("Integer", Integer.class);
   }

   public Integer read(ByteBuf var1) throws Exception {
      nP.b();
      int var3 = Type.VAR_INT.readPrimitive(var1);
      return var3 == 0?null:Integer.valueOf(var3 - 1);
   }

   public void write(ByteBuf var1, Integer var2) throws Exception {
      String var3 = nP.b();
      Type.VAR_INT.writePrimitive(var1, 0);
      Type.VAR_INT.writePrimitive(var1, var2.intValue() + 1);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
