package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.acE;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.packets.EntityPackets;

final class EntityPackets$5 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.BYTE, EntityPackets.toNewShort);
      this.a(Type.BYTE, EntityPackets.toNewShort);
      this.a(Type.BYTE, EntityPackets.toNewShort);
      this.a(Type.BOOLEAN);
   }
}
