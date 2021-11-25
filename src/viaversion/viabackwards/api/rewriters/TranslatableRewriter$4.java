package viaversion.viabackwards.api.rewriters;

import com.google.gson.JsonElement;
import net.acE;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class TranslatableRewriter$4 extends acE {
   final TranslatableRewriter this$0;

   TranslatableRewriter$4(TranslatableRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      this.this$0.processText((JsonElement)var1.passthrough(Type.COMPONENT));
   }
}
