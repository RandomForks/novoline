package viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import net.aoq;
import net.aqu;
import net.awj;
import net.ayd;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.Protocol1_13_2To1_14;
import viaversion.viaversion.api.protocol.ClientboundPacketType;

public class SoundPackets1_14 extends aqu {
   public SoundPackets1_14(Protocol1_13_2To1_14 var1) {
      super(var1);
   }

   protected void registerPackets() {
      SoundRewriter var1 = new SoundRewriter(this.c);
      var1.registerSound(awj.SOUND);
      var1.registerNamedSound(awj.NAMED_SOUND);
      var1.registerStopSound(awj.STOP_SOUND);
      ((Protocol1_13_2To1_14)this.c).a(awj.ENTITY_SOUND, (ClientboundPacketType)null, new aoq(this));
   }

   static ayd a(SoundPackets1_14 var0) {
      return var0.c;
   }

   static ayd b(SoundPackets1_14 var0) {
      return var0.c;
   }
}
