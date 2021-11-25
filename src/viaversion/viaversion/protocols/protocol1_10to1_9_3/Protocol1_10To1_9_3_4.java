package viaversion.viaversion.protocols.protocol1_10to1_9_3;

import net.Wx;
import net.Yk;
import net.a2Y;
import net.a66;
import net.a7O;
import net.a7y;
import net.a7z;
import net.agN;
import net.axe;
import net.c6;
import net.cA;
import net.rX;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4$1;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4$3;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4$5;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4$6;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4$7;

public class Protocol1_10To1_9_3_4 extends Protocol {
   public static final ValueTransformer TO_NEW_PITCH = new Protocol1_10To1_9_3_4$1(Type.FLOAT);
   public static final ValueTransformer TRANSFORM_METADATA = new Yk(rX.a);

   public Protocol1_10To1_9_3_4() {
      super(agN.class, agN.class, Wx.class, Wx.class);
   }

   protected void registerPackets() {
      a2Y.b();
      axe.a(this);
      this.b(a66.PLAY, 25, 25, new Protocol1_10To1_9_3_4$3(this));
      this.b(a66.PLAY, 70, 70, new a7y(this));
      this.b(a66.PLAY, 57, 57, new Protocol1_10To1_9_3_4$5(this));
      this.b(a66.PLAY, 3, 3, new Protocol1_10To1_9_3_4$6(this));
      this.b(a66.PLAY, 5, 5, new Protocol1_10To1_9_3_4$7(this));
      this.b(a66.PLAY, 50, 50, new a7z(this));
      this.a(a66.PLAY, 22, 22, new a7O(this));
   }

   public int a(int var1) {
      a2Y.b();
      int var3 = var1;
      if(var1 >= 24) {
         var3 = var1 + 1;
      }

      if(var1 >= 248) {
         var3 += 4;
      }

      if(var1 >= 296) {
         var3 += 6;
      }

      if(var1 >= 354) {
         var3 += 4;
      }

      if(var1 >= 372) {
         var3 += 4;
      }

      return var3;
   }

   public void init(UserConnection var1) {
      var1.a((cA)(new c6(var1)));
   }
}
