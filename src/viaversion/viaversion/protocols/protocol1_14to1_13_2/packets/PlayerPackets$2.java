package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import net.acE;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$2 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.POSITION1_14, Type.POSITION);
   }
}
