package viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import net.aSG;
import net.aTM;
import net.aW1;
import net.aW6;
import net.aWe;
import net.awj;
import net.q1;
import viaversion.viaversion.api.type.types.version.Types1_13_2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.EntityPackets$2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.EntityPackets$3;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.EntityPackets$4;

public class EntityPackets {
   public static void register(Protocol1_14To1_13_2 var0) {
      aTM var1 = (aTM)var0.get(aTM.class);
      var0.a(q1.SPAWN_ENTITY, new aW1(var1, var0));
      var0.a(q1.SPAWN_MOB, new EntityPackets$2(var1));
      var0.a(q1.SPAWN_PAINTING, new EntityPackets$3());
      var0.a(q1.SPAWN_PLAYER, new EntityPackets$4(var1));
      var0.a(q1.ENTITY_ANIMATION, new aW6());
      var0.a(q1.USE_BED, awj.ENTITY_METADATA, new aWe());
      var1.registerEntityDestroy(q1.DESTROY_ENTITIES);
      var1.registerMetadataRewriter(q1.ENTITY_METADATA, Types1_13_2.METADATA_LIST, aSG.c);
   }
}
