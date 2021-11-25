package viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import net.aqQ;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.item.Item;

public class HandItemProvider implements aqQ {
   public Item getHandItem(UserConnection var1) {
      return new Item(0, (byte)0, (short)0, (CompoundTag)null);
   }
}
