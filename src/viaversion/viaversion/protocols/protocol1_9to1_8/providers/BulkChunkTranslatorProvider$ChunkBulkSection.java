package viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import net.acE;
import net.amb;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.type.Type;

class BulkChunkTranslatorProvider$ChunkBulkSection {
   private int x;
   private int z;
   private int bitMask;
   private int length;
   private byte[] data;

   public static BulkChunkTranslatorProvider$ChunkBulkSection read(PacketWrapper var0, boolean var1) throws Exception {
      BulkChunkTranslatorProvider$ChunkBulkSection var3 = new BulkChunkTranslatorProvider$ChunkBulkSection();
      var3.setX(((Integer)var0.read(Type.INT)).intValue());
      amb.c();
      var3.setZ(((Integer)var0.read(Type.INT)).intValue());
      var3.setBitMask(((Integer)var0.read(Type.UNSIGNED_SHORT)).intValue());
      int var4 = Integer.bitCount(var3.getBitMask());
      var3.setLength(var4 * 10240 + (var1?var4 * 2048:0) + 256);
      if(acE.b() == null) {
         amb.b(false);
      }

      return var3;
   }

   public int getX() {
      return this.x;
   }

   public void setX(int var1) {
      this.x = var1;
   }

   public int getZ() {
      return this.z;
   }

   public void setZ(int var1) {
      this.z = var1;
   }

   public int getBitMask() {
      return this.bitMask;
   }

   public void setBitMask(int var1) {
      this.bitMask = var1;
   }

   public int getLength() {
      return this.length;
   }

   public void setLength(int var1) {
      this.length = var1;
   }

   public byte[] getData() {
      return this.data;
   }

   public void setData(byte[] var1) {
      this.data = var1;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
