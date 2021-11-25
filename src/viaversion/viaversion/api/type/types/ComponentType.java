package viaversion.viaversion.api.type.types;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.StringType;
import viaversion.viaversion.util.GsonUtil;

public class ComponentType extends Type {
   private static final StringType STRING_TAG = new StringType(262144);

   public ComponentType() {
      super("JsonElement", JsonElement.class);
   }

   public JsonElement read(ByteBuf var1) throws Exception {
      String var2 = STRING_TAG.read(var1);

      try {
         return GsonUtil.getJsonParser().parse(var2);
      } catch (JsonSyntaxException var4) {
         Via.getPlatform().getLogger().severe("Error when trying to parse json: " + var2);
         throw var4;
      }
   }

   public void write(ByteBuf var1, JsonElement var2) throws Exception {
      STRING_TAG.write(var1, var2.toString());
   }
}
