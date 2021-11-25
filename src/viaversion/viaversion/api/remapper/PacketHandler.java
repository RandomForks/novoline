package viaversion.viaversion.api.remapper;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueWriter;
import viaversion.viaversion.exception.InformativeException;

@FunctionalInterface
public interface PacketHandler extends ValueWriter {
   void handle(PacketWrapper var1) throws Exception;

   default void write(PacketWrapper var1, Object var2) throws Exception {
      PacketHandler var10000 = this;
      PacketWrapper var10001 = var1;

      try {
         var10000.handle(var10001);
      } catch (InformativeException var4) {
         var4.addSource(this.getClass());
         throw var4;
      }
   }
}
