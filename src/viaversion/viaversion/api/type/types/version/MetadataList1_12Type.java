package viaversion.viaversion.api.type.types.version;

import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.minecraft.ModernMetaListType;
import viaversion.viaversion.api.type.types.version.Types1_12;

public class MetadataList1_12Type extends ModernMetaListType {
   protected Type getType() {
      return Types1_12.METADATA;
   }
}
