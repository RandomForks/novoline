package viaversion.viabackwards.protocol.protocol1_9_4to1_10.packets;

import net.acE;
import net.aqR;
import net.cT;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.Chunk1_9_3_4Type;

class BlockItemPackets1_10$2 extends acE {
   final aqR c;

   BlockItemPackets1_10$2(aqR var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      cT var2 = (cT)var1.user().b(cT.class);
      Chunk1_9_3_4Type var3 = new Chunk1_9_3_4Type(var2);
      Chunk var4 = (Chunk)var1.passthrough(var3);
      aqR.a(this.c, var4);
   }
}
