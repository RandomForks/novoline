package viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import net.acE;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.Protocol1_9_3To1_9_1_2;

class Protocol1_9_3To1_9_1_2$6 extends acE {
   final Protocol1_9_3To1_9_1_2 this$0;

   Protocol1_9_3To1_9_1_2$6(Protocol1_9_3To1_9_1_2 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.FLOAT);
      this.a(Protocol1_9_3To1_9_1_2.ADJUST_PITCH);
   }
}
