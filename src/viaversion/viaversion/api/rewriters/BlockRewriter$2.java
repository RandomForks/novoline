package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.type.Type;

class BlockRewriter$2 extends acE {
   final BlockRewriter this$0;

   BlockRewriter$2(BlockRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(BlockRewriter.access$000(this.this$0));
      this.a(Type.VAR_INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      var1.set(Type.VAR_INT, 0, Integer.valueOf(BlockRewriter.access$100(this.this$0).getMappingData().getNewBlockStateId(((Integer)var1.get(Type.VAR_INT, 0)).intValue())));
   }
}
