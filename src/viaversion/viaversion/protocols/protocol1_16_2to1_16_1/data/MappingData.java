package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.data;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.aPX;
import net.acE;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;

public class MappingData extends viaversion.viaversion.api.data.MappingData {
   private final Map dimensionDataMap = new HashMap();
   private CompoundTag dimensionRegistry;
   private static acE[] n;

   public MappingData() {
      super("1.16", "1.16.2", true);
   }

   public void loadExtras(JsonObject var1, JsonObject var2, JsonObject var3) {
      acE[] var4 = b();

      try {
         this.dimensionRegistry = aPX.a(MappingDataLoader.getResource("dimension-registry-1.16.2.nbt"));
      } catch (IOException var10) {
         Via.getPlatform().getLogger().severe("Error loading dimension registry:");
         var10.printStackTrace();
      }

      ListTag var5 = (ListTag)((CompoundTag)this.dimensionRegistry.get("minecraft:dimension_type")).get("value");
      Iterator var6 = var5.iterator();
      if(var6.hasNext()) {
         Tag var7 = (Tag)var6.next();
         CompoundTag var8 = (CompoundTag)var7;
         CompoundTag var9 = new CompoundTag("", ((CompoundTag)var8.get("element")).getValue());
         this.dimensionDataMap.put(((StringTag)var8.get("name")).getValue(), var9);
      }

   }

   public Map getDimensionDataMap() {
      return this.dimensionDataMap;
   }

   public CompoundTag getDimensionRegistry() {
      return this.dimensionRegistry;
   }

   public static void b(acE[] var0) {
      n = var0;
   }

   public static acE[] b() {
      return n;
   }

   static {
      b(new acE[4]);
   }
}
