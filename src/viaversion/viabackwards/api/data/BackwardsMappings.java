package viaversion.viabackwards.api.data;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.Map;
import net.ayd;
import net.ln;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.data.VBMappingDataLoader;
import viaversion.viabackwards.api.data.VBMappings;
import viaversion.viaversion.api.data.MappingData;
import viaversion.viaversion.api.data.Mappings;
import viaversion.viaversion.api.protocol.ProtocolRegistry;

public class BackwardsMappings extends MappingData {
   private final Class vvProtocolClass;
   private Int2ObjectMap backwardsItemMappings;
   private Map backwardsSoundMappings;
   private static String o;

   public BackwardsMappings(String var1, String var2, @Nullable Class var3) {
      this(var1, var2, var3, false);
   }

   public BackwardsMappings(String var1, String var2, @Nullable Class var3, boolean var4) {
      super(var1, var2, var4);
      Preconditions.checkArgument(!var3.isAssignableFrom(ayd.class));
      this.vvProtocolClass = var3;
      this.loadItems = false;
   }

   protected void loadExtras(JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
      String var4 = b();
      if(var3 != null) {
         JsonObject var5 = var3.getAsJsonObject("items");
         if(var5 != null) {
            this.backwardsItemMappings = VBMappingDataLoader.loadItemMappings(var1.getAsJsonObject("items"), var2.getAsJsonObject("items"), var5);
         }

         JsonObject var6 = var3.getAsJsonObject("sounds");
         this.backwardsSoundMappings = VBMappingDataLoader.objectToMap(var6);
      }

      if(this.vvProtocolClass != null) {
         this.itemMappings = ProtocolRegistry.getProtocol(this.vvProtocolClass).getMappingData().getItemMappings().inverse();
      }

      this.loadVBExtras(var1, var2);
   }

   @Nullable
   protected Mappings loadFromArray(JsonObject var1, JsonObject var2, @Nullable JsonObject var3, String var4) {
      String var5 = b();
      if(var1.has(var4) && var2.has(var4)) {
         JsonObject var6 = var3 != null?var3.getAsJsonObject(var4):null;
         return new VBMappings(var1.getAsJsonArray(var4), var2.getAsJsonArray(var4), var6, this.shouldWarnOnMissing(var4));
      } else {
         return null;
      }
   }

   @Nullable
   protected Mappings loadFromObject(JsonObject var1, JsonObject var2, @Nullable JsonObject var3, String var4) {
      String var5 = b();
      if(var1.has(var4) && var2.has(var4)) {
         JsonObject var6 = var3 != null?var3.getAsJsonObject(var4):null;
         return new VBMappings(var1.getAsJsonObject(var4), var2.getAsJsonObject(var4), var6, this.shouldWarnOnMissing(var4));
      } else {
         return null;
      }
   }

   protected JsonObject loadDiffFile() {
      return VBMappingDataLoader.loadFromDataDir("mapping-" + this.newVersion + "to" + this.oldVersion + ".json");
   }

   protected void loadVBExtras(JsonObject var1, JsonObject var2) {
   }

   protected boolean shouldWarnOnMissing(String var1) {
      String var2 = b();
      return !var1.equals("blocks") && !var1.equals("statistics");
   }

   public int getNewItemId(int var1) {
      return this.itemMappings.get(var1);
   }

   public int getNewBlockId(int var1) {
      return this.blockMappings.getNewId(var1);
   }

   public int getOldItemId(int var1) {
      return this.checkValidity(var1, this.itemMappings.inverse().get(var1), "item");
   }

   @Nullable
   public ln a(int var1) {
      String var2 = b();
      return this.backwardsItemMappings != null?(ln)this.backwardsItemMappings.get(var1):null;
   }

   @Nullable
   public String getMappedNamedSound(String var1) {
      String var2 = b();
      return this.backwardsSoundMappings != null?(String)this.backwardsSoundMappings.get(var1):null;
   }

   @Nullable
   public Int2ObjectMap getBackwardsItemMappings() {
      return this.backwardsItemMappings;
   }

   @Nullable
   public Map getBackwardsSoundMappings() {
      return this.backwardsSoundMappings;
   }

   public static void b(String var0) {
      o = var0;
   }

   public static String b() {
      return o;
   }

   static {
      b((String)null);
   }
}
