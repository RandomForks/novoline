package viaversion.viaversion.api.rewriters;

import net.aQU;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class ItemRewriter$7 extends acE {
   final aQU c;

   ItemRewriter$7(aQU var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.read(Type.VAR_INT)).intValue();
      var1.write(Type.VAR_INT, Integer.valueOf(aQU.a(this.c).getMappingData().getNewItemId(var2)));
   }
}
