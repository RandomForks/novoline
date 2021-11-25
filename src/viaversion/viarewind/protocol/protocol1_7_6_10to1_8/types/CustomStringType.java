package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.type.PartialType;
import viaversion.viaversion.api.type.Type;

public class CustomStringType extends PartialType {
   public CustomStringType(Integer var1) {
      super(var1, "String[]", String[].class);
   }

   public String[] read(ByteBuf var1, Integer var2) throws Exception {
      acE[] var3 = Particle.b();
      if(var1.readableBytes() < var2.intValue() / 4) {
         throw new RuntimeException("Readable bytes does not match expected!");
      } else {
         String[] var4 = new String[var2.intValue()];
         int var5 = 0;
         if(var5 < var2.intValue()) {
            var4[var5] = (String)Type.STRING.read(var1);
            ++var5;
         }

         return var4;
      }
   }

   public void write(ByteBuf var1, Integer var2, String[] var3) throws Exception {
      Particle.b();
      int var6 = var3.length;
      int var7 = 0;
      if(var7 < var6) {
         String var8 = var3[var7];
         Type.STRING.write(var1, var8);
         ++var7;
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
