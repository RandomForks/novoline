package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.S3;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$6 extends acE {
   public void registerMap() {
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(WorldPackets$6::lambda$registerMap$0);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var2 = ((Integer)var0.read(Type.INT)).intValue();
      var0.write(Type.INT, Integer.valueOf(var2));
      S3.b();
      int var3 = 0;
      if(var3 < var2) {
         var0.passthrough(Type.UNSIGNED_BYTE);
         var0.passthrough(Type.UNSIGNED_BYTE);
         var0.passthrough(Type.UNSIGNED_BYTE);
         ++var3;
      }

   }
}
