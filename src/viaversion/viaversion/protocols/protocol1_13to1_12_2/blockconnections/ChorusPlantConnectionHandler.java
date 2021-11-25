package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.ArrayList;
import java.util.List;
import net.abi;
import net.acE;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.AbstractFenceConnectionHandler;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.WrappedBlockData;

public class ChorusPlantConnectionHandler extends AbstractFenceConnectionHandler {
   private final int endstone = ConnectionData.getId("minecraft:end_stone");

   static List init() {
      ArrayList var0 = new ArrayList(2);
      ChorusPlantConnectionHandler var1 = new ChorusPlantConnectionHandler();
      var0.add(var1.getInitAction("minecraft:chorus_plant"));
      var0.add(var1.getExtraAction());
      return var0;
   }

   public ChorusPlantConnectionHandler() {
      super((String)null);
   }

   public ConnectionData$ConnectorInitAction getExtraAction() {
      return this::lambda$getExtraAction$0;
   }

   protected byte getStates(WrappedBlockData var1) {
      abi.b();
      byte var3 = super.getStates(var1);
      if(var1.getValue("up").equals("true")) {
         var3 = (byte)(var3 | 16);
      }

      if(var1.getValue("down").equals("true")) {
         var3 = (byte)(var3 | 32);
      }

      return var3;
   }

   protected byte getStates(UserConnection var1, Position var2, int var3) {
      abi.b();
      byte var5 = super.getStates(var1, var2, var3);
      if(this.connects(BlockFace.TOP, this.getBlockData(var1, var2.getRelative(BlockFace.TOP)), false)) {
         var5 = (byte)(var5 | 16);
      }

      if(this.connects(BlockFace.BOTTOM, this.getBlockData(var1, var2.getRelative(BlockFace.BOTTOM)), false)) {
         var5 = (byte)(var5 | 32);
      }

      return var5;
   }

   protected boolean connects(BlockFace var1, int var2, boolean var3) {
      acE[] var4 = abi.b();
      return this.getBlockStates().contains(Integer.valueOf(var2)) || var1 == BlockFace.BOTTOM && var2 == this.endstone;
   }

   private void lambda$getExtraAction$0(WrappedBlockData var1) {
      acE[] var2 = abi.b();
      if(var1.getMinecraftKey().equals("minecraft:chorus_flower")) {
         this.getBlockStates().add(Integer.valueOf(var1.getSavedBlockStateId()));
      }

   }
}
