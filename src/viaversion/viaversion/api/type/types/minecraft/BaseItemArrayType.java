package viaversion.viaversion.api.type.types.minecraft;

import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;

public abstract class BaseItemArrayType extends Type {
   public BaseItemArrayType() {
      super("Item[]", Item[].class);
   }

   public BaseItemArrayType(String var1) {
      super(var1, Item[].class);
   }

   public Class getBaseClass() {
      return BaseItemArrayType.class;
   }
}
