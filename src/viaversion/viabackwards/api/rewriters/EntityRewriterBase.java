package viaversion.viabackwards.api.rewriters;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.Gh;
import net.VV;
import net.acE;
import net.aqu;
import net.ayd;
import net.cQ;
import net.cT;
import net.yb;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.entities.meta.MetaHandlerSettings;
import viaversion.viabackwards.api.entities.storage.EntityData;
import viaversion.viabackwards.api.entities.storage.EntityTracker$ProtocolEntityTracker;
import viaversion.viabackwards.api.entities.storage.EntityTracker$StoredEntity;
import viaversion.viabackwards.api.entities.storage.MetaStorage;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viabackwards.api.rewriters.EntityRewriterBase$1;
import viaversion.viabackwards.api.rewriters.EntityRewriterBase$2;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.ParticleMappings;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;
import viaversion.viaversion.exception.CancelException;

public abstract class EntityRewriterBase extends aqu {
   private final Map entityTypes = new HashMap();
   private final List metaHandlers = new ArrayList();
   private final MetaType displayNameMetaType;
   private final MetaType displayVisibilityMetaType;
   private final int displayNameIndex;
   private final int displayVisibilityIndex;
   protected Int2IntMap typeMapping;
   private static acE[] f;

   EntityRewriterBase(ayd var1, MetaType var2, int var3, MetaType var4, int var5) {
      super(var1);
      this.displayNameMetaType = var2;
      this.displayNameIndex = var3;
      this.displayVisibilityMetaType = var4;
      this.displayVisibilityIndex = var5;
   }

   protected EntityType getEntityType(UserConnection var1, int var2) {
      return this.getEntityTracker(var1).getEntityType(var2);
   }

   protected void addTrackedEntity(PacketWrapper var1, int var2, EntityType var3) throws Exception {
      this.getEntityTracker(var1.user()).trackEntityType(var2, var3);
   }

   protected boolean hasData(EntityType var1) {
      return this.entityTypes.containsKey(var1);
   }

   @Nullable
   protected EntityData getEntityData(EntityType var1) {
      return (EntityData)this.entityTypes.get(var1);
   }

   protected EntityData mapEntity(EntityType var1, EntityType var2) {
      Preconditions.checkArgument(var1.getClass() == var2.getClass());
      int var3 = this.getOldEntityId(var2.getId());
      EntityData var4 = new EntityData(var1.getId(), var3);
      this.mapEntityDirect(var1.getId(), var3);
      this.entityTypes.put(var1, var4);
      return var4;
   }

   public void mapTypes(EntityType[] var1, Class var2) {
      int var3 = aqu.d();
      if(this.typeMapping == null) {
         this.typeMapping = new Int2IntOpenHashMap(var1.length, 1.0F);
         this.typeMapping.defaultReturnValue(-1);
      }

      int var5 = var1.length;
      int var6 = 0;
      if(var6 < var5) {
         EntityType var7 = var1[var6];

         try {
            Enum var8 = Enum.valueOf(var2, var7.name());
            this.typeMapping.put(var7.getId(), ((EntityType)var8).getId());
         } catch (IllegalArgumentException var9) {
            ;
         }

         ++var6;
      }

   }

   public void mapEntityDirect(EntityType var1, EntityType var2) {
      Preconditions.checkArgument(var1.getClass() != var2.getClass());
      this.mapEntityDirect(var1.getId(), var2.getId());
   }

   private void mapEntityDirect(int var1, int var2) {
      int var3 = aqu.e();
      if(this.typeMapping == null) {
         this.typeMapping = new Int2IntOpenHashMap();
         this.typeMapping.defaultReturnValue(-1);
      }

      this.typeMapping.put(var1, var2);
   }

   public MetaHandlerSettings registerMetaHandler() {
      MetaHandlerSettings var1 = new MetaHandlerSettings();
      this.metaHandlers.add(var1);
      return var1;
   }

   protected MetaStorage handleMeta(UserConnection var1, int var2, MetaStorage var3) throws Exception {
      aqu.d();
      EntityTracker$StoredEntity var5 = this.getEntityTracker(var1).getEntity(var2);
      if(var5 == null) {
         if(!Via.getConfig().isSuppressMetadataErrors()) {
            VV.d().getLogger().warning("Metadata for entity id: " + var2 + " not sent because the entity doesn\'t exist. " + var3);
         }

         throw CancelException.CACHED;
      } else {
         EntityType var6 = var5.getType();
         Iterator var7 = this.metaHandlers.iterator();
         if(var7.hasNext()) {
            MetaHandlerSettings var8 = (MetaHandlerSettings)var7.next();
            ArrayList var9 = new ArrayList();
            Iterator var10 = var3.getMetaDataList().iterator();
            if(var10.hasNext()) {
               Metadata var11 = (Metadata)var10.next();
               yb var12 = null;

               try {
                  Metadata var13 = var11;
                  if(var8.isGucci(var6, var11)) {
                     var12 = new yb(var1, var5, var11.getId(), var11, var3);
                     var13 = var8.getHandler().a(var12);
                     if(var12.e() != null) {
                        var9.addAll(var12.e());
                        var12.d();
                     }
                  }

                  if(var13 == null) {
                     throw RemovedValueException.EX;
                  }

                  var9.add(var13);
               } catch (RemovedValueException var15) {
                  if(var12 != null && var12.e() != null) {
                     var9.addAll(var12.e());
                  }
               } catch (Exception var16) {
                  Logger var14 = VV.d().getLogger();
                  var14.warning("Unable to handle metadata " + var11 + " for entity type " + var6);
                  var14.warning((String)var3.getMetaDataList().stream().sorted(Comparator.comparingInt(Metadata::getId)).map(Metadata::toString).collect(Collectors.joining("\n", "Full metadata list: ", "")));
                  var16.printStackTrace();
               }
            }

            var3.setMetaDataList(var9);
         }

         Metadata var17 = var3.get(this.displayNameIndex);
         EntityData var18 = this.getEntityData(var6);
         if(var18 != null && var18.getMobName() != null && (var17.getValue() == null || var17.getValue().toString().isEmpty()) && var17.getMetaType().getTypeID() == this.displayNameMetaType.getTypeID()) {
            var17.setValue(var18.getMobName());
            if(VV.c().alwaysShowOriginalMobName()) {
               var3.delete(this.displayVisibilityIndex);
               var3.add(new Metadata(this.displayVisibilityIndex, this.displayVisibilityMetaType, Boolean.valueOf(true)));
            }
         }

         return var3;
      }
   }

   protected void registerExtraTracker(ClientboundPacketType var1, EntityType var2, Type var3) {
      this.c().a(var1, new EntityRewriterBase$1(this, var3, var2));
   }

   protected void registerExtraTracker(ClientboundPacketType var1, EntityType var2) {
      this.registerExtraTracker(var1, var2, Type.VAR_INT);
   }

   protected void registerEntityDestroy(ClientboundPacketType var1) {
      this.c().a(var1, new EntityRewriterBase$2(this));
   }

   protected PacketHandler getTrackerHandler(Type var1, int var2) {
      return this::lambda$getTrackerHandler$0;
   }

   protected PacketHandler getTrackerHandler() {
      return this.getTrackerHandler(Type.VAR_INT, 1);
   }

   protected PacketHandler getTrackerHandler(EntityType var1, Type var2) {
      return this::lambda$getTrackerHandler$1;
   }

   protected PacketHandler getDimensionHandler(int var1) {
      return EntityRewriterBase::lambda$getDimensionHandler$2;
   }

   public EntityTracker$ProtocolEntityTracker getEntityTracker(UserConnection var1) {
      return ((cQ)var1.b(cQ.class)).a(this.c());
   }

   protected void a(Gh var1) {
      aqu.d();
      ParticleMappings var3 = this.c.getMappingData().getParticleMappings();
      int var4 = var1.c();
      if(var4 == var3.getBlockId() || var4 == var3.getFallingDustId()) {
         Particle$ParticleData var5 = (Particle$ParticleData)var1.d().get(0);
         var5.setValue(Integer.valueOf(this.c.getMappingData().getNewBlockStateId(((Integer)var5.get()).intValue())));
      }

      if(var4 == var3.getItemId()) {
         Particle$ParticleData var6 = (Particle$ParticleData)var1.d().get(0);
         var6.setValue(Integer.valueOf(this.c.getMappingData().getNewItemId(((Integer)var6.get()).intValue())));
      }

      var1.a(this.c.getMappingData().getNewParticleId(var4));
   }

   protected abstract EntityType getTypeFromId(int var1);

   public int getOldEntityId(int var1) {
      int var2 = aqu.d();
      return this.typeMapping != null?this.typeMapping.getOrDefault(var1, var1):var1;
   }

   private static void lambda$getDimensionHandler$2(int var0, PacketWrapper var1) throws Exception {
      cT var2 = (cT)var1.user().b(cT.class);
      int var3 = ((Integer)var1.get(Type.INT, var0)).intValue();
      var2.c(var3);
   }

   private void lambda$getTrackerHandler$1(Type var1, EntityType var2, PacketWrapper var3) throws Exception {
      this.addTrackedEntity(var3, ((Integer)var3.get(var1, 0)).intValue(), var2);
   }

   private void lambda$getTrackerHandler$0(Type var1, int var2, PacketWrapper var3) throws Exception {
      Number var4 = (Number)var3.get(var1, var2);
      this.addTrackedEntity(var3, ((Integer)var3.get(Type.VAR_INT, 0)).intValue(), this.getTypeFromId(var4.intValue()));
   }

   public static void a(acE[] var0) {
      f = var0;
   }

   public static acE[] a() {
      return f;
   }

   private static Exception c(Exception var0) {
      return var0;
   }

   static {
      a((acE[])null);
   }
}
