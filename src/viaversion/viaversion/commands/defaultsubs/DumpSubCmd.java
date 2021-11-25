package viaversion.viaversion.commands.defaultsubs;

import java.util.Map;
import net.aUV;
import net.abo;
import net.acE;
import viaversion.viaversion.ViaManager;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;
import viaversion.viaversion.api.protocol.ProtocolRegistry;
import viaversion.viaversion.dump.DumpTemplate;
import viaversion.viaversion.dump.VersionInfo;

public class DumpSubCmd extends ViaSubCommand {
   public String name() {
      return "dump";
   }

   public String description() {
      return "Dump information about your server, this is helpful if you report bugs.";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      abo.a();
      VersionInfo var4 = new VersionInfo(System.getProperty("java.version"), System.getProperty("os.name"), ProtocolRegistry.SERVER_PROTOCOL, ProtocolRegistry.getSupportedVersions(), Via.getPlatform().getPlatformName(), Via.getPlatform().getPlatformVersion(), Via.getPlatform().getPluginVersion(), ViaManager.class.getPackage().getImplementationVersion(), Via.getManager().getSubPlatforms());
      Map var5 = Via.getPlatform().getConfigurationProvider().getValues();
      DumpTemplate var6 = new DumpTemplate(var4, var5, Via.getPlatform().getDump(), Via.getManager().getInjector().getDump());
      Via.getPlatform().runAsync(new aUV(this, var1, var4, var6));
      if(acE.b() == null) {
         abo.b(false);
      }

      return true;
   }

   private String getUrl(String var1) {
      return String.format("https://dump.viaversion.com/%s", new Object[]{var1});
   }

   static String access$000(DumpSubCmd var0, String var1) {
      return var0.getUrl(var1);
   }
}
