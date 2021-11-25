package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Function;
import net.aRi;
import net.cA;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.Scoreboard$ScoreTeam;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.type.Type;

public class Scoreboard extends cA {
   private final HashMap teams = new HashMap();
   private final HashSet objectives = new HashSet();
   private final HashMap scoreTeams = new HashMap();
   private final HashMap teamColors = new HashMap();
   private final HashSet scoreTeamNames = new HashSet();
   private String colorIndependentSidebar;
   private final HashMap colorDependentSidebar = new HashMap();

   public Scoreboard(UserConnection var1) {
      super(var1);
   }

   public void addPlayerToTeam(String var1, String var2) {
      ((List)this.teams.computeIfAbsent(var2, Scoreboard::lambda$addPlayerToTeam$0)).add(var1);
   }

   public void setTeamColor(String var1, Byte var2) {
      this.teamColors.put(var1, var2);
   }

   public Optional getTeamColor(String var1) {
      return Optional.ofNullable(this.teamColors.get(var1));
   }

   public void addTeam(String var1) {
      this.teams.computeIfAbsent(var1, Scoreboard::lambda$addTeam$1);
   }

   public void removeTeam(String var1) {
      this.teams.remove(var1);
      this.scoreTeams.remove(var1);
      this.teamColors.remove(var1);
   }

   public boolean teamExists(String var1) {
      return this.teams.containsKey(var1);
   }

   public void removePlayerFromTeam(String var1, String var2) {
      EntityTracker.b();
      List var4 = (List)this.teams.get(var2);
      if(var4 != null) {
         var4.remove(var1);
      }

   }

   public boolean isPlayerInTeam(String var1, String var2) {
      EntityTracker.b();
      List var4 = (List)this.teams.get(var2);
      return var4 != null && var4.contains(var1);
   }

   public boolean isPlayerInTeam(String var1) {
      EntityTracker.b();
      Iterator var3 = this.teams.values().iterator();
      if(var3.hasNext()) {
         List var4 = (List)var3.next();
         if(var4.contains(var1)) {
            return true;
         }
      }

      return false;
   }

   public Optional getPlayerTeamColor(String var1) {
      EntityTracker.b();
      Optional var3 = this.getTeam(var1);
      return var3.isPresent()?this.getTeamColor((String)var3.get()):Optional.empty();
   }

   public Optional getTeam(String var1) {
      EntityTracker.b();
      Iterator var3 = this.teams.entrySet().iterator();
      if(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(((List)var4.getValue()).contains(var1)) {
            return Optional.of(var4.getKey());
         }
      }

      return Optional.empty();
   }

   public void addObjective(String var1) {
      this.objectives.add(var1);
   }

   public void removeObjective(String var1) {
      EntityTracker.b();
      this.objectives.remove(var1);
      this.colorDependentSidebar.values().remove(var1);
      if(var1.equals(this.colorIndependentSidebar)) {
         this.colorIndependentSidebar = null;
      }

   }

   public boolean objectiveExists(String var1) {
      return this.objectives.contains(var1);
   }

   public String sendTeamForScore(String var1) {
      String var2 = EntityTracker.b();
      if(var1.length() <= 16) {
         return var1;
      } else if(this.scoreTeams.containsKey(var1)) {
         return Scoreboard$ScoreTeam.access$000((Scoreboard$ScoreTeam)this.scoreTeams.get(var1));
      } else {
         int var3 = 16;
         int var4 = Math.min(16, var1.length() - 16);
         String var5 = var1.substring(var4, var4 + var3);
         if(this.scoreTeamNames.contains(var5) || this.teams.containsKey(var5)) {
            --var4;
            if(var1.length() - var3 - var4 > 16) {
               --var3;
               if(var3 < 1) {
                  return var1;
               }

               var4 = Math.min(16, var1.length() - var3);
            }

            var5 = var1.substring(var4, var4 + var3);
         }

         String var6 = var1.substring(0, var4);
         String var7 = var4 + var3 >= var1.length()?"":var1.substring(var4 + var3);
         Scoreboard$ScoreTeam var8 = new Scoreboard$ScoreTeam(this, var5, var6, var7);
         this.scoreTeams.put(var1, var8);
         this.scoreTeamNames.add(var5);
         PacketWrapper var9 = new PacketWrapper(62, (ByteBuf)null, this.d());
         var9.write(Type.STRING, var5);
         var9.write(Type.BYTE, Byte.valueOf((byte)0));
         var9.write(Type.STRING, "ViaRewind");
         var9.write(Type.STRING, var6);
         var9.write(Type.STRING, var7);
         var9.write(Type.BYTE, Byte.valueOf((byte)0));
         var9.write(Type.SHORT, Short.valueOf((short)1));
         var9.write(Type.STRING, var5);
         PacketUtil.sendPacket(var9, aRi.class, true, true);
         return var5;
      }
   }

   public String k(String var1) {
      EntityTracker.b();
      Scoreboard$ScoreTeam var3 = (Scoreboard$ScoreTeam)this.scoreTeams.remove(var1);
      return var1;
   }

   public void setColorIndependentSidebar(String var1) {
      this.colorIndependentSidebar = var1;
   }

   public String getColorIndependentSidebar() {
      return this.colorIndependentSidebar;
   }

   public HashMap getColorDependentSidebar() {
      return this.colorDependentSidebar;
   }

   private static List lambda$addTeam$1(String var0) {
      return new ArrayList();
   }

   private static List lambda$addPlayerToTeam$0(String var0) {
      return new ArrayList();
   }
}
