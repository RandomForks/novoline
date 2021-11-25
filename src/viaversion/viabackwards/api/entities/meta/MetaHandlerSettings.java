package viaversion.viabackwards.api.entities.meta;

import net.yb;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.entities.meta.MetaHandler;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;

public class MetaHandlerSettings {
   private EntityType filterType;
   private boolean filterFamily;
   private int filterIndex = -1;
   private MetaHandler handler;

   public MetaHandlerSettings filter(EntityType var1) {
      return this.filter(var1, this.filterFamily, this.filterIndex);
   }

   public MetaHandlerSettings filter(EntityType var1, boolean var2) {
      return this.filter(var1, var2, this.filterIndex);
   }

   public MetaHandlerSettings filter(int var1) {
      return this.filter(this.filterType, this.filterFamily, var1);
   }

   public MetaHandlerSettings filter(EntityType var1, int var2) {
      return this.filter(var1, this.filterFamily, var2);
   }

   public MetaHandlerSettings filter(EntityType var1, boolean var2, int var3) {
      this.filterType = var1;
      this.filterFamily = var2;
      this.filterIndex = var3;
      return this;
   }

   public void handle(@Nullable MetaHandler var1) {
      this.handler = var1;
   }

   public void handleIndexChange(int var1) {
      this.handle(MetaHandlerSettings::lambda$handleIndexChange$0);
   }

   public void removed() {
      this.handle(MetaHandlerSettings::lambda$removed$1);
   }

   public boolean hasHandler() {
      return this.handler != null;
   }

   public boolean hasType() {
      return this.filterType != null;
   }

   public boolean hasIndex() {
      String var1 = yb.g();
      return this.filterIndex > -1;
   }

   public boolean isFilterFamily() {
      return this.filterFamily;
   }

   public boolean isGucci(EntityType var1, Metadata var2) {
      String var3 = yb.g();
      if(!this.hasHandler()) {
         return false;
      } else {
         if(this.hasType()) {
            if(this.filterFamily) {
               if(!var1.isOrHasParent(this.filterType)) {
                  return false;
               }
            } else if(!this.filterType.is(var1)) {
               return false;
            }
         }

         return !this.hasIndex() || var2.getId() == this.filterIndex;
      }
   }

   public EntityType getFilterType() {
      return this.filterType;
   }

   public int getFilterIndex() {
      return this.filterIndex;
   }

   @Nullable
   public MetaHandler getHandler() {
      return this.handler;
   }

   public String toString() {
      String var1 = yb.g();
      return "MetaHandlerSettings{filterType=" + this.filterType + ", filterFamily=" + this.filterFamily + ", filterIndex=" + this.filterIndex + ", handler=" + this.handler + '}';
   }

   private static Metadata lambda$removed$1(yb var0) throws RemovedValueException {
      throw RemovedValueException.EX;
   }

   private static Metadata lambda$handleIndexChange$0(int var0, yb var1) throws RemovedValueException {
      Metadata var2 = var1.i();
      var2.setId(var0);
      return var2;
   }
}
