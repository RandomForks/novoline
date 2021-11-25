package viaversion.viabackwards.protocol.protocol1_10to1_11.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_10to1_11.packets.PlayerPackets1_11;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class PlayerPackets1_11$3 extends acE {
   final PlayerPackets1_11 this$0;

   PlayerPackets1_11$3(PlayerPackets1_11 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(PlayerPackets1_11$3::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Integer var10000 = (Integer)var0.read(Type.VAR_INT);
   }
}
