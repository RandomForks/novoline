package viaversion.viarewind.protocol.protocol1_8to1_9.types;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import net.aF7;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.Type;

public class ChunkSectionType1_8 extends Type {
   public ChunkSectionType1_8() {
      super("Chunk Section Type", ChunkSection.class);
   }

   public ChunkSection read(ByteBuf var1) throws Exception {
      ChunkSection var3 = new ChunkSection();
      aF7.d();
      byte[] var4 = new byte[8192];
      var1.readBytes(var4);
      ShortBuffer var5 = ByteBuffer.wrap(var4).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
      int var6 = 0;
      if(var6 < 4096) {
         short var7 = var5.get();
         int var8 = var7 >> 4;
         int var9 = var7 & 15;
         var3.setBlock(var6, var8, var9);
         ++var6;
      }

      return var3;
   }

   public void write(ByteBuf var1, ChunkSection var2) throws Exception {
      aF7.c();
      int var4 = 0;
      if(var4 < 16) {
         int var5 = 0;
         if(var5 < 16) {
            int var6 = 0;
            if(var6 < 16) {
               int var7 = var2.getFlatBlock(var6, var4, var5);
               var1.writeByte(var7);
               var1.writeByte(var7 >> 8);
               ++var6;
            }

            ++var5;
         }

         ++var4;
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
