package viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.google.gson.JsonElement;
import net.km;
import net.kv;
import net.q1;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.util.GsonUtil;

public class ChatRewriter {
   private static final km a = new kv();

   public static String fromLegacyTextAsString(String var0, ChatColor var1, boolean var2) {
      q1.b();
      TextComponent var4 = new TextComponent();
      TextComponent var5 = new TextComponent();
      StringBuilder var6 = new StringBuilder();
      if(var2) {
         var4.setItalic(Boolean.valueOf(false));
      }

      int var7 = 0;
      if(var7 < var0.length()) {
         char var8 = var0.charAt(var7);
         if(var8 == 167) {
            ++var7;
            if(var7 >= var0.length()) {
               ;
            }

            var8 = var0.charAt(var7);
            if(var8 >= 65 && var8 <= 90) {
               var8 = (char)(var8 + 32);
            }

            ChatColor var9 = ChatColor.getByChar(var8);
            if(var6.length() > 0) {
               TextComponent var10 = var5;
               var5 = new TextComponent(var5);
               var10.setText(var6.toString());
               var6 = new StringBuilder();
               var4.addExtra(var10);
            }

            if(ChatColor.BOLD.equals(var9)) {
               var5.setBold(Boolean.valueOf(true));
            }

            if(ChatColor.ITALIC.equals(var9)) {
               var5.setItalic(Boolean.valueOf(true));
            }

            if(ChatColor.UNDERLINE.equals(var9)) {
               var5.setUnderlined(Boolean.valueOf(true));
            }

            if(ChatColor.STRIKETHROUGH.equals(var9)) {
               var5.setStrikethrough(Boolean.valueOf(true));
            }

            if(ChatColor.MAGIC.equals(var9)) {
               var5.setObfuscated(Boolean.valueOf(true));
            }

            if(ChatColor.RESET.equals(var9)) {
               var9 = var1;
               var5 = new TextComponent();
               var5.setColor(var1);
            }

            var5 = new TextComponent();
            var5.setColor(var9);
         }

         var6.append(var8);
         ++var7;
      }

      var5.setText(var6.toString());
      var4.addExtra(var5);
      return ComponentSerializer.toString(var4);
   }

   public static JsonElement fromLegacyText(String var0, ChatColor var1) {
      return GsonUtil.getJsonParser().parse(fromLegacyTextAsString(var0, var1, false));
   }

   public static JsonElement legacyTextToJson(String var0) {
      return fromLegacyText(var0, ChatColor.WHITE);
   }

   public static String legacyTextToJsonString(String var0) {
      return fromLegacyTextAsString(var0, ChatColor.WHITE, false);
   }

   public static String jsonTextToLegacy(String var0) {
      String var10000 = var0;

      try {
         return TextComponent.toLegacyText(ComponentSerializer.parse(var10000));
      } catch (Exception var2) {
         Via.getPlatform().getLogger().warning("Error converting json text to legacy: " + var0);
         return "";
      }
   }

   public static void processTranslate(JsonElement var0) {
      a.processText(var0);
   }
}
