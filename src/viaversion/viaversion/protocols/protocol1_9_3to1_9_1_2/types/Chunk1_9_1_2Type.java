package viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.types;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.BitSet;
import net.ays;
import net.cT;
import net.rX;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.minecraft.Environment;
import viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.PartialType;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseChunkType;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;

public class Chunk1_9_1_2Type extends PartialType {
   public Chunk1_9_1_2Type(cT var1) {
      super(var1, "Chunk", Chunk.class);
   }

   public Chunk a(ByteBuf var1, cT var2) throws Exception {
      int var3 = ays.d();
      if(var2.d().getProtocolInfo().getPipeline().contains(Protocol1_10To1_9_3_4.class) && Via.getConfig().isReplacePistons()) {
         boolean var20 = true;
      } else {
         boolean var10000 = false;
      }

      int var5 = Via.getConfig().getPistonReplacementId();
      int var6 = var1.readInt();
      int var7 = var1.readInt();
      boolean var8 = var1.readBoolean();
      int var9 = Type.VAR_INT.readPrimitive(var1);
      Type.VAR_INT.readPrimitive(var1);
      BitSet var10 = new BitSet(16);
      ChunkSection[] var11 = new ChunkSection[16];
      int var12 = 0;
      if(var12 < 16) {
         if((var9 & 1 << var12) != 0) {
            var10.set(var12);
         }

         ++var12;
      }

      var12 = 0;
      if(var12 < 16) {
         if(var10.get(var12)) {
            ChunkSection var13 = (ChunkSection)rX.b.read(var1);
            var11[var12] = var13;
            var13.readBlockLight(var1);
            if(var2.a() == Environment.NORMAL) {
               var13.readSkyLight(var1);
            }

            var13.replacePaletteEntry(36, var5);
         }

         ++var12;
      }

      int[] var17 = var8?new int[256]:null;
      if(var8) {
         int var18 = 0;
         if(var18 < 256) {
            var17[var18] = var1.readByte() & 255;
            ++var18;
         }
      }

      return new BaseChunk(var6, var7, var8, false, var9, var11, var17, new ArrayList());
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
