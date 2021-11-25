package viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets;

import net.aoR;
import net.q1;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.type.Type;

public class WorldPackets1_13_1 {
   public static void register(Protocol var0) {
      BlockRewriter var1 = new BlockRewriter(var0, Type.POSITION);
      var0.a((ClientboundPacketType)q1.CHUNK_DATA, new aoR(var0));
      var1.registerBlockAction(q1.BLOCK_ACTION);
      var1.registerBlockChange(q1.BLOCK_CHANGE);
      var1.registerMultiBlockChange(q1.MULTI_BLOCK_CHANGE);
      var1.registerEffect(q1.EFFECT, 1010, 2001);
   }
}
