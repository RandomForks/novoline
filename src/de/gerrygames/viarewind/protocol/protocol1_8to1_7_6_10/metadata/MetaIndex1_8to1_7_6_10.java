package de.gerrygames.viarewind.protocol.protocol1_8to1_7_6_10.metadata;

import com.viaversion.viaversion.api.minecraft.metadata.types.MetaType1_8;
import com.viaversion.viaversion.util.Pair;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.MetaType1_7_6_10;
import java.util.HashMap;
import java.util.Optional;
import net.MO;
import net.t4;

public enum MetaIndex1_8to1_7_6_10 {
   ENTITY_FLAGS(t4.ENTITY, 0, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ENTITY_AIR(t4.ENTITY, 1, MetaType1_7_6_10.Short, MetaType1_8.Short),
   ENTITY_NAME_TAG(t4.ENTITY, -1, MetaType1_7_6_10.NonExistent, 2, MetaType1_8.String),
   ENTITY_NAME_TAG_VISIBILITY(t4.ENTITY, -1, MetaType1_7_6_10.NonExistent, 3, MetaType1_8.Byte),
   ENTITY_SILENT(t4.ENTITY, -1, MetaType1_7_6_10.NonExistent, 4, MetaType1_8.Byte),
   ENTITY_LIVING_HEALTH(t4.ENTITY_LIVING, 6, MetaType1_7_6_10.Float, MetaType1_8.Float),
   ENTITY_LIVING_POTION_EFFECT_COLOR(t4.ENTITY_LIVING, 7, MetaType1_7_6_10.Int, MetaType1_8.Int),
   ENTITY_LIVING_IS_POTION_EFFECT_AMBIENT(t4.ENTITY_LIVING, 8, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ENTITY_LIVING_ARROWS(t4.ENTITY_LIVING, 9, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ENTITY_LIVING_NAME_TAG(t4.ENTITY_LIVING, 10, MetaType1_7_6_10.String, 2, MetaType1_8.String),
   ENTITY_LIVING_NAME_TAG_VISIBILITY(t4.ENTITY_LIVING, 11, MetaType1_7_6_10.Byte, 3, MetaType1_8.Byte),
   ENTITY_LIVING_AI(t4.ENTITY_LIVING, -1, MetaType1_7_6_10.NonExistent, 15, MetaType1_8.Byte),
   ENTITY_AGEABLE_AGE(t4.ENTITY_AGEABLE, 12, MetaType1_7_6_10.Int, MetaType1_8.Byte),
   ARMOR_STAND_FLAGS(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 10, MetaType1_8.Byte),
   ARMOR_STAND_HEAD_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 11, MetaType1_8.Rotation),
   ARMOR_STAND_BODY_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 12, MetaType1_8.Rotation),
   ARMOR_STAND_LEFT_ARM_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 13, MetaType1_8.Rotation),
   ARMOR_STAND_RIGHT_ARM_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 14, MetaType1_8.Rotation),
   ARMOR_STAND_LEFT_LEG_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 15, MetaType1_8.Rotation),
   ARMOR_STAND_RIGHT_LEG_POSITION(t4.ARMOR_STAND, -1, MetaType1_7_6_10.NonExistent, 16, MetaType1_8.Rotation),
   HUMAN_SKIN_FLAGS(t4.ENTITY_HUMAN, 16, MetaType1_7_6_10.Byte, 10, MetaType1_8.Byte),
   HUMAN_UNUSED(t4.ENTITY_HUMAN, -1, MetaType1_7_6_10.NonExistent, 16, MetaType1_8.Byte),
   HUMAN_ABSORPTION_HEATS(t4.ENTITY_HUMAN, 17, MetaType1_7_6_10.Float, MetaType1_8.Float),
   HUMAN_SCORE(t4.ENTITY_HUMAN, 18, MetaType1_7_6_10.Int, MetaType1_8.Int),
   HORSE_FLAGS(t4.HORSE, 16, MetaType1_7_6_10.Int, MetaType1_8.Int),
   HORSE_TYPE(t4.HORSE, 19, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   HORSE_COLOR(t4.HORSE, 20, MetaType1_7_6_10.Int, MetaType1_8.Int),
   HORSE_OWNER(t4.HORSE, 21, MetaType1_7_6_10.String, MetaType1_8.String),
   HORSE_ARMOR(t4.HORSE, 22, MetaType1_7_6_10.Int, MetaType1_8.Int),
   BAT_HANGING(t4.BAT, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   TAMEABLE_FLAGS(t4.ENTITY_TAMEABLE_ANIMAL, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   TAMEABLE_OWNER(t4.ENTITY_TAMEABLE_ANIMAL, 17, MetaType1_7_6_10.String, MetaType1_8.String),
   OCELOT_TYPE(t4.OCELOT, 18, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   WOLF_FLAGS(t4.WOLF, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   WOLF_HEALTH(t4.WOLF, 18, MetaType1_7_6_10.Float, MetaType1_8.Float),
   WOLF_BEGGING(t4.WOLF, 19, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   WOLF_COLLAR_COLOR(t4.WOLF, 20, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   PIG_SADDLE(t4.PIG, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   SHEEP_COLOR_OR_SHEARED(t4.SHEEP, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   VILLAGER_TYPE(t4.VILLAGER, 16, MetaType1_7_6_10.Int, MetaType1_8.Int),
   ENDERMAN_CARRIED_BLOCK(t4.ENDERMAN, 16, MetaType1_7_6_10.NonExistent, MetaType1_8.Short),
   ENDERMAN_CARRIED_BLOCK_DATA(t4.ENDERMAN, 17, MetaType1_7_6_10.NonExistent, MetaType1_8.Byte),
   ENDERMAN_IS_SCREAMING(t4.ENDERMAN, 18, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ZOMBIE_CHILD(t4.ZOMBIE, 12, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ZOMBIE_VILLAGER(t4.ZOMBIE, 13, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ZOMBIE_CONVERTING(t4.ZOMBIE, 14, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   BLAZE_ON_FIRE(t4.BLAZE, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   SPIDER_CLIMBING(t4.SPIDER, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   CREEPER_STATE(t4.CREEPER, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   CREEPER_POWERED(t4.CREEPER, 17, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   GHAST_STATE(t4.GHAST, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   GHAST_IS_POWERED(t4.GHAST, 17, MetaType1_7_6_10.NonExistent, MetaType1_8.Byte),
   SLIME_SIZE(t4.SLIME, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   SKELETON_TYPE(t4.SKELETON, 13, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   WITCH_AGRESSIVE(t4.WITCH, 21, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   IRON_GOLEM_IS_PLAYER_CREATED(t4.IRON_GOLEM, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   WITHER_WATCHED_TAGRET_1(t4.WITHER, 17, MetaType1_7_6_10.Int, MetaType1_8.Int),
   WITHER_WATCHED_TAGRET_2(t4.WITHER, 18, MetaType1_7_6_10.Int, MetaType1_8.Int),
   WITHER_WATCHED_TAGRET_3(t4.WITHER, 19, MetaType1_7_6_10.Int, MetaType1_8.Int),
   WITHER_INVULNERABLE_TIME(t4.WITHER, 20, MetaType1_7_6_10.Int, MetaType1_8.Int),
   GUARDIAN_FLAGS(t4.GUARDIAN, 16, MetaType1_7_6_10.NonExistent, MetaType1_8.Byte),
   GUARDIAN_TARGET(t4.GUARDIAN, 17, MetaType1_7_6_10.NonExistent, MetaType1_8.Int),
   BOAT_TIME_SINCE_HIT(t4.BOAT, 17, MetaType1_7_6_10.Int, MetaType1_8.Int),
   BOAT_FORWARD_DIRECTION(t4.BOAT, 18, MetaType1_7_6_10.Int, MetaType1_8.Int),
   BOAT_DAMAGE_TAKEN(t4.BOAT, 19, MetaType1_7_6_10.Float, MetaType1_8.Float),
   MINECART_SHAKING_POWER(t4.MINECART_ABSTRACT, 17, MetaType1_7_6_10.Int, MetaType1_8.Int),
   MINECART_SHAKING_DIRECTION(t4.MINECART_ABSTRACT, 18, MetaType1_7_6_10.Int, MetaType1_8.Int),
   MINECART_DAMAGE_TAKEN(t4.MINECART_ABSTRACT, 19, MetaType1_7_6_10.Float, MetaType1_8.Float),
   MINECART_BLOCK_INSIDE(t4.MINECART_ABSTRACT, 20, MetaType1_7_6_10.Int, MetaType1_8.Int),
   MINECART_BLOCK_Y(t4.MINECART_ABSTRACT, 21, MetaType1_7_6_10.Int, MetaType1_8.Int),
   MINECART_SHOW_BLOCK(t4.MINECART_ABSTRACT, 22, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   FURNACE_MINECART_IS_POWERED(t4.MINECART_FURNACE, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   ITEM_ITEM(t4.DROPPED_ITEM, 10, MetaType1_7_6_10.Slot, MetaType1_8.Slot),
   ARROW_IS_CRITICAL(t4.ARROW, 16, MetaType1_7_6_10.Byte, MetaType1_8.Byte),
   FIREWORK_INFO(t4.FIREWORK, 8, MetaType1_7_6_10.Slot, MetaType1_8.Slot),
   ITEM_FRAME_ITEM(t4.ITEM_FRAME, 2, MetaType1_7_6_10.Slot, 8, MetaType1_8.Slot),
   ITEM_FRAME_ROTATION(t4.ITEM_FRAME, 3, MetaType1_7_6_10.Byte, 9, MetaType1_8.Byte),
   ENDER_CRYSTAL_HEALTH(t4.ENDER_CRYSTAL, 8, MetaType1_7_6_10.Int, 9, MetaType1_8.Int);

   private static final HashMap metadataRewrites = new HashMap();
   private t4 g;
   private int newIndex;
   private MetaType1_8 newType;
   private MetaType1_7_6_10 oldType;
   private int index;
   private static final MetaIndex1_8to1_7_6_10[] $VALUES = new MetaIndex1_8to1_7_6_10[]{ENTITY_FLAGS, ENTITY_AIR, ENTITY_NAME_TAG, ENTITY_NAME_TAG_VISIBILITY, ENTITY_SILENT, ENTITY_LIVING_HEALTH, ENTITY_LIVING_POTION_EFFECT_COLOR, ENTITY_LIVING_IS_POTION_EFFECT_AMBIENT, ENTITY_LIVING_ARROWS, ENTITY_LIVING_NAME_TAG, ENTITY_LIVING_NAME_TAG_VISIBILITY, ENTITY_LIVING_AI, ENTITY_AGEABLE_AGE, ARMOR_STAND_FLAGS, ARMOR_STAND_HEAD_POSITION, ARMOR_STAND_BODY_POSITION, ARMOR_STAND_LEFT_ARM_POSITION, ARMOR_STAND_RIGHT_ARM_POSITION, ARMOR_STAND_LEFT_LEG_POSITION, ARMOR_STAND_RIGHT_LEG_POSITION, HUMAN_SKIN_FLAGS, HUMAN_UNUSED, HUMAN_ABSORPTION_HEATS, HUMAN_SCORE, HORSE_FLAGS, HORSE_TYPE, HORSE_COLOR, HORSE_OWNER, HORSE_ARMOR, BAT_HANGING, TAMEABLE_FLAGS, TAMEABLE_OWNER, OCELOT_TYPE, WOLF_FLAGS, WOLF_HEALTH, WOLF_BEGGING, WOLF_COLLAR_COLOR, PIG_SADDLE, SHEEP_COLOR_OR_SHEARED, VILLAGER_TYPE, ENDERMAN_CARRIED_BLOCK, ENDERMAN_CARRIED_BLOCK_DATA, ENDERMAN_IS_SCREAMING, ZOMBIE_CHILD, ZOMBIE_VILLAGER, ZOMBIE_CONVERTING, BLAZE_ON_FIRE, SPIDER_CLIMBING, CREEPER_STATE, CREEPER_POWERED, GHAST_STATE, GHAST_IS_POWERED, SLIME_SIZE, SKELETON_TYPE, WITCH_AGRESSIVE, IRON_GOLEM_IS_PLAYER_CREATED, WITHER_WATCHED_TAGRET_1, WITHER_WATCHED_TAGRET_2, WITHER_WATCHED_TAGRET_3, WITHER_INVULNERABLE_TIME, GUARDIAN_FLAGS, GUARDIAN_TARGET, BOAT_TIME_SINCE_HIT, BOAT_FORWARD_DIRECTION, BOAT_DAMAGE_TAKEN, MINECART_SHAKING_POWER, MINECART_SHAKING_DIRECTION, MINECART_DAMAGE_TAKEN, MINECART_BLOCK_INSIDE, MINECART_BLOCK_Y, MINECART_SHOW_BLOCK, FURNACE_MINECART_IS_POWERED, ITEM_ITEM, ARROW_IS_CRITICAL, FIREWORK_INFO, ITEM_FRAME_ITEM, ITEM_FRAME_ROTATION, ENDER_CRYSTAL_HEALTH};

   private MetaIndex1_8to1_7_6_10(t4 var3, int var4, MetaType1_7_6_10 var5, MetaType1_8 var6) {
      this.g = var3;
      this.index = var4;
      this.newIndex = var4;
      this.oldType = var5;
      this.newType = var6;
   }

   private MetaIndex1_8to1_7_6_10(t4 var3, int var4, MetaType1_7_6_10 var5, int var6, MetaType1_8 var7) {
      this.g = var3;
      this.index = var4;
      this.oldType = var5;
      this.newIndex = var6;
      this.newType = var7;
   }

   private static Optional a(t4 var0, int var1) {
      MO.b();
      Pair var3 = new Pair(var0, Integer.valueOf(var1));
      return metadataRewrites.containsKey(var3)?Optional.of(metadataRewrites.get(var3)):Optional.empty();
   }

   public t4 b() {
      return this.g;
   }

   public int getNewIndex() {
      return this.newIndex;
   }

   public MetaType1_8 getNewType() {
      return this.newType;
   }

   public MetaType1_7_6_10 getOldType() {
      return this.oldType;
   }

   public int getIndex() {
      return this.index;
   }

   public static MetaIndex1_8to1_7_6_10 b(t4 var0, int var1) {
      int[] var2 = MO.b();
      Optional var4 = a(var0, var1);
      if(var4.isPresent()) {
         return (MetaIndex1_8to1_7_6_10)var4.get();
      } else {
         t4 var3 = var0.a();
         return null;
      }
   }

   static {
      for(MetaIndex1_8to1_7_6_10 var11 : values()) {
         metadataRewrites.put(new Pair(var11.b(), Integer.valueOf(var11.getIndex())), var11);
      }

   }
}
