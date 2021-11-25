package viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import net.Gh;
import net.RL;
import net.VV;
import net.aCN;
import net.aCP;
import net.aCp;
import net.aCr;
import net.aCw;
import net.aEY;
import net.a_4;
import net.aci;
import net.aqI;
import net.aqr;
import net.ayk;
import net.q1;
import net.r;
import net.yb;
import viaversion.viabackwards.api.entities.meta.MetaHandler;
import viaversion.viabackwards.api.entities.storage.EntityData$MetaCreator;
import viaversion.viabackwards.api.entities.storage.MetaStorage;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.EntityTypeMapping;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.ParticleMapping$ParticleData;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13$4;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13$6;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets.EntityPackets1_13$8;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_12;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_12;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;

public class EntityPackets1_13 extends aqr {
   public EntityPackets1_13(ayk var1) {
      super(var1);
   }

   protected void registerPackets() {
      ((ayk)this.c).a(q1.PLAYER_POSITION, new aCr(this));
      ((ayk)this.c).a(q1.SPAWN_ENTITY, new aCp(this));
      this.registerExtraTracker(q1.SPAWN_EXPERIENCE_ORB, a_4.EXPERIENCE_ORB);
      this.registerExtraTracker(q1.SPAWN_GLOBAL_ENTITY, a_4.LIGHTNING_BOLT);
      ((ayk)this.c).a(q1.SPAWN_MOB, new aCw(this));
      ((ayk)this.c).a(q1.SPAWN_PLAYER, new EntityPackets1_13$4(this));
      ((ayk)this.c).a(q1.SPAWN_PAINTING, new aCP(this));
      this.b(q1.JOIN_GAME, a_4.PLAYER);
      ((ayk)this.c).a(q1.RESPAWN, new EntityPackets1_13$6(this));
      this.registerEntityDestroy(q1.DESTROY_ENTITIES);
      this.a(q1.ENTITY_METADATA, aEY.a, Types1_12.METADATA_LIST);
      ((ayk)this.c).a(q1.FACE_PLAYER, (ClientboundPacketType)null, new aCN(this));
      if(VV.c().isFix1_13FacePlayer()) {
         EntityPackets1_13$8 var1 = new EntityPackets1_13$8(this);
         ((ayk)this.c).a(r.PLAYER_POSITION, var1);
         ((ayk)this.c).a(r.PLAYER_POSITION_AND_ROTATION, var1);
         ((ayk)this.c).a(r.VEHICLE_MOVE, var1);
      }

   }

   protected void registerRewrites() {
      this.mapEntity(a_4.DROWNED, a_4.ZOMBIE_VILLAGER).mobName("Drowned");
      this.mapEntity(a_4.COD, a_4.SQUID).mobName("Cod");
      this.mapEntity(a_4.SALMON, a_4.SQUID).mobName("Salmon");
      this.mapEntity(a_4.PUFFERFISH, a_4.SQUID).mobName("Puffer Fish");
      this.mapEntity(a_4.TROPICAL_FISH, a_4.SQUID).mobName("Tropical Fish");
      this.mapEntity(a_4.PHANTOM, a_4.PARROT).mobName("Phantom").spawnMetadata(EntityPackets1_13::lambda$registerRewrites$0);
      aqI.a();
      this.mapEntity(a_4.DOLPHIN, a_4.SQUID).mobName("Dolphin");
      this.mapEntity(a_4.TURTLE, a_4.OCELOT).mobName("Turtle");
      this.registerMetaHandler().handle(this::lambda$registerRewrites$1);
      this.registerMetaHandler().filter(a_4.ENTITY, true, 2).handle(EntityPackets1_13::lambda$registerRewrites$2);
      this.registerMetaHandler().filter(a_4.ZOMBIE, true, 15).removed();
      this.registerMetaHandler().filter(a_4.ZOMBIE, true).handle(EntityPackets1_13::lambda$registerRewrites$3);
      this.registerMetaHandler().filter(a_4.TURTLE, 13).removed();
      this.registerMetaHandler().filter(a_4.TURTLE, 14).removed();
      this.registerMetaHandler().filter(a_4.TURTLE, 15).removed();
      this.registerMetaHandler().filter(a_4.TURTLE, 16).removed();
      this.registerMetaHandler().filter(a_4.TURTLE, 17).removed();
      this.registerMetaHandler().filter(a_4.TURTLE, 18).removed();
      this.registerMetaHandler().filter(a_4.ABSTRACT_FISHES, true, 12).removed();
      this.registerMetaHandler().filter(a_4.ABSTRACT_FISHES, true, 13).removed();
      this.registerMetaHandler().filter(a_4.PHANTOM, 12).removed();
      this.registerMetaHandler().filter(a_4.BOAT, 12).removed();
      this.registerMetaHandler().filter(a_4.TRIDENT, 7).removed();
      this.registerMetaHandler().filter(a_4.WOLF, 17).handle(EntityPackets1_13::lambda$registerRewrites$4);
      this.registerMetaHandler().filter(a_4.AREA_EFFECT_CLOUD, 9).handle(this::lambda$registerRewrites$5);
   }

   protected EntityType getTypeFromId(int var1) {
      return RL.a(var1, false);
   }

   protected EntityType getObjectTypeFromId(int var1) {
      return RL.a(var1, true);
   }

   public int getOldEntityId(int var1) {
      return EntityTypeMapping.getOldId(var1);
   }

   private Metadata lambda$registerRewrites$5(yb var1) throws RemovedValueException {
      aqI.a();
      Metadata var3 = var1.i();
      Gh var4 = (Gh)var3.getValue();
      ParticleMapping$ParticleData var5 = aci.a(var4.c());
      int var6 = 0;
      int var7 = 0;
      int[] var8 = var5.a((ayk)this.c, var4.d());
      if(var8.length != 0) {
         if(var5.getHandler().isBlockHandler() && var8[0] == 0) {
            var8[0] = 102;
         }

         var6 = var8[0];
         var7 = var8.length == 2?var8[1]:0;
      }

      var1.a(new Metadata(9, MetaType1_12.VarInt, Integer.valueOf(var5.getHistoryId())));
      var1.a(new Metadata(10, MetaType1_12.VarInt, Integer.valueOf(var6)));
      var1.a(new Metadata(11, MetaType1_12.VarInt, Integer.valueOf(var7)));
      throw RemovedValueException.EX;
   }

   private static Metadata lambda$registerRewrites$4(yb var0) throws RemovedValueException {
      Metadata var1 = var0.i();
      var1.setValue(Integer.valueOf(15 - ((Integer)var1.getValue()).intValue()));
      return var1;
   }

   private static Metadata lambda$registerRewrites$3(yb var0) throws RemovedValueException {
      aqI.a();
      Metadata var2 = var0.i();
      if(var2.getId() > 15) {
         var2.setId(var2.getId() - 1);
      }

      return var2;
   }

   private static Metadata lambda$registerRewrites$2(yb var0) throws RemovedValueException {
      Metadata var2 = var0.i();
      aqI.a();
      String var3 = var2.getValue().toString();
      if(var3.isEmpty()) {
         return var2;
      } else {
         var2.setValue(ChatRewriter.jsonTextToLegacy(var3));
         return var2;
      }
   }

   private Metadata lambda$registerRewrites$1(yb var1) throws RemovedValueException {
      aqI.a();
      Metadata var3 = var1.i();
      int var4 = var3.getMetaType().getTypeID();
      if(var4 == 5) {
         var3.setMetaType(MetaType1_12.String);
         if(var3.getValue() != null) {
            return var3;
         }

         var3.setValue("");
      }

      if(var4 == 6) {
         var3.setMetaType(MetaType1_12.Slot);
         Item var5 = (Item)var3.getValue();
         var3.setValue(((ayk)this.c).a().a(var5));
      }

      if(var4 == 15) {
         var3.setMetaType(MetaType1_12.Discontinued);
      }

      if(var4 > 5) {
         var3.setMetaType(MetaType1_12.byId(var4 - 1));
      }

      return var3;
   }

   private static void lambda$registerRewrites$0(MetaStorage var0) {
      var0.add(new Metadata(15, MetaType1_12.VarInt, Integer.valueOf(3)));
   }

   static PacketHandler access$000(EntityPackets1_13 var0) {
      return var0.c();
   }

   static void access$100(EntityPackets1_13 var0, PacketWrapper var1, int var2, EntityType var3) throws Exception {
      var0.addTrackedEntity(var1, var2, var3);
   }

   static boolean access$200(EntityPackets1_13 var0, EntityType var1) {
      return var0.hasData(var1);
   }

   static PacketHandler access$300(EntityPackets1_13 var0, Type var1) {
      return var0.a(var1);
   }

   static PacketHandler access$400(EntityPackets1_13 var0, Type var1, EntityType var2) {
      return var0.a(var1, var2);
   }

   static PacketHandler access$500(EntityPackets1_13 var0, EntityType var1, Type var2) {
      return var0.getTrackerHandler(var1, var2);
   }

   static PacketHandler access$600(EntityPackets1_13 var0, int var1) {
      return var0.getDimensionHandler(var1);
   }

   private static RemovedValueException a(RemovedValueException var0) {
      return var0;
   }
}
