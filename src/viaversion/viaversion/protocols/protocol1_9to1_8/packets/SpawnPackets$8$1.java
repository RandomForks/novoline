package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aM4;
import net.aXe;
import net.cq;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class SpawnPackets$8$1 implements PacketHandler {
   final aM4 a;

   SpawnPackets$8$1(aM4 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      aXe.b();
      int[] var3 = (int[])var1.get(Type.VAR_INT_ARRAY_PRIMITIVE, 0);
      int var5 = var3.length;
      int var6 = 0;
      if(var6 < var5) {
         int var7 = var3[var6];
         ((cq)var1.user().b(cq.class)).removeEntity(var7);
         ++var6;
      }

   }
}
