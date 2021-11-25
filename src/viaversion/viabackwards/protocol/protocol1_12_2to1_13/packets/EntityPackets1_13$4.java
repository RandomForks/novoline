package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.aEY;
import net.a_4;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_12;

class EntityPackets1_13$4 extends acE {
   final EntityPackets1_13 this$0;

   EntityPackets1_13$4(EntityPackets1_13 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(aEY.a, Types1_12.METADATA_LIST);
      this.a(EntityPackets1_13.access$400(this.this$0, Types1_12.METADATA_LIST, a_4.PLAYER));
   }
}
