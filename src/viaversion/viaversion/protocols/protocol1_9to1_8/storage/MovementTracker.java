package viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import net.cA;
import viaversion.viaversion.api.data.UserConnection;

public class MovementTracker extends cA {
   private static final long IDLE_PACKET_DELAY = 50L;
   private static final long IDLE_PACKET_LIMIT = 20L;
   private long nextIdlePacket = 0L;
   private boolean ground = true;

   public MovementTracker(UserConnection var1) {
      super(var1);
   }

   public void incrementIdlePacket() {
      this.nextIdlePacket = Math.max(this.nextIdlePacket + 50L, System.currentTimeMillis() - 1000L);
   }

   public long getNextIdlePacket() {
      return this.nextIdlePacket;
   }

   public boolean isGround() {
      return this.ground;
   }

   public void setGround(boolean var1) {
      this.ground = var1;
   }
}
