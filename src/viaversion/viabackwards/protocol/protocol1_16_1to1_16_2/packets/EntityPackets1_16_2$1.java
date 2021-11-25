package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import net.acE;
import net.aqG;
import net.awD;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.EntityPackets1_16_2;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.EntityPackets;

class EntityPackets1_16_2$1 extends acE {
   final EntityPackets1_16_2 this$0;

   EntityPackets1_16_2$1(EntityPackets1_16_2 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(EntityPackets1_16_2$1::lambda$registerMap$0);
      this.a(Type.BYTE);
      this.a(Type.STRING_ARRAY);
      this.a(this::lambda$registerMap$1);
      this.a(Type.STRING);
      this.a(Type.LONG);
      this.a(EntityPackets1_16_2$1::lambda$registerMap$2);
      this.a(EntityPackets1_16_2.access$000(this.this$0, awD.PLAYER, Type.INT));
   }

   private static void lambda$registerMap$2(PacketWrapper var0) throws Exception {
      int var1 = ((Integer)var0.read(Type.VAR_INT)).intValue();
      var0.write(Type.UNSIGNED_BYTE, Short.valueOf((short)Math.max(var1, 255)));
   }

   private void lambda$registerMap$1(PacketWrapper var1) throws Exception {
      var1.read(Type.NBT);
      var1.write(Type.NBT, EntityPackets.DIMENSIONS_TAG);
      CompoundTag var2 = (CompoundTag)var1.read(Type.NBT);
      var1.write(Type.STRING, EntityPackets1_16_2.access$100(this.this$0, var2));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      aqG.d();
      boolean var2 = ((Boolean)var0.read(Type.BOOLEAN)).booleanValue();
      short var3 = ((Short)var0.read(Type.UNSIGNED_BYTE)).shortValue();
      var3 = (short)(var3 | 8);
      var0.write(Type.UNSIGNED_BYTE, Short.valueOf(var3));
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
