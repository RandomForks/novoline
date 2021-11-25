package viaversion.viaversion.commands.defaultsubs;

import net.abo;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;
import viaversion.viaversion.api.configuration.ConfigurationProvider;

public class AutoTeamSubCmd extends ViaSubCommand {
   public String name() {
      return "autoteam";
   }

   public String description() {
      return "Toggle automatically teaming to prevent colliding.";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      abo.a();
      ConfigurationProvider var4 = Via.getPlatform().getConfigurationProvider();
      boolean var5 = !Via.getConfig().isAutoTeam();
      var4.set("auto-team", Boolean.valueOf(var5));
      var4.saveConfig();
      this.sendMessage(var1, "&6We will %s", new Object[]{"&aautomatically team players"});
      this.sendMessage(var1, "&6All players will need to re-login for the change to take place.", new Object[0]);
      return true;
   }
}
