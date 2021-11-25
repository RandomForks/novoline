package viaversion.viaversion.api.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.acE;
import net.cA;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.data.ExternalJoinGameListener;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.entities.EntityType;

public abstract class EntityTracker extends cA implements ExternalJoinGameListener {
   private final Map clientEntityTypes;
   private final EntityType playerType;
   private int clientEntityId;
   private static String[] d;

   protected EntityTracker(UserConnection var1, EntityType var2) {
      a();
      super(var1);
      this.clientEntityTypes = new ConcurrentHashMap();
      this.playerType = var2;
   }

   public void removeEntity(int var1) {
      this.clientEntityTypes.remove(Integer.valueOf(var1));
   }

   public void addEntity(int var1, EntityType var2) {
      this.clientEntityTypes.put(Integer.valueOf(var1), var2);
   }

   public boolean hasEntity(int var1) {
      return this.clientEntityTypes.containsKey(Integer.valueOf(var1));
   }

   @Nullable
   public EntityType getEntity(int var1) {
      return (EntityType)this.clientEntityTypes.get(Integer.valueOf(var1));
   }

   public void onExternalJoinGame(int var1) {
      a();
      this.clientEntityId = var1;
      this.clientEntityTypes.put(Integer.valueOf(var1), this.playerType);
      if(acE.b() == null) {
         b(new String[1]);
      }

   }

   public int getClientEntityId() {
      return this.clientEntityId;
   }

   public void setClientEntityId(int var1) {
      this.clientEntityId = var1;
   }

   public static void b(String[] var0) {
      d = var0;
   }

   public static String[] a() {
      return d;
   }

   static {
      if(a() != null) {
         b(new String[3]);
      }

   }
}
