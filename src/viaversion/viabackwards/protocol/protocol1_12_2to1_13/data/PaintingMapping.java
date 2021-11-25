package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.aci;

public class PaintingMapping {
   private static final Int2ObjectMap PAINTINGS = new Int2ObjectOpenHashMap(26, 1.0F);

   public static void init() {
      add("Kebab");
      add("Aztec");
      aci.b();
      add("Alban");
      add("Aztec2");
      add("Bomb");
      add("Plant");
      add("Wasteland");
      add("Pool");
      add("Courbet");
      add("Sea");
      add("Sunset");
      add("Creebet");
      add("Wanderer");
      add("Graham");
      add("Match");
      add("Bust");
      add("Stage");
      add("Void");
      add("SkullAndRoses");
      add("Wither");
      add("Fighters");
      add("Pointer");
      add("Pigscene");
      add("BurningSkull");
      add("Skeleton");
      add("DonkeyKong");
   }

   private static void add(String var0) {
      PAINTINGS.put(PAINTINGS.size(), var0);
   }

   public static String getStringId(int var0) {
      return (String)PAINTINGS.getOrDefault(var0, "kebab");
   }
}
