package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import net.a7O;
import net.c6;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_10To1_9_3_4$9$1 implements PacketHandler {
   final a7O a;

   Protocol1_10To1_9_3_4$9$1(a7O var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      c6 var2 = (c6)var1.user().b(c6.class);
      var1.write(Type.STRING, var2.b());
      var1.write(Type.VAR_INT, var1.read(Type.VAR_INT));
   }
}
