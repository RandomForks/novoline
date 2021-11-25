package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.type.Type;

public class IntArrayType extends Type {
   public IntArrayType() {
      super("int[]", int[].class);
   }

   public int[] read(ByteBuf var1) throws Exception {
      byte var3 = var1.readByte();
      Particle.b();
      int[] var4 = new int[var3];
      byte var5 = 0;
      if(var5 < var3) {
         var4[var5] = var1.readInt();
         ++var5;
      }

      return var4;
   }

   public void write(ByteBuf var1, int[] var2) throws Exception {
      Particle.b();
      var1.writeByte(var2.length);
      int var5 = var2.length;
      int var6 = 0;
      if(var6 < var5) {
         int var7 = var2[var6];
         var1.writeInt(var7);
         ++var6;
      }

   }
}
