package viaversion.viaversion.api.command;

import java.util.List;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;

public interface ViaVersionCommand {
   void registerSubCommand(ViaSubCommand var1) throws Exception;

   boolean hasSubCommand(String var1);

   @Nullable
   ViaSubCommand getSubCommand(String var1);

   boolean onCommand(ViaCommandSender var1, String[] var2);

   List onTabComplete(ViaCommandSender var1, String[] var2);
}
