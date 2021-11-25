package viamcp.platform;

import com.viaversion.viaversion.configuration.AbstractViaConfig;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VRViaConfig extends AbstractViaConfig {
   private static List UNSUPPORTED = Arrays.asList(new String[]{"anti-xray-patch", "bungee-ping-interval", "bungee-ping-save", "bungee-servers", "quick-move-action-fix", "nms-player-ticking", "item-cache", "velocity-ping-interval", "velocity-ping-save", "velocity-servers", "blockconnection-method", "change-1_9-hitbox", "change-1_14-hitbox"});

   public VRViaConfig(File var1) {
      super(var1);
      this.reloadConfig();
   }

   public URL getDefaultConfigURL() {
      return this.getClass().getClassLoader().getResource("assets/viaversion/config.yml");
   }

   protected void handleConfig(Map var1) {
   }

   public List getUnsupportedOptions() {
      return UNSUPPORTED;
   }

   public boolean w() {
      return false;
   }

   public boolean R() {
      return false;
   }

   public boolean X() {
      return false;
   }

   public boolean U() {
      return false;
   }

   public String getBlockConnectionMethod() {
      return "packet";
   }

   public boolean q() {
      return false;
   }

   public boolean L() {
      return false;
   }
}
