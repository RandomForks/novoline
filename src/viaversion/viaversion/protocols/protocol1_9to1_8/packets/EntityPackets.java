package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.Cw;
import net.aMJ;
import net.aMg;
import net.aRY;
import net.aV5;
import net.aVO;
import net.aVa;
import net.aVd;
import net.aVk;
import net.aVt;
import net.aVx;
import net.aXe;
import net.acE;
import net.aeU;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.packets.EntityPackets$1;
import viaversion.viaversion.protocols.protocol1_9to1_8.packets.EntityPackets$4;
import viaversion.viaversion.protocols.protocol1_9to1_8.packets.EntityPackets$5;

public class EntityPackets {
   public static final ValueTransformer toNewShort = new EntityPackets$1(Type.SHORT);

   public static void a(aRY var0) {
      var0.a(aeU.ATTACH_ENTITY, new aVd());
      var0.a(aeU.ENTITY_TELEPORT, new aVa());
      var0.a(aeU.ENTITY_POSITION_AND_ROTATION, new EntityPackets$4());
      var0.a(aeU.ENTITY_POSITION, new EntityPackets$5());
      int var10000 = aXe.c();
      var0.a(aeU.ENTITY_EQUIPMENT, new aV5());
      var0.a(aeU.ENTITY_METADATA, new aVk(var0));
      var0.a(aeU.ENTITY_EFFECT, new aMg());
      var0.cancelOutgoing(aeU.UPDATE_ENTITY_NBT);
      int var1 = var10000;
      var0.a(aeU.COMBAT_EVENT, new aMJ());
      var0.a(aeU.ENTITY_PROPERTIES, new aVO());
      var0.a(Cw.ENTITY_ACTION, new aVt());
      var0.a(Cw.INTERACT_ENTITY, new aVx());
      if(acE.b() == null) {
         ++var1;
         aXe.b(var1);
      }

   }
}
