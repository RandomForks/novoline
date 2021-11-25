package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import net.Gh;
import net.amt;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.ParticleRewriter;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.ParticleRewriter$ParticleDataHandler;

final class ParticleRewriter$1 implements ParticleRewriter$ParticleDataHandler {
   public Gh a(Gh var1, Integer[] var2) {
      boolean var3 = amt.c();
      var1.d().add(new Particle$ParticleData(Type.FLOAT, Float.valueOf(ParticleRewriter.access$000()?1.0F:0.0F)));
      var1.d().add(new Particle$ParticleData(Type.FLOAT, Float.valueOf(0.0F)));
      var1.d().add(new Particle$ParticleData(Type.FLOAT, Float.valueOf(ParticleRewriter.access$000()?1.0F:0.0F)));
      var1.d().add(new Particle$ParticleData(Type.FLOAT, Float.valueOf(1.0F)));
      return var1;
   }
}
