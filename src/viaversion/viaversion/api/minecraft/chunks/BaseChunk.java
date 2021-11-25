package viaversion.viaversion.api.minecraft.chunks;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import java.util.List;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;

public class BaseChunk implements Chunk {
   protected final int x;
   protected final int z;
   protected final boolean fullChunk;
   protected boolean ignoreOldLightData;
   protected final int bitmask;
   protected final ChunkSection[] sections;
   protected int[] biomeData;
   protected CompoundTag heightMap;
   protected final List blockEntities;

   public BaseChunk(int var1, int var2, boolean var3, boolean var4, int var5, ChunkSection[] var6, int[] var7, CompoundTag var8, List var9) {
      ChunkSection.b();
      super();
      this.x = var1;
      this.z = var2;
      this.fullChunk = var3;
      this.ignoreOldLightData = var4;
      this.bitmask = var5;
      this.sections = var6;
      this.biomeData = var7;
      this.heightMap = var8;
      this.blockEntities = var9;
   }

   public BaseChunk(int var1, int var2, boolean var3, boolean var4, int var5, ChunkSection[] var6, int[] var7, List var8) {
      this(var1, var2, var3, var4, var5, var6, var7, (CompoundTag)null, var8);
   }

   public boolean isBiomeData() {
      return this.biomeData != null;
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   public boolean isFullChunk() {
      return this.fullChunk;
   }

   public boolean isIgnoreOldLightData() {
      return this.ignoreOldLightData;
   }

   public void setIgnoreOldLightData(boolean var1) {
      this.ignoreOldLightData = var1;
   }

   public int getBitmask() {
      return this.bitmask;
   }

   public ChunkSection[] getSections() {
      return this.sections;
   }

   public int[] getBiomeData() {
      return this.biomeData;
   }

   public void setBiomeData(int[] var1) {
      this.biomeData = var1;
   }

   public CompoundTag getHeightMap() {
      return this.heightMap;
   }

   public void setHeightMap(CompoundTag var1) {
      this.heightMap = var1;
   }

   public List getBlockEntities() {
      return this.blockEntities;
   }
}
