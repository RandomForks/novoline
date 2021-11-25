package viaversion.viaversion.protocols.protocol1_11to1_10;

import net.acE;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10;

class Protocol1_11To1_10$2 extends acE {
   final MetadataRewriter val$metadataRewriter;
   final Protocol1_11To1_10 this$0;

   Protocol1_11To1_10$2(Protocol1_11To1_10 var1, MetadataRewriter var2) {
      this.this$0 = var1;
      this.val$metadataRewriter = var2;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.BYTE);
      this.a(this.val$metadataRewriter.getObjectTracker());
   }
}
