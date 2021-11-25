package viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import net.aEY;
import net.aTW;
import net.aWW;
import net.azW;
import viaversion.viaversion.api.type.types.version.Types1_12;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.EntityPackets$2;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.EntityPackets$3;

public class EntityPackets {
   public static void register(Protocol1_13To1_12_2 var0) {
      aTW var1 = (aTW)var0.get(aTW.class);
      var0.a(azW.SPAWN_ENTITY, new aWW());
      var0.a(azW.SPAWN_MOB, new EntityPackets$2(var1));
      var0.a(azW.SPAWN_PLAYER, new EntityPackets$3(var1));
      var1.registerEntityDestroy(azW.DESTROY_ENTITIES);
      var1.registerMetadataRewriter(azW.ENTITY_METADATA, Types1_12.METADATA_LIST, aEY.a);
   }
}
