import java.util.Arrays;
import net.Main;
import net.acE;

public final class a {
   private static String[] b;

   public static Object[] a(Object[] var0, Object[] var1) {
      Object[] var3 = Arrays.copyOf(var0, var0.length + var1.length);
      b();
      System.arraycopy(var1, 0, var3, var0.length, var1.length);
      if(acE.b() == null) {
         b(new String[1]);
      }

      return var3;
   }

   public static void main(String[] var0) {
      b();
      Main.main((String[])a(new String[]{"--version", "mcp", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.8", "--userProperties", "{}"}, var0));
   }

   public static void b(String[] var0) {
      b = var0;
   }

   public static String[] b() {
      return b;
   }

   static {
      b(new String[2]);
   }
}
