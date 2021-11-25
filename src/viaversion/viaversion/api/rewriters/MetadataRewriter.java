package viaversion.viaversion.api.rewriters;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import net.Gh;
import net.a7N;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.ParticleMappings;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.MetadataRewriter$1;
import viaversion.viaversion.api.rewriters.MetadataRewriter$3;
import viaversion.viaversion.api.rewriters.MetadataRewriter$4;
import viaversion.viaversion.api.rewriters.MetadataRewriter$5;
import viaversion.viaversion.api.storage.EntityTracker;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.Particle$ParticleData;

public abstract class MetadataRewriter {
   private final Class entityTrackerClass;
   protected final Protocol protocol;
   private Int2IntMap typeMapping;
   private static boolean d;

   protected MetadataRewriter(Protocol var1, Class var2) {
      this.protocol = var1;
      this.entityTrackerClass = var2;
      var1.put(this);
   }

   public final void handleMetadata(int var1, List var2, UserConnection var3) {
      EntityType var5 = ((EntityTracker)var3.b(this.entityTrackerClass)).getEntity(var1);
      c();
      Iterator var6 = (new ArrayList(var2)).iterator();
      if(var6.hasNext()) {
         Metadata var7 = (Metadata)var6.next();
         MetadataRewriter var10000 = this;
         int var10001 = var1;
         EntityType var10002 = var5;
         Metadata var10003 = var7;
         List var10004 = var2;
         UserConnection var10005 = var3;

         try {
            var10000.handleMetadata(var10001, var10002, var10003, var10004, var10005);
         } catch (Exception var10) {
            var2.remove(var7);
            if(!Via.getConfig().isSuppressMetadataErrors() || Via.getManager().isDebug()) {
               Logger var9 = Via.getPlatform().getLogger();
               var9.warning("An error occurred with entity metadata handler");
               var9.warning("This is most likely down to one of your plugins sending bad datawatchers. Please test if this occurs without any plugins except ViaVersion before reporting it on GitHub");
               var9.warning("Also make sure that all your plugins are compatible with your server version.");
               var9.warning("Entity type: " + var5);
               var9.warning("Metadata: " + var7);
               var10.printStackTrace();
            }
         }
      }

   }

   protected void a(Gh var1) {
      e();
      ParticleMappings var3 = this.protocol.getMappingData().getParticleMappings();
      int var4 = var1.c();
      if(var4 == var3.getBlockId() || var4 == var3.getFallingDustId()) {
         Particle$ParticleData var5 = (Particle$ParticleData)var1.d().get(0);
         var5.setValue(Integer.valueOf(this.protocol.getMappingData().getNewBlockStateId(((Integer)var5.get()).intValue())));
      }

      if(var4 == var3.getItemId()) {
         Particle$ParticleData var6 = (Particle$ParticleData)var1.d().get(0);
         var6.setValue(Integer.valueOf(this.protocol.getMappingData().getNewItemId(((Integer)var6.get()).intValue())));
      }

      var1.a(this.protocol.getMappingData().getNewParticleId(var4));
   }

   public void registerTracker(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new MetadataRewriter$1(this));
   }

   public void registerSpawnTrackerWithData(ClientboundPacketType var1, EntityType var2) {
      this.protocol.a((ClientboundPacketType)var1, new a7N(this, var2));
   }

   public void registerTracker(ClientboundPacketType var1, EntityType var2) {
      this.protocol.a((ClientboundPacketType)var1, new MetadataRewriter$3(this, var2));
   }

   public void registerEntityDestroy(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new MetadataRewriter$4(this));
   }

   public void registerMetadataRewriter(ClientboundPacketType var1, @Nullable Type var2, Type var3) {
      this.protocol.a((ClientboundPacketType)var1, new MetadataRewriter$5(this, var2, var3));
   }

   public void registerMetadataRewriter(ClientboundPacketType var1, Type var2) {
      this.registerMetadataRewriter(var1, (Type)null, var2);
   }

   public void mapTypes(EntityType[] var1, Class var2) {
      boolean var3 = e();
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
            if(!this.typeMapping.containsKey(var7.getId())) {
               Via.getPlatform().getLogger().warning("Could not find new entity type for " + var7 + "! Old type: " + var7.getClass().getEnclosingClass().getCanonicalName() + ", new type: " + var2.getEnclosingClass().getCanonicalName());
            }
         }

         ++var6;
      }

   }

   public void mapType(EntityType var1, EntityType var2) {
      boolean var3 = e();
      if(this.typeMapping == null) {
         this.typeMapping = new Int2IntOpenHashMap();
         this.typeMapping.defaultReturnValue(-1);
      }

      this.typeMapping.put(var1.getId(), var2.getId());
   }

   public PacketHandler getTracker() {
      return this.getTrackerAndRewriter((Type)null);
   }

   public PacketHandler getTrackerAndRewriter(@Nullable Type var1) {
      return this::lambda$getTrackerAndRewriter$0;
   }

   public PacketHandler getTrackerAndRewriter(@Nullable Type var1, EntityType var2) {
      return this::lambda$getTrackerAndRewriter$1;
   }

   public PacketHandler getObjectTracker() {
      return this::lambda$getObjectTracker$2;
   }

   protected abstract EntityType getTypeFromId(int var1);

   protected EntityType getObjectTypeFromId(int var1) {
      return this.getTypeFromId(var1);
   }

   public int getNewEntityId(int var1) {
      boolean var2 = c();
      return this.typeMapping != null?this.typeMapping.getOrDefault(var1, var1):var1;
   }

   protected abstract void handleMetadata(int var1, @Nullable EntityType var2, Metadata var3, List var4, UserConnection var5) throws Exception;

   @Nullable
   protected Metadata getMetaByIndex(int var1, List var2) {
      e();
      Iterator var4 = var2.iterator();
      if(var4.hasNext()) {
         Metadata var5 = (Metadata)var4.next();
         if(var5.getId() == var1) {
            return var5;
         }
      }

      return null;
   }

   private void lambda$getObjectTracker$2(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.get(Type.VAR_INT, 0)).intValue();
      byte var3 = ((Byte)var1.get(Type.BYTE, 0)).byteValue();
      EntityType var4 = this.getObjectTypeFromId(var3);
      ((EntityTracker)var1.user().b(this.entityTrackerClass)).addEntity(var2, var4);
   }

   private void lambda$getTrackerAndRewriter$1(EntityType var1, Type var2, PacketWrapper var3) throws Exception {
      int var4 = ((Integer)var3.get(Type.VAR_INT, 0)).intValue();
      ((EntityTracker)var3.user().b(this.entityTrackerClass)).addEntity(var4, var1);
      this.handleMetadata(var4, (List)var3.get(var2, 0), var3.user());
   }

   private void lambda$getTrackerAndRewriter$0(Type var1, PacketWrapper var2) throws Exception {
      int var3 = ((Integer)var2.get(Type.VAR_INT, 0)).intValue();
      int var4 = ((Integer)var2.get(Type.VAR_INT, 1)).intValue();
      int var5 = this.getNewEntityId(var4);
      if(var5 != var4) {
         var2.set(Type.VAR_INT, 1, Integer.valueOf(var5));
      }

      EntityType var6 = this.getTypeFromId(var5);
      ((EntityTracker)var2.user().b(this.entityTrackerClass)).addEntity(var3, var6);
      this.handleMetadata(var3, (List)var2.get(var1, 0), var2.user());
   }

   static Class access$000(MetadataRewriter var0) {
      return var0.entityTrackerClass;
   }

   public static void b(boolean var0) {
      d = var0;
   }

   public static boolean e() {
      return d;
   }

   public static boolean c() {
      boolean var0 = e();
      return true;
   }

   private static Exception b(Exception var0) {
      return var0;
   }

   static {
      b(true);
   }
}
