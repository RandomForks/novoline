package viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import io.netty.channel.ChannelHandlerContext;
import net.amb;
import net.aqQ;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.protocol1_9to1_8.storage.MovementTracker;
import viaversion.viaversion.util.PipelineUtil;

public abstract class MovementTransmitterProvider implements aqQ {
   public abstract Object getFlyingPacket();

   public abstract Object getGroundPacket();

   public void sendPlayer(UserConnection var1) {
      amb.c();
      ChannelHandlerContext var3 = PipelineUtil.getContextBefore("decoder", var1.getChannel().pipeline());
      if(((MovementTracker)var1.b(MovementTracker.class)).isGround()) {
         var3.fireChannelRead(this.getGroundPacket());
      }

      var3.fireChannelRead(this.getFlyingPacket());
      ((MovementTracker)var1.b(MovementTracker.class)).incrementIdlePacket();
   }
}
