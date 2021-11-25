package viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import net.Mo;
import net.aQU;
import net.ahW;
import net.amx;
import net.aoa;
import net.aod;
import net.aq3;
import net.aqq;
import net.ayd;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.Protocol1_14_4To1_15;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets.BlockItemPackets1_15$1;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.ServerboundPacketType;
import viaversion.viaversion.api.rewriters.BlockRewriter;
import viaversion.viaversion.api.rewriters.ItemRewriter$RewriteFunction;
import viaversion.viaversion.api.type.Type;

public class BlockItemPackets1_15 extends aqq {
   public BlockItemPackets1_15(Protocol1_14_4To1_15 var1, TranslatableRewriter var2) {
      super(var1, var2);
   }

   protected void registerPackets() {
      aQU var2 = new aQU(this.c, this::a, this::c);
      BlockRewriter var3 = new BlockRewriter(this.c, Type.POSITION1_14);
      (new amx(this.c, this::a)).registerDefaultHandler(Mo.DECLARE_RECIPES);
      ((Protocol1_14_4To1_15)this.c).a(ahW.EDIT_BOOK, new BlockItemPackets1_15$1(this));
      var2.a((ClientboundPacketType)Mo.COOLDOWN);
      var2.b((ClientboundPacketType)Mo.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
      var2.a((ClientboundPacketType)Mo.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
      var2.e(Mo.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
      var2.f(Mo.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
      var2.c(Mo.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
      var2.a((ServerboundPacketType)ahW.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
      var2.b((ServerboundPacketType)ahW.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
      var3.registerAcknowledgePlayerDigging(Mo.ACKNOWLEDGE_PLAYER_DIGGING);
      aq3.a();
      var3.registerBlockAction(Mo.BLOCK_ACTION);
      var3.registerBlockChange(Mo.BLOCK_CHANGE);
      var3.registerMultiBlockChange(Mo.MULTI_BLOCK_CHANGE);
      ((Protocol1_14_4To1_15)this.c).a(Mo.CHUNK_DATA, new aod(this));
      var3.registerEffect(Mo.EFFECT, 1010, 2001);
      ((Protocol1_14_4To1_15)this.c).a(Mo.SPAWN_PARTICLE, new aoa(this));
   }

   static ayd b(BlockItemPackets1_15 var0) {
      return var0.c;
   }

   static ayd c(BlockItemPackets1_15 var0) {
      return var0.c;
   }

   static ayd a(BlockItemPackets1_15 var0) {
      return var0.c;
   }
}
