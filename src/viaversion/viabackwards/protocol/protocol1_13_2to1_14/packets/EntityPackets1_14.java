package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import java.util.function.Supplier;
import net.Gh;
import net.N0;
import net.VV;
import net.aSG;
import net.a_4;
import net.acE;
import net.ao8;
import net.aoB;
import net.aoF;
import net.aoS;
import net.aol;
import net.aou;
import net.aq6;
import net.aqr;
import net.awj;
import net.ayd;
import net.jh;
import net.yb;
import net.z8;
import viaversion.viabackwards.api.entities.meta.MetaHandler;
import viaversion.viabackwards.api.entities.storage.EntityData;
import viaversion.viabackwards.api.entities.storage.EntityPositionHandler;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.Protocol1_13_2To1_14;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14$2;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14$6;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14$7;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14$8;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14$9;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage.EntityPositionStorage1_14;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.minecraft.VillagerData;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_13_2;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_13_2;

public class EntityPackets1_14 extends aqr {
   private EntityPositionHandler positionHandler;

   public EntityPackets1_14(Protocol1_13_2To1_14 var1) {
      super(var1, MetaType1_13_2.OptChat, MetaType1_13_2.Boolean);
   }

   protected void addTrackedEntity(PacketWrapper var1, int var2, EntityType var3) throws Exception {
      aq6.a();
      super.addTrackedEntity(var1, var2, var3);
      if(var3 == N0.PAINTING) {
         Position var5 = (Position)var1.get(Type.POSITION, 0);
         z8.a(this.positionHandler, var1, (double)var5.getX(), (double)var5.getY(), (double)var5.getZ(), true, false);
      }

      if(var1.getId() != 37) {
         this.positionHandler.cacheEntityPosition(var1, true, false);
      }

   }

   protected void registerPackets() {
      this.positionHandler = new EntityPositionHandler(this, EntityPositionStorage1_14.class, EntityPositionStorage1_14::<init>);
      ((Protocol1_13_2To1_14)this.c).a(awj.ENTITY_STATUS, new aol(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.ENTITY_TELEPORT, new EntityPackets1_14$2(this));
      aou var1 = new aou(this);
      ((Protocol1_13_2To1_14)this.c).a(awj.ENTITY_POSITION, var1);
      ((Protocol1_13_2To1_14)this.c).a(awj.ENTITY_POSITION_AND_ROTATION, var1);
      ((Protocol1_13_2To1_14)this.c).a(awj.SPAWN_ENTITY, new aoS(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.SPAWN_MOB, new aoF(this));
      ((Protocol1_13_2To1_14)this.c()).a(awj.SPAWN_EXPERIENCE_ORB, new EntityPackets1_14$6(this));
      ((Protocol1_13_2To1_14)this.c()).a(awj.SPAWN_GLOBAL_ENTITY, new EntityPackets1_14$7(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.SPAWN_PAINTING, new EntityPackets1_14$8(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.SPAWN_PLAYER, new EntityPackets1_14$9(this));
      this.registerEntityDestroy(awj.DESTROY_ENTITIES);
      this.a(awj.ENTITY_METADATA, aSG.c, Types1_13_2.METADATA_LIST);
      ((Protocol1_13_2To1_14)this.c).a(awj.JOIN_GAME, new ao8(this));
      ((Protocol1_13_2To1_14)this.c).a(awj.RESPAWN, new aoB(this));
   }

   protected void registerRewrites() {
      this.mapTypes(N0.values(), a_4.class);
      this.mapEntity(N0.CAT, N0.OCELOT).jsonName("Cat");
      this.mapEntity(N0.TRADER_LLAMA, N0.LLAMA).jsonName("Trader Llama");
      this.mapEntity(N0.FOX, N0.WOLF).jsonName("Fox");
      this.mapEntity(N0.PANDA, N0.POLAR_BEAR).jsonName("Panda");
      this.mapEntity(N0.PILLAGER, N0.VILLAGER).jsonName("Pillager");
      aq6.a();
      this.mapEntity(N0.WANDERING_TRADER, N0.VILLAGER).jsonName("Wandering Trader");
      this.mapEntity(N0.RAVAGER, N0.COW).jsonName("Ravager");
      this.registerMetaHandler().handle(this::lambda$registerRewrites$0);
      this.registerMetaHandler().filter(N0.PILLAGER, 15).removed();
      this.registerMetaHandler().filter(N0.FOX, 15).removed();
      this.registerMetaHandler().filter(N0.FOX, 16).removed();
      this.registerMetaHandler().filter(N0.FOX, 17).removed();
      this.registerMetaHandler().filter(N0.FOX, 18).removed();
      this.registerMetaHandler().filter(N0.PANDA, 15).removed();
      this.registerMetaHandler().filter(N0.PANDA, 16).removed();
      this.registerMetaHandler().filter(N0.PANDA, 17).removed();
      this.registerMetaHandler().filter(N0.PANDA, 18).removed();
      this.registerMetaHandler().filter(N0.PANDA, 19).removed();
      this.registerMetaHandler().filter(N0.PANDA, 20).removed();
      this.registerMetaHandler().filter(N0.CAT, 18).removed();
      this.registerMetaHandler().filter(N0.CAT, 19).removed();
      this.registerMetaHandler().filter(N0.CAT, 20).removed();
      this.registerMetaHandler().handle(EntityPackets1_14::lambda$registerRewrites$1);
      this.registerMetaHandler().filter(N0.AREA_EFFECT_CLOUD, 10).handle(this::lambda$registerRewrites$2);
      this.registerMetaHandler().filter(N0.FIREWORK_ROCKET, 8).handle(EntityPackets1_14::lambda$registerRewrites$3);
      this.registerMetaHandler().filter(N0.ABSTRACT_ARROW, true).handle(EntityPackets1_14::lambda$registerRewrites$4);
      this.registerMetaHandler().filter(N0.VILLAGER, 15).removed();
      MetaHandler var2 = this::lambda$registerRewrites$5;
      this.registerMetaHandler().filter(N0.ZOMBIE_VILLAGER, 18).handle(var2);
      this.registerMetaHandler().filter(N0.VILLAGER, 16).handle(var2);
      this.registerMetaHandler().filter(N0.ABSTRACT_SKELETON, true, 13).handle(EntityPackets1_14::lambda$registerRewrites$6);
      this.registerMetaHandler().filter(N0.ZOMBIE, true, 13).handle(EntityPackets1_14::lambda$registerRewrites$7);
      this.registerMetaHandler().filter(N0.ZOMBIE, true).handle(EntityPackets1_14::lambda$registerRewrites$8);
      this.registerMetaHandler().filter(N0.LIVINGENTITY, true).handle(EntityPackets1_14::lambda$registerRewrites$9);
      this.registerMetaHandler().handle(EntityPackets1_14::lambda$registerRewrites$10);
      this.registerMetaHandler().handle(EntityPackets1_14::lambda$registerRewrites$11);
      this.registerMetaHandler().filter(N0.OCELOT, 13).handle(EntityPackets1_14::lambda$registerRewrites$12);
      this.registerMetaHandler().filter(N0.CAT).handle(EntityPackets1_14::lambda$registerRewrites$13);
   }

   public int villagerDataToProfession(VillagerData var1) {
      acE[] var2 = aq6.a();
      switch(var1.getProfession()) {
      case 0:
      case 11:
      default:
         return 5;
      case 1:
      case 10:
      case 13:
      case 14:
         return 3;
      case 2:
      case 8:
         return 4;
      case 3:
      case 9:
         return 1;
      case 4:
         return 2;
      case 5:
      case 6:
      case 7:
      case 12:
         return 0;
      }
   }

   protected EntityType getTypeFromId(int var1) {
      return jh.a(var1);
   }

   private static Metadata lambda$registerRewrites$13(yb var0) throws RemovedValueException {
      aq6.a();
      Metadata var2 = var0.i();
      if(var2.getId() == 15) {
         var2.setValue(Integer.valueOf(1));
      }

      if(var2.getId() == 13) {
         var2.setValue(Byte.valueOf((byte)(((Byte)var2.getValue()).byteValue() & 4)));
      }

      return var2;
   }

   private static Metadata lambda$registerRewrites$12(yb var0) throws RemovedValueException {
      Metadata var1 = var0.i();
      var1.setId(15);
      var1.setMetaType(MetaType1_13_2.VarInt);
      var1.setValue(Integer.valueOf(0));
      return var1;
   }

   private static Metadata lambda$registerRewrites$11(yb var0) throws RemovedValueException {
      aq6.a();
      Metadata var2 = var0.i();
      int var3 = var2.getMetaType().getTypeID();
      if(var3 > 15) {
         VV.d().getLogger().warning("New 1.14 metadata was not handled: " + var2 + " entity: " + var0.h().getType());
         return null;
      } else {
         return var2;
      }
   }

   private static Metadata lambda$registerRewrites$10(yb var0) throws RemovedValueException {
      Metadata var2 = var0.i();
      aq6.a();
      int var3 = var0.a();
      if(var3 == 6) {
         throw RemovedValueException.EX;
      } else {
         if(var3 > 6) {
            var2.setId(var3 - 1);
         }

         return var2;
      }
   }

   private static Metadata lambda$registerRewrites$9(yb var0) throws RemovedValueException {
      aq6.a();
      Metadata var2 = var0.i();
      int var3 = var0.a();
      if(var3 == 12) {
         Position var4 = (Position)var2.getValue();
         PacketWrapper var5 = new PacketWrapper(51, (ByteBuf)null, var0.f());
         var5.write(Type.VAR_INT, Integer.valueOf(var0.h().getEntityId()));
         var5.write(Type.POSITION, var4);
         PacketWrapper var10000 = var5;
         Class var10001 = Protocol1_13_2To1_14.class;

         try {
            var10000.send(var10001);
         } catch (Exception var7) {
            var7.printStackTrace();
         }

         throw RemovedValueException.EX;
      } else {
         if(var3 > 12) {
            var2.setId(var3 - 1);
         }

         return var2;
      }
   }

   private static Metadata lambda$registerRewrites$8(yb var0) throws RemovedValueException {
      Metadata var1 = var0.i();
      int var2 = var0.a();
      if(var2 >= 16) {
         var1.setId(var2 + 1);
      }

      return var1;
   }

   private static Metadata lambda$registerRewrites$7(yb var0) throws RemovedValueException {
      byte var1 = ((Byte)var0.i().getValue()).byteValue();
      if((var1 & 4) != 0) {
         var0.a(new Metadata(16, MetaType1_13_2.Boolean, Boolean.valueOf(true)));
      }

      return var0.i();
   }

   private static Metadata lambda$registerRewrites$6(yb var0) throws RemovedValueException {
      byte var1 = ((Byte)var0.i().getValue()).byteValue();
      if((var1 & 4) != 0) {
         var0.a(new Metadata(14, MetaType1_13_2.Boolean, Boolean.valueOf(true)));
      }

      return var0.i();
   }

   private Metadata lambda$registerRewrites$5(yb var1) throws RemovedValueException {
      aq6.a();
      Metadata var3 = var1.i();
      VillagerData var4 = (VillagerData)var3.getValue();
      var3.setValue(Integer.valueOf(this.villagerDataToProfession(var4)));
      var3.setMetaType(MetaType1_13_2.VarInt);
      if(var3.getId() == 16) {
         var3.setId(15);
      }

      return var3;
   }

   private static Metadata lambda$registerRewrites$4(yb var0) throws RemovedValueException {
      Metadata var2 = var0.i();
      aq6.a();
      int var3 = var0.a();
      if(var3 == 9) {
         throw RemovedValueException.EX;
      } else {
         if(var3 > 9) {
            var2.setId(var3 - 1);
         }

         return var2;
      }
   }

   private static Metadata lambda$registerRewrites$3(yb var0) throws RemovedValueException {
      Metadata var1 = var0.i();
      var1.setMetaType(MetaType1_13_2.VarInt);
      Integer var2 = (Integer)var1.getValue();
      var1.setValue(Integer.valueOf(0));
      return var1;
   }

   private Metadata lambda$registerRewrites$2(yb var1) throws RemovedValueException {
      Metadata var2 = var1.i();
      this.a((Gh)var2.getValue());
      return var2;
   }

   private static Metadata lambda$registerRewrites$1(yb var0) throws RemovedValueException {
      aq6.a();
      EntityType var2 = var0.h().getType();
      Metadata var3 = var0.i();
      if(var2.isOrHasParent(N0.ABSTRACT_ILLAGER_BASE) || var2 == N0.RAVAGER || var2 == N0.WITCH) {
         int var4 = var0.a();
         if(var4 == 14) {
            throw RemovedValueException.EX;
         }

         if(var4 > 14) {
            var3.setId(var4 - 1);
         }
      }

      return var3;
   }

   private Metadata lambda$registerRewrites$0(yb var1) throws RemovedValueException {
      aq6.a();
      Metadata var3 = var1.i();
      int var4 = var3.getMetaType().getTypeID();
      if(var4 <= 15) {
         var3.setMetaType(MetaType1_13_2.byId(var4));
      }

      MetaType var5 = var3.getMetaType();
      if(var5 == MetaType1_13_2.Slot) {
         Item var6 = (Item)var3.getValue();
         var3.setValue(((Protocol1_13_2To1_14)this.c()).b().a(var6));
      }

      if(var5 == MetaType1_13_2.BlockID) {
         int var7 = ((Integer)var3.getValue()).intValue();
         var3.setValue(Integer.valueOf(((Protocol1_13_2To1_14)this.c).getMappingData().getNewBlockStateId(var7)));
      }

      return var3;
   }

   static EntityPositionHandler access$000(EntityPackets1_14 var0) {
      return var0.positionHandler;
   }

   static PacketHandler access$100(EntityPackets1_14 var0) {
      return var0.c();
   }

   static ayd b(EntityPackets1_14 var0) {
      return var0.c;
   }

   static Int2IntMap access$300(EntityPackets1_14 var0) {
      return var0.typeMapping;
   }

   static EntityData access$400(EntityPackets1_14 var0, EntityType var1) {
      return var0.getEntityData(var1);
   }

   static PacketHandler access$500(EntityPackets1_14 var0, Type var1) {
      return var0.a(var1);
   }

   static PacketHandler access$600(EntityPackets1_14 var0, Type var1, EntityType var2) {
      return var0.a(var1, var2);
   }

   static PacketHandler access$700(EntityPackets1_14 var0, EntityType var1, Type var2) {
      return var0.getTrackerHandler(var1, var2);
   }

   static PacketHandler access$800(EntityPackets1_14 var0, int var1) {
      return var0.getDimensionHandler(var1);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
