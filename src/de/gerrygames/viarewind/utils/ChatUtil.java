package de.gerrygames.viarewind.utils;

import com.google.gson.JsonElement;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import java.util.logging.Level;
import java.util.regex.Pattern;
import net.JM;
import net.vL;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

public class ChatUtil {
   private static final Pattern UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>§[0-fk-or])*(§r|\\Z))|(?>(?>§[0-f])*(§[0-f]))");

   public static String jsonToLegacy(String var0) {
      PacketRemapper[] var1 = vL.b();
      if(var0 != null && !var0.equals("null") && !var0.equals("")) {
         String var10000 = var0;

         try {
            String var2 = BaseComponent.toLegacyText(ComponentSerializer.parse(var10000));
            if(var2.startsWith("§f")) {
               var2 = var2.substring(2);
            }

            return var2;
         } catch (Exception var3) {
            JM.a().a().log(Level.WARNING, "Could not convert component to legacy text: " + var0, var3);
            return "";
         }
      } else {
         return "";
      }
   }

   public static String a(JsonElement var0) {
      PacketRemapper[] var1 = vL.b();
      return !var0.isJsonNull() && (!var0.isJsonArray() || var0.getAsJsonArray().size() != 0) && (!var0.isJsonObject() || var0.getAsJsonObject().size() != 0)?(var0.isJsonPrimitive()?var0.getAsString():jsonToLegacy(var0.toString())):"";
   }

   public static String legacyToJson(String var0) {
      PacketRemapper[] var1 = vL.b();
      return var0 == null?"":ComponentSerializer.toString(TextComponent.fromLegacyText(var0));
   }

   public static String removeUnusedColor(String var0, char var1) {
      PacketRemapper[] var2 = vL.b();
      if(var0 == null) {
         return null;
      } else {
         var0 = UNUSED_COLOR_PATTERN.matcher(var0).replaceAll("$1$2");
         StringBuilder var3 = new StringBuilder();
         int var4 = 0;
         if(var4 < var0.length()) {
            char var5 = var0.charAt(var4);
            if(var5 != 167 || var4 == var0.length() - 1) {
               var3.append(var5);
            }

            ++var4;
            var5 = var0.charAt(var4);
            if(var5 != var1) {
               var3.append('§').append(var5);
            }

            ++var4;
         }

         return var3.toString();
      }
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
