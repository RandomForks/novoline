package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseItemType;

public class FlatItemType extends BaseItemType {
   public FlatItemType() {
      super("FlatItem");
   }

   public Item a(ByteBuf var1) throws Exception {
      short var2 = var1.readShort();
      return null;
   }

   public void write(ByteBuf var1, Item var2) throws Exception {
      String var3 = nP.b();
      var1.writeShort(-1);
      var1.writeShort(var2.getIdentifier());
      var1.writeByte(var2.getAmount());
      Type.NBT.write(var1, var2.getTag());
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
