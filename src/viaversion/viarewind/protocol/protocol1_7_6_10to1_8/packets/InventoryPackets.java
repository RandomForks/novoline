package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.a66;
import net.aD7;
import net.aDH;
import net.aDV;
import net.aDW;
import net.aDf;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.InventoryPackets$2;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.InventoryPackets$5;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.InventoryPackets$6;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets.InventoryPackets$9;
import viaversion.viaversion.api.protocol.Protocol;

public class InventoryPackets {
   public static void register(Protocol var0) {
      var0.b(a66.PLAY, 45, 45, new aD7());
      var0.b(a66.PLAY, 46, 46, new InventoryPackets$2());
      var0.b(a66.PLAY, 47, 47, new aDW());
      var0.b(a66.PLAY, 48, 48, new aDV());
      var0.b(a66.PLAY, 49, 49, new InventoryPackets$5());
      var0.a(a66.PLAY, 13, 13, new InventoryPackets$6());
      var0.a(a66.PLAY, 14, 14, new aDH());
      var0.a(a66.PLAY, 15, 15, new aDf());
      var0.a(a66.PLAY, 16, 16, new InventoryPackets$9());
   }
}
