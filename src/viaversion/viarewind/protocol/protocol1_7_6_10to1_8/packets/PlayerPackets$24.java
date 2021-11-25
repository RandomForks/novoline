package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import net.afz;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.items.ItemRewriter;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$24 extends acE {
   public void registerMap() {
      this.a(PlayerPackets$24::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var2 = ((Integer)var0.read(Type.INT)).intValue();
      short var3 = ((Short)var0.read(Type.UNSIGNED_BYTE)).shortValue();
      int var4 = ((Integer)var0.read(Type.INT)).intValue();
      var0.write(Type.POSITION, new Position(var2, var3, var4));
      afz.b();
      var0.passthrough(Type.BYTE);
      Item var5 = (Item)var0.read(axZ.c);
      var5 = ItemRewriter.toServer(var5);
      var0.write(Type.ITEM, var5);
      int var6 = 0;
      if(var6 < 3) {
         var0.passthrough(Type.BYTE);
         ++var6;
      }

   }
}
