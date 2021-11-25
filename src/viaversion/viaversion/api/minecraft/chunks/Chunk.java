package viaversion.viaversion.api.minecraft.chunks;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import java.util.List;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;

public interface Chunk {
   int getX();

   int getZ();

   boolean isBiomeData();

   boolean isFullChunk();

   /** @deprecated */
   @Deprecated
   default boolean isGroundUp() {
      return this.isFullChunk();
   }

   boolean isIgnoreOldLightData();

   void setIgnoreOldLightData(boolean var1);

   int getBitmask();

   ChunkSection[] getSections();

   int[] getBiomeData();

   void setBiomeData(int[] var1);

   CompoundTag getHeightMap();

   void setHeightMap(CompoundTag var1);

   List getBlockEntities();
}
