package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.github.steveice10.opennbt.NBTIO;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import java.io.DataOutputStream;
import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.type.Type;

public class NBTType extends Type {
   public NBTType() {
      super("CompoundTag", CompoundTag.class);
   }

   public CompoundTag read(ByteBuf var1) {
      short var2 = var1.readShort();
      return null;
   }

   public void write(ByteBuf var1, CompoundTag var2) throws Exception {
      acE[] var3 = Particle.b();
      var1.writeShort(-1);
      ByteBuf var4 = var1.alloc().buffer();
      ByteBufOutputStream var5 = new ByteBufOutputStream(var4);
      DataOutputStream var6 = new DataOutputStream(var5);
      NBTIO.writeTag(var6, var2);
      var6.close();
      var1.writeShort(var4.readableBytes());
      var1.writeBytes(var4);
      var4.release();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
