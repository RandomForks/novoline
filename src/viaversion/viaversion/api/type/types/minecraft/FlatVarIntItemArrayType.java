package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.BaseItemArrayType;

public class FlatVarIntItemArrayType extends BaseItemArrayType {
   public FlatVarIntItemArrayType() {
      super("Flat Item Array");
   }

   public Item[] read(ByteBuf var1) throws Exception {
      short var3 = Type.SHORT.readPrimitive(var1);
      Item[] var4 = new Item[var3];
      nP.b();
      int var5 = 0;
      if(var5 < var3) {
         var4[var5] = (Item)Type.FLAT_VAR_INT_ITEM.read(var1);
         ++var5;
      }

      return var4;
   }

   public void write(ByteBuf var1, Item[] var2) throws Exception {
      nP.b();
      Type.SHORT.writePrimitive(var1, (short)var2.length);
      int var5 = var2.length;
      int var6 = 0;
      if(var6 < var5) {
         Item var7 = var2[var6];
         Type.FLAT_VAR_INT_ITEM.write(var1, var7);
         ++var6;
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
