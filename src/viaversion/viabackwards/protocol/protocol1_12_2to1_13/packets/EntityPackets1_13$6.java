package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.BackwardsBlockStorage;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_13$6 extends acE {
   final EntityPackets1_13 this$0;

   EntityPackets1_13$6(EntityPackets1_13 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(EntityPackets1_13.access$600(this.this$0, 0));
      this.a(EntityPackets1_13$6::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ((BackwardsBlockStorage)var0.user().b(BackwardsBlockStorage.class)).clear();
   }
}
