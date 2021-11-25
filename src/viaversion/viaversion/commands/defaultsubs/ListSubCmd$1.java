package viaversion.viaversion.commands.defaultsubs;

import java.util.Comparator;
import net.abo;
import viaversion.viaversion.api.protocol.ProtocolVersion;

class ListSubCmd$1 implements Comparator {
   final abo a;

   ListSubCmd$1(abo var1) {
      this.a = var1;
   }

   public int compare(ProtocolVersion var1, ProtocolVersion var2) {
      return ProtocolVersion.getIndex(var2) - ProtocolVersion.getIndex(var1);
   }
}
