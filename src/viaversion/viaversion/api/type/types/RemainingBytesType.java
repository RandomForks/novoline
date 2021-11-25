package viaversion.viaversion.api.type.types;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.type.Type;

public class RemainingBytesType extends Type {
   public RemainingBytesType() {
      super("byte[]", byte[].class);
   }

   public byte[] read(ByteBuf var1) {
      byte[] var2 = new byte[var1.readableBytes()];
      var1.readBytes(var2);
      return var2;
   }

   public void write(ByteBuf var1, byte[] var2) {
      var1.writeBytes(var2);
   }
}
