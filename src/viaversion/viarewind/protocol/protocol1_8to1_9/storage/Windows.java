package viaversion.viarewind.protocol.protocol1_8to1_9.storage;

import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.function.Function;
import net.aRE;
import net.cA;
import viaversion.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;

public class Windows extends cA {
   private HashMap types = new HashMap();
   private HashMap brewingItems = new HashMap();

   public Windows(UserConnection var1) {
      super(var1);
   }

   public String get(short var1) {
      return (String)this.types.get(Short.valueOf(var1));
   }

   public void put(short var1, String var2) {
      this.types.put(Short.valueOf(var1), var2);
   }

   public void remove(short var1) {
      this.types.remove(Short.valueOf(var1));
      this.brewingItems.remove(Short.valueOf(var1));
   }

   public Item[] getBrewingItems(short var1) {
      return (Item[])this.brewingItems.computeIfAbsent(Short.valueOf(var1), Windows::lambda$getBrewingItems$0);
   }

   public static void updateBrewingStand(UserConnection var0, Item var1, short var2) {
      String[] var3 = EntityTracker.d();
      if(var1 == null || var1.getIdentifier() == 377) {
         byte var4 = var1 == null?0:var1.getAmount();
         PacketWrapper var5 = new PacketWrapper(45, (ByteBuf)null, var0);
         var5.write(Type.UNSIGNED_BYTE, Short.valueOf(var2));
         var5.write(Type.STRING, "minecraft:brewing_stand");
         var5.write(Type.STRING, "[{\"translate\":\"container.brewing\"},{\"text\":\": \",\"color\":\"dark_gray\"},{\"text\":\"§4" + var4 + " \",\"color\":\"dark_red\"},{\"translate\":\"item.blazePowder.name\",\"color\":\"dark_red\"}]");
         var5.write(Type.UNSIGNED_BYTE, Short.valueOf((short)420));
         PacketUtil.sendPacket(var5, aRE.class);
         Item[] var6 = ((Windows)var0.b(Windows.class)).getBrewingItems(var2);
         int var7 = 0;
         if(var7 < var6.length) {
            PacketWrapper var8 = new PacketWrapper(47, (ByteBuf)null, var0);
            var8.write(Type.BYTE, Byte.valueOf((byte)var2));
            var8.write(Type.SHORT, Short.valueOf((short)var7));
            var8.write(Type.ITEM, var6[var7]);
            PacketUtil.sendPacket(var8, aRE.class);
            ++var7;
         }

      }
   }

   private static Item[] lambda$getBrewingItems$0(Short var0) {
      return new Item[]{new Item(), new Item(), new Item(), new Item()};
   }
}
