package viaversion.viaversion.api.type.types.minecraft;

import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;

public abstract class BaseItemType extends Type {
   public BaseItemType() {
      super("Item", Item.class);
   }

   public BaseItemType(String var1) {
      super(var1, Item.class);
   }

   public Class getBaseClass() {
      return BaseItemType.class;
   }
}
