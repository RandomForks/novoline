package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import net.a2Y;
import net.acE;
import net.rX;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;

class Protocol1_10To1_9_3_4$6 extends acE {
   final Protocol1_10To1_9_3_4 this$0;

   Protocol1_10To1_9_3_4$6(Protocol1_10To1_9_3_4 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      int var10000 = a2Y.b();
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      int var1 = var10000;
      this.a(Type.BYTE);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(rX.a, Protocol1_10To1_9_3_4.TRANSFORM_METADATA);
      if(acE.b() == null) {
         ++var1;
         a2Y.b(var1);
      }

   }
}
