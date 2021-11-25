package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import java.util.TimerTask;
import net.a9e;
import net.aRE;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;

class PlayerPackets$17$1 extends TimerTask {
   final PacketWrapper val$delayedPacket;
   final a9e a;

   PlayerPackets$17$1(a9e var1, PacketWrapper var2) {
      this.a = var1;
      this.val$delayedPacket = var2;
   }

   public void run() {
      PacketUtil.sendToServer(this.val$delayedPacket, aRE.class);
   }
}
