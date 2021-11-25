package de.gerrygames.viarewind.protocol.protocol1_8to1_9.types;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.Environment;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_8;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.PartialType;
import com.viaversion.viaversion.api.type.Type;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.types.ChunkSectionType1_8;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.logging.Level;
import net.aF7;
import net.aiV;
import net.cT;

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
         aiV[] var9 = new aiV[16];
         int[] var10 = null;
         int var11 = var1.readerIndex();
         int var12 = 0;
         if(var12 < 16) {
            if((var7 & 1 << var12) != 0) {
               var9[var12] = (aiV)CHUNK_SECTION_TYPE.read(var1);
            }

            ++var12;
         }

         var12 = 0;
         if(var12 < 16) {
            if((var7 & 1 << var12) != 0) {
               var9[var12].b(var1);
            }

            ++var12;
         }

         var12 = var8 - (var1.readerIndex() - var11);
         if(var12 >= 2048) {
            int var13 = 0;
            if(var13 < 16) {
               if((var7 & 1 << var13) != 0) {
                  var9[var13].c(var1);
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

         Via.d().getLogger().log(Level.WARNING, var12 + " Bytes left after reading chunks! (" + var6 + ")");
         Chunk1_8 var10000 = new Chunk1_8(var4, var5, var6, var7, var9, var10, new ArrayList());
         if(PacketRemapper.b() == null) {
            aF7.b(false);
         }

         return var10000;
      }
   }

   public void a(ByteBuf var1, cT var2, Chunk var3) throws Exception {
      aF7.d();
      ByteBuf var5 = var1.alloc().buffer();
      int var6 = 0;
      if(var6 < var3.f().length) {
         if((var3.k() & 1 << var6) != 0) {
            CHUNK_SECTION_TYPE.write(var5, var3.f()[var6]);
         }

         ++var6;
      }

      var6 = 0;
      if(var6 < var3.f().length) {
         if((var3.k() & 1 << var6) != 0) {
            var3.f()[var6].d(var5);
         }

         ++var6;
      }

      var6 = var2.a() == Environment.NORMAL;
      if(var6) {
         int var7 = 0;
         if(var7 < var3.f().length) {
            if((var3.k() & 1 << var7) != 0) {
               var3.f()[var7].a(var5);
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

      var1.writeInt(var3.h());
      var1.writeInt(var3.i());
      var1.writeBoolean(var3.isFullChunk());
      var1.writeShort(var3.k());
      Type.VAR_INT.writePrimitive(var1, var5.readableBytes());
      var1.writeBytes(var5, var5.readableBytes());
      var5.release();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
