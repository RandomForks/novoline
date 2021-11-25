package viaversion.viaversion.commands.defaultsubs;

import net.abo;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;
import viaversion.viaversion.api.configuration.ConfigurationProvider;

public class DontBugMeSubCmd extends ViaSubCommand {
   public String name() {
      return "dontbugme";
   }

   public String description() {
      return "Toggle checking for updates";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      abo.c();
      ConfigurationProvider var4 = Via.getPlatform().getConfigurationProvider();
      boolean var5 = !Via.getConfig().isCheckForUpdates();
      Via.getConfig().setCheckForUpdates(var5);
      var4.saveConfig();
      this.sendMessage(var1, "&6We will %snotify you about updates.", new Object[]{"&a"});
      return true;
   }
}
