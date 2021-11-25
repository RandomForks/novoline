package viaversion.viabackwards.api.entities.storage;

import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.entities.storage.EntityData$MetaCreator;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;

public class EntityData {
   private final int id;
   private final int replacementId;
   private Object mobName;
   private EntityData$MetaCreator defaultMeta;

   public EntityData(int var1, int var2) {
      this.id = var1;
      this.replacementId = var2;
   }

   public EntityData jsonName(String var1) {
      this.mobName = ChatRewriter.legacyTextToJson(var1);
      return this;
   }

   public EntityData mobName(String var1) {
      this.mobName = var1;
      return this;
   }

   public EntityData spawnMetadata(EntityData$MetaCreator var1) {
      this.defaultMeta = var1;
      return this;
   }

   public boolean hasBaseMeta() {
      return this.defaultMeta != null;
   }

   public int getId() {
      return this.id;
   }

   @Nullable
   public Object getMobName() {
      return this.mobName;
   }

   public int getReplacementId() {
      return this.replacementId;
   }

   @Nullable
   public EntityData$MetaCreator getDefaultMeta() {
      return this.defaultMeta;
   }

   public boolean isObject() {
      return false;
   }

   public int getObjectData() {
      return -1;
   }

   public String toString() {
      return "EntityData{id=" + this.id + ", mobName=\'" + this.mobName + '\'' + ", replacementId=" + this.replacementId + ", defaultMeta=" + this.defaultMeta + '}';
   }
}
