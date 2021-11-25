package viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers.FlowerPotHandler;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.BackwardsBlockEntityProvider$BackwardsBlockEntityHandler;
import viaversion.viaversion.api.data.UserConnection;

public class SkullHandler implements BackwardsBlockEntityProvider$BackwardsBlockEntityHandler {
   private static final int SKULL_START = 5447;

   public CompoundTag transform(UserConnection var1, int var2, CompoundTag var3) {
      FlowerPotHandler.b();
      int var5 = var2 - 5447;
      int var6 = var5 % 20;
      byte var7 = (byte)((int)Math.floor((double)((float)var5 / 20.0F)));
      var3.put(new ByteTag("SkullType", var7));
      if(var6 < 4) {
         return var3;
      } else {
         var3.put(new ByteTag("Rot", (byte)(var6 - 4 & 255)));
         return var3;
      }
   }
}
