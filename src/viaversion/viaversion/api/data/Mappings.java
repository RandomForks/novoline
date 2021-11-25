package viaversion.viaversion.api.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.data.MappingDataLoader;

public class Mappings {
   protected final short[] oldToNew;

   public Mappings(short[] var1) {
      this.oldToNew = var1;
   }

   public Mappings(int var1, JsonObject var2, JsonObject var3, @Nullable JsonObject var4) {
      this.oldToNew = new short[var1];
      Arrays.fill(this.oldToNew, (short)-1);
      MappingDataLoader.mapIdentifiers(this.oldToNew, var2, var3, var4);
   }

   public Mappings(JsonObject var1, JsonObject var2, @Nullable JsonObject var3) {
      this(var1.entrySet().size(), var1, var2, var3);
   }

   public Mappings(int var1, JsonObject var2, JsonObject var3) {
      this.oldToNew = new short[var1];
      Arrays.fill(this.oldToNew, (short)-1);
      MappingDataLoader.mapIdentifiers(this.oldToNew, var2, var3);
   }

   public Mappings(JsonObject var1, JsonObject var2) {
      this(var1.entrySet().size(), var1, var2);
   }

   public Mappings(int var1, JsonArray var2, JsonArray var3, JsonObject var4, boolean var5) {
      this.oldToNew = new short[var1];
      Arrays.fill(this.oldToNew, (short)-1);
      MappingDataLoader.mapIdentifiers(this.oldToNew, var2, var3, var4, var5);
   }

   public Mappings(int var1, JsonArray var2, JsonArray var3, boolean var4) {
      this(var1, var2, var3, (JsonObject)null, var4);
   }

   public Mappings(JsonArray var1, JsonArray var2, boolean var3) {
      this(var1.size(), var1, var2, var3);
   }

   public Mappings(int var1, JsonArray var2, JsonArray var3) {
      this(var1, var2, var3, true);
   }

   public Mappings(JsonArray var1, JsonArray var2, JsonObject var3) {
      this(var1.size(), var1, var2, var3, true);
   }

   public Mappings(JsonArray var1, JsonArray var2) {
      this(var1.size(), var1, var2, true);
   }

   public int getNewId(int var1) {
      return var1 < this.oldToNew.length?this.oldToNew[var1]:-1;
   }

   public short[] getOldToNew() {
      return this.oldToNew;
   }
}
