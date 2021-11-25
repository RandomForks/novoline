package de.gerrygames.viarewind.protocol.protocol1_8to1_9.items;

import de.gerrygames.viarewind.replacement.Replacement;
import net.Zx;
import net.aMz;
import net.amf;

public class ReplacementRegistry1_8to1_9 {
   private static final Zx c = new Zx();
   private static boolean b;

   public static aMz a(aMz var0) {
      return c.a(var0);
   }

   public static amf a(amf var0) {
      return c.a(var0);
   }

   static {
      b(false);
      c.c(198, new Replacement(50, 0, "End Rod"));
      c.c(434, new Replacement(391, "Beetroot"));
      c.c(435, new Replacement(361, "Beetroot Seeds"));
      c.c(436, new Replacement(282, "Beetroot Soup"));
      c.c(432, new Replacement(322, "Chorus Fruit"));
      c.c(433, new Replacement(393, "Popped Chorus Fruit"));
      c.c(437, new Replacement(373, "Dragons Breath"));
      c.c(443, new Replacement(299, "Elytra"));
      c.c(426, new Replacement(410, "End Crystal"));
      c.c(442, new Replacement(425, "Shield"));
      c.c(439, new Replacement(262, "Spectral Arrow"));
      c.c(440, new Replacement(262, "Tipped Arrow"));
      c.c(444, new Replacement(333, "Spruce Boat"));
      c.c(445, new Replacement(333, "Birch Boat"));
      c.c(446, new Replacement(333, "Jungle Boat"));
      c.c(447, new Replacement(333, "Acacia Boat"));
      c.c(448, new Replacement(333, "Dark Oak Boat"));
      c.c(204, new Replacement(43, 7, "Purpur Double Slab"));
      c.c(205, new Replacement(44, 7, "Purpur Slab"));
      c.b(209, new Replacement(119));
      c.a(198, 0, new Replacement(50, 5));
      c.a(198, 1, new Replacement(50, 5));
      c.a(198, 2, new Replacement(50, 4));
      c.a(198, 3, new Replacement(50, 3));
      c.a(198, 4, new Replacement(50, 2));
      c.a(198, 5, new Replacement(50, 1));
      c.b(204, new Replacement(43, 7));
      c.a(205, 0, new Replacement(44, 7));
      c.a(205, 8, new Replacement(44, 15));
      c.b(207, new Replacement(141));
      c.a(199, new Replacement(35, 10, "Chorus Plant"));
      c.a(200, new Replacement(35, 2, "Chorus Flower"));
      c.a(201, new Replacement(155, "Purpur Block"));
      c.a(202, new Replacement(155, 2, "Purpur Pillar"));
      c.a(203, new Replacement(156, "Purpur Stairs"));
      c.a(206, new Replacement(121, "Endstone Bricks"));
      c.a(207, new Replacement(141, "Beetroot Block"));
      c.a(208, new Replacement(2, "Grass Path"));
      c.a(209, new Replacement(90, "End Gateway"));
      c.a(210, new Replacement(137, "Repeating Command Block"));
      c.a(211, new Replacement(137, "Chain Command Block"));
      c.a(212, new Replacement(79, 0, "Frosted Ice"));
      c.a(214, new Replacement(87, "Nether Wart Block"));
      c.a(215, new Replacement(112, "Red Nether Brick"));
      c.a(217, new Replacement(166, "Structure Void"));
      c.a(255, new Replacement(137, 0, "Structure Block"));
      c.b(397, 5, new Replacement(397, 0, "Dragon Head"));
   }

   public static void b(boolean var0) {
      b = var0;
   }

   public static boolean b() {
      return b;
   }

   public static boolean c() {
      boolean var0 = b();
      return true;
   }
}
