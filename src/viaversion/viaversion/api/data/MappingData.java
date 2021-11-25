package viaversion.viaversion.api.data;

import com.google.gson.JsonObject;
import net.cA;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;
import viaversion.viaversion.api.data.Mappings;
import viaversion.viaversion.api.data.ParticleMappings;
import viaversion.viaversion.util.Int2IntBiMap;

public class MappingData {
   protected final String oldVersion;
   protected final String newVersion;
   protected final boolean hasDiffFile;
   protected Int2IntBiMap itemMappings;
   protected ParticleMappings particleMappings;
   protected Mappings blockMappings;
   protected Mappings blockStateMappings;
   protected Mappings soundMappings;
   protected Mappings statisticsMappings;
   protected boolean loadItems;
   private static String[] c;

   public MappingData(String var1, String var2) {
      this(var1, var2, false);
   }

   public MappingData(String var1, String var2, boolean var3) {
      this.loadItems = true;
      this.oldVersion = var1;
      this.newVersion = var2;
      this.hasDiffFile = var3;
   }

   public void load() {
      Via.getPlatform().getLogger().info("Loading " + this.oldVersion + " -> " + this.newVersion + " mappings...");
      JsonObject var1 = this.hasDiffFile?this.loadDiffFile():null;
      JsonObject var2 = MappingDataLoader.loadData("mapping-" + this.oldVersion + ".json", true);
      JsonObject var3 = MappingDataLoader.loadData("mapping-" + this.newVersion + ".json", true);
      System.out.println();
      this.blockMappings = this.loadFromObject(var2, var3, var1, "blocks");
      this.blockStateMappings = this.loadFromObject(var2, var3, var1, "blockstates");
      this.soundMappings = this.loadFromArray(var2, var3, var1, "sounds");
      this.statisticsMappings = this.loadFromArray(var2, var3, var1, "statistics");
      Mappings var4 = this.loadFromArray(var2, var3, var1, "particles");
      this.particleMappings = new ParticleMappings(var2.getAsJsonArray("particles"), var4);
      if(this.loadItems && var3.has("items")) {
         this.itemMappings = new Int2IntBiMap();
         this.itemMappings.defaultReturnValue(-1);
         MappingDataLoader.mapIdentifiers(this.itemMappings, var2.getAsJsonObject("items"), var3.getAsJsonObject("items"), var1.getAsJsonObject("items"));
      }

      this.loadExtras(var2, var3, var1);
   }

   public int getNewBlockStateId(int var1) {
      return this.checkValidity(var1, this.blockStateMappings.getNewId(var1), "blockstate");
   }

   public int getNewBlockId(int var1) {
      return this.checkValidity(var1, this.blockMappings.getNewId(var1), "block");
   }

   public int getNewItemId(int var1) {
      return this.checkValidity(var1, this.itemMappings.get(var1), "item");
   }

   public int getOldItemId(int var1) {
      cA.c();
      int var3 = this.itemMappings.inverse().get(var1);
      return var3 != -1?var3:1;
   }

   public int getNewParticleId(int var1) {
      return this.checkValidity(var1, this.particleMappings.getMappings().getNewId(var1), "particles");
   }

   @Nullable
   public Int2IntBiMap getItemMappings() {
      return this.itemMappings;
   }

   @Nullable
   public ParticleMappings getParticleMappings() {
      return this.particleMappings;
   }

   @Nullable
   public Mappings getBlockMappings() {
      return this.blockMappings;
   }

   @Nullable
   public Mappings getBlockStateMappings() {
      return this.blockStateMappings;
   }

   @Nullable
   public Mappings getSoundMappings() {
      return this.soundMappings;
   }

   @Nullable
   public Mappings getStatisticsMappings() {
      return this.statisticsMappings;
   }

   @Nullable
   protected Mappings loadFromArray(JsonObject var1, JsonObject var2, @Nullable JsonObject var3, String var4) {
      if(var1.has(var4) && var2.has(var4)) {
         JsonObject var5 = var3.getAsJsonObject(var4);
         return new Mappings(var1.getAsJsonArray(var4), var2.getAsJsonArray(var4), var5);
      } else {
         return null;
      }
   }

   @Nullable
   protected Mappings loadFromObject(JsonObject var1, JsonObject var2, @Nullable JsonObject var3, String var4) {
      if(var1.has(var4) && var2.has(var4)) {
         JsonObject var5 = var3.getAsJsonObject(var4);
         return new Mappings(var1.getAsJsonObject(var4), var2.getAsJsonObject(var4), var5);
      } else {
         return null;
      }
   }

   protected JsonObject loadDiffFile() {
      return MappingDataLoader.loadData("mappingdiff-" + this.oldVersion + "to" + this.newVersion + ".json");
   }

   protected int checkValidity(int var1, int var2, String var3) {
      boolean var4 = cA.b();
      if(var2 == -1) {
         Via.getPlatform().getLogger().warning(String.format("Missing %s %s for %s %s %d", new Object[]{this.newVersion, var3, this.oldVersion, var3, Integer.valueOf(var1)}));
         return 0;
      } else {
         return var2;
      }
   }

   protected void loadExtras(JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
   }

   public static void b(String[] var0) {
      c = var0;
   }

   public static String[] a() {
      return c;
   }

   static {
      b((String[])null);
   }
}
