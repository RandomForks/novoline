package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.ItemRewriter;
import net.EN;
import net.aMz;
import net.axZ;

final class InventoryPackets$9 extends PacketRemapper {
   public void registerMap() {
      this.a(Type.SHORT);
      this.map(axZ.c, Type.ITEM);
      this.a(InventoryPackets$9::lambda$registerMap$0);
   }

   private static void lambda$registerMap$0(PacketWrapperImpl var0) throws Exception {
      aMz var1 = (aMz)var0.b(Type.ITEM, 0);
      ItemRewriter.b(var1);
      var0.a(Type.ITEM, 0, var1);
   }
}
