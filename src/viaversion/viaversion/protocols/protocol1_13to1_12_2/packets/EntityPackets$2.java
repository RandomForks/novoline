package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aEY;
import net.aTW;
import net.acE;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_12;

final class EntityPackets$2 extends acE {
   final aTW c;

   EntityPackets$2(aTW var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.VAR_INT);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Types1_12.METADATA_LIST, aEY.a);
      this.a(this.c.getTrackerAndRewriter(aEY.a));
   }
}
