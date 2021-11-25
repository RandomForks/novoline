package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.MappingData;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;
import viaversion.viaversion.api.type.Type;

class TagRewriter$1 extends acE {
   final TagRewriter this$0;

   TagRewriter$1(TagRewriter var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$2);
   }

   private void lambda$registerMap$2(PacketWrapper var1) throws Exception {
      MetadataRewriter.c();
      MappingData var3 = TagRewriter.access$100(this.this$0).getMappingData();
      TagRewriter.access$300(this.this$0, var1, TagRewriter$1::lambda$null$0, TagRewriter.access$200(this.this$0));
      TagRewriter.access$300(this.this$0, var1, TagRewriter$1::lambda$null$1, TagRewriter.access$400(this.this$0));
      if(TagRewriter.access$500(this.this$0) != null || !TagRewriter.access$600(this.this$0).isEmpty()) {
         int var4 = ((Integer)var1.passthrough(Type.VAR_INT)).intValue();
         int var5 = 0;
         if(var5 < var4) {
            var1.passthrough(Type.STRING);
            var1.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
            ++var5;
         }

         TagRewriter.access$300(this.this$0, var1, TagRewriter.access$500(this.this$0), TagRewriter.access$600(this.this$0));
      }
   }

   private static int lambda$null$1(MappingData var0, int var1) {
      boolean var2 = MetadataRewriter.c();
      return (var0 != null?Integer.valueOf(var0.getNewItemId(var1)):null).intValue();
   }

   private static int lambda$null$0(MappingData var0, int var1) {
      boolean var2 = MetadataRewriter.c();
      return (var0 != null?Integer.valueOf(var0.getNewBlockId(var1)):null).intValue();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
