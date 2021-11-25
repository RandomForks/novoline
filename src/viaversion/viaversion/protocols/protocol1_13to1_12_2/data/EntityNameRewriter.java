package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import java.util.HashMap;
import java.util.Map;
import net.amt;

public class EntityNameRewriter {
   private static final Map entityNames = new HashMap();

   private static void reg(String var0, String var1) {
      entityNames.put("minecraft:" + var0, "minecraft:" + var1);
   }

   public static String rewrite(String var0) {
      amt.c();
      String var2 = (String)entityNames.get(var0);
      if(var2 != null) {
         return var2;
      } else {
         var2 = (String)entityNames.get("minecraft:" + var0);
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
