package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import net.aK0;
import net.q1;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_13To1_12_2$16$1 implements PacketHandler {
   final aK0 a;

   Protocol1_13To1_12_2$16$1(aK0 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      q1.b();
      int var3 = ((Integer)var1.passthrough(Type.VAR_INT)).intValue();
      int var4 = 0;
      if(var4 < var3) {
         byte var5 = ((Byte)var1.read(Type.BYTE)).byteValue();
         int var6 = (var5 & 240) >> 4;
         var1.write(Type.VAR_INT, Integer.valueOf(var6));
         var1.passthrough(Type.BYTE);
         var1.passthrough(Type.BYTE);
         byte var7 = (byte)(var5 & 15);
         var1.write(Type.BYTE, Byte.valueOf(var7));
         var1.write(Type.OPTIONAL_COMPONENT, (Object)null);
         ++var4;
      }

   }
}
