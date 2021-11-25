package viaversion.viaversion.protocols.protocol1_9to1_8;

import net.Cw;
import net.aRY;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.base.ProtocolInfo;
import viaversion.viaversion.protocols.protocol1_9to1_8.providers.MovementTransmitterProvider;
import viaversion.viaversion.protocols.protocol1_9to1_8.storage.MovementTracker;

public class ViaIdleThread implements Runnable {
   public void run() {
      Cw.a();

      for(UserConnection var3 : Via.getManager().getConnections()) {
         ProtocolInfo var4 = var3.getProtocolInfo();
         if(var4 != null && var4.getPipeline().contains(aRY.class)) {
            MovementTracker var5 = (MovementTracker)var3.b(MovementTracker.class);
            if(var5 != null) {
               long var6 = var5.getNextIdlePacket();
               if(var6 <= System.currentTimeMillis() && var3.getChannel().isOpen()) {
                  ((MovementTransmitterProvider)Via.getManager().f().b(MovementTransmitterProvider.class)).sendPlayer(var3);
               }
               break;
            }
         }
      }

   }
}
