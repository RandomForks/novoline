package viaversion.viaversion.commands.defaultsubs;

import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;

public class HelpSubCmd extends ViaSubCommand {
   public String name() {
      return "help";
   }

   public String description() {
      return "You are looking at it right now!";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      Via.getManager().getCommandHandler().showHelp(var1);
      return true;
   }
}
