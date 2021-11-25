package viaversion.viaversion.api.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.util.Int2IntBiMap;

public class MappingDataLoader {
   private static final Map MAPPINGS_CACHE = new ConcurrentHashMap();
   private static boolean cacheJsonMappings;

   public static boolean isCacheJsonMappings() {
      return cacheJsonMappings;
   }

   public static void enableMappingsCache() {
      cacheJsonMappings = true;
   }

   public static Map getMappingsCache() {
      return MAPPINGS_CACHE;
   }

   @Nullable
   public static JsonObject loadFromDataDir(String param0) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public static JsonObject loadData(String var0) {
      return loadData(var0, false);
   }

   @Nullable
   public static JsonObject loadData(String var0, boolean var1) {
      if(cacheJsonMappings) {
         JsonObject var3 = (JsonObject)MAPPINGS_CACHE.get(var0);
         return var3;
      } else {
         InputStream var2 = getResource(var0);
         return null;
      }
   }

   public static void mapIdentifiers(Int2IntBiMap var0, JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
      Object2IntMap var4 = indexedObjectToMap(var2);

      for(Entry var6 : var1.entrySet()) {
         int var7 = mapIdentifierEntry(var6, var4, var3);
         if(var7 != -1) {
            var0.put(Integer.parseInt((String)var6.getKey()), var7);
         }
      }

   }

   public static void mapIdentifiers(short[] var0, JsonObject var1, JsonObject var2) {
      mapIdentifiers((short[])var0, var1, var2, (JsonObject)null);
   }

   public static void mapIdentifiers(short[] var0, JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
      Object2IntMap var4 = indexedObjectToMap(var2);

      for(Entry var6 : var1.entrySet()) {
         int var7 = mapIdentifierEntry(var6, var4, var3);
         if(var7 != -1) {
            var0[Integer.parseInt((String)var6.getKey())] = (short)var7;
         }
      }

   }

   private static int mapIdentifierEntry(Entry var0, Object2IntMap var1, @Nullable JsonObject var2) {
      int var3 = var1.getInt(((JsonElement)var0.getValue()).getAsString());
      if(var3 == -1) {
         JsonElement var4 = var2.get((String)var0.getKey());
         var3 = var1.getInt(var4.getAsString());
         if(var3 == -1) {
            if(!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
               Via.getPlatform().getLogger().warning("No key for " + var0.getValue() + " :( ");
            }

            return -1;
         }
      }

      return var3;
   }

   public static void mapIdentifiers(short[] var0, JsonArray var1, JsonArray var2, boolean var3) {
      mapIdentifiers(var0, var1, var2, (JsonObject)null, var3);
   }

   public static void mapIdentifiers(short[] var0, JsonArray var1, JsonArray var2, @Nullable JsonObject var3, boolean var4) {
      Object2IntMap var5 = arrayToMap(var2);

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         JsonElement var7 = var1.get(var6);
         int var8 = var5.getInt(var7.getAsString());
         if(var8 == -1) {
            JsonElement var9 = var3.get(var7.getAsString());
            String var10 = var9.getAsString();
            if(var10.isEmpty()) {
               continue;
            }

            var8 = var5.getInt(var10);
            if(var8 == -1) {
               if(!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                  Via.getPlatform().getLogger().warning("No key for " + var7 + " :( ");
               }
               continue;
            }
         }

         var0[var6] = (short)var8;
      }

   }

   public static Object2IntMap indexedObjectToMap(JsonObject var0) {
      Object2IntOpenHashMap var1 = new Object2IntOpenHashMap(var0.size(), 1.0F);
      var1.defaultReturnValue(-1);

      for(Entry var3 : var0.entrySet()) {
         var1.put(((JsonElement)var3.getValue()).getAsString(), Integer.parseInt((String)var3.getKey()));
      }

      return var1;
   }

   public static Object2IntMap arrayToMap(JsonArray var0) {
      Object2IntOpenHashMap var1 = new Object2IntOpenHashMap(var0.size(), 1.0F);
      var1.defaultReturnValue(-1);

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         var1.put(var0.get(var2).getAsString(), var2);
      }

      return var1;
   }

   @Nullable
   public static InputStream getResource(String var0) {
      return MappingDataLoader.class.getClassLoader().getResourceAsStream("assets/viaversion/data/" + var0);
   }

   private static Throwable a(Throwable var0) {
      return var0;
   }
}
