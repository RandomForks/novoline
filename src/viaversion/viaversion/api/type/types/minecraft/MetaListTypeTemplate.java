package viaversion.viaversion.api.type.types.minecraft;

import java.util.List;
import viaversion.viaversion.api.type.Type;

public abstract class MetaListTypeTemplate extends Type {
   protected MetaListTypeTemplate() {
      super("MetaData List", List.class);
   }

   public Class getBaseClass() {
      return MetaListTypeTemplate.class;
   }
}
