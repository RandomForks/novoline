package viaversion.viabackwards.api.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.VV;
import net.ln;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;

public class VBMappingDataLoader {
   public static JsonObject loadFromDataDir(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static JsonObject loadData(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static void mapIdentifiers(short[] var0, JsonObject var1, JsonObject var2, JsonObject var3) {
      mapIdentifiers(var0, var1, var2, var3, true);
   }

   public static void mapIdentifiers(short[] var0, JsonObject var1, JsonObject var2, JsonObject var3, boolean var4) {
      BackwardsMappings.b();
      Object2IntMap var6 = MappingDataLoader.indexedObjectToMap(var2);

      for(Entry var8 : var1.entrySet()) {
         String var9 = ((JsonElement)var8.getValue()).getAsString();
         int var10 = var6.getInt(var9);
         if(var10 == -1) {
            if(var3 != null) {
               JsonPrimitive var11 = var3.getAsJsonPrimitive(var9);
               String var12 = var11 != null?var11.getAsString():null;
               int var13;
               if(var12 == null && (var13 = var9.indexOf(91)) != -1 && (var11 = var3.getAsJsonPrimitive(var9.substring(0, var13))) != null) {
                  var12 = var11.getAsString();
                  if(var12.endsWith("[")) {
                     var12 = var12 + var9.substring(var13 + 1);
                  }
               }

               if(var12 != null) {
                  var10 = var6.getInt(var12);
               }
            }

            if(var10 == -1) {
               if((!var4 || Via.getConfig().isSuppressConversionWarnings()) && !Via.getManager().isDebug()) {
                  continue;
               }

               VV.d().getLogger().warning("No key for " + var8.getValue() + " :( ");
            }
         }

         var0[Integer.parseInt((String)var8.getKey())] = (short)var10;
         break;
      }

   }

   public static Map objectToMap(JsonObject var0) {
      BackwardsMappings.b();
      HashMap var2 = new HashMap();
      Iterator var3 = var0.entrySet().iterator();
      if(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var5 = (String)var4.getKey();
         if(var5.indexOf(58) == -1) {
            var5 = "minecraft:" + var5;
         }

         String var6 = ((JsonElement)var4.getValue()).getAsString();
         if(var6.indexOf(58) == -1) {
            var6 = "minecraft:" + var6;
         }

         var2.put(var5, var6);
      }

      return var2;
   }

   public static Int2ObjectMap loadItemMappings(JsonObject var0, JsonObject var1, JsonObject var2) {
      Int2ObjectOpenHashMap var4 = new Int2ObjectOpenHashMap(var2.size(), 1.0F);
      Object2IntMap var5 = MappingDataLoader.indexedObjectToMap(var1);
      BackwardsMappings.b();
      Object2IntMap var6 = MappingDataLoader.indexedObjectToMap(var0);

      for(Entry var8 : var2.entrySet()) {
         JsonObject var9 = ((JsonElement)var8.getValue()).getAsJsonObject();
         String var10 = var9.getAsJsonPrimitive("id").getAsString();
         int var11 = var5.getInt(var10);
         if(var11 == -1) {
            if(Via.getConfig().isSuppressConversionWarnings() && !Via.getManager().isDebug()) {
               continue;
            }

            VV.d().getLogger().warning("No key for " + var10 + " :( ");
         }

         int var12 = var6.getInt(var8.getKey());
         if(var12 == -1) {
            if(Via.getConfig().isSuppressConversionWarnings() && !Via.getManager().isDebug()) {
               continue;
            }

            VV.d().getLogger().warning("No old entry for " + var10 + " :( ");
         }

         String var13 = var9.getAsJsonPrimitive("name").getAsString();
         var4.put(var12, new ln(var11, var13));
         break;
      }

      return var4;
   }

   private static Throwable a(Throwable var0) {
      return var0;
   }
}
