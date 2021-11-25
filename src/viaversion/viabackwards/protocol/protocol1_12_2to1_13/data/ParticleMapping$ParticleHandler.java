package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.List;
import net.ayk;
import viaversion.viaversion.api.PacketWrapper;

public interface ParticleMapping$ParticleHandler {
   int[] a(ayk var1, PacketWrapper var2) throws Exception;

   int[] a(ayk var1, List var2);

   default boolean isBlockHandler() {
      return false;
   }
}
