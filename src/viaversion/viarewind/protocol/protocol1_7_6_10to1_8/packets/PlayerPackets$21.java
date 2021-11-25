package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.PlayerPosition;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$21 extends acE {
   public void registerMap() {
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(Type.BOOLEAN);
      this.a(PlayerPackets$21::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      PlayerPosition var1 = (PlayerPosition)var0.user().b(PlayerPosition.class);
      var1.b(((Float)var0.get(Type.FLOAT, 0)).floatValue());
      var1.a(((Float)var0.get(Type.FLOAT, 1)).floatValue());
      var1.setOnGround(((Boolean)var0.get(Type.BOOLEAN, 0)).booleanValue());
   }
}
