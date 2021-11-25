package viaversion.viaversion.commands.defaultsubs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.abo;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.command.ViaSubCommand;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ProtocolVersion;

public class PPSSubCmd extends ViaSubCommand {
   public String name() {
      return "pps";
   }

   public String description() {
      return "Shows the packets per second of online players";
   }

   public String usage() {
      return "pps";
   }

   public boolean execute(ViaCommandSender var1, String[] var2) {
      abo.c();
      HashMap var4 = new HashMap();
      int var5 = 0;
      int var6 = 0;
      long var7 = 0L;
      ViaCommandSender[] var9 = Via.getPlatform().getOnlinePlayers();
      int var10 = var9.length;
      int var11 = 0;
      if(var11 < var10) {
         ViaCommandSender var12 = var9[var11];
         int var13 = Via.getAPI().getPlayerVersion(var12.getUUID());
         if(!var4.containsKey(Integer.valueOf(var13))) {
            var4.put(Integer.valueOf(var13), new HashSet());
         }

         UserConnection var14 = Via.getManager().getConnection(var12.getUUID());
         if(var14.getPacketsPerSecond() > -1L) {
            ((Set)var4.get(Integer.valueOf(var13))).add(var12.getName() + " (" + var14.getPacketsPerSecond() + " PPS)");
            var5 = (int)((long)var5 + var14.getPacketsPerSecond());
            if(var14.getPacketsPerSecond() > var7) {
               var7 = var14.getPacketsPerSecond();
            }

            ++var6;
         }

         ++var11;
      }

      TreeMap var15 = new TreeMap(var4);
      this.sendMessage(var1, "&4Live Packets Per Second", new Object[0]);
      if(var6 > 1) {
         this.sendMessage(var1, "&cAverage: &f" + var5 / var6, new Object[0]);
         this.sendMessage(var1, "&cHighest: &f" + var7, new Object[0]);
      }

      if(var6 == 0) {
         this.sendMessage(var1, "&cNo clients to display.", new Object[0]);
      }

      Iterator var16 = var15.entrySet().iterator();
      if(var16.hasNext()) {
         Entry var18 = (Entry)var16.next();
         this.sendMessage(var1, "&8[&6%s&8]: &b%s", new Object[]{ProtocolVersion.getProtocol(((Integer)var18.getKey()).intValue()).getName(), var18.getValue()});
      }

      var15.clear();
      return true;
   }
}
