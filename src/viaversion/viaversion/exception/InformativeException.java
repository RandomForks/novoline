package viaversion.viaversion.exception;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.acE;

public class InformativeException extends Exception {
   private final Map info = new HashMap();
   private int sources;
   private static int[] c;

   public InformativeException(Throwable var1) {
      super(var1);
   }

   public InformativeException set(String var1, Object var2) {
      this.info.put(var1, var2);
      return this;
   }

   public InformativeException addSource(Class var1) {
      int[] var2 = b();
      InformativeException var10000 = this.set("Source " + this.sources++, this.getSource(var1));
      if(acE.b() == null) {
         b(new int[5]);
      }

      return var10000;
   }

   private String getSource(Class var1) {
      int[] var2 = b();
      return var1.isAnonymousClass()?var1.getName() + " (Anonymous)":var1.getName();
   }

   public String getMessage() {
      StringBuilder var2 = new StringBuilder();
      var2.append("Please post this error to https://github.com/ViaVersion/ViaVersion/issues\n{");
      b();
      int var3 = 0;
      Iterator var4 = this.info.entrySet().iterator();
      if(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         var2.append("").append((String)var5.getKey()).append(": ").append(var5.getValue().toString());
         ++var3;
      }

      var2.append("}\nActual Error: ");
      return var2.toString();
   }

   public synchronized Throwable fillInStackTrace() {
      return this;
   }

   public static void b(int[] var0) {
      c = var0;
   }

   public static int[] b() {
      return c;
   }

   static {
      b((int[])null);
   }
}
