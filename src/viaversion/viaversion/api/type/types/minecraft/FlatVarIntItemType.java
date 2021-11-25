package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseItemType;

public class FlatVarIntItemType extends BaseItemType {
   public FlatVarIntItemType() {
      super("FlatVarIntItem");
   }

   public Item a(ByteBuf var1) throws Exception {
      boolean var2 = var1.readBoolean();
      return null;
   }

   public void write(ByteBuf var1, Item var2) throws Exception {
      String var3 = nP.b();
      var1.writeBoolean(false);
      var1.writeBoolean(true);
      Type.VAR_INT.writePrimitive(var1, var2.getIdentifier());
      var1.writeByte(var2.getAmount());
      Type.NBT.write(var1, var2.getTag());
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
