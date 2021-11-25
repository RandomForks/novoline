package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.N0;
import net.aSG;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_13_2;

class EntityPackets1_14$9 extends acE {
   final EntityPackets1_14 this$0;

   EntityPackets1_14$9(EntityPackets1_14 var1) {
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
      this.a(aSG.c, Types1_13_2.METADATA_LIST);
      this.a(EntityPackets1_14.access$600(this.this$0, Types1_13_2.METADATA_LIST, N0.PLAYER));
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      EntityPackets1_14.access$000(this.this$0).cacheEntityPosition(var1, true, false);
   }
}
