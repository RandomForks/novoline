package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.minecraft.EulerAngle;
import viaversion.viaversion.api.type.Type;

public class EulerAngleType extends Type {
   public EulerAngleType() {
      super("EulerAngle", EulerAngle.class);
   }

   public EulerAngle read(ByteBuf var1) throws Exception {
      float var2 = Type.FLOAT.readPrimitive(var1);
      float var3 = Type.FLOAT.readPrimitive(var1);
      float var4 = Type.FLOAT.readPrimitive(var1);
      return new EulerAngle(var2, var3, var4);
   }

   public void write(ByteBuf var1, EulerAngle var2) throws Exception {
      Type.FLOAT.writePrimitive(var1, var2.getX());
      Type.FLOAT.writePrimitive(var1, var2.getY());
      Type.FLOAT.writePrimitive(var1, var2.getZ());
   }
}
