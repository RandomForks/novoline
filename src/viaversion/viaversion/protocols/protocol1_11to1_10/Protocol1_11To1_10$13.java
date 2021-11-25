package viaversion.viaversion.protocols.protocol1_11to1_10;

import net.acE;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10;

class Protocol1_11To1_10$13 extends acE {
   final Protocol1_11To1_10 this$0;

   Protocol1_11To1_10$13(Protocol1_11To1_10 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.POSITION);
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(Type.FLOAT, Protocol1_11To1_10.access$000());
      this.a(Type.FLOAT, Protocol1_11To1_10.access$000());
      this.a(Type.FLOAT, Protocol1_11To1_10.access$000());
   }
}
