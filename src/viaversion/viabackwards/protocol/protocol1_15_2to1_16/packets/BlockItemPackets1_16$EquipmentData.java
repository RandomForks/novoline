package viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets;

import net.anW;
import viaversion.viaversion.api.minecraft.item.Item;

final class BlockItemPackets1_16$EquipmentData {
   private final int slot;
   private final Item item;

   private BlockItemPackets1_16$EquipmentData(int var1, Item var2) {
      this.slot = var1;
      this.item = var2;
   }

   BlockItemPackets1_16$EquipmentData(int var1, Item var2, anW var3) {
      this(var1, var2);
   }

   static int access$100(BlockItemPackets1_16$EquipmentData var0) {
      return var0.slot;
   }

   static Item access$200(BlockItemPackets1_16$EquipmentData var0) {
      return var0.item;
   }
}
