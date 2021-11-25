package viaversion.viaversion.api.rewriters;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.storage.EntityTracker;
import viaversion.viaversion.api.type.Type;

class MetadataRewriter$3 extends acE {
   final EntityType val$entityType;
   final MetadataRewriter this$0;

   MetadataRewriter$3(MetadataRewriter var1, EntityType var2) {
      this.this$0 = var1;
      this.val$entityType = var2;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(EntityType var1, PacketWrapper var2) throws Exception {
      int var3 = ((Integer)var2.get(Type.VAR_INT, 0)).intValue();
      ((EntityTracker)var2.user().b(MetadataRewriter.access$000(this.this$0))).addEntity(var3, var1);
   }
}
