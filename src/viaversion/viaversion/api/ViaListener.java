package viaversion.viaversion.api;

import java.util.UUID;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;

public abstract class ViaListener {
   private final Class requiredPipeline;
   private boolean registered;

   public ViaListener(Class var1) {
      this.requiredPipeline = var1;
   }

   @Nullable
   protected UserConnection getUserConnection(UUID var1) {
      return Via.getManager().getConnection(var1);
   }

   protected boolean isOnPipe(UUID var1) {
      PacketWrapper.f();
      UserConnection var3 = this.getUserConnection(var1);
      return this.requiredPipeline == null || var3.getProtocolInfo().getPipeline().contains(this.requiredPipeline);
   }

   public abstract void register();

   protected Class getRequiredPipeline() {
      return this.requiredPipeline;
   }

   protected boolean isRegistered() {
      return this.registered;
   }

   protected void setRegistered(boolean var1) {
      this.registered = var1;
   }
}
