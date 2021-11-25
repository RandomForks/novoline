package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.a9C;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.items.ReplacementRegistry1_7_6_10to1_8;
import viaversion.viarewind.storage.BlockState;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class WorldPackets$3$2 implements PacketHandler {
   final a9C a;

   WorldPackets$3$2(a9C var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      int var2 = ((Integer)var1.read(Type.VAR_INT)).intValue();
      int var3 = var2 >> 4;
      int var4 = var2 & 15;
      BlockState var5 = ReplacementRegistry1_7_6_10to1_8.replace(new BlockState(var3, var4));
      var3 = var5.getId();
      var4 = var5.getData();
      var1.write(Type.VAR_INT, Integer.valueOf(var3));
      var1.write(Type.UNSIGNED_BYTE, Short.valueOf((short)var4));
   }
}
