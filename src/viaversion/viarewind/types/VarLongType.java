package viaversion.viarewind.types;

import io.netty.buffer.ByteBuf;
import net.acE;
import net.zT;
import viaversion.viaversion.api.type.Type;

public class VarLongType extends Type {
   public static final VarLongType VAR_LONG = new VarLongType();

   public VarLongType() {
      super("VarLong", Long.class);
   }

   public Long read(ByteBuf var1) throws Exception {
      zT.b();
      long var3 = 0L;
      int var5 = 0;

      while(true) {
         byte var6 = var1.readByte();
         var3 |= (long)((var6 & 127) << var5++ * 7);
         if(var5 > 10) {
            throw new RuntimeException("VarLong too big");
         }

         if((var6 & 128) != 128) {
            break;
         }
      }

      return Long.valueOf(var3);
   }

   public void write(ByteBuf var1, Long var2) throws Exception {
      int[] var3 = zT.b();
      if((var2.longValue() & -128L) != 0L) {
         var1.writeByte((int)(var2.longValue() & 127L) | 128);
         var2 = Long.valueOf(var2.longValue() >>> 7);
      }

      var1.writeByte(var2.intValue());
      if(acE.b() == null) {
         zT.b(new int[3]);
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
