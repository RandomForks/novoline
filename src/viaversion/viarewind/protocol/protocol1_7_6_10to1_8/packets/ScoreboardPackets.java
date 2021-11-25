package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.a66;
import net.aD2;
import net.aDO;
import net.aDY;
import net.aDz;
import viaversion.viaversion.api.protocol.Protocol;

public class ScoreboardPackets {
   public static void register(Protocol var0) {
      var0.b(a66.PLAY, 59, 59, new aDY());
      var0.b(a66.PLAY, 60, 60, new aD2());
      var0.b(a66.PLAY, 61, 61, new aDz());
      var0.b(a66.PLAY, 62, 62, new aDO());
   }
}
