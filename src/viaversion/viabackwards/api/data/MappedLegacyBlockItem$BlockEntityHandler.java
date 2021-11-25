package viaversion.viabackwards.api.data;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;

@FunctionalInterface
public interface MappedLegacyBlockItem$BlockEntityHandler {
   CompoundTag handleOrNewCompoundTag(int var1, CompoundTag var2);
}
