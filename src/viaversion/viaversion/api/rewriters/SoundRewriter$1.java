package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.type.Type;

class SoundRewriter$1 extends acE {
   final SoundRewriter this$0;

   SoundRewriter$1(SoundRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(this.this$0.getSoundHandler());
   }
}
