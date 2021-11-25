package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import net.ac_;
import net.aq0;
import net.cT;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.Chunk1_9_3_4Type;

class BlockItemPackets1_12$4$1 implements PacketHandler {
   final ac_ a;

   BlockItemPackets1_12$4$1(ac_ var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      cT var2 = (cT)var1.user().b(cT.class);
      Chunk1_9_3_4Type var3 = new Chunk1_9_3_4Type(var2);
      Chunk var4 = (Chunk)var1.passthrough(var3);
      aq0.a(this.a.c, var4);
   }
}
