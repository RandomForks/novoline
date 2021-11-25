package viaversion.viabackwards.api.rewriters;

import net.acE;
import net.aqr;
import net.cT;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class LegacyEntityRewriter$2 extends acE {
   final EntityType val$playerType;
   final aqr c;

   LegacyEntityRewriter$2(aqr var1, EntityType var2) {
      this.c = var1;
      this.val$playerType = var2;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(EntityType var1, PacketWrapper var2) throws Exception {
      cT var3 = (cT)var2.user().b(cT.class);
      var3.c(((Integer)var2.get(Type.INT, 1)).intValue());
      this.c.getEntityTracker(var2.user()).trackEntityType(((Integer)var2.get(Type.INT, 0)).intValue(), var1);
   }
}
