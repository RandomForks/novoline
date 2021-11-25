package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.a66;
import net.a9a;
import viaversion.viaversion.api.protocol.Protocol;

public class ScoreboardPackets {
   public static void register(Protocol var0) {
      var0.c(a66.PLAY, 56, 61);
      var0.c(a66.PLAY, 63, 59);
      var0.b(a66.PLAY, 65, 62, new a9a());
      var0.c(a66.PLAY, 66, 60);
   }
}
