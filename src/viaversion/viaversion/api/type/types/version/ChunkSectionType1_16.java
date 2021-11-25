package viaversion.viaversion.api.type.types.version;

import io.netty.buffer.ByteBuf;
import java.util.function.IntToLongFunction;
import net.acE;
import net.aes;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.util.BiIntConsumer;
import viaversion.viaversion.util.CompactArrayUtil;

public class ChunkSectionType1_16 extends Type {
   private static final int GLOBAL_PALETTE = 15;

   public ChunkSectionType1_16() {
      super("Chunk Section Type", ChunkSection.class);
   }

   public ChunkSection read(ByteBuf var1) throws Exception {
      aes.b();
      short var3 = var1.readUnsignedByte();
      short var4 = var3;
      if(var3 == 0 || var3 > 8) {
         var3 = 15;
      }

      if(var3 != 15) {
         int var6 = Type.VAR_INT.readPrimitive(var1);
         ChunkSection var5 = new ChunkSection(var6);
         int var7 = 0;
         if(var7 < var6) {
            var5.addPaletteEntry(Type.VAR_INT.readPrimitive(var1));
            ++var7;
         }
      }

      ChunkSection var10 = new ChunkSection();
      long[] var11 = new long[Type.VAR_INT.readPrimitive(var1)];
      if(var11.length > 0) {
         char var13 = (char)(64 / var3);
         int var8 = (4096 + var13 - 1) / var13;
         if(var11.length != var8) {
            throw new IllegalStateException("Block data length (" + var11.length + ") does not match expected length (" + var8 + ")! bitsPerBlock=" + var3 + ", originalBitsPerBlock=" + var4);
         }

         int var9 = 0;
         if(var9 < var11.length) {
            var11[var9] = var1.readLong();
            ++var9;
         }

         CompactArrayUtil.iterateCompactArrayWithPadding(var3, 4096, var11, var3 == 15?var10::setFlatBlock:var10::setPaletteIndex);
      }

      return var10;
   }

   public void write(ByteBuf var1, ChunkSection var2) throws Exception {
      aes.b();
      int var4 = 4;
      if(var2.getPaletteSize() > 1 << var4) {
         ++var4;
      }

      if(var4 > 8) {
         var4 = 15;
      }

      var1.writeByte(var4);
      if(var4 != 15) {
         Type.VAR_INT.writePrimitive(var1, var2.getPaletteSize());
         int var5 = 0;
         if(var5 < var2.getPaletteSize()) {
            Type.VAR_INT.writePrimitive(var1, var2.getPaletteEntry(var5));
            ++var5;
         }
      }

      long[] var12 = CompactArrayUtil.createCompactArrayWithPadding(var4, 4096, var4 == 15?var2::getFlatBlock:var2::getPaletteIndex);
      Type.VAR_INT.writePrimitive(var1, var12.length);
      int var7 = var12.length;
      int var8 = 0;
      if(var8 < var7) {
         long var9 = var12[var8];
         var1.writeLong(var9);
         ++var8;
      }

      if(acE.b() == null) {
         aes.b(new String[1]);
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
