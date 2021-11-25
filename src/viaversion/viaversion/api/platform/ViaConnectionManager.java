package viaversion.viaversion.api.platform;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;

public class ViaConnectionManager {
   protected final Map clients = new ConcurrentHashMap();
   protected final Set connections = Collections.newSetFromMap(new ConcurrentHashMap());
   private static boolean b;

   public void onLoginSuccess(UserConnection var1) {
      boolean var2 = c();
      Objects.requireNonNull(var1, "connection is null!");
      this.connections.add(var1);
      if(this.isFrontEnd(var1)) {
         UUID var3 = var1.getProtocolInfo().getUuid();
         if(this.clients.put(var3, var1) != null) {
            Via.getPlatform().getLogger().warning("Duplicate UUID on frontend connection! (" + var3 + ")");
         }
      }

      if(var1.getChannel() != null) {
         var1.getChannel().closeFuture().addListener(this::lambda$onLoginSuccess$0);
      }

   }

   public void onDisconnect(UserConnection var1) {
      boolean var2 = c();
      Objects.requireNonNull(var1, "connection is null!");
      this.connections.remove(var1);
      if(this.isFrontEnd(var1)) {
         UUID var3 = var1.getProtocolInfo().getUuid();
         this.clients.remove(var3);
      }

      if(acE.b() == null) {
         b(false);
      }

   }

   public boolean isFrontEnd(UserConnection var1) {
      boolean var2 = c();
      return !var1.isClientSide();
   }

   public Map getConnectedClients() {
      return Collections.unmodifiableMap(this.clients);
   }

   @Nullable
   public UserConnection getConnectedClient(UUID var1) {
      return (UserConnection)this.clients.get(var1);
   }

   @Nullable
   public UUID getConnectedClientId(UserConnection var1) {
      boolean var2 = d();
      if(var1.getProtocolInfo() == null) {
         return null;
      } else {
         UUID var3 = var1.getProtocolInfo().getUuid();
         UserConnection var4 = (UserConnection)this.clients.get(var3);
         return var4 != null && var4.equals(var1)?var3:null;
      }
   }

   public Set getConnections() {
      return Collections.unmodifiableSet(this.connections);
   }

   public boolean isClientConnected(UUID var1) {
      return this.clients.containsKey(var1);
   }

   private void lambda$onLoginSuccess$0(UserConnection var1, ChannelFuture var2) throws Exception {
      this.onDisconnect(var1);
   }

   public static void b(boolean var0) {
      b = var0;
   }

   public static boolean c() {
      return b;
   }

   public static boolean d() {
      boolean var0 = c();
      return true;
   }

   static {
      b(true);
   }
}
