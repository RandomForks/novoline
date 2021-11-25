package viaversion.viabackwards.protocol.protocol1_9_4to1_10;

import net.acE;
import net.rL;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.protocol.protocol1_9_4to1_10.Protocol1_9_4To1_10;
import viaversion.viaversion.api.type.Type;

class Protocol1_9_4To1_10$2 extends acE {
   final SoundRewriter val$soundRewriter;
   final Protocol1_9_4To1_10 this$0;

   Protocol1_9_4To1_10$2(Protocol1_9_4To1_10 var1, SoundRewriter var2) {
      this.this$0 = var1;
      this.val$soundRewriter = var2;
   }

   public void registerMap() {
      rL.b();
      this.a(Type.STRING);
      this.a(Type.VAR_INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT, Protocol1_9_4To1_10.access$000());
      this.a(this.val$soundRewriter.getNamedSoundHandler());
      if(acE.b() == null) {
         rL.b(false);
      }

   }
}
