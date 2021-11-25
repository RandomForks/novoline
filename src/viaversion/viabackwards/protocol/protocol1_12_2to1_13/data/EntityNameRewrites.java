package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.HashMap;
import java.util.Map;
import net.aci;

public class EntityNameRewrites {
   private static final Map ENTITY_NAMES = new HashMap();

   private static void reg(String var0, String var1) {
      ENTITY_NAMES.put("minecraft:" + var1, "minecraft:" + var0);
   }

   public static String rewrite(String var0) {
      aci.b();
      String var2 = (String)ENTITY_NAMES.get(var0);
      if(var2 != null) {
         return var2;
      } else {
         var2 = (String)ENTITY_NAMES.get("minecraft:" + var0);
         return var2 != null?var2:var0;
      }
   }

   static {
      reg("commandblock_minecart", "command_block_minecart");
      reg("ender_crystal", "end_crystal");
      reg("evocation_fangs", "evoker_fangs");
      reg("evocation_illager", "evoker");
      reg("eye_of_ender_signal", "eye_of_ender");
      reg("fireworks_rocket", "firework_rocket");
      reg("illusion_illager", "illusioner");
      reg("snowman", "snow_golem");
      reg("villager_golem", "iron_golem");
      reg("vindication_illager", "vindicator");
      reg("xp_bottle", "experience_bottle");
      reg("xp_orb", "experience_orb");
   }
}
