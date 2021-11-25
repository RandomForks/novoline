package de.gerrygames.viarewind.protocol.protocol1_8to1_9;

import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;

final class Protocol1_8TO1_9$2 extends ValueTransformer {
   Protocol1_8TO1_9$2(Type var1) {
      super(var1);
   }

   public Byte a(PacketWrapperImpl var1, Float var2) throws Exception {
      return Byte.valueOf((byte)((int)(var2.floatValue() / 360.0F * 256.0F)));
   }
}
