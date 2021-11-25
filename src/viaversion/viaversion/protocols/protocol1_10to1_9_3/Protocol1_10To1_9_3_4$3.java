package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import net.acE;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;

class Protocol1_10To1_9_3_4$3 extends acE {
   final Protocol1_10To1_9_3_4 this$0;

   Protocol1_10To1_9_3_4$3(Protocol1_10To1_9_3_4 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.STRING);
      this.a(Type.VAR_INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.FLOAT);
      this.a(Type.UNSIGNED_BYTE, Protocol1_10To1_9_3_4.TO_NEW_PITCH);
   }
}
