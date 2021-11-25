package de.gerrygames.viarewind.utils;

import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;

public class PacketUtil {
   public static void a(PacketWrapperImpl var0, Class var1) {
      b(var0, var1, true);
   }

   public static void b(PacketWrapperImpl var0, Class var1, boolean var2) {
      a(var0, var1, var2, false);
   }

   public static void a(PacketWrapperImpl var0, Class var1, boolean var2, boolean var3) {
      PacketWrapperImpl var10000 = var0;
      Class var10001 = var1;
      boolean var10002 = var2;
      boolean var10003 = var3;

      try {
         var10000.b(var10001, var10002, var10003);
      } catch (CancelException var5) {
         ;
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public static boolean b(PacketWrapperImpl var0, Class var1) {
      return a(var0, var1, true);
   }

   public static boolean a(PacketWrapperImpl var0, Class var1, boolean var2) {
      return b(var0, var1, true, false);
   }

   public static boolean b(PacketWrapperImpl var0, Class var1, boolean var2, boolean var3) {
      PacketWrapperImpl var10000 = var0;
      Class var10001 = var1;
      boolean var10002 = var2;
      boolean var10003 = var3;

      try {
         var10000.a(var10001, var10002, var10003);
         return true;
      } catch (CancelException var5) {
         ;
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return false;
   }
}
