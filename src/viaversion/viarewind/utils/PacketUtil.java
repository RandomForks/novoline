package viaversion.viarewind.utils;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.exception.CancelException;

public class PacketUtil {
   public static void sendToServer(PacketWrapper var0, Class var1) {
      sendToServer(var0, var1, true);
   }

   public static void sendToServer(PacketWrapper var0, Class var1, boolean var2) {
      sendToServer(var0, var1, var2, false);
   }

   public static void sendToServer(PacketWrapper var0, Class var1, boolean var2, boolean var3) {
      PacketWrapper var10000 = var0;
      Class var10001 = var1;
      boolean var10002 = var2;
      boolean var10003 = var3;

      try {
         var10000.sendToServer(var10001, var10002, var10003);
      } catch (CancelException var5) {
         ;
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public static boolean sendPacket(PacketWrapper var0, Class var1) {
      return sendPacket(var0, var1, true);
   }

   public static boolean sendPacket(PacketWrapper var0, Class var1, boolean var2) {
      return sendPacket(var0, var1, true, false);
   }

   public static boolean sendPacket(PacketWrapper var0, Class var1, boolean var2, boolean var3) {
      PacketWrapper var10000 = var0;
      Class var10001 = var1;
      boolean var10002 = var2;
      boolean var10003 = var3;

      try {
         var10000.send(var10001, var10002, var10003);
         return true;
      } catch (CancelException var5) {
         ;
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return false;
   }
}
