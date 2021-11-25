package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import de.gerrygames.viarewind.utils.PacketUtil;
import de.gerrygames.viarewind.utils.Tickable;
import io.netty.buffer.ByteBuf;
import net.aRE;
import net.bgR;
import net.cA;

public class Levitation extends cA implements Tickable {
   private int amplifier;
   private volatile boolean active = false;

   public Levitation(bgR var1) {
      super(var1);
   }

   public void tick() {
      String[] var1 = EntityTracker.d();
      if(this.active) {
         int var2 = (this.amplifier + 1) * 360;
         PacketWrapperImpl var3 = new PacketWrapperImpl(18, (ByteBuf)null, this.d());
         var3.a(Type.VAR_INT, Integer.valueOf(((EntityTracker)this.d().b(EntityTracker.class)).getPlayerId()));
         var3.a(Type.SHORT, Short.valueOf((short)0));
         var3.a(Type.SHORT, Short.valueOf((short)var2));
         var3.a(Type.SHORT, Short.valueOf((short)0));
         PacketUtil.b(var3, aRE.class);
      }
   }

   public void setActive(boolean var1) {
      this.active = var1;
   }

   public void setAmplifier(int var1) {
      this.amplifier = var1;
   }
}
