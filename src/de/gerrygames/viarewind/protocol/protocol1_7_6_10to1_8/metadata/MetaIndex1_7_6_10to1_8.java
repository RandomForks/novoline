package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata;

import com.viaversion.viaversion.util.Pair;
import de.gerrygames.viarewind.protocol.protocol1_8to1_7_6_10.metadata.MetaIndex1_8to1_7_6_10;
import java.util.HashMap;
import java.util.Optional;
import net.Dk;
import net.t4;

public class MetaIndex1_7_6_10to1_8 {
   private static final HashMap metadataRewrites = new HashMap();

   private static Optional b(t4 var0, int var1) {
      Dk.b();
      Pair var3 = new Pair(var0, Integer.valueOf(var1));
      return metadataRewrites.containsKey(var3)?Optional.of(metadataRewrites.get(var3)):Optional.empty();
   }

   public static MetaIndex1_8to1_7_6_10 a(t4 var0, int var1) {
      String[] var2 = Dk.b();
      Optional var4 = b(var0, var1);
      if(var4.isPresent()) {
         return (MetaIndex1_8to1_7_6_10)var4.get();
      } else {
         t4 var3 = var0.a();
         return null;
      }
   }

   static {
      for(MetaIndex1_8to1_7_6_10 var3 : MetaIndex1_8to1_7_6_10.values()) {
         metadataRewrites.put(new Pair(var3.b(), Integer.valueOf(var3.getNewIndex())), var3);
      }

   }
}
