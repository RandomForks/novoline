package viaversion.viaversion.api.rewriters;

import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.rewriters.SoundRewriter$1;
import viaversion.viaversion.api.type.Type;

public class SoundRewriter {
   protected final Protocol protocol;
   protected final IdRewriteFunction idRewriter;

   public SoundRewriter(Protocol var1) {
      this.protocol = var1;
      this.idRewriter = SoundRewriter::lambda$new$0;
   }

   public SoundRewriter(Protocol var1, IdRewriteFunction var2) {
      this.protocol = var1;
      this.idRewriter = var2;
   }

   public void registerSound(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new SoundRewriter$1(this));
   }

   public PacketHandler getSoundHandler() {
      return this::lambda$getSoundHandler$1;
   }

   private void lambda$getSoundHandler$1(PacketWrapper var1) throws Exception {
      int var3 = ((Integer)var1.get(Type.VAR_INT, 0)).intValue();
      MetadataRewriter.e();
      int var4 = this.idRewriter.rewrite(var3);
      if(var4 == -1) {
         var1.cancel();
      }

      if(var3 != var4) {
         var1.set(Type.VAR_INT, 0, Integer.valueOf(var4));
      }

   }

   private static int lambda$new$0(Protocol var0, int var1) {
      return var0.getMappingData().getSoundMappings().getNewId(var1);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
