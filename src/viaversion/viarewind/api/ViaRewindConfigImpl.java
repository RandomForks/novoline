package viaversion.viarewind.api;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.bY;
import viaversion.viarewind.api.ViaRewindConfig;
import viaversion.viaversion.util.Config;

public class ViaRewindConfigImpl extends Config implements ViaRewindConfig {
   public ViaRewindConfigImpl(File var1) {
      bY.c();
      super(var1);
      this.reloadConfig();
   }

   public bY a() {
      return bY.valueOf(this.getString("cooldown-indicator", "TITLE").toUpperCase());
   }

   public boolean isReplaceAdventureMode() {
      return this.getBoolean("replace-adventure", false);
   }

   public boolean isReplaceParticles() {
      return this.getBoolean("replace-particles", false);
   }

   public URL getDefaultConfigURL() {
      return this.getClass().getClassLoader().getResource("assets/viarewind/config.yml");
   }

   protected void handleConfig(Map var1) {
   }

   public List getUnsupportedOptions() {
      return Collections.emptyList();
   }
}
