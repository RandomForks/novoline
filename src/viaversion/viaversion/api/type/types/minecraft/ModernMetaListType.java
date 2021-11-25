package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.AbstractMetaListType;

public abstract class ModernMetaListType extends AbstractMetaListType {
   protected void writeEnd(Type var1, ByteBuf var2) throws Exception {
      var1.write(var2, (Object)null);
   }
}
