package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import net.bgR;
import net.cA;

public class BlockPlaceDestroyTracker extends cA {
   private long blockPlaced;
   private long lastMining;
   private boolean mining;

   public BlockPlaceDestroyTracker(bgR var1) {
      super(var1);
   }

   public long getBlockPlaced() {
      return this.blockPlaced;
   }

   public void place() {
      this.blockPlaced = System.currentTimeMillis();
   }

   public boolean isMining() {
      EntityTracker.d();
      long var2 = System.currentTimeMillis() - this.lastMining;
      return this.mining && var2 < 75L || var2 < 75L;
   }

   public void setMining(boolean var1) {
      String[] var2 = EntityTracker.d();
      this.mining = var1 && ((EntityTracker)this.d().b(EntityTracker.class)).getPlayerGamemode() != 1;
      this.lastMining = System.currentTimeMillis();
   }

   public long getLastMining() {
      return this.lastMining;
   }

   public void updateMining() {
      String[] var1 = EntityTracker.d();
      if(this.isMining()) {
         this.lastMining = System.currentTimeMillis();
      }

   }

   public void setLastMining(long var1) {
      this.lastMining = var1;
   }
}
