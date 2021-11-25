package viaversion.viaversion.protocols.protocol1_9to1_8;

import com.google.gson.JsonElement;
import net.aRY;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;

final class Protocol1_9To1_8$1 extends ValueTransformer {
   Protocol1_9To1_8$1(Type var1) {
      super(var1);
   }

   public JsonElement transform(PacketWrapper var1, String var2) {
      return aRY.b(var2);
   }
}
