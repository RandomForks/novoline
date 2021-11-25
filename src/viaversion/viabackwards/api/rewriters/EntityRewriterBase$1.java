package viaversion.viabackwards.api.rewriters;

import net.acE;
import viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityRewriterBase$1 extends acE {
   final Type val$intType;
   final EntityType val$entityType;
   final EntityRewriterBase this$0;

   EntityRewriterBase$1(EntityRewriterBase var1, Type var2, EntityType var3) {
      this.this$0 = var1;
      this.val$intType = var2;
      this.val$entityType = var3;
   }

   public void registerMap() {
      this.a(this.val$intType);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(Type var1, EntityType var2, PacketWrapper var3) throws Exception {
      this.this$0.addTrackedEntity(var3, ((Integer)var3.get(var1, 0)).intValue(), var2);
   }
}
