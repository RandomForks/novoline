package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aM6;
import net.aRY;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class WorldPackets$11$1 implements ValueCreator {
   final aM6 a;

   WorldPackets$11$1(aM6 var1) {
      this.a = var1;
   }

   public void write(PacketWrapper var1) throws Exception {
      Item var2 = aRY.a(var1.user());
      var1.write(Type.ITEM, var2);
   }
}
