package viaversion.viaversion.commands;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.abo;
import net.acE;
import net.md_5.bungee.api.ChatColor;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;
import viaversion.viaversion.api.command.ViaVersionCommand;
import viaversion.viaversion.commands.defaultsubs.AutoTeamSubCmd;
import viaversion.viaversion.commands.defaultsubs.DebugSubCmd;
import viaversion.viaversion.commands.defaultsubs.DisplayLeaksSubCmd;
import viaversion.viaversion.commands.defaultsubs.DontBugMeSubCmd;
import viaversion.viaversion.commands.defaultsubs.DumpSubCmd;
import viaversion.viaversion.commands.defaultsubs.HelpSubCmd;
import viaversion.viaversion.commands.defaultsubs.PPSSubCmd;
import viaversion.viaversion.commands.defaultsubs.ReloadSubCmd;

public abstract class ViaCommandHandler implements ViaVersionCommand {
   private final Map commandMap = new HashMap();
   private static int[] b;

   public ViaCommandHandler() {
      ViaCommandHandler var10000 = this;

      try {
         var10000.registerDefaults();
      } catch (Exception var2) {
         ;
      }

   }

   public void registerSubCommand(ViaSubCommand var1) throws Exception {
      b();
      Preconditions.checkArgument(var1.name().matches("^[a-z0-9_-]{3,15}$"), var1.name() + " is not a valid sub-command name.");
      if(this.hasSubCommand(var1.name())) {
         throw new Exception("ViaSubCommand " + var1.name() + " does already exists!");
      } else {
         this.commandMap.put(var1.name().toLowerCase(Locale.ROOT), var1);
      }
   }

   public boolean hasSubCommand(String var1) {
      return this.commandMap.containsKey(var1.toLowerCase(Locale.ROOT));
   }

   public ViaSubCommand getSubCommand(String var1) {
      return (ViaSubCommand)this.commandMap.get(var1.toLowerCase(Locale.ROOT));
   }

   public boolean onCommand(ViaCommandSender var1, String[] var2) {
      int[] var3 = b();
      if(var2.length == 0) {
         this.showHelp(var1);
         return false;
      } else if(!this.hasSubCommand(var2[0])) {
         var1.sendMessage(color("&cThis command does not exist."));
         this.showHelp(var1);
         return false;
      } else {
         ViaSubCommand var4 = this.getSubCommand(var2[0]);
         if(!this.hasPermission(var1, var4.permission())) {
            var1.sendMessage(color("&cYou are not allowed to use this command!"));
            return false;
         } else {
            String[] var5 = (String[])Arrays.copyOfRange(var2, 1, var2.length);
            boolean var6 = var4.execute(var1, var5);
            if(!var6) {
               var1.sendMessage("Usage: /viaversion " + var4.usage());
            }

            return var6;
         }
      }
   }

   public List onTabComplete(ViaCommandSender var1, String[] var2) {
      Set var4 = this.calculateAllowedCommands(var1);
      b();
      ArrayList var5 = new ArrayList();
      if(var2.length == 1) {
         if(!var2[0].isEmpty()) {
            Iterator var6 = var4.iterator();
            if(var6.hasNext()) {
               ViaSubCommand var7 = (ViaSubCommand)var6.next();
               if(var7.name().toLowerCase().startsWith(var2[0].toLowerCase(Locale.ROOT))) {
                  var5.add(var7.name());
               }
            }
         }

         Iterator var9 = var4.iterator();
         if(var9.hasNext()) {
            ViaSubCommand var11 = (ViaSubCommand)var9.next();
            var5.add(var11.name());
         }
      }

      if(var2.length >= 2 && this.getSubCommand(var2[0]) != null) {
         ViaSubCommand var10 = this.getSubCommand(var2[0]);
         if(!var4.contains(var10)) {
            return var5;
         } else {
            String[] var12 = (String[])Arrays.copyOfRange(var2, 1, var2.length);
            List var8 = var10.onTabComplete(var1, var12);
            Collections.sort(var8);
            return var8;
         }
      } else {
         if(acE.b() == null) {
            b(new int[3]);
         }

         return var5;
      }
   }

   public void showHelp(ViaCommandSender var1) {
      b();
      Set var3 = this.calculateAllowedCommands(var1);
      if(var3.isEmpty()) {
         var1.sendMessage(color("&cYou are not allowed to use these commands!"));
      } else {
         var1.sendMessage(color("&aViaVersion &c" + Via.getPlatform().getPluginVersion()));
         var1.sendMessage(color("&6Commands:"));
         Iterator var4 = var3.iterator();
         if(var4.hasNext()) {
            ViaSubCommand var5 = (ViaSubCommand)var4.next();
            var1.sendMessage(color(String.format("&2/viaversion %s &7- &6%s", new Object[]{var5.usage(), var5.description()})));
         }

         var3.clear();
      }
   }

   private Set calculateAllowedCommands(ViaCommandSender var1) {
      HashSet var3 = new HashSet();
      b();
      Iterator var4 = this.commandMap.values().iterator();
      if(var4.hasNext()) {
         ViaSubCommand var5 = (ViaSubCommand)var4.next();
         if(this.hasPermission(var1, var5.permission())) {
            var3.add(var5);
         }
      }

      return var3;
   }

   private boolean hasPermission(ViaCommandSender var1, String var2) {
      int[] var3 = b();
      return var1.hasPermission(var2);
   }

   private void registerDefaults() throws Exception {
      this.registerSubCommand(new abo());
      this.registerSubCommand(new PPSSubCmd());
      this.registerSubCommand(new DebugSubCmd());
      this.registerSubCommand(new DumpSubCmd());
      this.registerSubCommand(new DisplayLeaksSubCmd());
      this.registerSubCommand(new DontBugMeSubCmd());
      this.registerSubCommand(new AutoTeamSubCmd());
      this.registerSubCommand(new HelpSubCmd());
      this.registerSubCommand(new ReloadSubCmd());
   }

   public static String color(String var0) {
      char var10000 = 38;
      String var10001 = var0;

      try {
         var0 = ChatColor.translateAlternateColorCodes(var10000, var10001);
      } catch (Exception var2) {
         ;
      }

      return var0;
   }

   public static void sendMessage(ViaCommandSender var0, String var1, Object... var2) {
      var0.sendMessage(color(var1));
   }

   public static void b(int[] var0) {
      b = var0;
   }

   public static int[] b() {
      return b;
   }

   private static Exception a(Exception var0) {
      return var0;
   }

   static {
      b((int[])null);
   }
}
