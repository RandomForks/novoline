package viaversion.viaversion.api.type.types.version;

import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_13_2;
import viaversion.viaversion.api.type.types.minecraft.ModernMetaType;

public class Metadata1_13_2Type extends ModernMetaType {
   protected MetaType getType(int var1) {
      return MetaType1_13_2.byId(var1);
   }
}
