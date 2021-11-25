package viaversion.viaversion.protocols.protocol1_14to1_13_2.types;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import net.aEY;
import net.acE;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseChunkType;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;

public class Chunk1_14Type extends Type {
   public Chunk1_14Type() {
      super("Chunk", Chunk.class);
   }

   public Chunk read(ByteBuf var1) throws Exception {
      int var3 = var1.readInt();
      ConnectionData.c();
      int var4 = var1.readInt();
      boolean var5 = var1.readBoolean();
      int var6 = Type.VAR_INT.readPrimitive(var1);
      CompoundTag var7 = (CompoundTag)Type.NBT.read(var1);
      Type.VAR_INT.readPrimitive(var1);
      ChunkSection[] var8 = new ChunkSection[16];
      int var9 = 0;
      if(var9 < 16) {
         if((var6 & 1 << var9) != 0) {
            short var10 = var1.readShort();
            ChunkSection var11 = (ChunkSection)aEY.c.read(var1);
            var11.setNonAirBlocksCount(var10);
            var8[var9] = var11;
         }

         ++var9;
      }

      int[] var13 = var5?new int[256]:null;
      if(var5) {
         int var14 = 0;
         if(var14 < 256) {
            var13[var14] = var1.readInt();
            ++var14;
         }
      }

      ArrayList var16 = new ArrayList(Arrays.asList((Object[])Type.NBT_ARRAY.read(var1)));
      if(var1.readableBytes() > 0) {
         byte[] var17 = (byte[])Type.REMAINING_BYTES.read(var1);
         if(Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().warning("Found " + var17.length + " more bytes than expected while reading the chunk: " + var3 + "/" + var4);
         }
      }

      BaseChunk var10000 = new BaseChunk(var3, var4, var5, false, var6, var8, var13, var7, var16);
      if(acE.b() == null) {
         ConnectionData.b(new String[4]);
      }

      return var10000;
   }

   public void write(ByteBuf param1, Chunk param2) throws Exception {
      // $FF: Couldn't be decompiled
   }

   public Class getBaseClass() {
      return BaseChunkType.class;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
