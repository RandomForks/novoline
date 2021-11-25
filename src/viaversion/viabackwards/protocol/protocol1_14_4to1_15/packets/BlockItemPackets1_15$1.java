package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets.BlockItemPackets1_15;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_15$1 extends acE {
   final BlockItemPackets1_15 this$0;

   BlockItemPackets1_15$1(BlockItemPackets1_15 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      this.this$0.c((Item)var1.passthrough(Type.FLAT_VAR_INT_ITEM));
   }
}
