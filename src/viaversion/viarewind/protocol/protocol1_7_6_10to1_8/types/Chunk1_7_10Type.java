package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import java.util.zip.Deflater;
import net.cT;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.minecraft.Environment;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.PartialType;

public class Chunk1_7_10Type extends PartialType {
   public Chunk1_7_10Type(cT var1) {
      super(var1, "Chunk", Chunk.class);
   }

   public Chunk a(ByteBuf var1, cT var2) throws Exception {
      throw new UnsupportedOperationException();
   }

   public void a(ByteBuf var1, cT var2, Chunk var3) throws Exception {
      var1.writeInt(var3.getX());
      Particle.b();
      var1.writeInt(var3.getZ());
      var1.writeBoolean(var3.isFullChunk());
      var1.writeShort(var3.getBitmask());
      var1.writeShort(0);
      ByteBuf var5 = var1.alloc().buffer();
      ByteBuf var6 = var1.alloc().buffer();
      int var7 = 0;
      if(var7 < var3.getSections().length) {
         if((var3.getBitmask() & 1 << var7) != 0) {
            ChunkSection var8 = var3.getSections()[var7];
            int var9 = 0;
            if(var9 < 16) {
               int var10 = 0;
               if(var10 < 16) {
                  int var11 = 0;
                  int var12 = 0;
                  if(var12 < 16) {
                     int var13 = var8.getFlatBlock(var12, var9, var10);
                     var5.writeByte(var13 >> 4);
                     int var14 = var13 & 15;
                     if(var12 % 2 == 0) {
                        var11 = var14;
                     }

                     var6.writeByte(var14 << 4 | var11);
                     ++var12;
                  }

                  ++var10;
               }

               ++var9;
            }
         }

         ++var7;
      }

      var5.writeBytes(var6);
      var6.release();
      var7 = 0;
      if(var7 < var3.getSections().length) {
         if((var3.getBitmask() & 1 << var7) != 0) {
            var3.getSections()[var7].writeBlockLight(var5);
         }

         ++var7;
      }

      var7 = var2 != null && var2.a() == Environment.NORMAL;
      if(var7) {
         int var22 = 0;
         if(var22 < var3.getSections().length) {
            if((var3.getBitmask() & 1 << var22) != 0) {
               var3.getSections()[var22].writeSkyLight(var5);
            }

            ++var22;
         }
      }

      if(var3.isFullChunk() && var3.isBiomeData()) {
         int[] var24 = var3.getBiomeData();
         int var27 = var24.length;
         int var30 = 0;
         if(var30 < var27) {
            int var33 = var24[var30];
            var5.writeByte((byte)var33);
            ++var30;
         }
      }

      var5.readerIndex(0);
      byte[] var25 = new byte[var5.readableBytes()];
      var5.readBytes(var25);
      var5.release();
      Deflater var28 = new Deflater(4);
      Deflater var10000 = var28;
      byte[] var10001 = var25;
      byte var10002 = 0;
      byte[] var10003 = var25;

      byte[] var32;
      int var34;
      try {
         var10000.setInput(var10001, var10002, var10003.length);
         var28.finish();
         var32 = new byte[var25.length];
         var34 = var28.deflate(var32);
      } finally {
         var28.end();
      }

      var1.writeInt(var34);
      var1.writeBytes(var32, 0, var34);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
