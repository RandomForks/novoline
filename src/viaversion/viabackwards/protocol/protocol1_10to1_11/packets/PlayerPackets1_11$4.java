package viaversion.viabackwards.protocol.protocol1_10to1_11.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_10to1_11.packets.PlayerPackets1_11;
import viaversion.viaversion.api.type.Type;

class PlayerPackets1_11$4 extends acE {
   final PlayerPackets1_11 this$0;

   PlayerPackets1_11$4(PlayerPackets1_11 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.POSITION);
      this.a(Type.VAR_INT);
      this.a(Type.VAR_INT);
      this.a(Type.UNSIGNED_BYTE, PlayerPackets1_11.access$000());
      this.a(Type.UNSIGNED_BYTE, PlayerPackets1_11.access$000());
      this.a(Type.UNSIGNED_BYTE, PlayerPackets1_11.access$000());
   }
}
