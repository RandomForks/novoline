package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.storage.EntityTracker;
import viaversion.viaversion.api.type.Type;

class MetadataRewriter$4 extends acE {
   final MetadataRewriter this$0;

   MetadataRewriter$4(MetadataRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT_ARRAY_PRIMITIVE);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      MetadataRewriter.c();
      EntityTracker var3 = (EntityTracker)var1.user().b(MetadataRewriter.access$000(this.this$0));
      int[] var4 = (int[])var1.get(Type.VAR_INT_ARRAY_PRIMITIVE, 0);
      int var5 = var4.length;
      int var6 = 0;
      if(var6 < var5) {
         int var7 = var4[var6];
         var3.removeEntity(var7);
         ++var6;
      }

   }
}
