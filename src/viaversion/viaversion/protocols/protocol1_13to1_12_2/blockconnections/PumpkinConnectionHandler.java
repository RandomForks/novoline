package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.AbstractStempConnectionHandler;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData$ConnectorInitAction;

public class PumpkinConnectionHandler extends AbstractStempConnectionHandler {
   static ConnectionData$ConnectorInitAction init() {
      return (new PumpkinConnectionHandler("minecraft:pumpkin_stem[age=7]")).getInitAction("minecraft:carved_pumpkin", "minecraft:attached_pumpkin_stem");
   }

   public PumpkinConnectionHandler(String var1) {
      super(var1);
   }
}
