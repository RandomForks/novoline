package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.minecraft.BlockChangeRecord;
import viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import viaversion.viaversion.api.type.Type;

public class BlockChangeRecordType extends Type {
   public BlockChangeRecordType() {
      super("BlockChangeRecord", BlockChangeRecord.class);
   }

   public BlockChangeRecord read(ByteBuf var1) throws Exception {
      short var2 = Type.SHORT.readPrimitive(var1);
      int var3 = Type.VAR_INT.readPrimitive(var1);
      return new BlockChangeRecord1_8(var2 >> 12 & 15, var2 & 255, var2 >> 8 & 15, var3);
   }

   public void write(ByteBuf var1, BlockChangeRecord var2) throws Exception {
      Type.SHORT.writePrimitive(var1, (short)(var2.getSectionX() << 12 | var2.getSectionZ() << 8 | var2.getY()));
      Type.VAR_INT.writePrimitive(var1, var2.getBlockId());
   }
}
