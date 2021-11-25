package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import net.aW2;
import net.aWR;
import net.aWx;
import net.ahW;
import net.q1;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$1;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$4;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$6;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$7;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets$8;

public class PlayerPackets {
   public static void register(Protocol var0) {
      var0.a((ClientboundPacketType)q1.OPEN_SIGN_EDITOR, new PlayerPackets$1());
      var0.a((ServerboundPacketType)ahW.QUERY_BLOCK_NBT, new PlayerPackets$2());
      var0.a((ServerboundPacketType)ahW.EDIT_BOOK, new aWR());
      var0.a((ServerboundPacketType)ahW.PLAYER_DIGGING, new PlayerPackets$4());
      var0.a((ServerboundPacketType)ahW.RECIPE_BOOK_DATA, new aW2());
      var0.a((ServerboundPacketType)ahW.UPDATE_COMMAND_BLOCK, new PlayerPackets$6());
      var0.a((ServerboundPacketType)ahW.UPDATE_STRUCTURE_BLOCK, new PlayerPackets$7());
      var0.a((ServerboundPacketType)ahW.UPDATE_SIGN, new PlayerPackets$8());
      var0.a((ServerboundPacketType)ahW.PLAYER_BLOCK_PLACEMENT, new aWx());
   }
}
