package viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import net.aRX;
import net.acE;
import net.awD;
import net.c1;
import net.dJ;
import net.lH;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class EntityPackets$1 extends acE {
   final aRX c;

   EntityPackets$1(aRX var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(Type.INT);
      this.a(EntityPackets$1::lambda$registerMap$0);
      this.a(Type.BYTE);
      this.a(Type.STRING_ARRAY);
      this.a(EntityPackets$1::lambda$registerMap$1);
      this.a(Type.STRING);
      this.a(Type.LONG);
      this.a(Type.UNSIGNED_BYTE, Type.VAR_INT);
      this.a(EntityPackets$1::lambda$registerMap$2);
   }

   private static void lambda$registerMap$2(PacketWrapper var0) throws Exception {
      ((c1)var0.user().b(c1.class)).addEntity(((Integer)var0.get(Type.INT, 0)).intValue(), awD.PLAYER);
   }

   private static void lambda$registerMap$1(aRX var0, PacketWrapper var1) throws Exception {
      var1.read(Type.NBT);
      var1.write(Type.NBT, var0.b().getDimensionRegistry());
      String var2 = (String)var1.read(Type.STRING);
      var1.write(Type.NBT, dJ.a(var2));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      lH.b();
      short var2 = ((Short)var0.read(Type.UNSIGNED_BYTE)).shortValue();
      var0.write(Type.BOOLEAN, Boolean.valueOf((var2 & 8) != 0));
      var2 = (short)(var2 & -9);
      var0.write(Type.UNSIGNED_BYTE, Short.valueOf(var2));
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
