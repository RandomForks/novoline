package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import net.cB;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class InventoryPackets$6 extends acE {
   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(InventoryPackets$6::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      short var1 = ((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue();
      ((cB)var0.user().b(cB.class)).a(var1);
   }
}
