package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.List;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.ParticleMapping$ParticleHandler;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;

final class ParticleMapping$1 implements ParticleMapping$ParticleHandler {
   public int[] a(ayk var1, PacketWrapper var2) throws Exception {
      return this.rewrite(((Integer)var2.read(Type.VAR_INT)).intValue());
   }

   public int[] a(ayk var1, List var2) {
      return this.rewrite(((Integer)((Particle$ParticleData)var2.get(0)).getValue()).intValue());
   }

   private int[] rewrite(int var1) {
      int var2 = ayk.k.getNewBlockStateId(var1);
      int var3 = var2 >> 4;
      int var4 = var2 & 15;
      return new int[]{var3 + (var4 << 12)};
   }

   public boolean isBlockHandler() {
      return true;
   }
}
