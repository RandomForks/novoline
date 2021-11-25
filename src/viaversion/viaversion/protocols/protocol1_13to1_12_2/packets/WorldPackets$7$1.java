package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aWr;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;

class WorldPackets$7$1 implements PacketHandler {
   final aWr a;

   WorldPackets$7$1(aWr var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.passthrough(Type.INT)).intValue();
      int var3 = ((Integer)var1.passthrough(Type.INT)).intValue();
      ConnectionData.d.unloadChunk(var1.user(), var2, var3);
   }
}
