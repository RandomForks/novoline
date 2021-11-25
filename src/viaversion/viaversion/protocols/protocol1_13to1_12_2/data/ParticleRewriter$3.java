package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import net.BS;
import net.Gh;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.ParticleRewriter$ParticleDataHandler;

final class ParticleRewriter$3 implements ParticleRewriter$ParticleDataHandler {
   public Gh a(Gh var1, Integer[] var2) {
      int var3 = var2[0].intValue();
      int var4 = (var3 & 4095) << 4 | var3 >> 12 & 15;
      int var5 = BS.a(var4);
      var1.d().add(new Particle$ParticleData(Type.VAR_INT, Integer.valueOf(var5)));
      return var1;
   }
}
