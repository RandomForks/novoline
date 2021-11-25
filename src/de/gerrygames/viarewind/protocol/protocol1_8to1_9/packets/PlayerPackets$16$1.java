package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.utils.PacketUtil;
import java.util.TimerTask;
import net.a9e;
import net.aRE;

class PlayerPackets$16$1 extends TimerTask {
   final PacketWrapperImpl b;
   final a9e a;

   PlayerPackets$16$1(a9e var1, PacketWrapperImpl var2) {
      this.a = var1;
      this.b = var2;
   }

   public void run() {
      PacketUtil.a(this.b, aRE.class);
   }
}
