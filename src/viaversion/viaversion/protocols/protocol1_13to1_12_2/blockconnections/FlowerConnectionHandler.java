package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.HashSet;
import java.util.Set;
import net.abi;
import net.acE;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.WrappedBlockData;

public class FlowerConnectionHandler extends abi {
   private static final Int2IntMap flowers = new Int2IntOpenHashMap();

   static ConnectionData$ConnectorInitAction init() {
      HashSet var0 = new HashSet();
      var0.add("minecraft:rose_bush");
      var0.add("minecraft:sunflower");
      var0.add("minecraft:peony");
      var0.add("minecraft:tall_grass");
      var0.add("minecraft:large_fern");
      var0.add("minecraft:lilac");
      FlowerConnectionHandler var1 = new FlowerConnectionHandler();
      return FlowerConnectionHandler::lambda$init$0;
   }

   public int connect(UserConnection var1, Position var2, int var3) {
      abi.b();
      int var5 = this.getBlockData(var1, var2.getRelative(BlockFace.BOTTOM));
      int var6 = flowers.get(var5);
      if(var6 != 0) {
         int var7 = this.getBlockData(var1, var2.getRelative(BlockFace.TOP));
         if(Via.getConfig().isStemWhenBlockAbove()) {
            if(var7 == 0) {
               return var6;
            }
         } else if(!flowers.containsKey(var7)) {
            return var6;
         }
      }

      return var3;
   }

   private static void lambda$init$0(Set var0, FlowerConnectionHandler var1, WrappedBlockData var2) {
      acE[] var3 = abi.b();
      if(var0.contains(var2.getMinecraftKey())) {
         ConnectionData.connectionHandlerMap.put(var2.getSavedBlockStateId(), var1);
         if(var2.getValue("half").equals("lower")) {
            var2.set("half", "upper");
            flowers.put(var2.getSavedBlockStateId(), var2.getBlockStateId());
         }
      }

   }
}
