package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.type.Type;

public class Position1_14Type extends Type {
   public Position1_14Type() {
      super("Position", Position.class);
   }

   public Position read(ByteBuf var1) {
      long var3 = var1.readLong();
      long var5 = var3 >> 38;
      nP.b();
      long var7 = var3 << 52 >> 52;
      long var9 = var3 << 26 >> 38;
      return new Position((int)var5, (short)((int)var7), (int)var9);
   }

   public void write(ByteBuf var1, Position var2) {
      var1.writeLong(((long)var2.getX() & 67108863L) << 38 | (long)(var2.getY() & 4095) | ((long)var2.getZ() & 67108863L) << 12);
   }
}
