package viaversion.viaversion.api.minecraft.chunks;

import java.util.Arrays;
import net.acE;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;

public class NibbleArray {
   private final byte[] handle;

   public NibbleArray(int var1) {
      ChunkSection.b();
      super();
      if(var1 != 0 && var1 % 2 == 0) {
         this.handle = new byte[var1 / 2];
      } else {
         throw new IllegalArgumentException("Length of nibble array must be a positive number dividable by 2!");
      }
   }

   public NibbleArray(byte[] var1) {
      ChunkSection.b();
      super();
      if(var1.length != 0 && var1.length % 2 == 0) {
         this.handle = var1;
      } else {
         throw new IllegalArgumentException("Length of nibble array must be a positive number dividable by 2!");
      }
   }

   public byte get(int var1, int var2, int var3) {
      return this.a(ChunkSection.index(var1, var2, var3));
   }

   public byte a(int var1) {
      ChunkSection.b();
      byte var3 = this.handle[var1 / 2];
      return var1 % 2 == 0?(byte)(var3 & 15):(byte)(var3 >> 4 & 15);
   }

   public void set(int var1, int var2, int var3, int var4) {
      this.a(ChunkSection.index(var1, var2, var3), var4);
   }

   public void a(int var1, int var2) {
      acE[] var3 = ChunkSection.b();
      if(var1 % 2 == 0) {
         var1 /= 2;
         this.handle[var1] = (byte)(this.handle[var1] & 240 | var2 & 15);
      }

      var1 = var1 / 2;
      this.handle[var1] = (byte)(this.handle[var1] & 15 | (var2 & 15) << 4);
   }

   public int size() {
      return this.handle.length * 2;
   }

   public int actualSize() {
      return this.handle.length;
   }

   public void fill(byte var1) {
      var1 = (byte)(var1 & 15);
      Arrays.fill(this.handle, (byte)(var1 << 4 | var1));
   }

   public byte[] getHandle() {
      return this.handle;
   }

   public void setHandle(byte[] var1) {
      acE[] var2 = ChunkSection.b();
      if(var1.length != this.handle.length) {
         throw new IllegalArgumentException("Length of handle must equal to size of nibble array!");
      } else {
         System.arraycopy(var1, 0, this.handle, 0, var1.length);
      }
   }

   private static IllegalArgumentException a(IllegalArgumentException var0) {
      return var0;
   }
}
