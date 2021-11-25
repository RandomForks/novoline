package viaversion.viaversion.protocols.protocol1_12_1to1_12;

import net.aEb;
import net.azW;
import net.lV;
import net.r;
import viaversion.viaversion.api.protocol.Protocol;

public class Protocol1_12_1To1_12 extends Protocol {
   public Protocol1_12_1To1_12() {
      super(lV.class, azW.class, aEb.class, r.class);
   }

   protected void registerPackets() {
      this.cancelIncoming(r.CRAFT_RECIPE_REQUEST);
   }
}
