package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.ReplacementRegistry1_8to1_9;
import net.EN;
import net.amf;

final class WorldPackets$3 extends PacketRemapper {
   public void registerMap() {
      this.a(Type.POSITION);
      this.a(Type.VAR_INT);
      this.a(WorldPackets$3::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapperImpl var0) throws Exception {
      int var1 = ((Integer)var0.b(Type.VAR_INT, 0)).intValue();
      amf var2 = amf.a(var1);
      var2 = ReplacementRegistry1_8to1_9.a(var2);
      var0.a(Type.VAR_INT, 0, Integer.valueOf(amf.a(var2)));
   }
}
