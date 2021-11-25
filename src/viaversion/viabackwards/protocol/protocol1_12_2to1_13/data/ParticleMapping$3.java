package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.List;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.ParticleMapping$ParticleHandler;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;

final class ParticleMapping$3 implements ParticleMapping$ParticleHandler {
   public int[] a(ayk var1, PacketWrapper var2) throws Exception {
      return this.a(var1, (Item)var2.read(Type.FLAT_ITEM));
   }

   public int[] a(ayk var1, List var2) {
      return this.a(var1, (Item)((Particle$ParticleData)var2.get(0)).getValue());
   }

   private int[] a(ayk var1, Item var2) {
      Item var3 = var1.a().a(var2);
      return new int[]{var3.getIdentifier(), var3.getData()};
   }
}
