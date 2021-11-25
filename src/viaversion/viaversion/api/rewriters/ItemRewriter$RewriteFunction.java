package viaversion.viaversion.api.rewriters;

import viaversion.viaversion.api.minecraft.item.Item;

@FunctionalInterface
public interface ItemRewriter$RewriteFunction {
   void rewrite(Item var1);
}
