package viaversion.viabackwards.api.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Arrays;
import viaversion.viabackwards.api.data.VBMappingDataLoader;
import viaversion.viaversion.api.data.Mappings;

public class VBMappings extends Mappings {
   public VBMappings(int var1, JsonObject var2, JsonObject var3, JsonObject var4, boolean var5) {
      super(create(var1, var2, var3, var4, var5));
   }

   public VBMappings(JsonObject var1, JsonObject var2, JsonObject var3, boolean var4) {
      super(create(var1.entrySet().size(), var1, var2, var3, var4));
   }

   public VBMappings(JsonObject var1, JsonObject var2, boolean var3) {
      this((JsonObject)var1, (JsonObject)var2, (JsonObject)null, var3);
   }

   public VBMappings(JsonArray var1, JsonArray var2, JsonObject var3, boolean var4) {
      super(var1.size(), var1, var2, var3, var4);
   }

   private static short[] create(int var0, JsonObject var1, JsonObject var2, JsonObject var3, boolean var4) {
      short[] var5 = new short[var0];
      Arrays.fill(var5, (short)-1);
      VBMappingDataLoader.mapIdentifiers(var5, var1, var2, var3, var4);
      return var5;
   }
}
