package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.Scoreboard;

class Scoreboard$ScoreTeam {
   private final String prefix;
   private final String suffix;
   private final String name;
   final Scoreboard this$0;

   public Scoreboard$ScoreTeam(Scoreboard var1, String var2, String var3, String var4) {
      this.this$0 = var1;
      this.prefix = var3;
      this.suffix = var4;
      this.name = var2;
   }

   static String access$000(Scoreboard$ScoreTeam var0) {
      return var0.name;
   }
}
