package viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import net.aqQ;
import net.cq;
import viaversion.viaversion.api.data.UserConnection;

public class EntityIdProvider implements aqQ {
   public int getEntityId(UserConnection var1) throws Exception {
      return ((cq)var1.b(cq.class)).getClientEntityId();
   }
}
