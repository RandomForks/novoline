package viaversion.viaversion.protocols.base;

import java.util.UUID;
import net.a66;
import net.a7G;
import net.a7T;
import net.a7h;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.SimpleProtocol;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public class BaseProtocol1_7 extends SimpleProtocol {
   protected void registerPackets() {
      ProtocolInfo.d();
      this.b(a66.STATUS, 0, 0, new a7G(this));
      this.c(a66.STATUS, 1, 1);
      this.c(a66.LOGIN, 0, 0);
      this.c(a66.LOGIN, 1, 1);
      this.b(a66.LOGIN, 2, 2, new a7h(this));
      this.c(a66.LOGIN, 3, 3);
      this.a(a66.LOGIN, 4, 4);
      this.a(a66.STATUS, 0, 0);
      this.a(a66.STATUS, 1, 1);
      this.a(a66.LOGIN, 0, 0, new a7T(this));
      this.a(a66.LOGIN, 1, 1);
      this.a(a66.LOGIN, 2, 2);
   }

   public static String addDashes(String var0) {
      StringBuilder var1 = new StringBuilder(var0);
      var1.insert(20, '-');
      var1.insert(16, '-');
      var1.insert(12, '-');
      var1.insert(8, '-');
      return var1.toString();
   }

   protected UUID passthroughLoginUUID(PacketWrapper var1) throws Exception {
      ProtocolInfo.d();
      String var3 = (String)var1.passthrough(Type.STRING);
      if(var3.length() == 32) {
         var3 = addDashes(var3);
      }

      return UUID.fromString(var3);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
