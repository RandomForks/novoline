package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.chunks;

import com.viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import net.Bx;

public class ExtendedBlockStorage {
   private int yBase;
   private byte[] blockLSBArray;
   private NibbleArray blockMSBArray;
   private NibbleArray d;
   private NibbleArray b;
   private NibbleArray a;

   public ExtendedBlockStorage(int var1, boolean var2) {
      Bx.b();
      super();
      this.yBase = var1;
      this.blockLSBArray = new byte[4096];
      this.d = new NibbleArray(this.blockLSBArray.length);
      this.b = new NibbleArray(this.blockLSBArray.length);
      this.a = new NibbleArray(this.blockLSBArray.length);
      if(PacketRemapper.b() == null) {
         Bx.b(new int[2]);
      }

   }

   public int b(int var1, int var2, int var3) {
      return this.d.get(var1, var2, var3);
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.d.set(var1, var2, var3, var4);
   }

   public int getYLocation() {
      return this.yBase;
   }

   public void b(int var1, int var2, int var3, int var4) {
      this.a.set(var1, var2, var3, var4);
   }

   public int c(int var1, int var2, int var3) {
      return this.a.get(var1, var2, var3);
   }

   public void c(int var1, int var2, int var3, int var4) {
      this.b.set(var1, var2, var3, var4);
   }

   public int a(int var1, int var2, int var3) {
      return this.b.get(var1, var2, var3);
   }

   public byte[] getBlockLSBArray() {
      return this.blockLSBArray;
   }

   public boolean isEmpty() {
      return this.blockMSBArray == null;
   }

   public void clearMSBArray() {
      this.blockMSBArray = null;
   }

   public NibbleArray getBlockMSBArray() {
      return this.blockMSBArray;
   }

   public NibbleArray i() {
      return this.d;
   }

   public NibbleArray f() {
      return this.b;
   }

   public NibbleArray h() {
      return this.a;
   }

   public void setBlockLSBArray(byte[] var1) {
      this.blockLSBArray = var1;
   }

   public void setBlockMSBArray(NibbleArray var1) {
      this.blockMSBArray = var1;
   }

   public void c(NibbleArray var1) {
      this.d = var1;
   }

   public void b(NibbleArray var1) {
      this.b = var1;
   }

   public void a(NibbleArray var1) {
      this.a = var1;
   }

   public NibbleArray createBlockMSBArray() {
      this.blockMSBArray = new NibbleArray(this.blockLSBArray.length);
      return this.blockMSBArray;
   }
}
