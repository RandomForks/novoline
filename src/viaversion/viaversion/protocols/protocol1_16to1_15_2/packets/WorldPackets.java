package viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.IntArrayTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.util.Iterator;
import java.util.UUID;
import net.Mo;
import net.aVq;
import net.adT;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.UUIDIntArrayType;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.WorldPackets$1;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.WorldPackets$3;

public class WorldPackets {
   public static void register(Protocol1_16To1_15_2 var0) {
      BlockRewriter var1 = new BlockRewriter(var0, Type.POSITION1_14);
      var1.registerBlockAction(Mo.BLOCK_ACTION);
      var1.registerBlockChange(Mo.BLOCK_CHANGE);
      var1.registerMultiBlockChange(Mo.MULTI_BLOCK_CHANGE);
      var1.registerAcknowledgePlayerDigging(Mo.ACKNOWLEDGE_PLAYER_DIGGING);
      var0.a(Mo.UPDATE_LIGHT, new WorldPackets$1());
      var0.a(Mo.CHUNK_DATA, new aVq(var0));
      var0.a(Mo.BLOCK_ENTITY_DATA, new WorldPackets$3());
      var1.registerEffect(Mo.EFFECT, 1010, 2001);
   }

   private static void handleBlockEntity(CompoundTag var0) {
      adT.b();
      StringTag var2 = (StringTag)var0.get("id");
      if(var2 != null) {
         String var3 = var2.getValue();
         if(var3.equals("minecraft:conduit")) {
            Tag var4 = var0.remove("target_uuid");
            if(!(var4 instanceof StringTag)) {
               return;
            }

            UUID var5 = UUID.fromString((String)var4.getValue());
            var0.put(new IntArrayTag("Target", UUIDIntArrayType.uuidToIntArray(var5)));
         }

         if(var3.equals("minecraft:skull") && var0.get("Owner") instanceof CompoundTag) {
            CompoundTag var9 = (CompoundTag)var0.remove("Owner");
            StringTag var10 = (StringTag)var9.remove("Id");
            if(var10 != null) {
               UUID var6 = UUID.fromString(var10.getValue());
               var9.put(new IntArrayTag("Id", UUIDIntArrayType.uuidToIntArray(var6)));
            }

            CompoundTag var11 = new CompoundTag("SkullOwner");
            Iterator var7 = var9.iterator();
            if(var7.hasNext()) {
               Tag var8 = (Tag)var7.next();
               var11.put(var8);
            }

            var0.put(var11);
         }

      }
   }

   static void access$000(CompoundTag var0) {
      handleBlockEntity(var0);
   }
}
