package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import io.netty.buffer.ByteBuf;
import net.S3;
import net.aRE;
import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.BlockPlaceDestroyTracker;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;

final class PlayerPackets$15 extends acE {
   public void registerMap() {
      this.a(Type.POSITION);
      this.a(Type.BYTE, Type.VAR_INT);
      this.a(PlayerPackets$15::lambda$registerMap$0);
      this.a(PlayerPackets$15::lambda$registerMap$1);
      this.a(Type.BYTE, Type.UNSIGNED_BYTE);
      this.a(Type.BYTE, Type.UNSIGNED_BYTE);
      this.a(Type.BYTE, Type.UNSIGNED_BYTE);
      this.a(PlayerPackets$15::lambda$registerMap$2);
      this.a(PlayerPackets$15::lambda$registerMap$3);
   }

   private static void lambda$registerMap$3(PacketWrapper var0) throws Exception {
      acE[] var1 = S3.b();
      if(((Integer)var0.get(Type.VAR_INT, 0)).intValue() != -1) {
         ((BlockPlaceDestroyTracker)var0.user().b(BlockPlaceDestroyTracker.class)).place();
      }

   }

   private static void lambda$registerMap$2(PacketWrapper var0) throws Exception {
      acE[] var1 = S3.b();
      if(((Integer)var0.get(Type.VAR_INT, 0)).intValue() == -1) {
         var0.cancel();
         PacketWrapper var2 = new PacketWrapper(29, (ByteBuf)null, var0.user());
         var2.write(Type.VAR_INT, Integer.valueOf(0));
         PacketUtil.sendToServer(var2, aRE.class, true, true);
      }

   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      var0.write(Type.VAR_INT, Integer.valueOf(0));
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Item var10000 = (Item)var0.read(Type.ITEM);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
