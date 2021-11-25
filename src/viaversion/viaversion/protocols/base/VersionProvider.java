package viaversion.viaversion.protocols.base;

import net.aqQ;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ProtocolRegistry;

public class VersionProvider implements aqQ {
   public int getServerProtocol(UserConnection var1) throws Exception {
      return ProtocolRegistry.SERVER_PROTOCOL;
   }
}
