package viaversion.viaversion.api.type.types.version;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.AbstractMetaListType;
import viaversion.viaversion.api.type.types.version.Types1_8;

public class MetadataList1_8Type extends AbstractMetaListType {
   protected Type getType() {
      return Types1_8.METADATA;
   }

   protected void writeEnd(Type var1, ByteBuf var2) throws Exception {
      var2.writeByte(127);
   }
}
