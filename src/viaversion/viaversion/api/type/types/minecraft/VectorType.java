package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.minecraft.Vector;
import viaversion.viaversion.api.type.Type;

public class VectorType extends Type {
   public VectorType() {
      super("Vector", Vector.class);
   }

   public Vector read(ByteBuf var1) throws Exception {
      int var2 = ((Integer)Type.INT.read(var1)).intValue();
      int var3 = ((Integer)Type.INT.read(var1)).intValue();
      int var4 = ((Integer)Type.INT.read(var1)).intValue();
      return new Vector(var2, var3, var4);
   }

   public void write(ByteBuf var1, Vector var2) throws Exception {
      Type.INT.write(var1, Integer.valueOf(var2.c()));
      Type.INT.write(var1, Integer.valueOf(var2.a()));
      Type.INT.write(var1, Integer.valueOf(var2.b()));
   }
}
