package viaversion.viaversion.protocols.base;

import net.JL;
import net.a66;
import net.a7X;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.SimpleProtocol;
import viaversion.viaversion.packets.Direction;
import viaversion.viaversion.protocols.base.ProtocolInfo;
import viaversion.viaversion.protocols.base.VersionProvider;

public class BaseProtocol extends SimpleProtocol {
   protected void registerPackets() {
      this.a(a66.HANDSHAKE, 0, 0, new a7X(this));
   }

   public void init(UserConnection var1) {
   }

   protected void a(JL var1) {
      var1.b(VersionProvider.class, new VersionProvider());
   }

   public void a(Direction var1, a66 var2, PacketWrapper var3) throws Exception {
      ProtocolInfo.d();
      super.a(var1, var2, var3);
      if(var1 == Direction.INCOMING && var2 == a66.HANDSHAKE && var3.getId() != 0) {
         var3.user().setActive(false);
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
