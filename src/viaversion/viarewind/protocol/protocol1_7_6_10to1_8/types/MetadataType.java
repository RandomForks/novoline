package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.ByteBuf;
import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.MetaType1_7_6_10;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.type.types.minecraft.MetaTypeTemplate;

public class MetadataType extends MetaTypeTemplate {
   public Metadata read(ByteBuf var1) throws Exception {
      Particle.b();
      byte var3 = var1.readByte();
      if(var3 == 127) {
         return null;
      } else {
         int var4 = (var3 & 224) >> 5;
         MetaType1_7_6_10 var5 = MetaType1_7_6_10.byId(var4);
         int var6 = var3 & 31;
         return new Metadata(var6, var5, var5.getType().read(var1));
      }
   }

   public void write(ByteBuf var1, Metadata var2) throws Exception {
      Particle.b();
      int var4 = (var2.getMetaType().getTypeID() << 5 | var2.getId() & 31) & 255;
      var1.writeByte(var4);
      var2.getMetaType().getType().write(var1, var2.getValue());
      if(acE.b() == null) {
         Particle.b(new acE[4]);
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
