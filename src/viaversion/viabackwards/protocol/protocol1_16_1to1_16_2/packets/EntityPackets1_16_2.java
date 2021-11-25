package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import java.util.Set;
import net.Gh;
import net.UN;
import net.aAA;
import net.aSG;
import net.acE;
import net.aqF;
import net.aqG;
import net.awD;
import net.axs;
import net.n3;
import net.yb;
import viaversion.viabackwards.api.entities.meta.MetaHandler;
import viaversion.viabackwards.api.exceptions.RemovedValueException;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.EntityPackets1_16_2$1;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.EntityPackets1_16_2$2;
import viaversion.viaversion.api.entities.EntityType;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

public class EntityPackets1_16_2 extends aqF {
   private final Set oldDimensions = Sets.newHashSet(new String[]{"minecraft:overworld", "minecraft:the_nether", "minecraft:the_end"});

   public EntityPackets1_16_2(Protocol1_16_1To1_16_2 var1) {
      super(var1);
   }

   protected void registerPackets() {
      aqG.c();
      this.b(UN.SPAWN_ENTITY, awD.FALLING_BLOCK);
      this.b(UN.SPAWN_MOB);
      this.registerExtraTracker(UN.SPAWN_EXPERIENCE_ORB, awD.EXPERIENCE_ORB);
      this.registerExtraTracker(UN.SPAWN_PAINTING, awD.PAINTING);
      this.registerExtraTracker(UN.SPAWN_PLAYER, awD.PLAYER);
      this.registerEntityDestroy(UN.DESTROY_ENTITIES);
      this.a(UN.ENTITY_METADATA, aSG.c);
      ((Protocol1_16_1To1_16_2)this.c).a(UN.JOIN_GAME, new EntityPackets1_16_2$1(this));
      ((Protocol1_16_1To1_16_2)this.c).a(UN.RESPAWN, new EntityPackets1_16_2$2(this));
      if(acE.b() == null) {
         aqG.b(false);
      }

   }

   private String getDimensionFromData(CompoundTag var1) {
      StringTag var2 = (StringTag)var1.get("effects");
      return this.oldDimensions.contains(var2.getValue())?var2.getValue():"minecraft:overworld";
   }

   protected void registerRewrites() {
      this.registerMetaHandler().handle(this::lambda$registerRewrites$0);
      this.mapTypes(awD.values(), axs.class);
      this.mapEntity(awD.PIGLIN_BRUTE, awD.PIGLIN).jsonName("Piglin Brute");
      this.registerMetaHandler().filter(awD.ABSTRACT_PIGLIN, true).handle(EntityPackets1_16_2::lambda$registerRewrites$1);
   }

   protected EntityType getTypeFromId(int var1) {
      return aAA.a(var1);
   }

   private static Metadata lambda$registerRewrites$1(yb var0) throws RemovedValueException {
      boolean var1 = aqG.d();
      if(var0.a() == 15) {
         var0.i().setId(16);
      }

      if(var0.a() == 16) {
         var0.i().setId(15);
      }

      return var0.i();
   }

   private Metadata lambda$registerRewrites$0(yb var1) throws RemovedValueException {
      aqG.d();
      Metadata var3 = var1.i();
      MetaType var4 = var3.getMetaType();
      if(var4 == n3.Slot) {
         var3.setValue(((Protocol1_16_1To1_16_2)this.c).a().a((Item)var3.getValue()));
      }

      if(var4 == n3.BlockID) {
         var3.setValue(Integer.valueOf(((Protocol1_16_1To1_16_2)this.c).getMappingData().getNewBlockStateId(((Integer)var3.getValue()).intValue())));
      }

      if(var4 == n3.OptChat) {
         JsonElement var5 = (JsonElement)var3.getCastedValue();
         ((Protocol1_16_1To1_16_2)this.c).getTranslatableRewriter().processText(var5);
      }

      if(var4 == n3.PARTICLE) {
         this.a((Gh)var3.getValue());
      }

      return var3;
   }

   static PacketHandler access$000(EntityPackets1_16_2 var0, EntityType var1, Type var2) {
      return var0.getTrackerHandler(var1, var2);
   }

   static String access$100(EntityPackets1_16_2 var0, CompoundTag var1) {
      return var0.getDimensionFromData(var1);
   }

   private static RemovedValueException a(RemovedValueException var0) {
      return var0;
   }
}
