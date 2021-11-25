package viaversion.viaversion.api.protocol;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.PacketHandler;

class Protocol$2 extends acE {
   final Protocol this$0;

   Protocol$2(Protocol var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(PacketWrapper::cancel);
   }
}
