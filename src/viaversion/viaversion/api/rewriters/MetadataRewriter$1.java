package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;

class MetadataRewriter$1 extends acE {
   final MetadataRewriter this$0;

   MetadataRewriter$1(MetadataRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.VAR_INT);
      this.a(this.this$0.getTracker());
   }
}
