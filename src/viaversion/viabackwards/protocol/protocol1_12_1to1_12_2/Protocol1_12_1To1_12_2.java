package viaversion.viabackwards.protocol.protocol1_12_1to1_12_2;

import net.aCM;
import net.aCV;
import net.ayd;
import net.azW;
import net.cA;
import net.cD;
import net.r;
import viaversion.viaversion.api.data.UserConnection;

public class Protocol1_12_1To1_12_2 extends ayd {
   public Protocol1_12_1To1_12_2() {
      super(azW.class, azW.class, r.class, r.class);
   }

   protected void registerPackets() {
      this.a(azW.KEEP_ALIVE, new aCV(this));
      this.a(r.KEEP_ALIVE, new aCM(this));
   }

   public void init(UserConnection var1) {
      var1.a((cA)(new cD(var1)));
   }
}
