package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import net.acE;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.EntityPackets1_16_2;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_16_2$2 extends acE {
   final EntityPackets1_16_2 this$0;

   EntityPackets1_16_2$2(EntityPackets1_16_2 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      CompoundTag var2 = (CompoundTag)var1.read(Type.NBT);
      var1.write(Type.STRING, EntityPackets1_16_2.access$100(this.this$0, var2));
   }
}
