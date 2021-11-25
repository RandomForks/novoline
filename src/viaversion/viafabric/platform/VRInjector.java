package viaversion.viafabric.platform;

import com.google.gson.JsonObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import net.af_;
import viaversion.viaversion.api.platform.ViaInjector;
import viaversion.viaversion.util.GsonUtil;

public class VRInjector implements ViaInjector {
   public void inject() {
   }

   public void uninject() {
   }

   public int getServerProtocolVersion() {
      return this.getClientProtocol();
   }

   private int getClientProtocol() {
      return 47;
   }

   public String getEncoderName() {
      return "via-encoder";
   }

   public String getDecoderName() {
      return "via-decoder";
   }

   public JsonObject getDump() {
      JsonObject var1 = new JsonObject();
      JsonObject var10000 = var1;
      String var10001 = "serverNetworkIOChInit";

      try {
         var10000.add(var10001, GsonUtil.getGson().toJsonTree(Arrays.stream(af_.a("net.minecraft.class_3242$1").getDeclaredMethods()).map(Method::toString).toArray(VRInjector::lambda$getDump$0)));
      } catch (ClassNotFoundException var4) {
         ;
      }

      var10000 = var1;
      var10001 = "clientConnectionChInit";

      try {
         var10000.add(var10001, GsonUtil.getGson().toJsonTree(Arrays.stream(af_.a("net.minecraft.class_2535$1").getDeclaredMethods()).map(Method::toString).toArray(VRInjector::lambda$getDump$1)));
      } catch (ClassNotFoundException var3) {
         ;
      }

      return var1;
   }

   private static String[] lambda$getDump$1(int var0) {
      return new String[var0];
   }

   private static String[] lambda$getDump$0(int var0) {
      return new String[var0];
   }
}
