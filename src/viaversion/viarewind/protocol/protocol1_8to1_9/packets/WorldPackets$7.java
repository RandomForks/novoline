package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.acE;
import net.cT;
import viaversion.viarewind.protocol.protocol1_8to1_9.types.Chunk1_8Type;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.chunks.Chunk1_8;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class WorldPackets$7 extends acE {
   public void registerMap() {
      this.a(WorldPackets$7::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.read(Type.INT)).intValue();
      int var2 = ((Integer)var0.read(Type.INT)).intValue();
      cT var3 = (cT)var0.user().b(cT.class);
      var0.write(new Chunk1_8Type(var3), new Chunk1_8(var1, var2));
   }
}
