package viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import net.Gh;
import viaversion.viaversion.api.type.Type;

public class VarIntArrayType extends Type {
   public VarIntArrayType() {
      super("int[]", int[].class);
   }

   public int[] read(ByteBuf var1) throws Exception {
      Gh.b();
      int var3 = Type.VAR_INT.readPrimitive(var1);
      Preconditions.checkArgument(var1.isReadable(var3));
      int[] var4 = new int[var3];
      int var5 = 0;
      if(var5 < var4.length) {
         var4[var5] = Type.VAR_INT.readPrimitive(var1);
         ++var5;
      }

      return var4;
   }

   public void write(ByteBuf var1, int[] var2) throws Exception {
      Gh.b();
      Type.VAR_INT.writePrimitive(var1, var2.length);
      int var5 = var2.length;
      int var6 = 0;
      if(var6 < var5) {
         int var7 = var2[var6];
         Type.VAR_INT.writePrimitive(var1, var7);
         ++var6;
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
