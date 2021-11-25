package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.abi;
import net.acE;
import viaversion.viaversion.api.Pair;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.WrappedBlockData;

public class SnowyGrassConnectionHandler extends abi {
   private static final Map grassBlocks = new HashMap();
   private static final Set snows = new HashSet();

   static ConnectionData$ConnectorInitAction init() {
      HashSet var0 = new HashSet();
      var0.add("minecraft:grass_block");
      var0.add("minecraft:podzol");
      var0.add("minecraft:mycelium");
      SnowyGrassConnectionHandler var1 = new SnowyGrassConnectionHandler();
      return SnowyGrassConnectionHandler::lambda$init$0;
   }

   public int connect(UserConnection var1, Position var2, int var3) {
      int var5 = this.getBlockData(var1, var2.getRelative(BlockFace.TOP));
      abi.b();
      Integer var6 = (Integer)grassBlocks.get(new Pair(Integer.valueOf(var3), Boolean.valueOf(snows.contains(Integer.valueOf(var5)))));
      return var6 != null?var6.intValue():var3;
   }

   private static void lambda$init$0(Set var0, SnowyGrassConnectionHandler var1, WrappedBlockData var2) {
      acE[] var3 = abi.b();
      if(var0.contains(var2.getMinecraftKey())) {
         ConnectionData.connectionHandlerMap.put(var2.getSavedBlockStateId(), var1);
         var2.set("snowy", "true");
         grassBlocks.put(new Pair(Integer.valueOf(var2.getSavedBlockStateId()), Boolean.valueOf(true)), Integer.valueOf(var2.getBlockStateId()));
         var2.set("snowy", "false");
         grassBlocks.put(new Pair(Integer.valueOf(var2.getSavedBlockStateId()), Boolean.valueOf(false)), Integer.valueOf(var2.getBlockStateId()));
      }

      if(var2.getMinecraftKey().equals("minecraft:snow") || var2.getMinecraftKey().equals("minecraft:snow_block")) {
         ConnectionData.connectionHandlerMap.put(var2.getSavedBlockStateId(), var1);
         snows.add(Integer.valueOf(var2.getSavedBlockStateId()));
      }

   }
}
