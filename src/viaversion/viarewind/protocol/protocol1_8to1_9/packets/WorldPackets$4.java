package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.S3;
import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.items.ReplacementRegistry1_8to1_9;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$4 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.INT);
      this.a(Type.BLOCK_CHANGE_RECORD_ARRAY);
      this.a(WorldPackets$4::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      BlockChangeRecord[] var2 = (BlockChangeRecord[])var0.get(Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
      S3.b();
      int var3 = var2.length;
      int var4 = 0;
      if(var4 < var3) {
         BlockChangeRecord var5 = var2[var4];
         BlockState var6 = BlockState.rawToState(var5.getBlockId());
         var6 = ReplacementRegistry1_8to1_9.replace(var6);
         var5.setBlockId(BlockState.stateToRaw(var6));
         ++var4;
      }

   }
}
