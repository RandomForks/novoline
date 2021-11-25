package viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class Int2IntBiMap implements Int2IntMap {
   private final Int2IntMap map = new Int2IntOpenHashMap();
   private final Int2IntBiMap inverse;

   public Int2IntBiMap() {
      this.inverse = new Int2IntBiMap(this);
   }

   private Int2IntBiMap(Int2IntBiMap var1) {
      this.inverse = var1;
   }

   public Int2IntBiMap inverse() {
      return this.inverse;
   }

   public int put(int var1, int var2) {
      if(this.containsKey(var1) && var2 == this.get(var1)) {
         return var2;
      } else {
         Preconditions.checkArgument(!this.containsValue(var2), "value already present: %s", new Object[]{Integer.valueOf(var2)});
         this.map.put(var1, var2);
         this.inverse.map.put(var2, var1);
         return this.defaultReturnValue();
      }
   }

   public boolean remove(int var1, int var2) {
      this.map.remove(var1, var2);
      return this.inverse.map.remove(var1, var2);
   }

   public int get(int var1) {
      return this.map.get(var1);
   }

   public void clear() {
      this.map.clear();
      this.inverse.map.clear();
   }

   public int size() {
      return this.map.size();
   }

   public boolean isEmpty() {
      return this.map.isEmpty();
   }

   /** @deprecated */
   @Deprecated
   public void putAll(@NotNull Map var1) {
      throw new UnsupportedOperationException();
   }

   public void defaultReturnValue(int var1) {
      this.map.defaultReturnValue(var1);
      this.inverse.map.defaultReturnValue(var1);
   }

   public int defaultReturnValue() {
      return this.map.defaultReturnValue();
   }

   public ObjectSet int2IntEntrySet() {
      return this.map.int2IntEntrySet();
   }

   @NotNull
   public IntSet keySet() {
      return this.map.keySet();
   }

   @NotNull
   public IntSet values() {
      return this.inverse.map.keySet();
   }

   public boolean containsKey(int var1) {
      return this.map.containsKey(var1);
   }

   public boolean containsValue(int var1) {
      return this.inverse.map.containsKey(var1);
   }

   private static UnsupportedOperationException a(UnsupportedOperationException var0) {
      return var0;
   }
}
