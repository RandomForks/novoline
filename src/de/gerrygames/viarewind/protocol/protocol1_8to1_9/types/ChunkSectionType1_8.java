package de.gerrygames.viarewind.protocol.protocol1_8to1_9.types;

import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import net.aF7;
import net.aiV;

public class ChunkSectionType1_8 extends Type {
   public ChunkSectionType1_8() {
      super("Chunk Section Type", aiV.class);
   }

   public aiV a(ByteBuf var1) throws Exception {
      aiV var3 = new aiV();
      aF7.d();
      byte[] var4 = new byte[8192];
      var1.readBytes(var4);
      ShortBuffer var5 = ByteBuffer.wrap(var4).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
      int var6 = 0;
      if(var6 < 4096) {
         short var7 = var5.get();
         int var8 = var7 >> 4;
         int var9 = var7 & 15;
         var3.a(var6, var8, var9);
         ++var6;
      }

      return var3;
   }

   public void a(ByteBuf var1, aiV var2) throws Exception {
      aF7.c();
      int var4 = 0;
      if(var4 < 16) {
         int var5 = 0;
         if(var5 < 16) {
            int var6 = 0;
            if(var6 < 16) {
               int var7 = var2.c(var6, var4, var5);
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
