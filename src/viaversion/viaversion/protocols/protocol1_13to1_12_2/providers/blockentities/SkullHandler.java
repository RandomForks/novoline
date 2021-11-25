package viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import net.aYj;
import net.cX;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider$BlockEntityHandler;

public class SkullHandler implements BlockEntityProvider$BlockEntityHandler {
   private static final int SKULL_WALL_START = 5447;
   private static final int SKULL_END = 5566;

   public int transform(UserConnection var1, CompoundTag var2) {
      cX var4 = (cX)var1.b(cX.class);
      aYj.a();
      Position var5 = new Position((int)this.getLong(var2.get("x")), (short)((int)this.getLong(var2.get("y"))), (int)this.getLong(var2.get("z")));
      if(!var4.c(var5)) {
         Via.getPlatform().getLogger().warning("Received an head update packet, but there is no head! O_o " + var2);
         return -1;
      } else {
         int var6 = var4.b(var5).getOriginal();
         if(var6 >= 5447 && var6 <= 5566) {
            Tag var7 = var2.get("SkullType");
            var6 = var6 + ((Number)var2.get("SkullType").getValue()).intValue() * 20;
            if(var2.contains("Rot")) {
               int var10000 = var6 + ((Number)var2.get("Rot").getValue()).intValue();
            }
         }

         Via.getPlatform().getLogger().warning("Why does this block have the skull block entity? " + var2);
         return -1;
      }
   }

   private long getLong(Tag var1) {
      return ((Integer)var1.getValue()).longValue();
   }
}
