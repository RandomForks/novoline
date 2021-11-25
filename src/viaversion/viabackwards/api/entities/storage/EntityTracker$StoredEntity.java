package viaversion.viabackwards.api.entities.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.entities.storage.EntityStorage;
import viaversion.viabackwards.api.entities.storage.EntityTracker$1;
import viaversion.viaversion.api.entities.EntityType;

public final class EntityTracker$StoredEntity {
   private final int entityId;
   private final EntityType type;
   private final Map storedObjects;

   private EntityTracker$StoredEntity(int var1, EntityType var2) {
      this.storedObjects = new ConcurrentHashMap();
      this.entityId = var1;
      this.type = var2;
   }

   @Nullable
   public EntityStorage get(Class var1) {
      return (EntityStorage)this.storedObjects.get(var1);
   }

   public boolean has(Class var1) {
      return this.storedObjects.containsKey(var1);
   }

   public void put(EntityStorage var1) {
      this.storedObjects.put(var1.getClass(), var1);
   }

   public int getEntityId() {
      return this.entityId;
   }

   public EntityType getType() {
      return this.type;
   }

   public String toString() {
      return "StoredEntity{entityId=" + this.entityId + ", type=" + this.type + ", storedObjects=" + this.storedObjects + '}';
   }

   EntityTracker$StoredEntity(int var1, EntityType var2, EntityTracker$1 var3) {
      this(var1, var2);
   }
}
