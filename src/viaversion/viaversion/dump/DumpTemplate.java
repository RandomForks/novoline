package viaversion.viaversion.dump;

import com.google.gson.JsonObject;
import java.util.Map;
import viaversion.viaversion.dump.VersionInfo;

public class DumpTemplate {
   private final VersionInfo versionInfo;
   private final Map configuration;
   private final JsonObject platformDump;
   private final JsonObject injectionDump;

   public DumpTemplate(VersionInfo var1, Map var2, JsonObject var3, JsonObject var4) {
      this.versionInfo = var1;
      this.configuration = var2;
      this.platformDump = var3;
      this.injectionDump = var4;
   }

   public VersionInfo getVersionInfo() {
      return this.versionInfo;
   }

   public Map getConfiguration() {
      return this.configuration;
   }

   public JsonObject getPlatformDump() {
      return this.platformDump;
   }

   public JsonObject getInjectionDump() {
      return this.injectionDump;
   }
}
