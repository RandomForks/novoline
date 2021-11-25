package viaversion.viabackwards.api.rewriters;

import net.acE;
import net.aqF;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityRewriter$2 extends acE {
   final aqF c;

   EntityRewriter$2(aqF var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.VAR_INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      aqF.a(this.c, var1);
   }
}
