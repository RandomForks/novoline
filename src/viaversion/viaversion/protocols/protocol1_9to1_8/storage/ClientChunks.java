package viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import net.aIa;
import net.cA;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;

public class ClientChunks extends cA {
   private final Set loadedChunks = Sets.newConcurrentHashSet();
   private final Set bulkChunks = Sets.newConcurrentHashSet();

   public ClientChunks(UserConnection var1) {
      super(var1);
   }

   public static long toLong(int var0, int var1) {
      return ((long)var0 << 32) + (long)var1 - -2147483648L;
   }

   public List transformMapChunkBulk(Object var1) throws Exception {
      return ((aIa)Via.getManager().f().b(aIa.class)).a(var1, this);
   }

   public Set getLoadedChunks() {
      return this.loadedChunks;
   }

   public Set getBulkChunks() {
      return this.bulkChunks;
   }
}
