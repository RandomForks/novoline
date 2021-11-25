package viaversion.viaversion.protocols.protocol1_9to1_8;

import net.Cw;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.storage.MovementTracker;

public class PlayerMovementMapper implements PacketHandler {
   public void handle(PacketWrapper var1) throws Exception {
      Cw.b();
      MovementTracker var3 = (MovementTracker)var1.user().b(MovementTracker.class);
      var3.incrementIdlePacket();
      if(var1.is(Type.BOOLEAN, 0)) {
         var3.setGround(((Boolean)var1.get(Type.BOOLEAN, 0)).booleanValue());
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
