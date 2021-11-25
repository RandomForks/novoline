package viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import io.netty.buffer.ByteBuf;
import net.acE;
import net.ahY;
import net.aqw;
import net.ay_;
import viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.ShoulderTracker;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_12$4 extends acE {
   final aqw c;

   EntityPackets1_12$4(aqw var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.INT);
      this.a(aqw.a(this.c, (EntityType)ahY.PLAYER, (Type)Type.INT));
      this.a(aqw.a(this.c, 1));
      this.a(EntityPackets1_12$4::lambda$registerMap$0);
      this.a(EntityPackets1_12$4::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      PacketWrapper var1 = new PacketWrapper(7, (ByteBuf)null, var0.user());
      var1.write(Type.VAR_INT, Integer.valueOf(1));
      var1.write(Type.STRING, "achievement.openInventory");
      var1.write(Type.VAR_INT, Integer.valueOf(1));
      var1.send(ay_.class);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      ShoulderTracker var1 = (ShoulderTracker)var0.user().b(ShoulderTracker.class);
      var1.setEntityId(((Integer)var0.get(Type.INT, 0)).intValue());
   }
}
