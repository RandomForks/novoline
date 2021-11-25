package viaversion.viaversion.api.type.types.minecraft;

import com.google.gson.JsonElement;
import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.type.Type;

public class OptionalComponentType extends Type {
   public OptionalComponentType() {
      super("JsonElement", JsonElement.class);
   }

   public JsonElement read(ByteBuf var1) throws Exception {
      boolean var2 = var1.readBoolean();
      return (JsonElement)Type.COMPONENT.read(var1);
   }

   public void write(ByteBuf var1, JsonElement var2) throws Exception {
      String var3 = nP.b();
      var1.writeBoolean(false);
      var1.writeBoolean(true);
      Type.COMPONENT.write(var1, var2);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
