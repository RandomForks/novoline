package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import net.acE;
import net.aqG;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_16_2$4 extends acE {
   final aqG c;

   BlockItemPackets1_16_2$4(aqG var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      long var3 = ((Long)var1.read(Type.LONG)).longValue();
      var1.read(Type.BOOLEAN);
      int var5 = (int)(var3 >> 42);
      int var6 = (int)(var3 << 44 >> 44);
      int var7 = (int)(var3 << 22 >> 42);
      var1.write(Type.INT, Integer.valueOf(var5));
      aqG.c();
      var1.write(Type.INT, Integer.valueOf(var7));
      BlockChangeRecord[] var8 = (BlockChangeRecord[])var1.read(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY);
      var1.write(Type.BLOCK_CHANGE_RECORD_ARRAY, var8);
      int var9 = 0;
      if(var9 < var8.length) {
         BlockChangeRecord var10 = var8[var9];
         int var11 = ((Protocol1_16_1To1_16_2)aqG.a(this.c)).getMappingData().getNewBlockStateId(var10.getBlockId());
         var8[var9] = new BlockChangeRecord1_8(var10.getSectionX(), var10.getY(var6), var10.getSectionZ(), var11);
         ++var9;
      }

   }
}
