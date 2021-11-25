package viaversion.viaversion;

import viaversion.viaversion.ViaManager;
import viaversion.viaversion.api.platform.ViaInjector;
import viaversion.viaversion.api.platform.ViaPlatform;
import viaversion.viaversion.api.platform.ViaPlatformLoader;
import viaversion.viaversion.commands.ViaCommandHandler;

public final class ViaManager$ViaManagerBuilder {
   private ViaPlatform platform;
   private ViaInjector injector;
   private ViaCommandHandler commandHandler;
   private ViaPlatformLoader loader;

   public ViaManager$ViaManagerBuilder platform(ViaPlatform var1) {
      this.platform = var1;
      return this;
   }

   public ViaManager$ViaManagerBuilder injector(ViaInjector var1) {
      this.injector = var1;
      return this;
   }

   public ViaManager$ViaManagerBuilder loader(ViaPlatformLoader var1) {
      this.loader = var1;
      return this;
   }

   public ViaManager$ViaManagerBuilder commandHandler(ViaCommandHandler var1) {
      this.commandHandler = var1;
      return this;
   }

   public ViaManager build() {
      return new ViaManager(this.platform, this.injector, this.commandHandler, this.loader);
   }
}
