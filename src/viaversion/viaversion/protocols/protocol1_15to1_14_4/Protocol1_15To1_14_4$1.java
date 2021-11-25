package viaversion.viaversion.protocols.protocol1_15to1_14_4;

import net.Q3;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;

class Protocol1_15To1_14_4$1 extends acE {
   final Protocol1_15To1_14_4 this$0;

   Protocol1_15To1_14_4$1(Protocol1_15To1_14_4 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Protocol1_15To1_14_4$1::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      Q3.b((Item)var0.passthrough(Type.FLAT_VAR_INT_ITEM));
   }
}
