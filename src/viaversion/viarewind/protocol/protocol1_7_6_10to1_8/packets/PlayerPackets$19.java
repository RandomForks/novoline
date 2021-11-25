package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.PlayerPosition;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$19 extends acE {
   public void registerMap() {
      this.a(Type.BOOLEAN);
      this.a(PlayerPackets$19::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      PlayerPosition var1 = (PlayerPosition)var0.user().b(PlayerPosition.class);
      var1.setOnGround(((Boolean)var0.get(Type.BOOLEAN, 0)).booleanValue());
   }
}
