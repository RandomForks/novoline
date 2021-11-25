package viaversion.viarewind.protocol.protocol1_8to1_9.storage;

import io.netty.buffer.ByteBuf;
import net.aRE;
import net.cA;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viarewind.utils.Tickable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.type.Type;

public class Levitation extends cA implements Tickable {
   private int amplifier;
   private volatile boolean active = false;

   public Levitation(UserConnection var1) {
      super(var1);
   }

   public void tick() {
      String[] var1 = EntityTracker.d();
      if(this.active) {
         int var2 = (this.amplifier + 1) * 360;
         PacketWrapper var3 = new PacketWrapper(18, (ByteBuf)null, this.d());
         var3.write(Type.VAR_INT, Integer.valueOf(((EntityTracker)this.d().b(EntityTracker.class)).getPlayerId()));
         var3.write(Type.SHORT, Short.valueOf((short)0));
         var3.write(Type.SHORT, Short.valueOf((short)var2));
         var3.write(Type.SHORT, Short.valueOf((short)0));
         PacketUtil.sendPacket(var3, aRE.class);
      }
   }

   public void setActive(boolean var1) {
      this.active = var1;
   }

   public void setAmplifier(int var1) {
      this.amplifier = var1;
   }
}
