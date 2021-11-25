package viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import java.util.Iterator;
import java.util.List;
import net.a1R;
import net.q1;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_13_2;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.types.version.Types1_13_2;
import viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets.EntityPackets$1;
import viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets.EntityPackets$2;
import viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets.EntityPackets$3;

public class EntityPackets {
   public static void register(Protocol var0) {
      PacketHandler var1 = EntityPackets::lambda$register$0;
      var0.a((ClientboundPacketType)q1.SPAWN_MOB, new EntityPackets$1(var1));
      var0.a((ClientboundPacketType)q1.SPAWN_PLAYER, new EntityPackets$2(var1));
      var0.a((ClientboundPacketType)q1.ENTITY_METADATA, new EntityPackets$3(var1));
   }

   private static void lambda$register$0(PacketWrapper var0) throws Exception {
      a1R.b();
      Iterator var2 = ((List)var0.get(Types1_13_2.METADATA_LIST, 0)).iterator();
      if(var2.hasNext()) {
         Metadata var3 = (Metadata)var2.next();
         var3.setMetaType(MetaType1_13_2.byId(var3.getMetaType().getTypeID()));
      }

   }
}
