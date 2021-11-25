package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import net.EN;
import net.S3;

final class EntityPackets$6 extends PacketRemapper {
   public void registerMap() {
      this.a(Type.VAR_INT_ARRAY_PRIMITIVE);
      this.a(EntityPackets$6::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapperImpl var0) throws Exception {
      S3.b();
      EntityTracker var2 = (EntityTracker)var0.e().b(EntityTracker.class);
      int[] var3 = (int[])var0.b(Type.VAR_INT_ARRAY_PRIMITIVE, 0);
      int var4 = var3.length;
      int var5 = 0;
      if(var5 < var4) {
         int var6 = var3[var5];
         var2.removeEntity(var6);
         ++var5;
      }

   }
}
