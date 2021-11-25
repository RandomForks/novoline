package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import net.Gh;
import net.amt;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.ParticleRewriter$ParticleDataHandler;

class ParticleRewriter$NewParticle {
   private final int id;
   private final ParticleRewriter$ParticleDataHandler handler;

   public ParticleRewriter$NewParticle(int var1, ParticleRewriter$ParticleDataHandler var2) {
      this.id = var1;
      this.handler = var2;
   }

   public Gh a(Gh var1, Integer[] var2) {
      boolean var3 = amt.c();
      return this.handler != null?this.handler.a(var1, var2):var1;
   }

   public int getId() {
      return this.id;
   }

   public ParticleRewriter$ParticleDataHandler getHandler() {
      return this.handler;
   }
}
