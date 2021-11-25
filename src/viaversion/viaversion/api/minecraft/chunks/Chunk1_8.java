package viaversion.viaversion.api.minecraft.chunks;

import java.util.ArrayList;
import java.util.List;
import net.acE;
import viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;

public class Chunk1_8 extends BaseChunk {
   private boolean unloadPacket;

   public Chunk1_8(int var1, int var2, boolean var3, int var4, ChunkSection[] var5, int[] var6, List var7) {
      super(var1, var2, var3, false, var4, var5, var6, var7);
   }

   public Chunk1_8(int var1, int var2) {
      this(var1, var2, true, 0, new ChunkSection[16], (int[])null, new ArrayList());
      this.unloadPacket = true;
   }

   public boolean e() {
      acE[] var1 = ChunkSection.b();
      return this.biomeData != null && this.fullChunk;
   }

   public boolean isUnloadPacket() {
      return this.unloadPacket;
   }
}
