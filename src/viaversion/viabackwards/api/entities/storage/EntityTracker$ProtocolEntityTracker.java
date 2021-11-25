package viaversion.viabackwards.api.entities.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.cQ;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.entities.storage.EntityTracker$StoredEntity;
import viaversion.viaversion.api.entities.EntityType;

public class EntityTracker$ProtocolEntityTracker {
   private final Map entityMap = new ConcurrentHashMap();

   public void trackEntityType(int var1, EntityType var2) {
      this.entityMap.putIfAbsent(Integer.valueOf(var1), new EntityTracker$StoredEntity(var1, var2));
   }

   public void removeEntity(int var1) {
      this.entityMap.remove(Integer.valueOf(var1));
   }

   @Nullable
   public EntityType getEntityType(int var1) {
      cQ.a();
      EntityTracker$StoredEntity var3 = (EntityTracker$StoredEntity)this.entityMap.get(Integer.valueOf(var1));
      return var3 != null?var3.getType():null;
   }

   @Nullable
   public EntityTracker$StoredEntity getEntity(int var1) {
      return (EntityTracker$StoredEntity)this.entityMap.get(Integer.valueOf(var1));
   }
}
