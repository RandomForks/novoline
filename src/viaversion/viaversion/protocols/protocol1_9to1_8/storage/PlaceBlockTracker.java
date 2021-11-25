package viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import net.cA;
import net.cq;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;

public class PlaceBlockTracker extends cA {
   private long lastPlaceTimestamp = 0L;
   private Position lastPlacedPosition = null;

   public PlaceBlockTracker(UserConnection var1) {
      super(var1);
   }

   public boolean isExpired(int var1) {
      String var2 = cq.c();
      return System.currentTimeMillis() > this.lastPlaceTimestamp + (long)var1;
   }

   public void updateTime() {
      this.lastPlaceTimestamp = System.currentTimeMillis();
   }

   public long getLastPlaceTimestamp() {
      return this.lastPlaceTimestamp;
   }

   public Position getLastPlacedPosition() {
      return this.lastPlacedPosition;
   }

   public void setLastPlacedPosition(Position var1) {
      this.lastPlacedPosition = var1;
   }
}
