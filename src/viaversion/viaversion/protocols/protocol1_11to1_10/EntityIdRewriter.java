package viaversion.viaversion.protocols.protocol1_11to1_10;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import viaversion.viaversion.api.minecraft.item.Item;

public class EntityIdRewriter {
   private static final BiMap oldToNewNames = HashBiMap.create();
   private static String[] b;

   public static void toClient(CompoundTag var0) {
      toClient(var0, false);
   }

   public static void toClient(CompoundTag var0, boolean var1) {
      b();
      Tag var3 = var0.get("id");
      if(var3 instanceof StringTag) {
         StringTag var4 = (StringTag)var3;
         String var5 = (String)oldToNewNames.inverse().get(var4.getValue());
         var4.setValue(var5);
      }

   }

   public static void toClientSpawner(CompoundTag var0) {
      toClientSpawner(var0, false);
   }

   public static void toClientSpawner(CompoundTag var0, boolean var1) {
      String[] var2 = b();
      if(var0 != null) {
         Tag var3 = var0.get("SpawnData");
         if(var3 != null) {
            toClient((CompoundTag)var3, var1);
         }

      }
   }

   public static void toClientItem(Item var0) {
      toClientItem(var0, false);
   }

   public static void toClientItem(Item var0, boolean var1) {
      String[] var2 = b();
      if(hasEntityTag(var0)) {
         toClient((CompoundTag)var0.getTag().get("EntityTag"), var1);
      }

      if(var0 != null && var0.getAmount() <= 0) {
         var0.setAmount((byte)1);
      }

   }

   public static void toServerItem(Item var0) {
      toServerItem(var0, false);
   }

   public static void toServerItem(Item var0, boolean var1) {
      String[] var2 = b();
      if(hasEntityTag(var0)) {
         CompoundTag var3 = (CompoundTag)var0.getTag().get("EntityTag");
         Tag var4 = var3.get("id");
         if(var4 instanceof StringTag) {
            StringTag var5 = (StringTag)var4;
            String var6 = (String)oldToNewNames.get(var5.getValue());
            var5.setValue(var6);
         }

      }
   }

   private static boolean hasEntityTag(Item var0) {
      String[] var1 = b();
      if(var0 != null && var0.getIdentifier() == 383) {
         CompoundTag var2 = var0.getTag();
         if(var2 == null) {
            return false;
         } else {
            Tag var3 = var2.get("EntityTag");
            return var3 instanceof CompoundTag && ((CompoundTag)var3).get("id") instanceof StringTag;
         }
      } else {
         return false;
      }
   }

   static {
      b((String[])null);
      oldToNewNames.put("AreaEffectCloud", "minecraft:area_effect_cloud");
      oldToNewNames.put("ArmorStand", "minecraft:armor_stand");
      oldToNewNames.put("Arrow", "minecraft:arrow");
      oldToNewNames.put("Bat", "minecraft:bat");
      oldToNewNames.put("Blaze", "minecraft:blaze");
      oldToNewNames.put("Boat", "minecraft:boat");
      oldToNewNames.put("CaveSpider", "minecraft:cave_spider");
      oldToNewNames.put("Chicken", "minecraft:chicken");
      oldToNewNames.put("Cow", "minecraft:cow");
      oldToNewNames.put("Creeper", "minecraft:creeper");
      oldToNewNames.put("Donkey", "minecraft:donkey");
      oldToNewNames.put("DragonFireball", "minecraft:dragon_fireball");
      oldToNewNames.put("ElderGuardian", "minecraft:elder_guardian");
      oldToNewNames.put("EnderCrystal", "minecraft:ender_crystal");
      oldToNewNames.put("EnderDragon", "minecraft:ender_dragon");
      oldToNewNames.put("Enderman", "minecraft:enderman");
      oldToNewNames.put("Endermite", "minecraft:endermite");
      oldToNewNames.put("EntityHorse", "minecraft:horse");
      oldToNewNames.put("EyeOfEnderSignal", "minecraft:eye_of_ender_signal");
      oldToNewNames.put("FallingSand", "minecraft:falling_block");
      oldToNewNames.put("Fireball", "minecraft:fireball");
      oldToNewNames.put("FireworksRocketEntity", "minecraft:fireworks_rocket");
      oldToNewNames.put("Ghast", "minecraft:ghast");
      oldToNewNames.put("Giant", "minecraft:giant");
      oldToNewNames.put("Guardian", "minecraft:guardian");
      oldToNewNames.put("Husk", "minecraft:husk");
      oldToNewNames.put("Item", "minecraft:item");
      oldToNewNames.put("ItemFrame", "minecraft:item_frame");
      oldToNewNames.put("LavaSlime", "minecraft:magma_cube");
      oldToNewNames.put("LeashKnot", "minecraft:leash_knot");
      oldToNewNames.put("MinecartChest", "minecraft:chest_minecart");
      oldToNewNames.put("MinecartCommandBlock", "minecraft:commandblock_minecart");
      oldToNewNames.put("MinecartFurnace", "minecraft:furnace_minecart");
      oldToNewNames.put("MinecartHopper", "minecraft:hopper_minecart");
      oldToNewNames.put("MinecartRideable", "minecraft:minecart");
      oldToNewNames.put("MinecartSpawner", "minecraft:spawner_minecart");
      oldToNewNames.put("MinecartTNT", "minecraft:tnt_minecart");
      oldToNewNames.put("Mule", "minecraft:mule");
      oldToNewNames.put("MushroomCow", "minecraft:mooshroom");
      oldToNewNames.put("Ozelot", "minecraft:ocelot");
      oldToNewNames.put("Painting", "minecraft:painting");
      oldToNewNames.put("Pig", "minecraft:pig");
      oldToNewNames.put("PigZombie", "minecraft:zombie_pigman");
      oldToNewNames.put("PolarBear", "minecraft:polar_bear");
      oldToNewNames.put("PrimedTnt", "minecraft:tnt");
      oldToNewNames.put("Rabbit", "minecraft:rabbit");
      oldToNewNames.put("Sheep", "minecraft:sheep");
      oldToNewNames.put("Shulker", "minecraft:shulker");
      oldToNewNames.put("ShulkerBullet", "minecraft:shulker_bullet");
      oldToNewNames.put("Silverfish", "minecraft:silverfish");
      oldToNewNames.put("Skeleton", "minecraft:skeleton");
      oldToNewNames.put("SkeletonHorse", "minecraft:skeleton_horse");
      oldToNewNames.put("Slime", "minecraft:slime");
      oldToNewNames.put("SmallFireball", "minecraft:small_fireball");
      oldToNewNames.put("Snowball", "minecraft:snowball");
      oldToNewNames.put("SnowMan", "minecraft:snowman");
      oldToNewNames.put("SpectralArrow", "minecraft:spectral_arrow");
      oldToNewNames.put("Spider", "minecraft:spider");
      oldToNewNames.put("Squid", "minecraft:squid");
      oldToNewNames.put("Stray", "minecraft:stray");
      oldToNewNames.put("ThrownEgg", "minecraft:egg");
      oldToNewNames.put("ThrownEnderpearl", "minecraft:ender_pearl");
      oldToNewNames.put("ThrownExpBottle", "minecraft:xp_bottle");
      oldToNewNames.put("ThrownPotion", "minecraft:potion");
      oldToNewNames.put("Villager", "minecraft:villager");
      oldToNewNames.put("VillagerGolem", "minecraft:villager_golem");
      oldToNewNames.put("Witch", "minecraft:witch");
      oldToNewNames.put("WitherBoss", "minecraft:wither");
      oldToNewNames.put("WitherSkeleton", "minecraft:wither_skeleton");
      oldToNewNames.put("WitherSkull", "minecraft:wither_skull");
      oldToNewNames.put("Wolf", "minecraft:wolf");
      oldToNewNames.put("XPOrb", "minecraft:xp_orb");
      oldToNewNames.put("Zombie", "minecraft:zombie");
      oldToNewNames.put("ZombieHorse", "minecraft:zombie_horse");
      oldToNewNames.put("ZombieVillager", "minecraft:zombie_villager");
   }

   public static void b(String[] var0) {
      b = var0;
   }

   public static String[] b() {
      return b;
   }
}
