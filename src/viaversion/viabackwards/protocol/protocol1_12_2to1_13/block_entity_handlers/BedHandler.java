package viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.IntTag;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.BackwardsBlockEntityProvider$BackwardsBlockEntityHandler;
import viaversion.viaversion.api.data.UserConnection;

public class BedHandler implements BackwardsBlockEntityProvider$BackwardsBlockEntityHandler {
   public CompoundTag transform(UserConnection var1, int var2, CompoundTag var3) {
      int var4 = var2 - 748;
      int var5 = var4 >> 4;
      var3.put(new IntTag("color", var5));
      return var3;
   }
}
