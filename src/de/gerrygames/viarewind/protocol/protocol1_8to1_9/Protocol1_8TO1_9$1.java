package de.gerrygames.viarewind.protocol.protocol1_8to1_9;

import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;

final class Protocol1_8TO1_9$1 extends ValueTransformer {
   Protocol1_8TO1_9$1(Type var1) {
      super(var1);
   }

   public Integer a(PacketWrapperImpl var1, Double var2) {
      return Integer.valueOf((int)(var2.doubleValue() * 32.0D));
   }
}
