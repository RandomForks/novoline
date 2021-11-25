package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import java.util.Arrays;
import java.util.function.IntToLongFunction;
import net.aVA;
import net.aVC;
import net.aVJ;
import net.aVQ;
import net.aVc;
import net.aVg;
import net.aW_;
import net.aWa;
import net.aWk;
import net.acE;
import net.q1;
import viaversion.viaversion.api.minecraft.BlockFace;
import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.WorldPackets$1;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.WorldPackets$12;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.WorldPackets$2;
import viaversion.viaversion.util.CompactArrayUtil;

public class WorldPackets {
   public static final int SERVERSIDE_VIEW_DISTANCE = 64;
   private static final byte[] FULL_LIGHT = new byte[2048];
   public static int f;
   public static int c;
   public static int a;
   private static int[] d;

   public static void register(Protocol1_14To1_13_2 var0) {
      BlockRewriter var2 = new BlockRewriter(var0, (Type)null);
      var0.a(q1.BLOCK_BREAK_ANIMATION, new WorldPackets$1());
      b();
      var0.a(q1.BLOCK_ENTITY_DATA, new WorldPackets$2());
      var0.a(q1.BLOCK_ACTION, new aWk(var0));
      var0.a(q1.BLOCK_CHANGE, new aVg(var0));
      var0.a(q1.SERVER_DIFFICULTY, new aVJ());
      var2.registerMultiBlockChange(q1.MULTI_BLOCK_CHANGE);
      var0.a(q1.EXPLOSION, new aVA());
      var0.a(q1.CHUNK_DATA, new aVQ(var0));
      var0.a(q1.EFFECT, new aVc(var0));
      var0.a(q1.JOIN_GAME, new aVC(var0));
      var0.a(q1.MAP_DATA, new aWa());
      var0.a(q1.RESPAWN, new aW_(var0));
      var0.a(q1.SPAWN_POSITION, new WorldPackets$12());
      if(acE.b() == null) {
         b(new int[5]);
      }

   }

   private static long[] encodeHeightMap(int[] var0) {
      return CompactArrayUtil.createCompactArray(9, var0.length, WorldPackets::lambda$encodeHeightMap$0);
   }

   private static void setNonFullLight(Chunk var0, ChunkSection var1, int var2, int var3, int var4, int var5) {
      int var7 = 0;
      int var8 = 0;
      b();
      BlockFace[] var9 = BlockFace.values();
      int var10 = var9.length;
      int var11 = 0;
      if(var11 < var10) {
         label31: {
            BlockFace var12 = var9[var11];
            NibbleArray var13 = var1.getSkyLightNibbleArray();
            NibbleArray var14 = var1.getBlockLightNibbleArray();
            int var15 = var3 + var12.getModX();
            int var16 = var4 + var12.getModY();
            int var17 = var5 + var12.getModZ();
            if(var12.getModX() != 0) {
               if(var15 == 16 || var15 == -1) {
                  break label31;
               }
            } else {
               label112: {
                  if(var12.getModY() != 0) {
                     if(var16 != 16 && var16 != -1) {
                        break label112;
                     }

                     if(var16 == 16) {
                        ++var2;
                        var16 = 0;
                     }

                     --var2;
                     var16 = 15;
                     if(var2 == 16 || var2 == -1) {
                        break label31;
                     }

                     ChunkSection var18 = var0.getSections()[var2];
                     if(var18 == null) {
                        break label31;
                     }

                     var13 = var18.getSkyLightNibbleArray();
                     var14 = var18.getBlockLightNibbleArray();
                  }

                  if(var12.getModZ() != 0 && (var17 == 16 || var17 == -1)) {
                     break label31;
                  }
               }
            }

            if(var14 != null && var8 != 15) {
               byte var24 = var14.get(var15, var16, var17);
               if(var24 == 15) {
                  var8 = 14;
               }

               if(var24 > var8) {
                  var8 = var24 - 1;
               }
            }

            if(var13 != null && var7 != 15) {
               byte var25 = var13.get(var15, var16, var17);
               if(var25 == 15) {
                  if(var12.getModY() == 1) {
                     var7 = 15;
                  }

                  var7 = 14;
               }

               if(var25 > var7) {
                  var7 = var25 - 1;
               }
            }
         }

         ++var11;
      }

      if(var7 != 0) {
         if(!var1.hasSkyLight()) {
            byte[] var21 = new byte[2028];
            var1.setSkyLight(var21);
         }

         var1.getSkyLightNibbleArray().set(var3, var4, var5, var7);
      }

      if(var8 != 0) {
         var1.getBlockLightNibbleArray().set(var3, var4, var5, var8);
      }

   }

   private static long getChunkIndex(int var0, int var1) {
      return ((long)var0 & 67108863L) << 38 | (long)var1 & 67108863L;
   }

   private static long lambda$encodeHeightMap$0(int[] var0, int var1) {
      return (long)var0[var1];
   }

   static void access$000(Chunk var0, ChunkSection var1, int var2, int var3, int var4, int var5) {
      setNonFullLight(var0, var1, var2, var3, var4, var5);
   }

   static long[] access$100(int[] var0) {
      return encodeHeightMap(var0);
   }

   static byte[] access$200() {
      return FULL_LIGHT;
   }

   static {
      int[] var10000 = new int[3];
      b(var10000);
      Arrays.fill(FULL_LIGHT, (byte)-1);
   }

   public static void b(int[] var0) {
      d = var0;
   }

   public static int[] b() {
      return d;
   }
}
