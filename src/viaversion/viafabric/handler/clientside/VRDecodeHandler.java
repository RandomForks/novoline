package viaversion.viafabric.handler.clientside;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import java.util.function.Function;
import net.aAu;
import net.l_;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.exception.CancelDecoderException;

public class VRDecodeHandler extends MessageToMessageDecoder {
   private final UserConnection info;

   public VRDecodeHandler(UserConnection var1) {
      this.info = var1;
   }

   protected void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws Exception {
      l_.b();
      this.info.checkOutgoingPacket();
      if(!this.info.shouldTransformPacket()) {
         var3.add(var2.retain());
      } else {
         ByteBuf var5 = var1.alloc().buffer().writeBytes(var2);
         VRDecodeHandler var10000 = this;

         try {
            var10000.info.transformOutgoing(var5, CancelDecoderException::generate);
            var3.add(var5.retain());
         } finally {
            var5.release();
         }

      }
   }

   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
      int[] var3 = l_.b();
      if(!(var2 instanceof aAu)) {
         super.exceptionCaught(var1, var2);
      }
   }

   public UserConnection getInfo() {
      return this.info;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
