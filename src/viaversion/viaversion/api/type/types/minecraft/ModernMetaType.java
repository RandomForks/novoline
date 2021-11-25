package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import net.nP;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.type.types.minecraft.MetaTypeTemplate;

public abstract class ModernMetaType extends MetaTypeTemplate {
   public Metadata read(ByteBuf var1) throws Exception {
      short var2 = var1.readUnsignedByte();
      if(var2 == 255) {
         return null;
      } else {
         MetaType var3 = this.getType(var1.readByte());
         return new Metadata(var2, var3, var3.getType().read(var1));
      }
   }

   protected abstract MetaType getType(int var1);

   public void write(ByteBuf var1, Metadata var2) throws Exception {
      String var3 = nP.b();
      if(var2 == null) {
         var1.writeByte(255);
      }

      var1.writeByte(var2.getId());
      MetaType var4 = var2.getMetaType();
      var1.writeByte(var4.getTypeID());
      var4.getType().write(var1, var2.getValue());
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
