package viaversion.viarewind.utils;

import java.util.UUID;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public class Utils {
   public static UUID getUUID(UserConnection var0) {
      return ((ProtocolInfo)var0.b(ProtocolInfo.class)).getUuid();
   }
}
