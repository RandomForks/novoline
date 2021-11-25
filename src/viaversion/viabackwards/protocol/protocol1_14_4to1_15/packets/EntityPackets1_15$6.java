package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import java.util.ArrayList;
import net.aSG;
import net.acE;
import net.aq3;
import net.g4;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_15$6 extends acE {
   final aq3 c;

   EntityPackets1_15$6(aq3 var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(EntityPackets1_15$6::lambda$registerMap$0);
      this.a(aq3.a(this.c, g4.PLAYER, Type.VAR_INT));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(aSG.c, new ArrayList());
   }
}
