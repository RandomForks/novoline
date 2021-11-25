package viaversion.viafabric.platform;

import net.awT;
import net.i6;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.platform.ViaPlatformLoader;
import viaversion.viaversion.protocols.base.VersionProvider;
import viaversion.viaversion.protocols.protocol1_9to1_8.providers.MovementTransmitterProvider;

public class VRLoader implements ViaPlatformLoader {
   public void load() {
      Via.getManager().f().a(MovementTransmitterProvider.class, new i6());
      Via.getManager().f().a(VersionProvider.class, new awT());
   }

   public void unload() {
   }
}
