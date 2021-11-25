package viaversion.viaversion.protocols.protocol1_14to1_13_2.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import net.amx;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;

public class MappingData extends viaversion.viaversion.api.data.MappingData {
   private IntSet motionBlocking;
   private IntSet nonFullBlocks;

   public MappingData() {
      super("1.13.2", "1.14");
   }

   public void loadExtras(JsonObject var1, JsonObject var2, JsonObject var3) {
      amx.a();
      JsonObject var5 = var2.getAsJsonObject("blockstates");
      HashMap var6 = new HashMap(var5.entrySet().size());
      Iterator var7 = var5.entrySet().iterator();
      if(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         var6.put(((JsonElement)var8.getValue()).getAsString(), Integer.valueOf(Integer.parseInt((String)var8.getKey())));
      }

      JsonObject var13 = MappingDataLoader.loadData("heightMapData-1.14.json");
      JsonArray var14 = var13.getAsJsonArray("MOTION_BLOCKING");
      this.motionBlocking = new IntOpenHashSet(var14.size(), 1.0F);
      Iterator var9 = var14.iterator();
      if(var9.hasNext()) {
         JsonElement var10 = (JsonElement)var9.next();
         String var11 = var10.getAsString();
         Integer var12 = (Integer)var6.get(var11);
         if(var12 == null) {
            Via.getPlatform().getLogger().warning("Unknown blockstate " + var11 + " :(");
         }

         this.motionBlocking.add(var12.intValue());
      }

      if(Via.getConfig().isNonFullBlockLightFix()) {
         this.nonFullBlocks = new IntOpenHashSet(1611, 1.0F);
         var9 = var1.getAsJsonObject("blockstates").entrySet().iterator();
         if(var9.hasNext()) {
            Entry var18 = (Entry)var9.next();
            String var19 = ((JsonElement)var18.getValue()).getAsString();
            if(var19.contains("_slab") || var19.contains("_stairs") || var19.contains("_wall[")) {
               this.nonFullBlocks.add(this.blockStateMappings.getNewId(Integer.parseInt((String)var18.getKey())));
            }
         }

         this.nonFullBlocks.add(this.blockStateMappings.getNewId(8163));
         int var16 = 3060;
         if(var16 <= 3067) {
            this.nonFullBlocks.add(this.blockStateMappings.getNewId(var16));
            ++var16;
         }
      }

   }

   public IntSet getMotionBlocking() {
      return this.motionBlocking;
   }

   public IntSet getNonFullBlocks() {
      return this.nonFullBlocks;
   }
}
