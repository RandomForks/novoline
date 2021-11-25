package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.NamedSoundRewriter;

public class NamedSoundMapping {
   private static final Map SOUNDS = new HashMap();

   public static String getOldId(String var0) {
      return (String)SOUNDS.get(var0);
   }

   private static void lambda$static$0(String var0, String var1) {
      String var10000 = (String)SOUNDS.put(var1, var0);
   }

   static {
      NamedSoundRewriter.oldToNew.forEach(NamedSoundMapping::lambda$static$0);
   }
}
