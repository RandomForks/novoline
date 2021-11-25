package de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.MetaIndex;
import com.viaversion.viaversion.util.Pair;
import java.util.HashMap;
import java.util.Optional;
import net.arP;
import net.t4;

public class MetaIndex1_8to1_9 {
   private static final HashMap metadataRewrites = new HashMap();

   private static Optional b(t4 var0, int var1) {
      arP.a();
      Pair var3 = new Pair(var0, Integer.valueOf(var1));
      return metadataRewrites.containsKey(var3)?Optional.of(metadataRewrites.get(var3)):Optional.empty();
   }

   public static MetaIndex a(t4 var0, int var1) {
      boolean var2 = arP.b();
      Optional var4 = b(var0, var1);
      if(var4.isPresent()) {
         return (MetaIndex)var4.get();
      } else {
         t4 var3 = var0.a();
         return null;
      }
   }

   static {
      for(MetaIndex var3 : MetaIndex.values()) {
         metadataRewrites.put(new Pair(var3.c(), Integer.valueOf(var3.getNewIndex())), var3);
      }

   }
}
