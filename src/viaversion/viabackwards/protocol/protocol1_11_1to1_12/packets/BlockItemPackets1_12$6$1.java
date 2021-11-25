package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import net.ac5;
import net.aqw;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_12$6$1 implements PacketHandler {
   final ac5 a;

   BlockItemPackets1_12$6$1(ac5 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      aqw.a();
      BlockChangeRecord[] var3 = (BlockChangeRecord[])var1.get(Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
      int var4 = var3.length;
      int var5 = 0;
      if(var5 < var4) {
         BlockChangeRecord var6 = var3[var5];
         var6.setBlockId(this.a.c.a(var6.getBlockId()));
         ++var5;
      }

   }
}
