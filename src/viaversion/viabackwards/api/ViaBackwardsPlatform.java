package viaversion.viabackwards.api;

import java.io.File;
import java.util.logging.Logger;
import net.VV;
import net.aR9;
import net.aRC;
import net.aRD;
import net.aRJ;
import net.aRK;
import net.aRM;
import net.aRV;
import net.aRZ;
import net.aRc;
import net.aRg;
import net.aRo;
import net.ay_;
import net.ayd;
import net.ayj;
import net.ayk;
import net.hz;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_10to1_11.Protocol1_10To1_11;
import viaversion.viabackwards.protocol.protocol1_12_1to1_12_2.Protocol1_12_1To1_12_2;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.Protocol1_13_2To1_14;
import viaversion.viabackwards.protocol.protocol1_13to1_13_1.Protocol1_13To1_13_1;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.Protocol1_14_4To1_15;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import viaversion.viabackwards.protocol.protocol1_9_4to1_10.Protocol1_9_4To1_10;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.protocol.ProtocolRegistry;
import viaversion.viaversion.api.protocol.ProtocolVersion;

public interface ViaBackwardsPlatform {
   String a = "3.2.0";

   default void init(File var1) {
      viaversion.viabackwards.ViaBackwardsConfig var3 = new viaversion.viabackwards.ViaBackwardsConfig(new File(var1, "config.yml"));
      var3.reloadConfig();
      ayd.a();
      VV.a(this, var3);
      String var4 = VV.class.getPackage().getImplementationVersion();
      Via.getManager().getSubPlatforms().add(var4 != null?var4:"UNKNOWN");
      this.getLogger().info("Loading translations...");
      TranslatableRewriter.loadTranslatables();
      this.getLogger().info("Registering protocols...");
      ProtocolRegistry.registerProtocol(new Protocol1_9_4To1_10(), ProtocolVersion.v1_9_3, ProtocolVersion.v1_10);
      ProtocolRegistry.registerProtocol(new Protocol1_10To1_11(), ProtocolVersion.v1_10, ProtocolVersion.v1_11);
      ProtocolRegistry.registerProtocol(new ayj(), ProtocolVersion.v1_11, ProtocolVersion.v1_11_1);
      ProtocolRegistry.registerProtocol(new ay_(), ProtocolVersion.v1_11_1, ProtocolVersion.v1_12);
      ProtocolRegistry.registerProtocol(new aRg(), ProtocolVersion.v1_12, ProtocolVersion.v1_12_1);
      ProtocolRegistry.registerProtocol(new Protocol1_12_1To1_12_2(), ProtocolVersion.v1_12_1, ProtocolVersion.v1_12_2);
      ProtocolRegistry.registerProtocol(new ayk(), ProtocolVersion.v1_12_2, ProtocolVersion.v1_13);
      ProtocolRegistry.registerProtocol(new Protocol1_13To1_13_1(), ProtocolVersion.v1_13, ProtocolVersion.v1_13_1);
      ProtocolRegistry.registerProtocol(new aRJ(), ProtocolVersion.v1_13_1, ProtocolVersion.v1_13_2);
      ProtocolRegistry.registerProtocol(new Protocol1_13_2To1_14(), ProtocolVersion.v1_13_2, ProtocolVersion.v1_14);
      ProtocolRegistry.registerProtocol(new aRD(), ProtocolVersion.v1_14, ProtocolVersion.v1_14_1);
      ProtocolRegistry.registerProtocol(new aRc(), ProtocolVersion.v1_14_1, ProtocolVersion.v1_14_2);
      ProtocolRegistry.registerProtocol(new aRC(), ProtocolVersion.v1_14_2, ProtocolVersion.v1_14_3);
      ProtocolRegistry.registerProtocol(new aRo(), ProtocolVersion.v1_14_3, ProtocolVersion.v1_14_4);
      ProtocolRegistry.registerProtocol(new Protocol1_14_4To1_15(), ProtocolVersion.v1_14_4, ProtocolVersion.v1_15);
      ProtocolRegistry.registerProtocol(new aRK(), ProtocolVersion.v1_15, ProtocolVersion.v1_15_1);
      ProtocolRegistry.registerProtocol(new aR9(), ProtocolVersion.v1_15_1, ProtocolVersion.v1_15_2);
      ProtocolRegistry.registerProtocol(new Protocol1_15_2To1_16(), ProtocolVersion.v1_15_2, ProtocolVersion.v1_16);
      ProtocolRegistry.registerProtocol(new aRZ(), ProtocolVersion.v1_16, ProtocolVersion.v1_16_1);
      ProtocolRegistry.registerProtocol(new Protocol1_16_1To1_16_2(), ProtocolVersion.v1_16_1, ProtocolVersion.v1_16_2);
      ProtocolRegistry.registerProtocol(new aRV(), ProtocolVersion.v1_16_2, ProtocolVersion.v1_16_3);
      ProtocolRegistry.registerProtocol(new aRM(), ProtocolVersion.v1_16_3, ProtocolVersion.v1_16_4);
   }

   Logger getLogger();

   default boolean isOutdated() {
      ayd.a();
      String var2 = Via.getPlatform().getPluginVersion();
      if((new hz(var2)).a(new hz("3.2.0--")) < 0) {
         this.getLogger().severe("================================");
         this.getLogger().severe("YOUR VIAVERSION IS OUTDATED");
         this.getLogger().severe("PLEASE USE VIAVERSION 3.2.0 OR NEWER");
         this.getLogger().severe("LINK: https://ci.viaversion.com/");
         this.getLogger().severe("VIABACKWARDS WILL NOW DISABLE");
         this.getLogger().severe("================================");
         this.disable();
         return true;
      } else {
         return false;
      }
   }

   void disable();

   File getDataFolder();
}
