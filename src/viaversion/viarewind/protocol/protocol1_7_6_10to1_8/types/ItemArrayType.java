package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;

public class ItemArrayType extends Type {
   private final boolean compressed;

   public ItemArrayType(boolean var1) {
      super("Item[]", Item[].class);
      this.compressed = var1;
   }

   public Item[] read(ByteBuf var1) throws Exception {
      Particle.b();
      short var3 = Type.SHORT.read(var1).shortValue();
      Item[] var4 = new Item[var3];
      int var5 = 0;
      if(var5 < var3) {
         var4[var5] = (Item)(this.compressed?axZ.c:axZ.h).read(var1);
         ++var5;
      }

      return var4;
   }

   public void write(ByteBuf var1, Item[] var2) throws Exception {
      Type.SHORT.write(var1, Short.valueOf((short)var2.length));
      Particle.b();
      int var5 = var2.length;
      int var6 = 0;
      if(var6 < var5) {
         Item var7 = var2[var6];
         (this.compressed?axZ.c:axZ.h).write(var1, var7);
         ++var6;
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
