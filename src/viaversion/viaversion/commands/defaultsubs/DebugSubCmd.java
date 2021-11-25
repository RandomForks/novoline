package viaversion.viaversion.commands.defaultsubs;

import net.abo;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;

public class DebugSubCmd extends ViaSubCommand {
   public String name() {
      return "debug";
   }

   public String description() {
      return "Toggle debug mode";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      boolean var3 = abo.c();
      Via.getManager().setDebug(!Via.getManager().isDebug());
      this.sendMessage(var1, "&6Debug mode is now %s", new Object[]{Via.getManager().isDebug()?"&aenabled":"&cdisabled"});
      return true;
   }
}
