package viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import net.acE;
import net.cT;
import net.oy;
import net.rX;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.minecraft.Environment;
import viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.PartialType;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseChunkType;

public class Chunk1_9_3_4Type extends PartialType {
   public Chunk1_9_3_4Type(cT var1) {
      super(var1, "Chunk", Chunk.class);
   }

   public Chunk a(ByteBuf var1, cT var2) throws Exception {
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      boolean var6 = var1.readBoolean();
      oy.b();
      int var7 = Type.VAR_INT.readPrimitive(var1);
      Type.VAR_INT.readPrimitive(var1);
      ChunkSection[] var8 = new ChunkSection[16];
      int var9 = 0;
      if(var9 < 16) {
         if((var7 & 1 << var9) != 0) {
            ChunkSection var10 = (ChunkSection)rX.b.read(var1);
            var8[var9] = var10;
            var10.readBlockLight(var1);
            if(var2.a() == Environment.NORMAL) {
               var10.readSkyLight(var1);
            }
         }

         ++var9;
      }

      int[] var13 = var6?new int[256]:null;
      if(var6) {
         int var14 = 0;
         if(var14 < 256) {
            var13[var14] = var1.readByte() & 255;
            ++var14;
         }
      }

      ArrayList var16 = new ArrayList(Arrays.asList((Object[])Type.NBT_ARRAY.read(var1)));
      if(var1.readableBytes() > 0) {
         byte[] var11 = (byte[])Type.REMAINING_BYTES.read(var1);
         if(Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().warning("Found " + var11.length + " more bytes than expected while reading the chunk: " + var4 + "/" + var5);
         }
      }

      BaseChunk var10000 = new BaseChunk(var4, var5, var6, false, var7, var8, var13, var16);
      if(acE.b() == null) {
         oy.b(new acE[4]);
      }

      return var10000;
   }

   public void a(ByteBuf param1, cT param2, Chunk param3) throws Exception {
      // $FF: Couldn't be decompiled
   }

   public Class getBaseClass() {
      return BaseChunkType.class;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
