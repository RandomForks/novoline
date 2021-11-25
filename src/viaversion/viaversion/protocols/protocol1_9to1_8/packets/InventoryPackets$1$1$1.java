package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import net.ME;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

class InventoryPackets$1$1$1 implements ValueCreator {
   final short val$windowId;
   final short val$property;
   final short val$enchantID;
   final ME c;

   InventoryPackets$1$1$1(ME var1, short var2, short var3, short var4) {
      this.c = var1;
      this.val$windowId = var2;
      this.val$property = var3;
      this.val$enchantID = var4;
   }

   public void write(PacketWrapper var1) throws Exception {
      var1.write(Type.UNSIGNED_BYTE, Short.valueOf(this.val$windowId));
      var1.write(Type.SHORT, Short.valueOf(this.val$property));
      var1.write(Type.SHORT, Short.valueOf(this.val$enchantID));
   }
}
