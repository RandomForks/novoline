package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.a66;
import net.a79;
import net.a7A;
import net.a7C;
import net.a7Q;
import net.a7V;
import net.a7W;
import net.a7o;
import viaversion.viarewind.protocol.protocol1_8to1_9.packets.WorldPackets$11;
import viaversion.viarewind.protocol.protocol1_8to1_9.packets.WorldPackets$3;
import viaversion.viarewind.protocol.protocol1_8to1_9.packets.WorldPackets$4;
import viaversion.viarewind.protocol.protocol1_8to1_9.packets.WorldPackets$6;
import viaversion.viarewind.protocol.protocol1_8to1_9.packets.WorldPackets$7;
import viaversion.viaversion.api.protocol.Protocol;

public class WorldPackets {
   public static void register(Protocol var0) {
      var0.c(a66.PLAY, 8, 37);
      var0.b(a66.PLAY, 9, 53, new a7A());
      var0.b(a66.PLAY, 10, 36, new a7o());
      var0.b(a66.PLAY, 11, 35, new WorldPackets$3());
      var0.c(a66.PLAY, 13, 65);
      var0.b(a66.PLAY, 16, 34, new WorldPackets$4());
      var0.b(a66.PLAY, 25, 41, new a79());
      var0.b(a66.PLAY, 28, 39, new WorldPackets$6());
      var0.b(a66.PLAY, 29, 33, new WorldPackets$7());
      var0.b(a66.PLAY, 32, 33, new a7W());
      var0.b(a66.PLAY, 33, 40, new a7V());
      var0.b(a66.PLAY, 34, 42, new a7Q());
      var0.b(a66.PLAY, 36, 52, new WorldPackets$11());
      var0.c(a66.PLAY, 44, 66);
      var0.c(a66.PLAY, 53, 68);
      var0.c(a66.PLAY, 68, 3);
      var0.c(a66.PLAY, 70, 51);
      var0.b(a66.PLAY, 71, 41, new a7C());
   }
}
