package viaversion.viabackwards.api.rewriters;

import net.acE;
import net.aqu;
import viaversion.viabackwards.api.entities.storage.EntityTracker$ProtocolEntityTracker;
import viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityRewriterBase$2 extends acE {
   final EntityRewriterBase this$0;

   EntityRewriterBase$2(EntityRewriterBase var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT_ARRAY_PRIMITIVE);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      aqu.d();
      EntityTracker$ProtocolEntityTracker var3 = this.this$0.getEntityTracker(var1.user());
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
