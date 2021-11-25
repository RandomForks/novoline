package viaversion.viaversion.api.rewriters;

import java.util.List;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;

class MetadataRewriter$5 extends acE {
   final Type val$oldMetaType;
   final Type val$newMetaType;
   final MetadataRewriter this$0;

   MetadataRewriter$5(MetadataRewriter var1, Type var2, Type var3) {
      this.this$0 = var1;
      this.val$oldMetaType = var2;
      this.val$newMetaType = var3;
   }

   public void registerMap() {
      MetadataRewriter.e();
      this.a(Type.VAR_INT);
      if(this.val$oldMetaType != null) {
         this.a(this.val$oldMetaType, this.val$newMetaType);
      }

      this.a(this.val$newMetaType);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(Type var1, PacketWrapper var2) throws Exception {
      int var3 = ((Integer)var2.get(Type.VAR_INT, 0)).intValue();
      List var4 = (List)var2.get(var1, 0);
      this.this$0.handleMetadata(var3, var4, var2.user());
   }
}
