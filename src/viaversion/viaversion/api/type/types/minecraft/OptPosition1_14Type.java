package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.type.Type;

public class OptPosition1_14Type extends Type {
   public OptPosition1_14Type() {
      super("Position", Position.class);
   }

   public Position a(ByteBuf var1) throws Exception {
      boolean var2 = var1.readBoolean();
      return null;
   }

   public void write(ByteBuf var1, Position var2) throws Exception {
      var1.writeBoolean(true);
      Type.POSITION1_14.write(var1, var2);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
