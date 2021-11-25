package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.a66;
import net.aD9;
import net.aDA;
import net.aDC;
import net.aDD;
import net.aDJ;
import net.aDg;
import net.aDn;
import net.acE;
import net.afz;
import net.an5;
import net.an_;
import net.ana;
import net.and;
import net.anj;
import net.anx;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.EntityPackets$15;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.EntityPackets$3;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.EntityPackets$4;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.EntityPackets$6;
import viaversion.viaversion.api.protocol.Protocol;

public class EntityPackets {
   public static void register(Protocol var0) {
      var0.b(a66.PLAY, 4, 4, new anx());
      var0.b(a66.PLAY, 10, 10, new aDA());
      var0.b(a66.PLAY, 13, 13, new EntityPackets$3());
      var0.b(a66.PLAY, 18, 18, new EntityPackets$4());
      int var10000 = afz.b();
      var0.b(a66.PLAY, 19, 19, new aDC());
      var0.b(a66.PLAY, 20, 20, new EntityPackets$6());
      var0.b(a66.PLAY, 21, 21, new aDn());
      var0.b(a66.PLAY, 22, 22, new aDD());
      var0.b(a66.PLAY, 23, 23, new aD9());
      var0.b(a66.PLAY, 24, 24, new and());
      int var1 = var10000;
      var0.b(a66.PLAY, 25, 25, new ana());
      var0.b(a66.PLAY, 27, 27, new an_());
      var0.b(a66.PLAY, 28, 28, new anj());
      var0.b(a66.PLAY, 29, 29, new an5());
      var0.b(a66.PLAY, 30, 30, new EntityPackets$15());
      var0.b(a66.PLAY, 32, 32, new aDg());
      var0.b(a66.PLAY, 73, -1, new aDJ());
      if(acE.b() == null) {
         ++var1;
         afz.b(var1);
      }

   }
}
