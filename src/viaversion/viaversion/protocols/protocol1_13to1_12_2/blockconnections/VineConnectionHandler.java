package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.HashSet;
import java.util.Set;
import net.abi;
import net.acE;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.WrappedBlockData;

class VineConnectionHandler extends abi {
   private static final Set vines = new HashSet();

   static ConnectionData$ConnectorInitAction init() {
      VineConnectionHandler var0 = new VineConnectionHandler();
      return VineConnectionHandler::lambda$init$0;
   }

   public int connect(UserConnection var1, Position var2, int var3) {
      acE[] var4 = abi.b();
      if(this.isAttachedToBlock(var1, var2)) {
         return var3;
      } else {
         Position var5 = var2.getRelative(BlockFace.TOP);
         int var6 = this.getBlockData(var1, var5);
         return vines.contains(Integer.valueOf(var6)) && this.isAttachedToBlock(var1, var5)?var3:0;
      }
   }

   private boolean isAttachedToBlock(UserConnection var1, Position var2) {
      acE[] var3 = abi.b();
      return this.isAttachedToBlock(var1, var2, BlockFace.EAST) || this.isAttachedToBlock(var1, var2, BlockFace.WEST) || this.isAttachedToBlock(var1, var2, BlockFace.NORTH) || this.isAttachedToBlock(var1, var2, BlockFace.SOUTH);
   }

   private boolean isAttachedToBlock(UserConnection var1, Position var2, BlockFace var3) {
      return ConnectionData.occludingStates.contains(this.getBlockData(var1, var2.getRelative(var3)));
   }

   private static void lambda$init$0(VineConnectionHandler var0, WrappedBlockData var1) {
      acE[] var2 = abi.b();
      if(var1.getMinecraftKey().equals("minecraft:vine")) {
         vines.add(Integer.valueOf(var1.getSavedBlockStateId()));
         ConnectionData.connectionHandlerMap.put(var1.getSavedBlockStateId(), var0);
      }
   }
}
