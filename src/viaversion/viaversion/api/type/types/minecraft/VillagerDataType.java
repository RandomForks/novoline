package viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.ByteBuf;
import viaversion.viaversion.api.minecraft.VillagerData;
import viaversion.viaversion.api.type.Type;

public class VillagerDataType extends Type {
   public VillagerDataType() {
      super("VillagerData", VillagerData.class);
   }

   public VillagerData read(ByteBuf var1) throws Exception {
      return new VillagerData(Type.VAR_INT.readPrimitive(var1), Type.VAR_INT.readPrimitive(var1), Type.VAR_INT.readPrimitive(var1));
   }

   public void write(ByteBuf var1, VillagerData var2) throws Exception {
      Type.VAR_INT.writePrimitive(var1, var2.getType());
      Type.VAR_INT.writePrimitive(var1, var2.getProfession());
      Type.VAR_INT.writePrimitive(var1, var2.getLevel());
   }
}
