package viaversion.viaversion.protocols.base;

import java.util.UUID;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.base.BaseProtocol1_7;

public class BaseProtocol1_16 extends BaseProtocol1_7 {
   protected UUID passthroughLoginUUID(PacketWrapper var1) throws Exception {
      return (UUID)var1.passthrough(Type.UUID_INT_ARRAY);
   }
}
