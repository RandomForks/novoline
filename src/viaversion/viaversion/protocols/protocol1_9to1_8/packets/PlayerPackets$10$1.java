package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aMV;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.storage.ClientChunks;

class PlayerPackets$10$1 implements PacketHandler {
   final aMV a;

   PlayerPackets$10$1(aMV var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      float var2 = ((Float)var1.get(Type.FLOAT, 0)).floatValue();
      if(var2 <= 0.0F) {
         ClientChunks var3 = (ClientChunks)var1.user().b(ClientChunks.class);
         var3.getBulkChunks().clear();
         var3.getLoadedChunks().clear();
      }

   }
}
