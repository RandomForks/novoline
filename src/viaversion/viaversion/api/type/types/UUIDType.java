package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import viaversion.viaversion.api.type.Type;

public class UUIDType extends Type {
   public UUIDType() {
      super("UUID", UUID.class);
   }

   public UUID read(ByteBuf var1) {
      return new UUID(var1.readLong(), var1.readLong());
   }

   public void write(ByteBuf var1, UUID var2) {
      var1.writeLong(var2.getMostSignificantBits());
      var1.writeLong(var2.getLeastSignificantBits());
   }
}
