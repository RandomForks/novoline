package viaversion.viaversion.protocols.protocol1_12to1_11_1;

import net.aRp;
import net.acE;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;

class Protocol1_12To1_11_1$1 extends acE {
   final MetadataRewriter val$metadataRewriter;
   final aRp c;

   Protocol1_12To1_11_1$1(aRp var1, MetadataRewriter var2) {
      this.c = var1;
      this.val$metadataRewriter = var2;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.BYTE);
      this.a(this.val$metadataRewriter.getObjectTracker());
   }
}
