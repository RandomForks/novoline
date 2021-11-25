package viaversion.viaversion.api.rewriters;

import net.a7H;
import net.a7l;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.BlockRewriter$2;
import viaversion.viaversion.api.rewriters.BlockRewriter$3;
import viaversion.viaversion.api.rewriters.BlockRewriter$4;
import viaversion.viaversion.api.type.Type;

public class BlockRewriter {
   private final Protocol protocol;
   private final Type positionType;

   public BlockRewriter(Protocol var1, Type var2) {
      this.protocol = var1;
      this.positionType = var2;
   }

   public void registerBlockAction(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new a7H(this));
   }

   public void registerBlockChange(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new BlockRewriter$2(this));
   }

   public void registerMultiBlockChange(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new BlockRewriter$3(this));
   }

   public void registerVarLongMultiBlockChange(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new BlockRewriter$4(this));
   }

   public void registerAcknowledgePlayerDigging(ClientboundPacketType var1) {
      this.registerBlockChange(var1);
   }

   public void registerEffect(ClientboundPacketType var1, int var2, int var3) {
      this.protocol.a((ClientboundPacketType)var1, new a7l(this, var2, var3));
   }

   static Type access$000(BlockRewriter var0) {
      return var0.positionType;
   }

   static Protocol access$100(BlockRewriter var0) {
      return var0.protocol;
   }
}
