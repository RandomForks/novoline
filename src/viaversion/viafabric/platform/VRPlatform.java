package viaversion.viafabric.platform;

import com.google.gson.JsonObject;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.File;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;
import net.acE;
import net.bgY;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import viaversion.viafabric.ViaFabric;
import viaversion.viafabric.platform.VRConnectionManager;
import viaversion.viafabric.platform.VRViaAPI;
import viaversion.viafabric.platform.VRViaConfig;
import viaversion.viafabric.util.FutureTaskId;
import viaversion.viafabric.util.JLoggerToLog4j;
import viaversion.viaversion.api.ViaAPI;
import viaversion.viaversion.api.ViaVersionConfig;
import viaversion.viaversion.api.command.ViaCommandSender;
import viaversion.viaversion.api.configuration.ConfigurationProvider;
import viaversion.viaversion.api.platform.TaskId;
import viaversion.viaversion.api.platform.ViaConnectionManager;
import viaversion.viaversion.api.platform.ViaPlatform;

public class VRPlatform implements ViaPlatform {
   private final Logger logger = new JLoggerToLog4j(LogManager.getLogger("ViaVersion"));
   private final VRViaConfig config;
   private final File dataFolder;
   private final ViaConnectionManager connectionManager;
   private final ViaAPI api;

   public VRPlatform() {
      bgY.b();
      Path var2 = Minecraft.getInstance().mcDataDir.toPath().resolve("ViaFabric");
      this.config = new VRViaConfig(var2.resolve("viaversion.yml").toFile());
      this.dataFolder = var2.toFile();
      this.connectionManager = new VRConnectionManager();
      this.api = new VRViaAPI();
   }

   public static MinecraftServer getServer() {
      return !Minecraft.getInstance().isIntegratedServerRunning()?null:MinecraftServer.getServer();
   }

   public Logger getLogger() {
      return this.logger;
   }

   public String getPlatformName() {
      return "ViaFabric";
   }

   public String getPlatformVersion() {
      return ViaFabric.getVersion();
   }

   public String getPluginVersion() {
      return "3.3.0";
   }

   public TaskId runAsync(Runnable var1) {
      return new FutureTaskId(CompletableFuture.runAsync(var1, ViaFabric.ASYNC_EXECUTOR).exceptionally(VRPlatform::lambda$runAsync$0));
   }

   public TaskId runSync(Runnable var1) {
      return getServer() != null?this.runServerSync(var1):this.runEventLoop(var1);
   }

   private TaskId runServerSync(Runnable var1) {
      return new FutureTaskId(CompletableFuture.runAsync(var1, VRPlatform::lambda$runServerSync$2));
   }

   private TaskId runEventLoop(Runnable var1) {
      return new FutureTaskId(ViaFabric.EVENT_LOOP.submit(var1).addListener(this.errorLogger()));
   }

   public TaskId runSync(Runnable var1, Long var2) {
      return new FutureTaskId(ViaFabric.EVENT_LOOP.schedule(this::lambda$runSync$3, var2.longValue() * 50L, TimeUnit.MILLISECONDS).addListener(this.errorLogger()));
   }

   public TaskId runRepeatingSync(Runnable var1, Long var2) {
      acE[] var3 = bgY.b();
      FutureTaskId var10000 = new FutureTaskId(ViaFabric.EVENT_LOOP.scheduleAtFixedRate(this::lambda$runRepeatingSync$4, 0L, var2.longValue() * 50L, TimeUnit.MILLISECONDS).addListener(this.errorLogger()));
      if(acE.b() == null) {
         bgY.b(new acE[1]);
      }

      return var10000;
   }

   private GenericFutureListener errorLogger() {
      return VRPlatform::lambda$errorLogger$5;
   }

   public void cancelTask(TaskId var1) {
      acE[] var2 = bgY.b();
      if(var1 instanceof FutureTaskId) {
         ((FutureTaskId)var1).getObject().cancel(false);
      }

   }

   public ViaCommandSender[] getOnlinePlayers() {
      return new ViaCommandSender[0];
   }

   public void sendMessage(UUID var1, String var2) {
   }

   public boolean kickPlayer(UUID var1, String var2) {
      return this.kickServer(var1, var2);
   }

   private boolean kickServer(UUID var1, String var2) {
      return false;
   }

   public boolean isPluginEnabled() {
      return true;
   }

   public ViaAPI getApi() {
      return this.api;
   }

   public ViaVersionConfig getConf() {
      return this.config;
   }

   public ConfigurationProvider getConfigurationProvider() {
      return this.config;
   }

   public File getDataFolder() {
      return this.dataFolder;
   }

   public void onReload() {
   }

   public JsonObject getDump() {
      return new JsonObject();
   }

   public boolean isOldClientsAllowed() {
      return true;
   }

   public ViaConnectionManager getConnectionManager() {
      return this.connectionManager;
   }

   private String legacyToJson(String var1) {
      return ComponentSerializer.toString(TextComponent.fromLegacyText(var1));
   }

   private static void lambda$errorLogger$5(Future var0) throws Exception {
      acE[] var1 = bgY.b();
      if(!var0.isCancelled() && var0.cause() != null) {
         var0.cause().printStackTrace();
      }

   }

   private void lambda$runRepeatingSync$4(Runnable var1) {
      this.runSync(var1);
   }

   private TaskId lambda$runSync$3(Runnable var1) throws Exception {
      return this.runSync(var1);
   }

   private static void lambda$runServerSync$2(Runnable var0) {
      getServer().callFromMainThread(VRPlatform::lambda$null$1);
   }

   private static Void lambda$null$1(Runnable var0) throws Exception {
      var0.run();
      return null;
   }

   private static Void lambda$runAsync$0(Throwable var0) {
      acE[] var1 = bgY.b();
      if(!(var0 instanceof CancellationException)) {
         var0.printStackTrace();
      }

      return null;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
