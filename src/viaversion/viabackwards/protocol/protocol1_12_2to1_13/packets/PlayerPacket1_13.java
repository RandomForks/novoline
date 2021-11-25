package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.a66;
import net.aC4;
import net.aC6;
import net.aCG;
import net.aCI;
import net.aCT;
import net.aCX;
import net.aCe;
import net.aCh;
import net.aCq;
import net.aqu;
import net.ayd;
import net.ayk;
import net.q1;
import net.r;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.PlayerPacket1_13$1;

public class PlayerPacket1_13 extends aqu {
   public PlayerPacket1_13(ayk var1) {
      super(var1);
   }

   protected void registerPackets() {
      ((ayk)this.c).b(a66.LOGIN, 4, -1, new PlayerPacket1_13$1(this));
      ((ayk)this.c).a(q1.PLUGIN_MESSAGE, new aCq(this));
      ((ayk)this.c).a(q1.SPAWN_PARTICLE, new aCI(this));
      ((ayk)this.c).a(q1.PLAYER_INFO, new aC6(this));
      ((ayk)this.c).a(q1.SCOREBOARD_OBJECTIVE, new aCe(this));
      ((ayk)this.c).a(q1.TEAMS, new aCX(this));
      ((ayk)this.c).a(q1.TAB_COMPLETE, new aCG(this));
      ((ayk)this.c).a(r.TAB_COMPLETE, new aCh(this));
      ((ayk)this.c).a(r.PLUGIN_MESSAGE, new aCT(this));
      ((ayk)this.c).a(q1.STATISTICS, new aC4(this));
   }

   static ayd a(PlayerPacket1_13 var0) {
      return var0.c;
   }

   static ayd b(PlayerPacket1_13 var0) {
      return var0.c;
   }

   static ayd c(PlayerPacket1_13 var0) {
      return var0.c;
   }
}
