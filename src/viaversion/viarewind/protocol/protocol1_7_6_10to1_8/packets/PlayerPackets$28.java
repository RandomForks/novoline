package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import net.acE;
import net.afz;
import viaversion.viarewind.utils.ChatUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.util.GsonUtil;

final class PlayerPackets$28 extends acE {
   public void registerMap() {
      this.a(PlayerPackets$28::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      int var2 = ((Integer)var0.read(Type.INT)).intValue();
      short var3 = ((Short)var0.read(Type.SHORT)).shortValue();
      int var4 = ((Integer)var0.read(Type.INT)).intValue();
      afz.b();
      var0.write(Type.POSITION, new Position(var2, var3, var4));
      int var5 = 0;
      if(var5 < 4) {
         String var6 = (String)var0.read(Type.STRING);
         var6 = ChatUtil.legacyToJson(var6);
         var0.write(Type.COMPONENT, GsonUtil.getJsonParser().parse(var6));
         ++var5;
      }

   }
}
