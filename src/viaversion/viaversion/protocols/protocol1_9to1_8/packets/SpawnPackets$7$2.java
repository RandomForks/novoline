package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import net.aM1;
import net.aRY;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class SpawnPackets$7$2 implements PacketHandler {
   final aM1 a;

   SpawnPackets$7$2(aM1 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      short var2 = ((Short)var1.read(Type.SHORT)).shortValue();
      PacketWrapper var3 = new PacketWrapper(60, (ByteBuf)null, var1.user());
      var3.write(Type.VAR_INT, var1.get(Type.VAR_INT, 0));
      var3.write(Type.VAR_INT, Integer.valueOf(0));
      var3.write(Type.ITEM, new Item(var2, (byte)1, (short)0, (CompoundTag)null));
      PacketWrapper var10000 = var3;
      Class var10001 = aRY.class;
      boolean var10002 = true;
      boolean var10003 = true;

      try {
         var10000.send(var10001, var10002, var10003);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}
