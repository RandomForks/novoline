package viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers;

import net.aPh;
import net.acE;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.BlockConnectionStorage;

public class PacketBlockConnectionProvider extends aPh {
   public void a(UserConnection var1, int var2, int var3, int var4, int var5) {
      aPh.b();
      ((BlockConnectionStorage)var1.b(BlockConnectionStorage.class)).store(var2, var3, var4, var5);
      if(acE.b() == null) {
         aPh.b("ShlY4b");
      }

   }

   public void removeBlock(UserConnection var1, int var2, int var3, int var4) {
      ((BlockConnectionStorage)var1.b(BlockConnectionStorage.class)).remove(var2, var3, var4);
   }

   public int getBlockData(UserConnection var1, int var2, int var3, int var4) {
      return ((BlockConnectionStorage)var1.b(BlockConnectionStorage.class)).get(var2, var3, var4);
   }

   public void clearStorage(UserConnection var1) {
      ((BlockConnectionStorage)var1.b(BlockConnectionStorage.class)).clear();
   }

   public void unloadChunk(UserConnection var1, int var2, int var3) {
      ((BlockConnectionStorage)var1.b(BlockConnectionStorage.class)).unloadChunk(var2, var3);
   }

   public boolean storesBlocks() {
      return true;
   }
}
