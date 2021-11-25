package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.a9c;
import net.afz;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.items.ReplacementRegistry1_7_6_10to1_8;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class WorldPackets$2$1 implements PacketHandler {
   final a9c a;

   WorldPackets$2$1(a9c var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      afz.b();
      BlockChangeRecord[] var3 = (BlockChangeRecord[])var1.read(Type.BLOCK_CHANGE_RECORD_ARRAY);
      var1.write(Type.SHORT, Short.valueOf((short)var3.length));
      var1.write(Type.INT, Integer.valueOf(var3.length * 4));
      int var5 = var3.length;
      int var6 = 0;
      if(var6 < var5) {
         BlockChangeRecord var7 = var3[var6];
         short var8 = (short)(var7.getSectionX() << 12 | var7.getSectionZ() << 8 | var7.getY());
         var1.write(Type.SHORT, Short.valueOf(var8));
         BlockState var9 = BlockState.rawToState(var7.getBlockId());
         var9 = ReplacementRegistry1_7_6_10to1_8.replace(var9);
         var1.write(Type.SHORT, Short.valueOf((short)BlockState.stateToRaw(var9)));
         ++var6;
      }

   }
}
