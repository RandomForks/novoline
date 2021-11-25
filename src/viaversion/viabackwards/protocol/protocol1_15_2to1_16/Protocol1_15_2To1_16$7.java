package viaversion.viabackwards.protocol.protocol1_15_2to1_16;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_15_2To1_16$7 extends acE {
   final Protocol1_15_2To1_16 this$0;

   Protocol1_15_2To1_16$7(Protocol1_15_2To1_16 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Protocol1_15_2To1_16$7::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      byte var1 = ((Byte)var0.read(Type.BYTE)).byteValue();
      var1 = (byte)(var1 & 2);
      var0.write(Type.BYTE, Byte.valueOf(var1));
      var0.read(Type.FLOAT);
      var0.read(Type.FLOAT);
   }
}
