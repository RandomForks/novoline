package viaversion.viaversion.protocols.protocol1_16to1_15_2.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.JsonObject;
import net.acE;
import net.amd;

public class MappingData extends viaversion.viaversion.api.data.MappingData {
   private final BiMap attributeMappings = HashBiMap.create();

   public MappingData() {
      super("1.15", "1.16", true);
   }

   protected void loadExtras(JsonObject var1, JsonObject var2, JsonObject var3) {
      this.attributeMappings.put("generic.maxHealth", "minecraft:generic.max_health");
      this.attributeMappings.put("zombie.spawnReinforcements", "minecraft:zombie.spawn_reinforcements");
      amd.a();
      this.attributeMappings.put("horse.jumpStrength", "minecraft:horse.jump_strength");
      this.attributeMappings.put("generic.followRange", "minecraft:generic.follow_range");
      this.attributeMappings.put("generic.knockbackResistance", "minecraft:generic.knockback_resistance");
      this.attributeMappings.put("generic.movementSpeed", "minecraft:generic.movement_speed");
      this.attributeMappings.put("generic.flyingSpeed", "minecraft:generic.flying_speed");
      this.attributeMappings.put("generic.attackDamage", "minecraft:generic.attack_damage");
      this.attributeMappings.put("generic.attackKnockback", "minecraft:generic.attack_knockback");
      this.attributeMappings.put("generic.attackSpeed", "minecraft:generic.attack_speed");
      this.attributeMappings.put("generic.armorToughness", "minecraft:generic.armor_toughness");
      if(acE.b() == null) {
         amd.b(new int[2]);
      }

   }

   public BiMap getAttributeMappings() {
      return this.attributeMappings;
   }
}
