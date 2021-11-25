package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets.SoundPackets1_12;
import viaversion.viaversion.api.type.Type;

class SoundPackets1_12$1 extends acE {
   final SoundPackets1_12 this$0;

   SoundPackets1_12$1(SoundPackets1_12 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.STRING);
      this.a(Type.VAR_INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
   }
}
