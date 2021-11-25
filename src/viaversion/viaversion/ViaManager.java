package viaversion.viaversion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.JL;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.ViaManager$ViaManagerBuilder;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.platform.TaskId;
import viaversion.viaversion.api.platform.ViaInjector;
import viaversion.viaversion.api.platform.ViaPlatform;
import viaversion.viaversion.api.platform.ViaPlatformLoader;
import viaversion.viaversion.api.protocol.ProtocolRegistry;
import viaversion.viaversion.api.protocol.ProtocolVersion;
import viaversion.viaversion.commands.ViaCommandHandler;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.TabCompleteThread;
import viaversion.viaversion.protocols.protocol1_9to1_8.ViaIdleThread;
import viaversion.viaversion.update.UpdateUtil;

public class ViaManager {
   private final ViaPlatform platform;
   private final JL i = new JL();
   private final ViaInjector injector;
   private final ViaCommandHandler commandHandler;
   private final ViaPlatformLoader loader;
   private final Set subPlatforms = new HashSet();
   private List enableListeners = new ArrayList();
   private TaskId mappingLoadingTask;
   private boolean debug;
   private static boolean g;

   public ViaManager(ViaPlatform var1, ViaInjector var2, ViaCommandHandler var3, ViaPlatformLoader var4) {
      this.platform = var1;
      this.injector = var2;
      this.commandHandler = var3;
      this.loader = var4;
   }

   public static ViaManager$ViaManagerBuilder builder() {
      return new ViaManager$ViaManagerBuilder();
   }

   public void init() {
      boolean var1 = n();
      if(System.getProperty("ViaVersion") != null) {
         this.platform.onReload();
      }

      if(this.platform.getConf().isCheckForUpdates()) {
         UpdateUtil.sendUpdateMessage();
      }

      ProtocolRegistry.init();

      try {
         this.injector.inject();
      } catch (Exception var4) {
         this.platform.getLogger().severe("ViaVersion failed to inject:");
         var4.printStackTrace();
         return;
      }

      System.setProperty("ViaVersion", this.platform.getPluginVersion());
      Iterator var2 = this.enableListeners.iterator();
      if(var2.hasNext()) {
         Runnable var3 = (Runnable)var2.next();
         var3.run();
      }

      this.enableListeners = null;
      this.platform.runSync(this::onServerLoaded);
   }

   public void onServerLoaded() {
      boolean var1 = n();

      try {
         ProtocolRegistry.SERVER_PROTOCOL = ProtocolVersion.getProtocol(this.injector.getServerProtocolVersion()).getVersion();
      } catch (Exception var3) {
         this.platform.getLogger().severe("ViaVersion failed to get the server protocol!");
         var3.printStackTrace();
      }

      if(ProtocolRegistry.SERVER_PROTOCOL != -1) {
         this.platform.getLogger().info("ViaVersion detected server version: " + ProtocolVersion.getProtocol(ProtocolRegistry.SERVER_PROTOCOL));
         if(!ProtocolRegistry.isWorkingPipe() && !this.platform.isProxy()) {
            this.platform.getLogger().warning("ViaVersion does not have any compatible versions for this server version!");
            this.platform.getLogger().warning("Please remember that ViaVersion only adds support for versions newer than the server version.");
            this.platform.getLogger().warning("If you need support for older versions you may need to use one or more ViaVersion addons too.");
            this.platform.getLogger().warning("In that case please read the ViaVersion resource page carefully or use https://jo0001.github.io/ViaSetup");
            this.platform.getLogger().warning("and if you\'re still unsure, feel free to join our Discord-Server for further assistance.");
         }

         if(ProtocolRegistry.SERVER_PROTOCOL == ProtocolVersion.v1_8.getVersion() && !this.platform.isProxy()) {
            this.platform.getLogger().warning("This version of Minecraft is over half a decade old and support for it will be fully dropped eventually. Please upgrade to a newer version to avoid encountering bugs and stability issues that have long been fixed.");
         }
      }

      ProtocolRegistry.onServerLoaded();
      this.loader.load();
      this.mappingLoadingTask = Via.getPlatform().runRepeatingSync(this::lambda$onServerLoaded$0, Long.valueOf(10L));
      if(ProtocolRegistry.SERVER_PROTOCOL < ProtocolVersion.v1_9.getVersion() && Via.getConfig().isSimulatePlayerTick()) {
         Via.getPlatform().runRepeatingSync(new ViaIdleThread(), Long.valueOf(1L));
      }

      if(ProtocolRegistry.SERVER_PROTOCOL < ProtocolVersion.v1_13.getVersion() && Via.getConfig().get1_13TabCompleteDelay() > 0) {
         Via.getPlatform().runRepeatingSync(new TabCompleteThread(), Long.valueOf(1L));
      }

      ProtocolRegistry.refreshVersions();
      if(acE.b() == null) {
         b(false);
      }

   }

   public void destroy() {
      this.platform.getLogger().info("ViaVersion is disabling, if this is a reload and you experience issues consider rebooting.");

      try {
         this.injector.uninject();
      } catch (Exception var2) {
         this.platform.getLogger().severe("ViaVersion failed to uninject:");
         var2.printStackTrace();
      }

      this.loader.unload();
   }

   public Set getConnections() {
      return this.platform.getConnectionManager().getConnections();
   }

   /** @deprecated */
   @Deprecated
   public Map getPortedPlayers() {
      return this.getConnectedClients();
   }

   public Map getConnectedClients() {
      return this.platform.getConnectionManager().getConnectedClients();
   }

   public UUID getConnectedClientId(UserConnection var1) {
      return this.platform.getConnectionManager().getConnectedClientId(var1);
   }

   public boolean isClientConnected(UUID var1) {
      return this.platform.getConnectionManager().isClientConnected(var1);
   }

   public void handleLoginSuccess(UserConnection var1) {
      this.platform.getConnectionManager().onLoginSuccess(var1);
   }

   public ViaPlatform getPlatform() {
      return this.platform;
   }

   public JL f() {
      return this.i;
   }

   public boolean isDebug() {
      return this.debug;
   }

   public void setDebug(boolean var1) {
      this.debug = var1;
   }

   public ViaInjector getInjector() {
      return this.injector;
   }

   public ViaCommandHandler getCommandHandler() {
      return this.commandHandler;
   }

   public ViaPlatformLoader getLoader() {
      return this.loader;
   }

   public Set getSubPlatforms() {
      return this.subPlatforms;
   }

   @Nullable
   public UserConnection getConnection(UUID var1) {
      return this.platform.getConnectionManager().getConnectedClient(var1);
   }

   public void addEnableListener(Runnable var1) {
      this.enableListeners.add(var1);
   }

   private void lambda$onServerLoaded$0() {
      boolean var1 = i();
      if(ProtocolRegistry.checkForMappingCompletion()) {
         this.platform.cancelTask(this.mappingLoadingTask);
         this.mappingLoadingTask = null;
      }

   }

   public static void b(boolean var0) {
      g = var0;
   }

   public static boolean i() {
      return g;
   }

   public static boolean n() {
      boolean var0 = i();
      return true;
   }

   private static Exception a(Exception var0) {
      return var0;
   }

   static {
      b(false);
   }
}
