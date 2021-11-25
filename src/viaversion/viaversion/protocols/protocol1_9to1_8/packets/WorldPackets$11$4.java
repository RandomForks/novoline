package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import io.netty.buffer.ByteBuf;
import java.util.Optional;
import net.aM6;
import net.aRY;
import net.amb;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class WorldPackets$11$4 implements PacketHandler {
   final aM6 a;

   WorldPackets$11$4(aM6 var1) {
      this.a = var1;
   }

   public void handle(PacketWrapper var1) throws Exception {
      amb var2 = (amb)Via.getManager().f().b(amb.class);
      Position var3 = (Position)var1.get(Type.POSITION, 0);
      Optional var4 = var2.a(var1.user(), var3);
      if(var4.isPresent()) {
         PacketWrapper var5 = new PacketWrapper(9, (ByteBuf)null, var1.user());
         var5.write(Type.POSITION, var3);
         var5.write(Type.UNSIGNED_BYTE, Short.valueOf((short)2));
         var5.write(Type.NBT, var4.get());
         var5.send(aRY.class);
      }

   }
}
