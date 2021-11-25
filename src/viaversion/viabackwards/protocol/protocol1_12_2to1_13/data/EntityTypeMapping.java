package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.EntityTypeRewriter;

public class EntityTypeMapping {
   private static final Int2IntFunction TYPES = new Int2IntOpenHashMap();

   public static int getOldId(int var0) {
      return TYPES.get(var0);
   }

   static {
      TYPES.defaultReturnValue(-1);
      ObjectIterator var0 = EntityTypeRewriter.ENTITY_TYPES.int2IntEntrySet().iterator();

      while(var0.hasNext()) {
         Entry var1 = (Entry)var0.next();
         TYPES.put(var1.getIntValue(), var1.getIntKey());
      }

   }
}
