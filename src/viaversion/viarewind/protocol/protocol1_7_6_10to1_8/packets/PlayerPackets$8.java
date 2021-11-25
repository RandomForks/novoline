package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import net.JM;
import net.aRi;
import net.acE;
import net.afz;
import net.axZ;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage$GameProfile;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.base.ProtocolInfo;

final class PlayerPackets$8 extends acE {
   public void registerMap() {
      this.a(Type.UNSIGNED_BYTE);
      this.a(Type.FLOAT);
      this.a(PlayerPackets$8::lambda$registerMap$0);
      this.a(PlayerPackets$8::lambda$registerMap$1);
   }

   private static void lambda$registerMap$1(PacketWrapper var0) throws Exception {
      afz.b();
      short var2 = ((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue();
      if(var2 == 3) {
         int var3 = ((Float)var0.get(Type.FLOAT, 0)).intValue();
         if(var3 == 2 && JM.b().isReplaceAdventureMode()) {
            var3 = 0;
            var0.set(Type.FLOAT, 0, Float.valueOf(0.0F));
         }

         ((EntityTracker)var0.user().b(EntityTracker.class)).k(var3);
      }

   }

   private static void lambda$registerMap$0(PacketWrapper var0) throws Exception {
      afz.a();
      short var2 = ((Short)var0.get(Type.UNSIGNED_BYTE, 0)).shortValue();
      if(var2 == 3) {
         int var3 = ((Float)var0.get(Type.FLOAT, 0)).intValue();
         EntityTracker var4 = (EntityTracker)var0.user().b(EntityTracker.class);
         if(var3 == 3 || var4.a() == 3) {
            UUID var5 = ((ProtocolInfo)var0.user().b(ProtocolInfo.class)).getUuid();
            if(var3 == 3) {
               GameProfileStorage$GameProfile var7 = ((GameProfileStorage)var0.user().b(GameProfileStorage.class)).get(var5);
               Item[] var6 = new Item[5];
               var6[4] = var7.getSkull();
            }

            Item[] var9 = var4.getPlayerEquipment(var5);
            if(var9 == null) {
               var9 = new Item[5];
            }

            int var10 = 1;
            if(var10 < 5) {
               PacketWrapper var8 = new PacketWrapper(47, (ByteBuf)null, var0.user());
               var8.write(Type.BYTE, Byte.valueOf((byte)0));
               var8.write(Type.SHORT, Short.valueOf((short)(9 - var10)));
               var8.write(axZ.c, var9[var10]);
               PacketUtil.sendPacket(var8, aRi.class);
               ++var10;
            }
         }

      }
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
