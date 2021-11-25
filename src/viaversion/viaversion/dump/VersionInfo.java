package viaversion.viaversion.dump;

import java.util.Set;
import net.acE;

public class VersionInfo {
   private final String javaVersion;
   private final String operatingSystem;
   private final int serverProtocol;
   private final Set enabledProtocols;
   private final String platformName;
   private final String platformVersion;
   private final String pluginVersion;
   private final String implementationVersion;
   private final Set subPlatforms;
   private static acE[] i;

   public VersionInfo(String var1, String var2, int var3, Set var4, String var5, String var6, String var7, String var8, Set var9) {
      this.javaVersion = var1;
      b();
      this.operatingSystem = var2;
      this.serverProtocol = var3;
      this.enabledProtocols = var4;
      this.platformName = var5;
      this.platformVersion = var6;
      this.pluginVersion = var7;
      this.implementationVersion = var8;
      this.subPlatforms = var9;
   }

   public String getJavaVersion() {
      return this.javaVersion;
   }

   public String getOperatingSystem() {
      return this.operatingSystem;
   }

   public int getServerProtocol() {
      return this.serverProtocol;
   }

   public Set getEnabledProtocols() {
      return this.enabledProtocols;
   }

   public String getPlatformName() {
      return this.platformName;
   }

   public String getPlatformVersion() {
      return this.platformVersion;
   }

   public String getPluginVersion() {
      return this.pluginVersion;
   }

   public String getImplementationVersion() {
      return this.implementationVersion;
   }

   public Set getSubPlatforms() {
      return this.subPlatforms;
   }

   public static void b(acE[] var0) {
      i = var0;
   }

   public static acE[] b() {
      return i;
   }

   static {
      if(b() == null) {
         b(new acE[5]);
      }

   }
}
