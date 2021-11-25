package viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets;

import java.util.ArrayList;
import net.Mo;
import net.acE;
import net.anW;
import net.aqX;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets.BlockItemPackets1_16$EquipmentData;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class BlockItemPackets1_16$2 extends acE {
   final aqX c;

   BlockItemPackets1_16$2(aqX var1) {
      this.c = var1;
   }

   public void registerMap() {
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(PacketWrapper var1) throws Exception {
      aqX.a();
      int var3 = ((Integer)var1.passthrough(Type.VAR_INT)).intValue();
      ArrayList var4 = new ArrayList();

      while(true) {
         byte var5 = ((Byte)var1.read(Type.BYTE)).byteValue();
         Item var6 = this.c.a((Item)var1.read(Type.FLAT_VAR_INT_ITEM));
         int var7 = var5 & 127;
         var4.add(new BlockItemPackets1_16$EquipmentData(var7, var6, (anW)null));
         if((var5 & -128) == 0) {
            break;
         }
      }

      BlockItemPackets1_16$EquipmentData var10 = (BlockItemPackets1_16$EquipmentData)var4.get(0);
      var1.write(Type.VAR_INT, Integer.valueOf(BlockItemPackets1_16$EquipmentData.access$100(var10)));
      var1.write(Type.FLAT_VAR_INT_ITEM, BlockItemPackets1_16$EquipmentData.access$200(var10));
      int var11 = 1;
      if(var11 < var4.size()) {
         PacketWrapper var8 = var1.create(Mo.ENTITY_EQUIPMENT.ordinal());
         BlockItemPackets1_16$EquipmentData var9 = (BlockItemPackets1_16$EquipmentData)var4.get(var11);
         var8.write(Type.VAR_INT, Integer.valueOf(var3));
         var8.write(Type.VAR_INT, Integer.valueOf(BlockItemPackets1_16$EquipmentData.access$100(var9)));
         var8.write(Type.FLAT_VAR_INT_ITEM, BlockItemPackets1_16$EquipmentData.access$200(var9));
         var8.send(Protocol1_15_2To1_16.class);
         ++var11;
      }

   }
}
