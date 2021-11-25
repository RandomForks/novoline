package viaversion.viaversion.api.minecraft.chunks;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.minecraft.chunks.NibbleArray;

public class ChunkSection {
   public static final int SIZE = 4096;
   public static final int LIGHT_LENGTH = 2048;
   private final IntList palette;
   private final Int2IntMap inversePalette;
   private final int[] blocks = new int[4096];
   private NibbleArray blockLight;
   private NibbleArray skyLight;
   private int nonAirBlocksCount;
   private static acE[] f;

   public ChunkSection() {
      this.blockLight = new NibbleArray(4096);
      this.palette = new IntArrayList();
      this.inversePalette = new Int2IntOpenHashMap();
      this.inversePalette.defaultReturnValue(-1);
   }

   public ChunkSection(int var1) {
      b();
      this.blockLight = new NibbleArray(4096);
      this.palette = new IntArrayList(var1);
      this.inversePalette = new Int2IntOpenHashMap(var1);
      this.inversePalette.defaultReturnValue(-1);
      if(acE.b() == null) {
         b(new acE[3]);
      }

   }

   public void setBlock(int var1, int var2, int var3, int var4, int var5) {
      this.setFlatBlock(index(var1, var2, var3), var4 << 4 | var5 & 15);
   }

   public void setFlatBlock(int var1, int var2, int var3, int var4) {
      this.setFlatBlock(index(var1, var2, var3), var4);
   }

   public int getBlockId(int var1, int var2, int var3) {
      return this.getFlatBlock(var1, var2, var3) >> 4;
   }

   public int getBlockData(int var1, int var2, int var3) {
      return this.getFlatBlock(var1, var2, var3) & 15;
   }

   public int getFlatBlock(int var1, int var2, int var3) {
      int var4 = this.blocks[index(var1, var2, var3)];
      return this.palette.getInt(var4);
   }

   public int getFlatBlock(int var1) {
      int var2 = this.blocks[var1];
      return this.palette.getInt(var2);
   }

   public void setBlock(int var1, int var2, int var3) {
      this.setFlatBlock(var1, var2 << 4 | var3 & 15);
   }

   public void setPaletteIndex(int var1, int var2) {
      this.blocks[var1] = var2;
   }

   public int getPaletteIndex(int var1) {
      return this.blocks[var1];
   }

   public int getPaletteSize() {
      return this.palette.size();
   }

   public int getPaletteEntry(int var1) {
      acE[] var2 = b();
      if(var1 >= 0 && var1 < this.palette.size()) {
         return this.palette.getInt(var1);
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void setPaletteEntry(int var1, int var2) {
      acE[] var3 = b();
      if(var1 >= 0 && var1 < this.palette.size()) {
         int var4 = this.palette.set(var1, var2);
         if(var4 != var2) {
            this.inversePalette.put(var2, var1);
            if(this.inversePalette.get(var4) == var1) {
               this.inversePalette.remove(var4);
               int var5 = 0;
               if(var5 < this.palette.size()) {
                  if(this.palette.getInt(var5) == var4) {
                     this.inversePalette.put(var4, var5);
                  }

                  ++var5;
               }
            }

         }
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void replacePaletteEntry(int var1, int var2) {
      b();
      int var4 = this.inversePalette.remove(var1);
      if(var4 != -1) {
         this.inversePalette.put(var2, var4);
         int var5 = 0;
         if(var5 < this.palette.size()) {
            if(this.palette.getInt(var5) == var1) {
               this.palette.set(var5, var2);
            }

            ++var5;
         }

      }
   }

   public void addPaletteEntry(int var1) {
      this.inversePalette.put(var1, this.palette.size());
      this.palette.add(var1);
   }

   public void clearPalette() {
      this.palette.clear();
      this.inversePalette.clear();
   }

   public void setFlatBlock(int var1, int var2) {
      b();
      int var4 = this.inversePalette.get(var2);
      if(var4 == -1) {
         var4 = this.palette.size();
         this.palette.add(var2);
         this.inversePalette.put(var2, var4);
      }

      this.blocks[var1] = var4;
   }

   public void setBlockLight(@Nullable byte[] var1) {
      acE[] var2 = b();
      if(var1.length != 2048) {
         throw new IllegalArgumentException("Data length != 2048");
      } else {
         if(this.blockLight == null) {
            this.blockLight = new NibbleArray(var1);
         }

         this.blockLight.setHandle(var1);
      }
   }

   public void setSkyLight(@Nullable byte[] var1) {
      acE[] var2 = b();
      if(var1.length != 2048) {
         throw new IllegalArgumentException("Data length != 2048");
      } else {
         if(this.skyLight == null) {
            this.skyLight = new NibbleArray(var1);
         }

         this.skyLight.setHandle(var1);
      }
   }

   @Nullable
   public byte[] getBlockLight() {
      acE[] var1 = b();
      return this.blockLight == null?null:this.blockLight.getHandle();
   }

   @Nullable
   public NibbleArray getBlockLightNibbleArray() {
      return this.blockLight;
   }

   @Nullable
   public byte[] getSkyLight() {
      acE[] var1 = b();
      return this.skyLight == null?null:this.skyLight.getHandle();
   }

   @Nullable
   public NibbleArray getSkyLightNibbleArray() {
      return this.skyLight;
   }

   public void readBlockLight(ByteBuf var1) {
      acE[] var2 = b();
      if(this.blockLight == null) {
         this.blockLight = new NibbleArray(4096);
      }

      var1.readBytes(this.blockLight.getHandle());
   }

   public void readSkyLight(ByteBuf var1) {
      acE[] var2 = b();
      if(this.skyLight == null) {
         this.skyLight = new NibbleArray(4096);
      }

      var1.readBytes(this.skyLight.getHandle());
   }

   public static int index(int var0, int var1, int var2) {
      return var1 << 8 | var2 << 4 | var0;
   }

   public void writeBlockLight(ByteBuf var1) {
      var1.writeBytes(this.blockLight.getHandle());
   }

   public void writeSkyLight(ByteBuf var1) {
      var1.writeBytes(this.skyLight.getHandle());
   }

   public boolean hasSkyLight() {
      return this.skyLight != null;
   }

   public boolean hasBlockLight() {
      return this.blockLight != null;
   }

   public int getNonAirBlocksCount() {
      return this.nonAirBlocksCount;
   }

   public void setNonAirBlocksCount(int var1) {
      this.nonAirBlocksCount = var1;
   }

   public static void b(acE[] var0) {
      f = var0;
   }

   public static acE[] b() {
      return f;
   }

   private static IndexOutOfBoundsException a(IndexOutOfBoundsException var0) {
      return var0;
   }

   static {
      b(new acE[4]);
   }
}
