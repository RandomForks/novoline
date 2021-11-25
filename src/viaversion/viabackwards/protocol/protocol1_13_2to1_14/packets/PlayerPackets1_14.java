package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.ao4;
import net.aob;
import net.aqu;
import net.awj;
import net.uN;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.Protocol1_13_2To1_14;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$1;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$2;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$3;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$4;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$6;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$7;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14$8;

public class PlayerPackets1_14 extends aqu {
   public PlayerPackets1_14(Protocol1_13_2To1_14 var1) {
      super(var1);
   }

   protected void registerPackets() {
      ((Protocol1_13_2To1_14)this.c).a(awj.SERVER_DIFFICULTY, new PlayerPackets1_14$1(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.OPEN_SIGN_EDITOR, new PlayerPackets1_14$2(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.QUERY_BLOCK_NBT, new PlayerPackets1_14$3(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.PLAYER_DIGGING, new PlayerPackets1_14$4(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.RECIPE_BOOK_DATA, new aob(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.UPDATE_COMMAND_BLOCK, new PlayerPackets1_14$6(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.UPDATE_STRUCTURE_BLOCK, new PlayerPackets1_14$7(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.UPDATE_SIGN, new PlayerPackets1_14$8(this));
      ((Protocol1_13_2To1_14)this.c).a(uN.PLAYER_BLOCK_PLACEMENT, new ao4(this));
   }
}
