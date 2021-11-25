package viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets;

import com.google.gson.JsonElement;
import net.C4;
import net.Gh;
import net.YO;
import net.aNT;
import net.aSG;
import net.acE;
import net.an8;
import net.anB;
import net.anl;
import net.anm;
import net.aqF;
import net.aqX;
import net.axs;
import net.ayd;
import net.g4;
import net.n3;
import net.yb;
import viaversion.viabackwards.api.entities.meta.MetaHandler;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

public class EntityPackets1_16 extends aqF {
   private final ValueTransformer dimensionTransformer = new YO(this, Type.STRING, Type.INT);

   public EntityPackets1_16(Protocol1_15_2To1_16 var1) {
      super(var1);
   }

   protected void registerPackets() {
      this.b(C4.SPAWN_ENTITY, axs.FALLING_BLOCK);
      this.b(C4.SPAWN_MOB);
      ((Protocol1_15_2To1_16)this.c).a(C4.RESPAWN, new anl(this));
      ((Protocol1_15_2To1_16)this.c).a(C4.JOIN_GAME, new an8(this));
      this.registerExtraTracker(C4.SPAWN_EXPERIENCE_ORB, axs.EXPERIENCE_ORB);
      this.registerExtraTracker(C4.SPAWN_PAINTING, axs.PAINTING);
      this.registerExtraTracker(C4.SPAWN_PLAYER, axs.PLAYER);
      this.registerEntityDestroy(C4.DESTROY_ENTITIES);
      this.a(C4.ENTITY_METADATA, aSG.c);
      ((Protocol1_15_2To1_16)this.c).a(C4.ENTITY_PROPERTIES, new anB(this));
      ((Protocol1_15_2To1_16)this.c).a(C4.PLAYER_INFO, new anm(this));
   }

   protected void registerRewrites() {
      this.registerMetaHandler().handle(this::lambda$registerRewrites$0);
      this.mapEntityDirect(axs.ZOMBIFIED_PIGLIN, g4.ZOMBIE_PIGMAN);
      this.mapTypes(axs.values(), g4.class);
      this.mapEntity(axs.HOGLIN, axs.COW).jsonName("Hoglin");
      this.mapEntity(axs.ZOGLIN, axs.COW).jsonName("Zoglin");
      this.mapEntity(axs.PIGLIN, axs.ZOMBIFIED_PIGLIN).jsonName("Piglin");
      this.mapEntity(axs.STRIDER, axs.MAGMA_CUBE).jsonName("Strider");
      aqX.a();
      this.registerMetaHandler().filter(axs.ZOGLIN, 16).removed();
      this.registerMetaHandler().filter(axs.HOGLIN, 15).removed();
      this.registerMetaHandler().filter(axs.PIGLIN, 16).removed();
      this.registerMetaHandler().filter(axs.PIGLIN, 17).removed();
      this.registerMetaHandler().filter(axs.PIGLIN, 18).removed();
      this.registerMetaHandler().filter(axs.STRIDER, 15).handle(EntityPackets1_16::lambda$registerRewrites$1);
      this.registerMetaHandler().filter(axs.STRIDER, 16).removed();
      this.registerMetaHandler().filter(axs.STRIDER, 17).removed();
      this.registerMetaHandler().filter(axs.STRIDER, 18).removed();
      this.registerMetaHandler().filter(axs.FISHING_BOBBER, 8).removed();
      this.registerMetaHandler().filter(axs.ABSTRACT_ARROW, true, 8).removed();
      this.registerMetaHandler().filter(axs.ABSTRACT_ARROW, true).handle(EntityPackets1_16::lambda$registerRewrites$2);
      if(acE.b() == null) {
         aqX.b(new String[1]);
      }

   }

   protected EntityType getTypeFromId(int var1) {
      return aNT.a(var1);
   }

   private static Metadata lambda$registerRewrites$2(yb var0) throws RemovedValueException {
      String[] var1 = aqX.a();
      if(var0.a() >= 8) {
         var0.i().setId(var0.a() + 1);
      }

      return var0.i();
   }

   private static Metadata lambda$registerRewrites$1(yb var0) throws RemovedValueException {
      aqX.a();
      boolean var2 = ((Boolean)var0.i().getCastedValue()).booleanValue();
      var0.i().setValue(Integer.valueOf(var2?1:3));
      var0.i().setMetaType(n3.VarInt);
      return var0.i();
   }

   private Metadata lambda$registerRewrites$0(yb var1) throws RemovedValueException {
      aqX.a();
      Metadata var3 = var1.i();
      MetaType var4 = var3.getMetaType();
      if(var4 == n3.Slot) {
         var3.setValue(((Protocol1_15_2To1_16)this.c).c().a((Item)var3.getValue()));
      }

      if(var4 == n3.BlockID) {
         var3.setValue(Integer.valueOf(((Protocol1_15_2To1_16)this.c).getMappingData().getNewBlockStateId(((Integer)var3.getValue()).intValue())));
      }

      if(var4 == n3.PARTICLE) {
         this.a((Gh)((Gh)var3.getValue()));
      }

      if(var4 == n3.OptChat) {
         JsonElement var5 = (JsonElement)var3.getCastedValue();
         ((Protocol1_15_2To1_16)this.c).getTranslatableRewriter().processText(var5);
      }

      return var3;
   }

   static ValueTransformer access$000(EntityPackets1_16 var0) {
      return var0.dimensionTransformer;
   }

   static ayd a(EntityPackets1_16 var0) {
      return var0.c;
   }

   static ayd b(EntityPackets1_16 var0) {
      return var0.c;
   }

   static ayd d(EntityPackets1_16 var0) {
      return var0.c;
   }

   private static RemovedValueException a(RemovedValueException var0) {
      return var0;
   }
}
