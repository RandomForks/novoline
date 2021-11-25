package viaversion.viafabric.platform;

import net.acE;
import net.bgY;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.platform.ViaConnectionManager;

public class VRConnectionManager extends ViaConnectionManager {
   public boolean isFrontEnd(UserConnection var1) {
      acE[] var2 = bgY.b();
      return !(var1 instanceof bgY);
   }
}
