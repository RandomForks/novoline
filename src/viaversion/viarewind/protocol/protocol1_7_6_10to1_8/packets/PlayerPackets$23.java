package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$23 extends acE {
   public void registerMap() {
      this.a(Type.BYTE);
      this.a(PlayerPackets$23::lambda$registerMap$0);
      this.a(Type.BYTE);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.read(Type.INT)).intValue();
      short var2 = ((Short)var0.read(Type.UNSIGNED_BYTE)).shortValue();
      int var3 = ((Integer)var0.read(Type.INT)).intValue();
      var0.write(Type.POSITION, new Position(var1, var2, var3));
   }
}
