package viaversion.viaversion.update;

import java.util.UUID;
import net.hz;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.Via;

public class UpdateUtil {
   public static final String PREFIX = ChatColor.GREEN + "" + ChatColor.BOLD + "[ViaVersion] " + ChatColor.GREEN;
   private static final String a = "https://api.spiget.org/v2/resources/";
   private static final int PLUGIN = 19254;
   private static final String d = "/versions/latest";

   public static void sendUpdateMessage(UUID var0) {
      Via.getPlatform().runAsync(UpdateUtil::lambda$sendUpdateMessage$1);
   }

   public static void sendUpdateMessage() {
      Via.getPlatform().runAsync(UpdateUtil::lambda$sendUpdateMessage$3);
   }

   @Nullable
   private static String a(boolean var0) {
      boolean var1 = hz.d();
      if(Via.getPlatform().getPluginVersion().equals("${project.version}")) {
         return "You are using a debug/custom version, consider updating.";
      } else {
         String var2 = getNewestVersion();
         return "Could not check for updates, check your connection.";
      }
   }

   @Nullable
   private static String getNewestVersion() {
      // $FF: Couldn't be decompiled
   }

   private static void lambda$sendUpdateMessage$3() {
      String var0 = a(true);
      Via.getPlatform().runSync(UpdateUtil::lambda$null$2);
   }

   private static void lambda$null$2(String var0) {
      Via.getPlatform().getLogger().warning(var0);
   }

   private static void lambda$sendUpdateMessage$1(UUID var0) {
      String var1 = a(false);
      Via.getPlatform().runSync(UpdateUtil::lambda$null$0);
   }

   private static void lambda$null$0(UUID var0, String var1) {
      Via.getPlatform().sendMessage(var0, PREFIX + var1);
   }

   private static RuntimeException a(RuntimeException var0) {
      return var0;
   }
}
