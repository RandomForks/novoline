package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.acE;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.PlayerPacket1_13;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class PlayerPacket1_13$1 extends acE {
   final PlayerPacket1_13 this$0;

   PlayerPacket1_13$1(PlayerPacket1_13 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(PlayerPacket1_13$1::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      var0.cancel();
      var0.create(2, PlayerPacket1_13$1::lambda$null$0).sendToServer(ayk.class);
   }

   private static void lambda$null$0(PacketWrapper var0, PacketWrapper var1) throws Exception {
      var1.write(Type.VAR_INT, var0.read(Type.VAR_INT));
      var1.write(Type.BOOLEAN, Boolean.valueOf(false));
   }
}
