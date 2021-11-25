package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import de.gerrygames.viarewind.utils.PacketUtil;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.function.Function;
import net.aMz;
import net.aRE;
import net.bgR;
import net.cA;

public class Windows extends cA {
   private HashMap types = new HashMap();
   private HashMap brewingItems = new HashMap();

   public Windows(bgR var1) {
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

   public aMz[] c(short var1) {
      return (aMz[])this.brewingItems.computeIfAbsent(Short.valueOf(var1), Windows::lambda$getBrewingItems$0);
   }

   public static void a(bgR var0, aMz var1, short var2) {
      String[] var3 = EntityTracker.d();
      if(var1 == null || var1.e() == 377) {
         byte var4 = var1 == null?0:var1.f();
         PacketWrapperImpl var5 = new PacketWrapperImpl(45, (ByteBuf)null, var0);
         var5.a(Type.M, Short.valueOf(var2));
         var5.a(Type.STRING, "minecraft:brewing_stand");
         var5.a(Type.STRING, "[{\"translate\":\"container.brewing\"},{\"text\":\": \",\"color\":\"dark_gray\"},{\"text\":\"§4" + var4 + " \",\"color\":\"dark_red\"},{\"translate\":\"item.blazePowder.name\",\"color\":\"dark_red\"}]");
         var5.a(Type.M, Short.valueOf((short)420));
         PacketUtil.b(var5, aRE.class);
         aMz[] var6 = ((Windows)var0.b(Windows.class)).c(var2);
         int var7 = 0;
         if(var7 < var6.length) {
            PacketWrapperImpl var8 = new PacketWrapperImpl(47, (ByteBuf)null, var0);
            var8.a(Type.k, Byte.valueOf((byte)var2));
            var8.a(Type.SHORT, Short.valueOf((short)var7));
            var8.a(Type.ITEM, var6[var7]);
            PacketUtil.b(var8, aRE.class);
            ++var7;
         }

      }
   }

   private static aMz[] lambda$getBrewingItems$0(Short var0) {
      return new aMz[]{new aMz(), new aMz(), new aMz(), new aMz()};
   }
}
