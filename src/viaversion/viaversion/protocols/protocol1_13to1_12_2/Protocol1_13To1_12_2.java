package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.BS;
import net.DA;
import net.JL;
import net.KK;
import net.a66;
import net.aK0;
import net.aK2;
import net.aK5;
import net.aK6;
import net.aKG;
import net.aKO;
import net.aKR;
import net.aKT;
import net.aKX;
import net.aKY;
import net.aK_;
import net.aKa;
import net.aKd;
import net.aKh;
import net.aKj;
import net.aKt;
import net.aKx;
import net.aKy;
import net.aKz;
import net.aPh;
import net.aTW;
import net.aW7;
import net.aWA;
import net.aWC;
import net.aWD;
import net.aWJ;
import net.aWQ;
import net.aWc;
import net.aWg;
import net.aWn;
import net.aWo;
import net.acE;
import net.acW;
import net.azW;
import net.cA;
import net.cT;
import net.cX;
import net.n_;
import net.q1;
import net.r;
import net.r9;
import net.uN;
import net.md_5.bungee.api.ChatColor;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2$11;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2$3;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2$7;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2$9;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.ConnectionData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.PacketBlockConnectionProvider;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.data.MappingData;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.EntityPackets;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.InventoryPackets;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.PaintingProvider;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.BlockConnectionStorage;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.EntityTracker1_13;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.TabCompleteTracker;

public class Protocol1_13To1_12_2 extends Protocol {
   public static final MappingData MAPPINGS = new MappingData();
   public static final PacketHandler POS_TO_3_INT = Protocol1_13To1_12_2::lambda$static$0;
   private static final PacketHandler SEND_DECLARE_COMMANDS_AND_TAGS = Protocol1_13To1_12_2::lambda$static$1;
   protected static final Map SCOREBOARD_TEAM_NAME_REWRITE = new HashMap();
   private static final Set FORMATTING_CODES = Sets.newHashSet(new ChatColor[]{ChatColor.MAGIC, ChatColor.BOLD, ChatColor.STRIKETHROUGH, ChatColor.UNDERLINE, ChatColor.ITALIC, ChatColor.RESET});
   private static String k;

   public Protocol1_13To1_12_2() {
      super(azW.class, q1.class, r.class, uN.class);
   }

   protected void registerPackets() {
      new aTW(this);
      EntityPackets.register(this);
      BS.a(this);
      InventoryPackets.register(this);
      this.b(a66.LOGIN, 0, 0, new Protocol1_13To1_12_2$3(this));
      this.b(a66.STATUS, 0, 0, new aWo(this));
      this.a(azW.STATISTICS, new aWn(this));
      this.a(azW.BOSSBAR, new aWD(this));
      this.a(azW.CHAT_MESSAGE, new Protocol1_13To1_12_2$7(this));
      this.a(azW.TAB_COMPLETE, new aW7(this));
      this.a(azW.OPEN_WINDOW, new Protocol1_13To1_12_2$9(this));
      this.a(azW.COOLDOWN, new aK6(this));
      this.a(azW.DISCONNECT, new Protocol1_13To1_12_2$11(this));
      this.a(azW.EFFECT, new aKX(this));
      this.a(azW.JOIN_GAME, new aKG(this));
      this.a(azW.CRAFT_RECIPE_RESPONSE, new aKh(this));
      this.a(azW.COMBAT_EVENT, new aKT(this));
      this.a(azW.MAP_DATA, new aK0(this));
      this.a(azW.UNLOCK_RECIPES, new aKy(this));
      this.a(azW.RESPAWN, new aKR(this));
      this.a(azW.SCOREBOARD_OBJECTIVE, new aKY(this));
      this.a(azW.TEAMS, new aK2(this));
      this.a(azW.UPDATE_SCORE, new aKz(this));
      this.a(azW.TITLE, new aKO(this));
      (new SoundRewriter(this)).registerSound(azW.SOUND);
      this.a(azW.TAB_LIST, new aKt(this));
      this.a(azW.ADVANCEMENTS, new aKx(this));
      this.c(a66.LOGIN, 2);
      this.cancelIncoming(uN.QUERY_BLOCK_NBT);
      this.a(uN.TAB_COMPLETE, new aKd(this));
      q1.b();
      this.a(uN.EDIT_BOOK, r.PLUGIN_MESSAGE, new aKa(this));
      this.cancelIncoming(uN.ENTITY_NBT_REQUEST);
      this.a(uN.PICK_ITEM, r.PLUGIN_MESSAGE, new aK_(this));
      this.a(uN.CRAFT_RECIPE_REQUEST, new aKj(this));
      this.a(uN.RECIPE_BOOK_DATA, new aK5(this));
      this.a(uN.RENAME_ITEM, r.PLUGIN_MESSAGE, new aWg(this));
      this.a(uN.SELECT_TRADE, r.PLUGIN_MESSAGE, new aWJ(this));
      this.a(uN.SET_BEACON_EFFECT, r.PLUGIN_MESSAGE, new aWA(this));
      this.a(uN.UPDATE_COMMAND_BLOCK, r.PLUGIN_MESSAGE, new aWQ(this));
      this.a(uN.UPDATE_COMMAND_BLOCK_MINECART, r.PLUGIN_MESSAGE, new aWc(this));
      this.a(uN.UPDATE_STRUCTURE_BLOCK, r.PLUGIN_MESSAGE, new aWC(this));
   }

   protected void onMappingDataLoaded() {
      ConnectionData.init();
      acW.a();
      DA.a();
   }

   public void init(UserConnection var1) {
      q1.b();
      var1.a((cA)(new EntityTracker1_13(var1)));
      var1.a((cA)(new TabCompleteTracker(var1)));
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

      var1.a((cA)(new cX(var1)));
      if(Via.getConfig().isServersideBlockConnections() && Via.getManager().f().b(aPh.class) instanceof PacketBlockConnectionProvider) {
         var1.a((cA)(new BlockConnectionStorage(var1)));
      }

   }

   protected void a(JL var1) {
      var1.b(KK.class, new KK());
      var1.b(PaintingProvider.class, new PaintingProvider());
   }

   public ChatColor getLastColor(String var1) {
      q1.b();
      int var3 = var1.length();
      int var4 = var3 - 1;
      if(var4 > -1) {
         char var5 = var1.charAt(var4);
         if(var5 == 167 && var4 < var3 - 1) {
            char var6 = var1.charAt(var4 + 1);
            ChatColor var7 = ChatColor.getByChar(var6);
            if(!FORMATTING_CODES.contains(var7)) {
               return var7;
            }
         }

         --var4;
      }

      return ChatColor.RESET;
   }

   protected String rewriteTeamMemberName(String var1) {
      acE[] var2 = q1.b();
      if(ChatColor.stripColor(var1).isEmpty()) {
         StringBuilder var3 = new StringBuilder();
         int var4 = 1;
         if(var4 < var1.length()) {
            char var5 = var1.charAt(var4);
            Character var6 = (Character)SCOREBOARD_TEAM_NAME_REWRITE.get(ChatColor.getByChar(var5));
            var6 = Character.valueOf(var5);
            var3.append('§').append(var6);
            var4 = var4 + 2;
         }

         var1 = var3.toString();
      }

      return var1;
   }

   public static int[] toPrimitive(Integer[] var0) {
      int[] var2 = new int[var0.length];
      q1.b();
      int var3 = 0;
      if(var3 < var0.length) {
         var2[var3] = var0[var3].intValue();
         ++var3;
      }

      return var2;
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   private static void lambda$static$1(PacketWrapper var0) throws Exception {
      var0.create(17, new r9()).send(Protocol1_13To1_12_2.class);
      var0.create(85, new n_()).send(Protocol1_13To1_12_2.class);
   }

   private static void lambda$static$0(PacketWrapper var0) throws Exception {
      Position var1 = (Position)var0.read(Type.POSITION);
      var0.write(Type.INT, Integer.valueOf(var1.getX()));
      var0.write(Type.INT, Integer.valueOf(var1.getY()));
      var0.write(Type.INT, Integer.valueOf(var1.getZ()));
   }

   static PacketHandler access$000() {
      return SEND_DECLARE_COMMANDS_AND_TAGS;
   }

   static {
      b((String)null);
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.BLACK, Character.valueOf('g'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_BLUE, Character.valueOf('h'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_GREEN, Character.valueOf('i'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_AQUA, Character.valueOf('j'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_RED, Character.valueOf('p'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_PURPLE, Character.valueOf('q'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.GOLD, Character.valueOf('s'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.GRAY, Character.valueOf('t'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.DARK_GRAY, Character.valueOf('u'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.BLUE, Character.valueOf('v'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.GREEN, Character.valueOf('w'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.AQUA, Character.valueOf('x'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.RED, Character.valueOf('y'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.LIGHT_PURPLE, Character.valueOf('z'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.YELLOW, Character.valueOf('!'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.WHITE, Character.valueOf('?'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.MAGIC, Character.valueOf('#'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.BOLD, Character.valueOf('('));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.STRIKETHROUGH, Character.valueOf(')'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.UNDERLINE, Character.valueOf(':'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.ITALIC, Character.valueOf(';'));
      SCOREBOARD_TEAM_NAME_REWRITE.put(ChatColor.RESET, Character.valueOf('/'));
   }

   public static void b(String var0) {
      k = var0;
   }

   public static String c() {
      return k;
   }
}
