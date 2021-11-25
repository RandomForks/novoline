package viaversion.viaversion.protocols.protocol1_15to1_14_4.packets;

import net.acE;
import net.awA;
import net.cU;
import net.g4;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$2 extends acE {
   public void registerMap() {
      this.a(Type.INT);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.INT);
      this.a(PlayerPackets$2::lambda$registerMap$0);
      this.a(PlayerPackets$2::lambda$registerMap$1);
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.STRING);
      this.a(Type.VAR_INT);
      this.a(Type.BOOLEAN);
      this.a(PlayerPackets$2::lambda$registerMap$2);
   }

   private static void lambda$registerMap$2(PacketWrapper var0) throws Exception {
      String var1 = awA.b();
      var0.write(Type.BOOLEAN, Boolean.valueOf(!Via.getConfig().is1_15InstantRespawn()));
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      var0.write(Type.LONG, Long.valueOf(0L));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      cU var1 = (cU)var0.user().b(cU.class);
      int var2 = ((Integer)var0.get(Type.INT, 0)).intValue();
      var1.addEntity(var2, g4.PLAYER);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
