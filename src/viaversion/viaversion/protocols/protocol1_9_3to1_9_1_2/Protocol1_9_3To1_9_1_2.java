package viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2;

import net.Cw;
import net.Wx;
import net.a0c;
import net.aV0;
import net.aVR;
import net.aVY;
import net.aVy;
import net.agN;
import net.cA;
import net.cT;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.Protocol1_9_3To1_9_1_2$1;
import viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.Protocol1_9_3To1_9_1_2$6;

public class Protocol1_9_3To1_9_1_2 extends Protocol {
   public static final ValueTransformer ADJUST_PITCH = new Protocol1_9_3To1_9_1_2$1(Type.UNSIGNED_BYTE, Type.UNSIGNED_BYTE);

   public Protocol1_9_3To1_9_1_2() {
      super(a0c.class, agN.class, Cw.class, Wx.class);
   }

   protected void registerPackets() {
      this.a(a0c.UPDATE_SIGN, (ClientboundPacketType)null, new aV0(this));
      this.a(a0c.CHUNK_DATA, new aVy(this));
      this.a(a0c.JOIN_GAME, new aVR(this));
      this.a(a0c.RESPAWN, new aVY(this));
      this.a(a0c.SOUND, new Protocol1_9_3To1_9_1_2$6(this));
   }

   public void init(UserConnection var1) {
      boolean var2 = agN.b();
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

   }
}
