package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import net.acE;
import net.aq3;
import net.cW;
import net.g4;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_15$5 extends acE {
   final aq3 c;

   EntityPackets1_15$5(aq3 var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.INT);
      this.a(Type.LONG, Type.NOTHING);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(Type.VAR_INT);
      this.a(Type.BOOLEAN);
      this.a(aq3.b(this.c, g4.PLAYER, Type.INT));
      this.a(EntityPackets1_15$5::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ((cW)var0.user().b(cW.class)).a(((Boolean)var0.read(Type.BOOLEAN)).booleanValue());
   }
}
