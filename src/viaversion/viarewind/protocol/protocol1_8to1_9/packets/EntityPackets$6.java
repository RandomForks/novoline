package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import net.S3;
import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

final class EntityPackets$6 extends acE {
   public void registerMap() {
      this.a(Type.VAR_INT_ARRAY_PRIMITIVE);
      this.a(EntityPackets$6::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      S3.b();
      EntityTracker var2 = (EntityTracker)var0.user().b(EntityTracker.class);
      int[] var3 = (int[])var0.get(Type.VAR_INT_ARRAY_PRIMITIVE, 0);
      int var4 = var3.length;
      int var5 = 0;
      if(var5 < var4) {
         int var6 = var3[var5];
         var2.removeEntity(var6);
         ++var5;
      }

   }
}
