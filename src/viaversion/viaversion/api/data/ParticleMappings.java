package viaversion.viaversion.api.data;

import com.google.gson.JsonArray;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import viaversion.viaversion.api.data.MappingDataLoader;
import viaversion.viaversion.api.data.Mappings;

public class ParticleMappings {
   private final Mappings mappings;
   private final int blockId;
   private final int fallingDustId;
   private final int itemId;

   public ParticleMappings(JsonArray var1, Mappings var2) {
      this.mappings = var2;
      Object2IntMap var3 = MappingDataLoader.arrayToMap(var1);
      this.blockId = var3.getInt("block");
      this.fallingDustId = var3.getInt("falling_dust");
      this.itemId = var3.getInt("item");
   }

   public Mappings getMappings() {
      return this.mappings;
   }

   public int getBlockId() {
      return this.blockId;
   }

   public int getFallingDustId() {
      return this.fallingDustId;
   }

   public int getItemId() {
      return this.itemId;
   }
}
