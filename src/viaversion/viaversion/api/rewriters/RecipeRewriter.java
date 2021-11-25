package viaversion.viaversion.api.rewriters;

import java.util.HashMap;
import java.util.Map;
import net.a7q;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.rewriters.RecipeRewriter$RecipeConsumer;

public abstract class RecipeRewriter {
   protected final Protocol protocol;
   protected final ItemRewriter$RewriteFunction rewriter;
   protected final Map recipeHandlers = new HashMap();

   protected RecipeRewriter(Protocol var1, ItemRewriter$RewriteFunction var2) {
      this.protocol = var1;
      this.rewriter = var2;
   }

   public void handle(PacketWrapper var1, String var2) throws Exception {
      MetadataRewriter.e();
      RecipeRewriter$RecipeConsumer var4 = (RecipeRewriter$RecipeConsumer)this.recipeHandlers.get(var2);
      if(var4 != null) {
         var4.accept(var1);
      }

   }

   public void registerDefaultHandler(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new a7q(this));
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
