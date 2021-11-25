package viaversion.viaversion.api.rewriters;

import net.aQU;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;

class ItemRewriter$4 extends acE {
   final Type val$type;
   final aQU c;

   ItemRewriter$4(aQU var1, Type var2) {
      this.c = var1;
      this.val$type = var2;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(Type var1, PacketWrapper var2) throws Exception {
      boolean var3 = MetadataRewriter.c();

      while(true) {
         byte var4 = ((Byte)var2.passthrough(Type.BYTE)).byteValue();
         aQU.b(this.c).rewrite((Item)var2.passthrough(var1));
         if((var4 & -128) == 0) {
            break;
         }
      }

   }
}
