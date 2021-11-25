package viaversion.viaversion.api.platform;

import com.google.gson.JsonObject;
import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;
import viaversion.viaversion.api.ViaAPI;
import viaversion.viaversion.api.ViaVersionConfig;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.configuration.ConfigurationProvider;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.platform.TaskId;
import viaversion.viaversion.api.platform.ViaConnectionManager;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public interface ViaPlatform {
   Logger getLogger();

   String getPlatformName();

   String getPlatformVersion();

   default boolean isProxy() {
      return false;
   }

   String getPluginVersion();

   TaskId runAsync(Runnable var1);

   TaskId runSync(Runnable var1);

   TaskId runSync(Runnable var1, Long var2);

   TaskId runRepeatingSync(Runnable var1, Long var2);

   void cancelTask(TaskId var1);

   ViaCommandSender[] getOnlinePlayers();

   void sendMessage(UUID var1, String var2);

   boolean kickPlayer(UUID var1, String var2);

   default boolean disconnect(UserConnection var1, String var2) {
      boolean var3 = ViaConnectionManager.c();
      if(var1.isClientSide()) {
         return false;
      } else {
         UUID var4 = ((ProtocolInfo)var1.b(ProtocolInfo.class)).getUuid();
         return false;
      }
   }

   boolean isPluginEnabled();

   ViaAPI getApi();

   ViaVersionConfig getConf();

   ConfigurationProvider getConfigurationProvider();

   File getDataFolder();

   void onReload();

   JsonObject getDump();

   boolean isOldClientsAllowed();

   ViaConnectionManager getConnectionManager();
}
