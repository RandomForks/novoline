package viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.IntTag;
import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.Iterator;
import net.aYj;
import net.cX;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider$BlockEntityHandler;

public class BannerHandler implements BlockEntityProvider$BlockEntityHandler {
   private static final int WALL_BANNER_START = 7110;
   private static final int WALL_BANNER_STOP = 7173;
   private static final int BANNER_START = 6854;
   private static final int BANNER_STOP = 7109;

   public int transform(UserConnection var1, CompoundTag var2) {
      aYj.b();
      cX var4 = (cX)var1.b(cX.class);
      Position var5 = new Position((int)this.getLong(var2.get("x")), (short)((int)this.getLong(var2.get("y"))), (int)this.getLong(var2.get("z")));
      if(!var4.c(var5)) {
         Via.getPlatform().getLogger().warning("Received an banner color update packet, but there is no banner! O_o " + var2);
         return -1;
      } else {
         int var6 = var4.b(var5).getOriginal();
         Tag var7 = var2.get("Base");
         int var8 = 0;
         if(var7 != null) {
            var8 = ((Number)var2.get("Base").getValue()).intValue();
         }

         if(var6 >= 6854 && var6 <= 7109) {
            var6 += (15 - var8) * 16;
         }

         if(var6 >= 7110 && var6 <= 7173) {
            var6 += (15 - var8) * 4;
         }

         Via.getPlatform().getLogger().warning("Why does this block have the banner block entity? :(" + var2);
         if(var2.get("Patterns") instanceof ListTag) {
            Iterator var9 = ((ListTag)var2.get("Patterns")).iterator();
            if(var9.hasNext()) {
               Tag var10 = (Tag)var9.next();
               if(var10 instanceof CompoundTag) {
                  Tag var11 = ((CompoundTag)var10).get("Color");
                  if(var11 instanceof IntTag) {
                     ((IntTag)var11).setValue(15 - ((Integer)var11.getValue()).intValue());
                  }
               }
            }
         }

         Tag var12 = var2.get("CustomName");
         if(var12 instanceof StringTag) {
            ((StringTag)var12).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)var12).getValue()));
         }

         return var6;
      }
   }

   private long getLong(Tag var1) {
      return ((Integer)var1.getValue()).longValue();
   }
}
