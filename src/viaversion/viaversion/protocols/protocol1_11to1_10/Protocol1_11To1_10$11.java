package viaversion.viaversion.protocols.protocol1_11to1_10;

import net.acE;
import net.cT;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10;

class Protocol1_11To1_10$11 extends acE {
   final Protocol1_11To1_10 this$0;

   Protocol1_11To1_10$11(Protocol1_11To1_10 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Protocol1_11To1_10$11::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      cT var1 = (cT)var0.user().b(cT.class);
      int var2 = ((Integer)var0.get(Type.INT, 0)).intValue();
      var1.c(var2);
   }
}
