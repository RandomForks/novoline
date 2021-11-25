package viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import java.util.ArrayList;
import net.aIP;
import net.aR5;
import net.rX;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.remapper.ValueCreator;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter;

class SpawnPackets$2$4$1 implements ValueCreator {
   final int val$entityID;
   final int val$data;
   final aIP c;

   SpawnPackets$2$4$1(aIP var1, int var2, int var3) {
      this.c = var1;
      this.val$entityID = var2;
      this.val$data = var3;
   }

   public void write(PacketWrapper var1) throws Exception {
      var1.write(Type.VAR_INT, Integer.valueOf(this.val$entityID));
      ArrayList var2 = new ArrayList();
      Item var3 = new Item(373, (byte)1, (short)this.val$data, (CompoundTag)null);
      ItemRewriter.toClient(var3);
      Metadata var4 = new Metadata(5, aR5.Slot, var3);
      var2.add(var4);
      var1.write(rX.a, var2);
   }
}
