package viaversion.viaversion.protocols.protocol1_13to1_12_2.storage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.af_;
import net.cA;
import net.cX;
import viaversion.viaversion.api.Pair;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;

public class BlockConnectionStorage extends cA {
   private static final short[] REVERSE_BLOCK_MAPPINGS = new short[8582];
   private static Constructor fastUtilLongObjectHashMap;
   private final Map blockStorage = this.createLongObjectMap();

   public BlockConnectionStorage(UserConnection var1) {
      super(var1);
   }

   public void store(int var1, int var2, int var3, int var4) {
      cX.a();
      short var6 = REVERSE_BLOCK_MAPPINGS[var4];
      if(var6 != -1) {
         long var7 = this.getChunkSectionIndex(var1, var2, var3);
         Pair var9 = this.getChunkSection(var7, (var6 & 15) != 0);
         short var10 = this.encodeBlockPos(var1, var2, var3);
         ((byte[])var9.getKey())[var10] = (byte)(var6 >> 4);
         NibbleArray var11 = (NibbleArray)var9.getValue();
         if(var11 != null) {
            var11.a(var10, var6);
         }

      }
   }

   public int get(int var1, int var2, int var3) {
      cX.a();
      long var5 = this.getChunkSectionIndex(var1, var2, var3);
      Pair var7 = (Pair)this.blockStorage.get(Long.valueOf(var5));
      return 0;
   }

   public void remove(int var1, int var2, int var3) {
      cX.a();
      long var5 = this.getChunkSectionIndex(var1, var2, var3);
      Pair var7 = (Pair)this.blockStorage.get(Long.valueOf(var5));
   }

   public void clear() {
      this.blockStorage.clear();
   }

   public void unloadChunk(int var1, int var2) {
      cX.a();
      int var4 = 0;
      if(var4 < 256) {
         this.blockStorage.remove(Long.valueOf(this.getChunkSectionIndex(var1 << 4, var4, var2 << 4)));
         var4 = var4 + 16;
      }

   }

   private Pair getChunkSection(long var1, boolean var3) {
      cX.a();
      Pair var5 = (Pair)this.blockStorage.get(Long.valueOf(var1));
      if(var5 == null) {
         var5 = new Pair(new byte[4096], (Object)null);
         this.blockStorage.put(Long.valueOf(var1), var5);
      }

      if(var5.getValue() == null) {
         var5.setValue(new NibbleArray(4096));
      }

      return var5;
   }

   private long getChunkSectionIndex(int var1, int var2, int var3) {
      return ((long)(var1 >> 4) & 67108863L) << 38 | ((long)(var2 >> 4) & 4095L) << 26 | (long)(var3 >> 4) & 67108863L;
   }

   private long getChunkSectionIndex(Position var1) {
      return this.getChunkSectionIndex(var1.getX(), var1.getY(), var1.getZ());
   }

   private short encodeBlockPos(int var1, int var2, int var3) {
      return (short)((var2 & 15) << 8 | (var1 & 15) << 4 | var3 & 15);
   }

   private short encodeBlockPos(Position var1) {
      return this.encodeBlockPos(var1.getX(), var1.getY(), var1.getZ());
   }

   private Map createLongObjectMap() {
      String[] var1 = cX.a();
      if(fastUtilLongObjectHashMap != null) {
         try {
            return (Map)fastUtilLongObjectHashMap.newInstance(new Object[0]);
         } catch (InstantiationException | InvocationTargetException | IllegalAccessException var3) {
            var3.printStackTrace();
         }
      }

      return new HashMap();
   }

   static {
      try {
         String var8 = "it" + ".unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap";
         fastUtilLongObjectHashMap = af_.a(var8).getConstructor(new Class[0]);
         Via.getPlatform().getLogger().info("Using FastUtil Long2ObjectOpenHashMap for block connections");
      } catch (NoSuchMethodException | ClassNotFoundException var10) {
         ;
      }

      Arrays.fill(REVERSE_BLOCK_MAPPINGS, (short)-1);

      for(int var11 = 0; var11 < 4096; ++var11) {
         int var9 = Protocol1_13To1_12_2.MAPPINGS.getBlockMappings().getNewId(var11);
         if(var9 != -1) {
            REVERSE_BLOCK_MAPPINGS[var9] = (short)var11;
         }
      }

   }

   private static ReflectiveOperationException a(ReflectiveOperationException var0) {
      return var0;
   }
}
