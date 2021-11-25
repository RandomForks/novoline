package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.aNs;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class InventoryPackets$7$2$1 implements ValueCreator {
   final short val$slot;
   final aNs b;

   InventoryPackets$7$2$1(aNs var1, short var2) {
      this.b = var1;
      this.val$slot = var2;
   }

   public void write(PacketWrapper var1) throws Exception {
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.SHORT, Short.valueOf(this.val$slot));
      var1.write(Type.ITEM, (Object)null);
   }
}
