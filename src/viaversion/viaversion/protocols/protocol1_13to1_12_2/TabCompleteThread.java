package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import net.q1;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.TabCompleteTracker;

public class TabCompleteThread implements Runnable {
   public void run() {
      q1.b();

      for(UserConnection var3 : Via.getManager().getConnections()) {
         if(var3.getProtocolInfo() != null) {
            if(var3.getProtocolInfo().getPipeline().contains(Protocol1_13To1_12_2.class) && var3.getChannel().isOpen()) {
               ((TabCompleteTracker)var3.b(TabCompleteTracker.class)).sendPacketToServer();
            }
            break;
         }
      }

   }
}
