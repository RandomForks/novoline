package viaversion.viafabric;

import cc.novoline.viaversion.platform.ViaBackwardsPlatformImplementation;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.channel.EventLoop;
import io.netty.channel.local.LocalEventLoopGroup;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;
import net.NO;
import net.acE;
import net.af_;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import sun.misc.URLClassPath;
import viaversion.viafabric.platform.VRInjector;
import viaversion.viafabric.platform.VRLoader;
import viaversion.viafabric.platform.VRPlatform;
import viaversion.viafabric.util.JLoggerToLog4j;
import viaversion.viaversion.ViaManager;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;

public class ViaFabric {
   public static int clientSideVersion = 47;
   public static final Logger JLOGGER = new JLoggerToLog4j(LogManager.getLogger("ViaFabric"));
   public static final ExecutorService ASYNC_EXECUTOR;
   public static final EventLoop EVENT_LOOP;
   public static CompletableFuture INIT_FUTURE = new CompletableFuture();
   private static int e;

   public static String getVersion() {
      return "1.0";
   }

   public void onInitialize() throws IllegalAccessException, NoSuchFieldException, MalformedURLException {
      d();
      this.loadVia();
      Via.init(ViaManager.builder().injector(new VRInjector()).loader(new VRLoader()).platform(new VRPlatform()).build());
      MappingDataLoader.enableMappingsCache();
      new ViaBackwardsPlatformImplementation();
      new NO();
      Via.getManager().init();
      INIT_FUTURE.complete((Object)null);
   }

   public void loadVia() throws NoSuchFieldException, IllegalAccessException, MalformedURLException {
      ClassLoader var2 = ClassLoader.getSystemClassLoader();
      int var10000 = d();
      Field var3 = af_.c(var2.getClass(), "ucp");
      var3.setAccessible(true);
      URLClassPath var4 = (URLClassPath)var3.get(var2);
      File[] var5 = (new File(Minecraft.getInstance().mcDataDir, "mods")).listFiles();
      int var1 = var10000;
      if(var5 != null) {
         int var7 = var5.length;
         int var8 = 0;
         if(var8 < var7) {
            File var9 = var5[var8];
            if(var9.isFile() && var9.getName().startsWith("Via") && var9.getName().toLowerCase().endsWith(".jar")) {
               var4.addURL(var9.toURI().toURL());
            }

            ++var8;
         }
      }

      if(acE.b() == null) {
         ++var1;
         b(var1);
      }

   }

   static {
      b(97);
      ThreadFactory var7 = (new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("ViaFabric-%d").build();
      ASYNC_EXECUTOR = Executors.newFixedThreadPool(8, var7);
      EVENT_LOOP = (new LocalEventLoopGroup(1, var7)).next();
      EventLoop var10000 = EVENT_LOOP;
      CompletableFuture var10001 = INIT_FUTURE;
      INIT_FUTURE.getClass();
      var10000.submit(var10001::join);
   }

   public static void b(int var0) {
      e = var0;
   }

   public static int c() {
      return e;
   }

   public static int d() {
      int var0 = c();
      return 5;
   }

   private static ReflectiveOperationException a(ReflectiveOperationException var0) {
      return var0;
   }
}
