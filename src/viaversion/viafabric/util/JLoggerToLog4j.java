package viaversion.viafabric.util;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import net.acE;

public class JLoggerToLog4j extends Logger {
   private final org.apache.logging.log4j.Logger base;
   private static boolean b;

   public JLoggerToLog4j(org.apache.logging.log4j.Logger var1) {
      super("logger", (String)null);
      this.base = var1;
   }

   public void log(LogRecord var1) {
      this.log(var1.getLevel(), var1.getMessage());
   }

   public void log(Level var1, String var2) {
      boolean var3 = c();
      if(var1 == Level.FINE) {
         this.base.debug(var2);
      }

      if(var1 == Level.WARNING) {
         this.base.warn(var2);
      }

      if(var1 == Level.SEVERE) {
         this.base.error(var2);
      }

      if(var1 == Level.INFO) {
         this.base.info(var2);
      }

      this.base.trace(var2);
   }

   public void log(Level var1, String var2, Object var3) {
      boolean var4 = c();
      if(var1 == Level.FINE) {
         this.base.debug(var2, new Object[]{var3});
      }

      if(var1 == Level.WARNING) {
         this.base.warn(var2, new Object[]{var3});
      }

      if(var1 == Level.SEVERE) {
         this.base.error(var2, new Object[]{var3});
      }

      if(var1 == Level.INFO) {
         this.base.info(var2, new Object[]{var3});
      }

      this.base.trace(var2, new Object[]{var3});
   }

   public void log(Level var1, String var2, Object[] var3) {
      this.log(var1, MessageFormat.format(var2, var3));
   }

   public void log(Level var1, String var2, Throwable var3) {
      boolean var4 = b();
      if(var1 == Level.FINE) {
         this.base.debug(var2, var3);
      }

      if(var1 == Level.WARNING) {
         this.base.warn(var2, var3);
      }

      if(var1 == Level.SEVERE) {
         this.base.error(var2, var3);
      }

      if(var1 == Level.INFO) {
         this.base.info(var2, var3);
      }

      this.base.trace(var2, var3);
      if(acE.b() == null) {
         b(false);
      }

   }

   public static void b(boolean var0) {
      b = var0;
   }

   public static boolean b() {
      return b;
   }

   public static boolean c() {
      boolean var0 = b();
      return true;
   }

   static {
      if(!b()) {
         b(true);
      }

   }
}
