package viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.chunks;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.IntTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.acE;

public class FakeTileEntity {
   private static final Map tileEntities = new HashMap();
   private static acE[] b;

   private static void register(Integer var0, String var1) {
      CompoundTag var2 = new CompoundTag("");
      var2.put(new StringTag(var1));
      tileEntities.put(var0, var2);
   }

   private static void register(List var0, String var1) {
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         int var3 = ((Integer)var2.next()).intValue();
         register(Integer.valueOf(var3), var1);
      }

   }

   public static boolean hasBlock(int var0) {
      return tileEntities.containsKey(Integer.valueOf(var0));
   }

   public static CompoundTag getFromBlock(int var0, int var1, int var2, int var3) {
      b();
      CompoundTag var5 = (CompoundTag)tileEntities.get(Integer.valueOf(var3));
      if(var5 != null) {
         CompoundTag var6 = var5.clone();
         var6.put(new IntTag("x", var0));
         var6.put(new IntTag("y", var1));
         var6.put(new IntTag("z", var2));
         return var6;
      } else {
         return null;
      }
   }

   static {
      b((acE[])null);
      register(Arrays.asList(new Integer[]{Integer.valueOf(61), Integer.valueOf(62)}), "Furnace");
      register(Arrays.asList(new Integer[]{Integer.valueOf(54), Integer.valueOf(146)}), "Chest");
      register(Integer.valueOf(130), "EnderChest");
      register(Integer.valueOf(84), "RecordPlayer");
      register(Integer.valueOf(23), "Trap");
      register(Integer.valueOf(158), "Dropper");
      register(Arrays.asList(new Integer[]{Integer.valueOf(63), Integer.valueOf(68)}), "Sign");
      register(Integer.valueOf(52), "MobSpawner");
      register(Integer.valueOf(25), "Music");
      register(Arrays.asList(new Integer[]{Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(29), Integer.valueOf(36)}), "Piston");
      register(Integer.valueOf(117), "Cauldron");
      register(Integer.valueOf(116), "EnchantTable");
      register(Arrays.asList(new Integer[]{Integer.valueOf(119), Integer.valueOf(120)}), "Airportal");
      register(Integer.valueOf(138), "Beacon");
      register(Integer.valueOf(144), "Skull");
      register(Arrays.asList(new Integer[]{Integer.valueOf(178), Integer.valueOf(151)}), "DLDetector");
      register(Integer.valueOf(154), "Hopper");
      register(Arrays.asList(new Integer[]{Integer.valueOf(149), Integer.valueOf(150)}), "Comparator");
      register(Integer.valueOf(140), "FlowerPot");
      register(Arrays.asList(new Integer[]{Integer.valueOf(176), Integer.valueOf(177)}), "Banner");
      register(Integer.valueOf(209), "EndGateway");
      register(Integer.valueOf(137), "Control");
   }

   public static void b(acE[] var0) {
      b = var0;
   }

   public static acE[] b() {
      return b;
   }
}
