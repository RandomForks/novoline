package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import java.util.ArrayList;
import net.aSG;
import net.acE;
import net.agc;
import net.aq3;
import net.g4;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.data.EntityTypeMapping;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class EntityPackets1_15$3 extends acE {
   final aq3 c;

   EntityPackets1_15$3(aq3 var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(Type.UUID);
      this.a(Type.VAR_INT);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(EntityPackets1_15$3::lambda$registerMap$0);
      this.a(this::lambda$registerMap$1);
   }

   private void lambda$registerMap$1(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.get(Type.VAR_INT, 1)).intValue();
      g4 var3 = agc.a(var2);
      aq3.a(this.c, var1, ((Integer)var1.get(Type.VAR_INT, 0)).intValue(), var3);
      var1.set(Type.VAR_INT, 1, Integer.valueOf(EntityTypeMapping.getOldEntityId(var2)));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(aSG.c, new ArrayList());
   }
}
