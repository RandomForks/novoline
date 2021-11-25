package viaversion.viaversion.api.rewriters;

import com.google.gson.JsonElement;
import net.acE;
import net.km;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class ComponentRewriter$1 extends acE {
   final km c;

   ComponentRewriter$1(km var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      this.c.processText((JsonElement)var1.passthrough(Type.COMPONENT));
   }
}
