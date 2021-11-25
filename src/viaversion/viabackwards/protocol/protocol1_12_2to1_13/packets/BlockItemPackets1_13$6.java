package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.acE;
import net.aqI;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.BackwardsBlockStorage;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_13$6 extends acE {
   final aqI c;

   BlockItemPackets1_13$6(aqI var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.BLOCK_CHANGE_RECORD_ARRAY);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      aqI.a();
      BackwardsBlockStorage var3 = (BackwardsBlockStorage)var1.user().b(BackwardsBlockStorage.class);
      BlockChangeRecord[] var4 = (BlockChangeRecord[])var1.get(Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
      int var5 = var4.length;
      int var6 = 0;
      if(var6 < var5) {
         BlockChangeRecord var7 = var4[var6];
         int var8 = ((Integer)var1.get(Type.INT, 0)).intValue();
         int var9 = ((Integer)var1.get(Type.INT, 1)).intValue();
         int var10 = var7.getBlockId();
         Position var11 = new Position(var7.getSectionX() + var8 * 16, var7.getY(), var7.getSectionZ() + var9 * 16);
         var3.checkAndStore(var11, var10);
         aqI.a(var1.user(), var10, var11);
         var7.setBlockId(((ayk)aqI.b(this.c)).c().getNewBlockStateId(var10));
         ++var6;
      }

   }
}
