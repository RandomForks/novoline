package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.abi;
import net.acE;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.protocol.ProtocolVersion;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.BlockData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.StairConnectionHandler;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.WrappedBlockData;

public abstract class AbstractFenceConnectionHandler extends abi {
   private static final StairConnectionHandler STAIR_CONNECTION_HANDLER = new StairConnectionHandler();
   private final String blockConnections;
   private final Set blockStates = new HashSet();
   private final Map connectedBlockStates = new HashMap();

   protected AbstractFenceConnectionHandler(String var1) {
      this.blockConnections = var1;
   }

   public ConnectionData$ConnectorInitAction getInitAction(String var1) {
      return this::lambda$getInitAction$0;
   }

   protected byte getStates(WrappedBlockData var1) {
      abi.b();
      byte var3 = 0;
      if(var1.getValue("east").equals("true")) {
         var3 = (byte)(var3 | 1);
      }

      if(var1.getValue("north").equals("true")) {
         var3 = (byte)(var3 | 2);
      }

      if(var1.getValue("south").equals("true")) {
         var3 = (byte)(var3 | 4);
      }

      if(var1.getValue("west").equals("true")) {
         var3 = (byte)(var3 | 8);
      }

      return var3;
   }

   protected byte getStates(UserConnection var1, Position var2, int var3) {
      abi.b();
      byte var5 = 0;
      boolean var6 = var1.getProtocolInfo().getServerProtocolVersion() < ProtocolVersion.v1_12.getVersion();
      if(this.connects(BlockFace.EAST, this.getBlockData(var1, var2.getRelative(BlockFace.EAST)), var6)) {
         var5 = (byte)(var5 | 1);
      }

      if(this.connects(BlockFace.NORTH, this.getBlockData(var1, var2.getRelative(BlockFace.NORTH)), var6)) {
         var5 = (byte)(var5 | 2);
      }

      if(this.connects(BlockFace.SOUTH, this.getBlockData(var1, var2.getRelative(BlockFace.SOUTH)), var6)) {
         var5 = (byte)(var5 | 4);
      }

      if(this.connects(BlockFace.WEST, this.getBlockData(var1, var2.getRelative(BlockFace.WEST)), var6)) {
         var5 = (byte)(var5 | 8);
      }

      return var5;
   }

   public int getBlockData(UserConnection var1, Position var2) {
      return STAIR_CONNECTION_HANDLER.connect(var1, var2, super.getBlockData(var1, var2));
   }

   public int connect(UserConnection var1, Position var2, int var3) {
      abi.b();
      Integer var5 = (Integer)this.connectedBlockStates.get(Byte.valueOf(this.getStates(var1, var2, var3)));
      return var5 == null?var3:var5.intValue();
   }

   protected boolean connects(BlockFace var1, int var2, boolean var3) {
      acE[] var4 = abi.b();
      if(this.blockStates.contains(Integer.valueOf(var2))) {
         return true;
      } else if(this.blockConnections == null) {
         return false;
      } else {
         BlockData var5 = (BlockData)ConnectionData.blockConnectionData.get(var2);
         return var5 != null && var5.connectsTo(this.blockConnections, var1.opposite(), var3);
      }
   }

   public Set getBlockStates() {
      return this.blockStates;
   }

   private void lambda$getInitAction$0(String var1, AbstractFenceConnectionHandler var2, WrappedBlockData var3) {
      acE[] var4 = abi.b();
      if(var1.equals(var3.getMinecraftKey())) {
         if(var3.hasData("waterlogged") && var3.getValue("waterlogged").equals("true")) {
            return;
         }

         this.blockStates.add(Integer.valueOf(var3.getSavedBlockStateId()));
         ConnectionData.connectionHandlerMap.put(var3.getSavedBlockStateId(), var2);
         this.connectedBlockStates.put(Byte.valueOf(this.getStates(var3)), Integer.valueOf(var3.getSavedBlockStateId()));
      }

   }
}
