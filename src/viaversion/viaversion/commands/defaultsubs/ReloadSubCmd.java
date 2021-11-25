package viaversion.viaversion.commands.defaultsubs;

import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;

public class ReloadSubCmd extends ViaSubCommand {
   public String name() {
      return "reload";
   }

   public String description() {
      return "Reload the config from the disk";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      Via.getPlatform().getConfigurationProvider().reloadConfig();
      this.sendMessage(var1, "&6Configuration successfully reloaded! Some features may need a restart.", new Object[0]);
      return true;
   }
}
