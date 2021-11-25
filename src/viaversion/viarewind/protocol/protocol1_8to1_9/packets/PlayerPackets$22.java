package viaversion.viarewind.protocol.protocol1_8to1_9.packets;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import net.aRE;
import net.acE;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_8;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_8;

final class PlayerPackets$22 extends acE {
   public void registerMap() {
      this.a(Type.STRING);
      this.a(Type.BYTE);
      this.a(Type.BYTE, Type.VAR_INT);
      this.a(Type.BOOLEAN);
      this.a(Type.UNSIGNED_BYTE);
      this.a(PlayerPackets$22::lambda$registerMap$0);
      this.a(PlayerPackets$22::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      short var1 = ((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue();
      PacketWrapper var2 = new PacketWrapper(28, (ByteBuf)null, var0.user());
      var2.write(Type.VAR_INT, Integer.valueOf(((EntityTracker)var0.user().b(EntityTracker.class)).getPlayerId()));
      ArrayList var3 = new ArrayList();
      var3.add(new Metadata(10, MetaType1_8.Byte, Byte.valueOf((byte)var1)));
      var2.write(Types1_8.METADATA_LIST, var3);
      PacketUtil.sendPacket(var2, aRE.class);
   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      var0.write(Type.VAR_INT, Integer.valueOf(1));
   }
}
