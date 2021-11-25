package viaversion.viaversion.protocols.protocol1_16to1_15_2.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;
import net.amd;
import net.km;
import viaversion.viaversion.api.protocol.Protocol;

public class TranslationMappings extends km {
   private final Map mappings = new HashMap();

   public TranslationMappings(Protocol var1) {
      super(var1);
      this.mappings.put("block.minecraft.flowing_water", "Flowing Water");
      amd.a();
      this.mappings.put("block.minecraft.flowing_lava", "Flowing Lava");
      this.mappings.put("block.minecraft.bed", "Bed");
      this.mappings.put("block.minecraft.bed.not_valid", "Your home bed was missing or obstructed");
      this.mappings.put("block.minecraft.bed.set_spawn", "Respawn point set");
      this.mappings.put("block.minecraft.two_turtle_eggs", "Two Turtle Eggs");
      this.mappings.put("block.minecraft.three_turtle_eggs", "Three Turtle Eggs");
      this.mappings.put("block.minecraft.four_turtle_eggs", "Four Turtle Eggs");
      this.mappings.put("block.minecraft.banner", "Banner");
      this.mappings.put("block.minecraft.wall_banner", "Wall Banner");
      this.mappings.put("item.minecraft.zombie_pigman_spawn_egg", "Zombie Pigman Spawn Egg");
      this.mappings.put("item.minecraft.skeleton_skull", "Skeleton Skull");
      this.mappings.put("item.minecraft.wither_skeleton_skull", "Wither Skeleton Skull");
      this.mappings.put("item.minecraft.zombie_head", "Zombie Head");
      this.mappings.put("item.minecraft.creeper_head", "Creeper Head");
      this.mappings.put("item.minecraft.dragon_head", "Dragon Head");
      this.mappings.put("entity.minecraft.zombie_pigman", "Zombie Pigman");
      this.mappings.put("death.fell.accident.water", "%1$s fell out of the water");
      this.mappings.put("death.attack.netherBed.message", "%1$s was killed by %2$s");
      this.mappings.put("death.attack.netherBed.link", "Intentional Game Design");
      this.mappings.put("advancements.husbandry.break_diamond_hoe.title", "Serious Dedication");
      this.mappings.put("advancements.husbandry.break_diamond_hoe.description", "Completely use up a diamond hoe, and then reevaluate your life choices");
      this.mappings.put("biome.minecraft.nether", "Nether");
   }

   public void processText(JsonElement var1) {
      amd.a();
      super.processText(var1);
      if(var1 != null && var1.isJsonObject()) {
         JsonObject var3 = var1.getAsJsonObject();
         JsonObject var4 = var3.getAsJsonObject("score");
         if(var4 != null && !var3.has("text")) {
            JsonPrimitive var5 = var4.getAsJsonPrimitive("value");
            if(var5 != null) {
               var3.remove("score");
               var3.add("text", var5);
            }

         }
      }
   }

   protected void handleTranslate(JsonObject var1, String var2) {
      String var3 = (String)this.mappings.get(var2);
      var1.addProperty("translate", var3);
   }
}
