package viaversion.viarewind.protocol.protocol1_8to1_9.types;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.logging.Level;
import net.aF7;
import net.acE;
import net.cT;
import viaversion.viarewind.protocol.protocol1_8to1_9.types.ChunkSectionType1_8;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.minecraft.Environment;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.Chunk1_8;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.PartialType;
import viaversion.viaversion.api.type.Type;

public class Chunk1_8Type extends PartialType {
   private static final Type CHUNK_SECTION_TYPE = new ChunkSectionType1_8();

   public Chunk1_8Type(cT var1) {
      super(var1, "Chunk", Chunk.class);
   }

   public Chunk a(ByteBuf var1, cT var2) throws Exception {
      int var4 = var1.readInt();
      aF7.c();
      int var5 = var1.readInt();
      boolean var6 = var1.readByte() != 0;
      int var7 = var1.readUnsignedShort();
      int var8 = Type.VAR_INT.readPrimitive(var1);
      if(var7 == 0 && var6) {
         if(var8 >= 256) {
            var1.readerIndex(var1.readerIndex() + 256);
         }

         return new Chunk1_8(var4, var5);
      } else {
         ChunkSection[] var9 = new ChunkSection[16];
         int[] var10 = null;
         int var11 = var1.readerIndex();
         int var12 = 0;
         if(var12 < 16) {
            if((var7 & 1 << var12) != 0) {
               var9[var12] = (ChunkSection)CHUNK_SECTION_TYPE.read(var1);
            }

            ++var12;
         }

         var12 = 0;
         if(var12 < 16) {
            if((var7 & 1 << var12) != 0) {
               var9[var12].readBlockLight(var1);
            }

            ++var12;
         }

         var12 = var8 - (var1.readerIndex() - var11);
         if(var12 >= 2048) {
            int var13 = 0;
            if(var13 < 16) {
               if((var7 & 1 << var13) != 0) {
                  var9[var13].readSkyLight(var1);
                  var12 -= 2048;
               }

               ++var13;
            }
         }

         if(var12 >= 256) {
            var10 = new int[256];
            int var19 = 0;
            if(var19 < 256) {
               var10[var19] = var1.readByte() & 255;
               ++var19;
            }

            var12 -= 256;
         }

         Via.getPlatform().getLogger().log(Level.WARNING, var12 + " Bytes left after reading chunks! (" + var6 + ")");
         Chunk1_8 var10000 = new Chunk1_8(var4, var5, var6, var7, var9, var10, new ArrayList());
         if(acE.b() == null) {
            aF7.b(false);
         }

         return var10000;
      }
   }

   public void a(ByteBuf var1, cT var2, Chunk var3) throws Exception {
      aF7.d();
      ByteBuf var5 = var1.alloc().buffer();
      int var6 = 0;
      if(var6 < var3.getSections().length) {
         if((var3.getBitmask() & 1 << var6) != 0) {
            CHUNK_SECTION_TYPE.write(var5, var3.getSections()[var6]);
         }

         ++var6;
      }

      var6 = 0;
      if(var6 < var3.getSections().length) {
         if((var3.getBitmask() & 1 << var6) != 0) {
            var3.getSections()[var6].writeBlockLight(var5);
         }

         ++var6;
      }

      var6 = var2.a() == Environment.NORMAL;
      if(var6) {
         int var7 = 0;
         if(var7 < var3.getSections().length) {
            if((var3.getBitmask() & 1 << var7) != 0) {
               var3.getSections()[var7].writeSkyLight(var5);
            }

            ++var7;
         }
      }

      if(var3.isFullChunk() && var3.isBiomeData()) {
         int[] var16 = var3.getBiomeData();
         int var8 = var16.length;
         int var9 = 0;
         if(var9 < var8) {
            int var10 = var16[var9];
            var5.writeByte((byte)var10);
            ++var9;
         }
      }

      var1.writeInt(var3.getX());
      var1.writeInt(var3.getZ());
      var1.writeBoolean(var3.isFullChunk());
      var1.writeShort(var3.getBitmask());
      Type.VAR_INT.writePrimitive(var1, var5.readableBytes());
      var1.writeBytes(var5, var5.readableBytes());
      var5.release();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
