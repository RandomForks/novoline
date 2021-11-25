package viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import net.aEY;
import net.acE;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_13_2;

final class EntityPackets$3 extends acE {
   final PacketHandler val$metaTypeHandler;

   EntityPackets$3(PacketHandler var1) {
      this.val$metaTypeHandler = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(aEY.a, Types1_13_2.METADATA_LIST);
      this.a(this.val$metaTypeHandler);
   }
}
