package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.Cooldown;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;

final class PlayerPackets$16 extends acE {
   public void registerMap() {
      this.a(PlayerPackets$16::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ((Cooldown)var0.user().b(Cooldown.class)).hit();
   }
}
