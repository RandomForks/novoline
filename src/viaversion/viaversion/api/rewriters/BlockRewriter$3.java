package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;

class BlockRewriter$3 extends acE {
   final BlockRewriter this$0;

   BlockRewriter$3(BlockRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      MetadataRewriter.c();
      BlockChangeRecord[] var3 = (BlockChangeRecord[])var1.passthrough(Type.BLOCK_CHANGE_RECORD_ARRAY);
      int var4 = var3.length;
      int var5 = 0;
      if(var5 < var4) {
         BlockChangeRecord var6 = var3[var5];
         var6.setBlockId(BlockRewriter.access$100(this.this$0).getMappingData().getNewBlockStateId(var6.getBlockId()));
         ++var5;
      }

   }
}
