package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.minecraft.metadata.Metadata;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.types.minecraft.MetaListTypeTemplate;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.MetaType1_7_6_10;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.MetadataType;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.axZ;

public class MetadataListType extends MetaListTypeTemplate {
   private MetadataType metadataType = new MetadataType();

   public List read(ByteBuf var1) throws Exception {
      Particle.b();
      ArrayList var3 = new ArrayList();

      while(true) {
         Metadata var4 = (Metadata)axZ.d.read(var1);
         var3.add(var4);
         if(var4 == null) {
            break;
         }
      }

      if(this.find(2, "Slot", var3) != null && this.find(8, "Slot", var3) != null) {
         var3.removeIf(MetadataListType::lambda$read$0);
      }

      return var3;
   }

   private Metadata find(int var1, String var2, List var3) {
      Particle.b();
      Iterator var5 = var3.iterator();
      if(var5.hasNext()) {
         Metadata var6 = (Metadata)var5.next();
         if(var6.id() == var1 && var6.metaType().toString().equals(var2)) {
            return var6;
         }
      }

      return null;
   }

   public void write(ByteBuf var1, List var2) throws Exception {
      Particle.b();
      Iterator var4 = var2.iterator();
      if(var4.hasNext()) {
         Metadata var5 = (Metadata)var4.next();
         axZ.d.write(var1, var5);
      }

      if(var2.isEmpty()) {
         axZ.d.write(var1, new Metadata(0, MetaType1_7_6_10.Byte, Byte.valueOf((byte)0)));
      }

      var1.writeByte(127);
   }

   private static boolean lambda$read$0(Metadata var0) {
      PacketRemapper[] var1 = Particle.b();
      return var0.id() == 2 || var0.id() == 3;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
