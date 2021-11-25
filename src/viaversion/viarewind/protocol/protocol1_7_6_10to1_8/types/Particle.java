package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import java.util.HashMap;
import net.acE;

public enum Particle {
   EXPLOSION_NORMAL("explode"),
   EXPLOSION_LARGE("largeexplode"),
   EXPLOSION_HUGE("hugeexplosion"),
   FIREWORKS_SPARK("fireworksSpark"),
   WATER_BUBBLE("bubble"),
   WATER_SPLASH("splash"),
   WATER_WAKE("wake"),
   SUSPENDED("suspended"),
   SUSPENDED_DEPTH("depthsuspend"),
   CRIT("crit"),
   CRIT_MAGIC("magicCrit"),
   SMOKE_NORMAL("smoke"),
   SMOKE_LARGE("largesmoke"),
   SPELL("spell"),
   SPELL_INSTANT("instantSpell"),
   SPELL_MOB("mobSpell"),
   SPELL_MOB_AMBIENT("mobSpellAmbient"),
   SPELL_WITCH("witchMagic"),
   DRIP_WATER("dripWater"),
   DRIP_LAVA("dripLava"),
   VILLAGER_ANGRY("angryVillager"),
   VILLAGER_HAPPY("happyVillager"),
   TOWN_AURA("townaura"),
   NOTE("note"),
   PORTAL("portal"),
   ENCHANTMENT_TABLE("enchantmenttable"),
   FLAME("flame"),
   LAVA("lava"),
   FOOTSTEP("footstep"),
   CLOUD("cloud"),
   REDSTONE("reddust"),
   SNOWBALL("snowballpoof"),
   SNOW_SHOVEL("snowshovel"),
   SLIME("slime"),
   HEART("heart"),
   BARRIER("barrier"),
   ICON_CRACK("iconcrack", 2),
   BLOCK_CRACK("blockcrack", 1),
   BLOCK_DUST("blockdust", 1),
   WATER_DROP("droplet"),
   ITEM_TAKE("take"),
   MOB_APPEARANCE("mobappearance");

   public final String name;
   public final int extra;
   private static final HashMap particleMap = new HashMap();
   private static acE[] b;

   private Particle(String var3) {
      this(var3, 0);
   }

   private Particle(String var3, int var4) {
      this.name = var3;
      this.extra = var4;
   }

   public static Particle find(String var0) {
      return (Particle)particleMap.get(var0);
   }

   public static Particle find(int var0) {
      return null;
   }

   static {
      b(new acE[1]);
      Particle[] var8 = values();

      for(Particle var12 : var8) {
         particleMap.put(var12.name, var12);
      }

   }

   public static void b(acE[] var0) {
      b = var0;
   }

   public static acE[] b() {
      return b;
   }
}
