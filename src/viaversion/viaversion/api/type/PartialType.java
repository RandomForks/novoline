package viaversion.viaversion.api.type;

import io.netty.buffer.ByteBuf;
import net.a26;
import viaversion.viaversion.api.type.Type;

public abstract class PartialType extends Type {
   private final Object param;
   private static String[] ai;

   public PartialType(Object var1, String var2, Class var3) {
      a26.b();
      super(var2, var3);
      this.param = var1;
   }

   public abstract Object read(ByteBuf var1, Object var2) throws Exception;

   public abstract void write(ByteBuf var1, Object var2, Object var3) throws Exception;

   public Object read(ByteBuf var1) throws Exception {
      return this.read(var1, this.param);
   }

   public void write(ByteBuf var1, Object var2) throws Exception {
      this.write(var1, this.param, var2);
   }

   public static void b(String[] var0) {
      ai = var0;
   }

   public static String[] a() {
      return ai;
   }

   static {
      if(a() != null) {
         b(new String[1]);
      }

   }
}
