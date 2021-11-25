package viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.WorldPackets;

final class WorldPackets$3 extends acE {
   public void registerMap() {
      this.a(WorldPackets$3::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Position var1 = (Position)var0.passthrough(Type.POSITION1_14);
      short var2 = ((Short)var0.passthrough(Type.UNSIGNED_BYTE)).shortValue();
      CompoundTag var3 = (CompoundTag)var0.passthrough(Type.NBT);
      WorldPackets.access$000(var3);
   }
}
