package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.a0W;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class InventoryPackets$8$2$1 implements ValueCreator {
   final short val$windowID;
   final short val$slot;
   final a0W a;

   InventoryPackets$8$2$1(a0W var1, short var2, short var3) {
      this.a = var1;
      this.val$windowID = var2;
      this.val$slot = var3;
   }

   public void write(PacketWrapper var1) throws Exception {
      var1.write(Type.BYTE, Byte.valueOf((byte)this.val$windowID));
      var1.write(Type.SHORT, Short.valueOf(this.val$slot));
      var1.write(Type.ITEM, (Object)null);
   }
}
