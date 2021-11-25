package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import net.acE;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$1 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.POSITION, Type.POSITION1_14);
      this.a(Type.BYTE);
   }
}
