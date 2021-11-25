package viaversion.viarewind.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

public class ForwardMessageToMessageDecoder extends MessageToMessageDecoder {
   protected void decode(ChannelHandlerContext var1, Object var2, List var3) throws Exception {
      var3.add(var2);
   }
}
