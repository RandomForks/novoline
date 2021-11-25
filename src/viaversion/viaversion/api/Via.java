package viaversion.viaversion.api;

import com.google.common.base.Preconditions;
import viaversion.viaversion.ViaManager;
import viaversion.viaversion.api.ViaAPI;
import viaversion.viaversion.api.ViaVersionConfig;
import viaversion.viaversion.api.platform.ViaPlatform;

public class Via {
   private static ViaPlatform platform;
   private static ViaManager manager;

   public static void init(ViaManager var0) {
      Preconditions.checkArgument(manager == null, "ViaManager is already set");
      platform = var0.getPlatform();
      manager = var0;
   }

   public static ViaAPI getAPI() {
      Preconditions.checkArgument(platform != null, "ViaVersion has not loaded the Platform");
      return platform.getApi();
   }

   public static ViaVersionConfig getConfig() {
      Preconditions.checkArgument(platform != null, "ViaVersion has not loaded the Platform");
      return platform.getConf();
   }

   public static ViaPlatform getPlatform() {
      return platform;
   }

   public static ViaManager getManager() {
      return manager;
   }
}
