package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import net.acE;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;

public class ItemType extends Type {
   private final boolean compressed;

   public ItemType(boolean var1) {
      super("Item", Item.class);
      this.compressed = var1;
   }

   public Item a(ByteBuf var1) throws Exception {
      int var3 = var1.readerIndex();
      Particle.b();
      short var4 = var1.readShort();
      return null;
   }

   public void write(ByteBuf var1, Item var2) throws Exception {
      acE[] var3 = Particle.b();
      var1.writeShort(-1);
      var1.writeShort(var2.getIdentifier());
      var1.writeByte(var2.getAmount());
      var1.writeShort(var2.getData());
      (this.compressed?axZ.a:axZ.g).write(var1, var2.getTag());
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
