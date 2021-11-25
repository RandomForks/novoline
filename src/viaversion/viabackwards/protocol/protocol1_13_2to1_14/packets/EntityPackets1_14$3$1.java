package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.aou;
import net.z8;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_14$3$1 implements PacketHandler {
   final aou a;

   EntityPackets1_14$3$1(aou var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      double var2 = (double)((Short)var1.get(Type.SHORT, 0)).shortValue() / 4096.0D;
      double var4 = (double)((Short)var1.get(Type.SHORT, 1)).shortValue() / 4096.0D;
      double var6 = (double)((Short)var1.get(Type.SHORT, 2)).shortValue() / 4096.0D;
      z8.a(EntityPackets1_14.access$000(this.a.c), var1, var2, var4, var6, false, true);
   }
}
