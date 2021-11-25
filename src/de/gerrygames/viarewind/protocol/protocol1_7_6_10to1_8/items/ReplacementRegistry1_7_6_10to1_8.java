package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items;

import de.gerrygames.viarewind.replacement.Replacement;
import net.Zx;
import net.aMz;
import net.amf;

public class ReplacementRegistry1_7_6_10to1_8 {
   private static final Zx a = new Zx();
   private static boolean b;

   public static aMz a(aMz var0) {
      return a.a(var0);
   }

   public static amf a(amf var0) {
      return a.a(var0);
   }

   static {
      b(true);
      a.b(176, new Replacement(63));
      a.b(177, new Replacement(68));
      a.b(193, new Replacement(64));
      a.b(194, new Replacement(64));
      a.b(195, new Replacement(64));
      a.b(196, new Replacement(64));
      a.b(197, new Replacement(64));
      a.a(77, 5, new Replacement(69, 6));
      a.a(77, 13, new Replacement(69, 14));
      a.a(77, 0, new Replacement(69, 0));
      a.a(77, 8, new Replacement(69, 8));
      a.a(143, 5, new Replacement(69, 6));
      a.a(143, 13, new Replacement(69, 14));
      a.a(143, 0, new Replacement(69, 0));
      a.a(143, 8, new Replacement(69, 8));
      a.b(178, new Replacement(151));
      a.a(182, 0, new Replacement(44, 1));
      a.a(182, 8, new Replacement(44, 9));
      a.c(425, new Replacement(323, "Banner"));
      a.c(409, new Replacement(406, "Prismarine Shard"));
      a.c(410, new Replacement(406, "Prismarine Crystal"));
      a.c(416, new Replacement(280, "Armor Stand"));
      a.c(423, new Replacement(363, "Raw Mutton"));
      a.c(424, new Replacement(364, "Cooked Mutton"));
      a.c(411, new Replacement(365, "Raw Rabbit"));
      a.c(412, new Replacement(366, "Cooked Rabbit"));
      a.c(413, new Replacement(282, "Rabbit Stew"));
      a.c(414, new Replacement(375, "Rabbit\'s Foot"));
      a.c(415, new Replacement(334, "Rabbit Hide"));
      a.c(373, 8203, new Replacement(373, 0, "Potion of Leaping"));
      a.c(373, 8235, new Replacement(373, 0, "Potion of Leaping"));
      a.c(373, 8267, new Replacement(373, 0, "Potion of Leaping"));
      a.c(373, 16395, new Replacement(373, 0, "Splash Potion of Leaping"));
      a.c(373, 16427, new Replacement(373, 0, "Splash Potion of Leaping"));
      a.c(373, 16459, new Replacement(373, 0, "Splash Potion of Leaping"));
      a.c(383, 30, new Replacement(383, "Spawn ArmorStand"));
      a.c(383, 67, new Replacement(383, "Spawn Endermite"));
      a.c(383, 68, new Replacement(383, "Spawn Guardian"));
      a.c(383, 101, new Replacement(383, "Spawn Rabbit"));
      a.c(19, 1, new Replacement(19, 0, "Wet Sponge"));
      a.c(182, new Replacement(44, 1, "Red Sandstone Slab"));
      a.a(166, new Replacement(20, "Barrier"));
      a.a(167, new Replacement(96, "Iron Trapdoor"));
      a.b(1, 1, new Replacement(1, 0, "Granite"));
      a.b(1, 2, new Replacement(1, 0, "Polished Granite"));
      a.b(1, 3, new Replacement(1, 0, "Diorite"));
      a.b(1, 4, new Replacement(1, 0, "Polished Diorite"));
      a.b(1, 5, new Replacement(1, 0, "Andesite"));
      a.b(1, 6, new Replacement(1, 0, "Polished Andesite"));
      a.b(168, 0, new Replacement(1, 0, "Prismarine"));
      a.b(168, 1, new Replacement(98, 0, "Prismarine Bricks"));
      a.b(168, 2, new Replacement(98, 1, "Dark Prismarine"));
      a.a(169, new Replacement(89, "Sea Lantern"));
      a.a(165, new Replacement(95, 5, "Slime Block"));
      a.b(179, 0, new Replacement(24, "Red Sandstone"));
      a.b(179, 1, new Replacement(24, "Chiseled Red Sandstone"));
      a.b(179, 2, new Replacement(24, "Smooth Sandstone"));
      a.a(181, new Replacement(43, 1, "Double Red Sandstone Slab"));
      a.a(180, new Replacement(128, "Red Sandstone Stairs"));
      a.a(188, new Replacement(85, "Spruce Fence"));
      a.a(189, new Replacement(85, "Birch Fence"));
      a.a(190, new Replacement(85, "Jungle Fence"));
      a.a(191, new Replacement(85, "Dark Oak Fence"));
      a.a(192, new Replacement(85, "Acacia Fence"));
      a.a(183, new Replacement(107, "Spruce Fence Gate"));
      a.a(184, new Replacement(107, "Birch Fence Gate"));
      a.a(185, new Replacement(107, "Jungle Fence Gate"));
      a.a(186, new Replacement(107, "Dark Oak Fence Gate"));
      a.a(187, new Replacement(107, "Acacia Fence Gate"));
      a.a(427, new Replacement(324, "Spruce Door"));
      a.a(428, new Replacement(324, "Birch Door"));
      a.a(429, new Replacement(324, "Jungle Door"));
      a.a(430, new Replacement(324, "Dark Oak Door"));
      a.a(431, new Replacement(324, "Acacia Door"));
      a.a(157, new Replacement(28, "Activator Rail"));
   }

   public static void b(boolean var0) {
      b = var0;
   }

   public static boolean b() {
      return b;
   }

   public static boolean a() {
      boolean var0 = b();
      return true;
   }
}
