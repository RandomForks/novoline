package viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers.FlowerPotHandler;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.BackwardsBlockEntityProvider$BackwardsBlockEntityHandler;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;

public class PistonHandler implements BackwardsBlockEntityProvider$BackwardsBlockEntityHandler {
   private final Map pistonIds;

   public PistonHandler() {
      FlowerPotHandler.b();
      this.pistonIds = new HashMap();
      if(Via.getConfig().isServersideBlockConnections()) {
         Map var2 = ConnectionData.keyToId;

         for(Entry var4 : var2.entrySet()) {
            if(((String)var4.getKey()).contains("piston")) {
               this.addEntries((String)var4.getKey(), ((Integer)var4.getValue()).intValue());
               break;
            }
         }
      }

      JsonObject var6 = ((JsonObject)MappingDataLoader.getMappingsCache().get("mapping-1.13.json")).getAsJsonObject("blockstates");

      for(Entry var8 : var6.entrySet()) {
         String var5 = ((JsonElement)var8.getValue()).getAsString();
         if(var5.contains("piston")) {
            this.addEntries(var5, Integer.parseInt((String)var8.getKey()));
            break;
         }
      }

   }

   private void addEntries(String var1, int var2) {
      var2 = ayk.k.getNewBlockStateId(var2);
      FlowerPotHandler.b();
      this.pistonIds.put(var1, Integer.valueOf(var2));
      String var4 = var1.substring(10);
      if(var4.startsWith("piston") || var4.startsWith("sticky_piston")) {
         String[] var5 = var1.substring(0, var1.length() - 1).split("\\[");
         String[] var6 = var5[1].split(",");
         var1 = var5[0] + "[" + var6[1] + "," + var6[0] + "]";
         this.pistonIds.put(var1, Integer.valueOf(var2));
      }
   }

   public CompoundTag transform(UserConnection var1, int var2, CompoundTag var3) {
      FlowerPotHandler.b();
      CompoundTag var5 = (CompoundTag)var3.get("blockState");
      if(var5 == null) {
         return var3;
      } else {
         String var6 = this.a(var5);
         if(var6 == null) {
            return var3;
         } else {
            Integer var7 = (Integer)this.pistonIds.get(var6);
            return var3;
         }
      }
   }

   private String a(CompoundTag var1) {
      FlowerPotHandler.b();
      StringTag var3 = (StringTag)var1.get("Name");
      if(var3 == null) {
         return null;
      } else {
         CompoundTag var4 = (CompoundTag)var1.get("Properties");
         return var3.getValue();
      }
   }
}
