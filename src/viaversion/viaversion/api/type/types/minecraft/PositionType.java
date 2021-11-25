package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.acE;
import net.nP;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.type.Type;

public class PositionType extends Type {
   public PositionType() {
      super("Position", Position.class);
   }

   public Position a(ByteBuf var1) {
      nP.b();
      long var3 = var1.readLong();
      long var5 = var3 >> 38;
      long var7 = var3 >> 26 & 4095L;
      long var9 = var3 << 38 >> 38;
      Position var10000 = new Position((int)var5, (short)((int)var7), (int)var9);
      if(acE.b() == null) {
         nP.b("nMnGs");
      }

      return var10000;
   }

   public void write(ByteBuf var1, Position var2) {
      var1.writeLong(((long)var2.getX() & 67108863L) << 38 | ((long)var2.getY() & 4095L) << 26 | (long)(var2.getZ() & 67108863));
   }
}
