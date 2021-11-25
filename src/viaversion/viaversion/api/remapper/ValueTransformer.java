package viaversion.viaversion.api.remapper;

import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueWriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.exception.InformativeException;

public abstract class ValueTransformer implements ValueWriter {
   private final Type inputType;
   private final Type outputType;
   private static boolean c;

   public ValueTransformer(@Nullable Type var1, Type var2) {
      this.inputType = var1;
      this.outputType = var2;
   }

   public ValueTransformer(Type var1) {
      this((Type)null, var1);
   }

   public abstract Object transform(PacketWrapper var1, Object var2) throws Exception;

   public void write(PacketWrapper var1, Object var2) throws Exception {
      try {
         var1.write(this.outputType, this.transform(var1, var2));
      } catch (InformativeException var4) {
         var4.addSource(this.getClass());
         throw var4;
      }
   }

   @Nullable
   public Type getInputType() {
      return this.inputType;
   }

   public Type getOutputType() {
      return this.outputType;
   }

   public static void b(boolean var0) {
      c = var0;
   }

   public static boolean b() {
      return c;
   }

   public static boolean a() {
      boolean var0 = b();
      return true;
   }

   static {
      if(!b()) {
         b(true);
      }

   }
}
