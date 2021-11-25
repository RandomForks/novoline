package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.items.ReplacementRegistry1_8to1_9;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$3 extends acE {
   public void registerMap() {
      this.a(Type.POSITION);
      this.a(Type.VAR_INT);
      this.a(WorldPackets$3::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.get(Type.VAR_INT, 0)).intValue();
      BlockState var2 = BlockState.rawToState(var1);
      var2 = ReplacementRegistry1_8to1_9.replace(var2);
      var0.set(Type.VAR_INT, 0, Integer.valueOf(BlockState.stateToRaw(var2)));
   }
}
