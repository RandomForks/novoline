package viaversion.viaversion.protocols.protocol1_12to1_11_1;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.aRp;
import net.acE;
import net.km;
import net.ks;
import viaversion.viaversion.api.data.UserConnection;

public class TranslateRewriter {
   private static final km a = new ks();

   public static void toClient(JsonElement var0, UserConnection var1) {
      acE[] var2 = aRp.a();
      if(var0 instanceof JsonObject) {
         JsonObject var3 = (JsonObject)var0;
         JsonElement var4 = var3.get("translate");
         if(var4 != null && var4.getAsString().startsWith("chat.type.achievement")) {
            a.processText(var3);
         }
      }

   }
}
