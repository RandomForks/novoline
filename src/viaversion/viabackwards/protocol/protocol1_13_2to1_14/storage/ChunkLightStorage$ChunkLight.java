package viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage;

import net.acE;
import net.cK;

public class ChunkLightStorage$ChunkLight {
   private final byte[][] skyLight;
   private final byte[][] blockLight;

   public ChunkLightStorage$ChunkLight(byte[][] var1, byte[][] var2) {
      cK.b();
      super();
      this.skyLight = var1;
      this.blockLight = var2;
      if(acE.b() == null) {
         cK.b(new acE[4]);
      }

   }

   public byte[][] getSkyLight() {
      return this.skyLight;
   }

   public byte[][] getBlockLight() {
      return this.blockLight;
   }
}
