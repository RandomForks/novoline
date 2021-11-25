package viaversion.viabackwards.protocol.protocol1_14_4to1_15;

import net.acE;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.Protocol1_14_4To1_15;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class Protocol1_14_4To1_15$1 extends acE {
   final Protocol1_14_4To1_15 this$0;

   Protocol1_14_4To1_15$1(Protocol1_14_4To1_15 var1) {
      this.this$0 = var1;
   }

   public void registerMap() {
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(Type.FLOAT);
      this.a(this::lambda$registerMap$0);
   }

   private int toEffectCoordinate(float var1) {
      return (int)(var1 * 8.0F);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      PacketWrapper var2 = var1.create(81);
      var2.write(Type.VAR_INT, Integer.valueOf(243));
      var2.write(Type.VAR_INT, Integer.valueOf(4));
      var2.write(Type.INT, Integer.valueOf(this.toEffectCoordinate(((Float)var1.get(Type.FLOAT, 0)).floatValue())));
      var2.write(Type.INT, Integer.valueOf(this.toEffectCoordinate(((Float)var1.get(Type.FLOAT, 1)).floatValue())));
      var2.write(Type.INT, Integer.valueOf(this.toEffectCoordinate(((Float)var1.get(Type.FLOAT, 2)).floatValue())));
      var2.write(Type.FLOAT, Float.valueOf(4.0F));
      var2.write(Type.FLOAT, Float.valueOf(1.0F));
      var2.send(Protocol1_14_4To1_15.class);
   }
}
