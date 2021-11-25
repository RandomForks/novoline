package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import net.acE;
import net.rX;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;

class Protocol1_10To1_9_3_4$7 extends acE {
   final Protocol1_10To1_9_3_4 this$0;

   Protocol1_10To1_9_3_4$7(Protocol1_10To1_9_3_4 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(rX.a, Protocol1_10To1_9_3_4.TRANSFORM_METADATA);
   }
}
