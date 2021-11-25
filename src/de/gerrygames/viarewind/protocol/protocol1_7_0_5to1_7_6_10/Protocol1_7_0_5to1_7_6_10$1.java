package de.gerrygames.viarewind.protocol.protocol1_7_0_5to1_7_6_10;

import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;

final class Protocol1_7_0_5to1_7_6_10$1 extends ValueTransformer {
   Protocol1_7_0_5to1_7_6_10$1(Type var1) {
      super(var1);
   }

   public String a(PacketWrapperImpl var1, String var2) {
      return var2.replace("-", "");
   }
}
