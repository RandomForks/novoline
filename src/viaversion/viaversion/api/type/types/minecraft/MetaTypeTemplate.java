package viaversion.viaversion.api.type.types.minecraft;

import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.type.Type;

public abstract class MetaTypeTemplate extends Type {
   public MetaTypeTemplate() {
      super("Metadata type", Metadata.class);
   }

   public Class getBaseClass() {
      return MetaTypeTemplate.class;
   }
}
