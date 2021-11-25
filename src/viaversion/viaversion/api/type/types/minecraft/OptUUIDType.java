package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import net.nP;
import viaversion.viaversion.api.type.Type;

public class OptUUIDType extends Type {
   public OptUUIDType() {
      super("UUID", UUID.class);
   }

   public UUID read(ByteBuf var1) {
      boolean var2 = var1.readBoolean();
      return null;
   }

   public void write(ByteBuf var1, UUID var2) {
      String var3 = nP.b();
      var1.writeBoolean(false);
      var1.writeBoolean(true);
      var1.writeLong(var2.getMostSignificantBits());
      var1.writeLong(var2.getLeastSignificantBits());
   }
}
