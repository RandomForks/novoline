package viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers.FlowerPotHandler;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.EntityNameRewrites;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.BackwardsBlockEntityProvider$BackwardsBlockEntityHandler;
import viaversion.viaversion.api.data.UserConnection;

public class SpawnerHandler implements BackwardsBlockEntityProvider$BackwardsBlockEntityHandler {
   public CompoundTag transform(UserConnection var1, int var2, CompoundTag var3) {
      FlowerPotHandler.b();
      Tag var5 = var3.get("SpawnData");
      if(var5 instanceof CompoundTag) {
         CompoundTag var6 = (CompoundTag)var5;
         Tag var7 = var6.get("id");
         if(var7 instanceof StringTag) {
            StringTag var8 = (StringTag)var7;
            var8.setValue(EntityNameRewrites.rewrite(var8.getValue()));
         }
      }

      return var3;
   }
}
