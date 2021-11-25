package viaversion.viaversion.protocols.protocol1_16to1_15_2;

import java.util.UUID;
import net.C4;
import net.Mo;
import net.a66;
import net.aTf;
import net.aVF;
import net.aVS;
import net.aVm;
import net.acE;
import net.adT;
import net.ahW;
import net.cA;
import net.ch;
import net.sM;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.RegistryType;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2$1;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2$3;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2$6;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.data.MappingData;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.data.TranslationMappings;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.EntityPackets;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.WorldPackets;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.storage.EntityTracker1_16;

public class Protocol1_16To1_15_2 extends Protocol {
   private static final UUID ZERO_UUID = new UUID(0L, 0L);
   public static final MappingData MAPPINGS = new MappingData();
   private TagRewriter tagRewriter;
   private static acE[] l;

   public Protocol1_16To1_15_2() {
      super(Mo.class, C4.class, ahW.class, sM.class);
   }

   protected void registerPackets() {
      aTf var2 = new aTf(this);
      EntityPackets.register(this);
      WorldPackets.register(this);
      adT.a(this);
      var2.getClass();
      this.tagRewriter = new TagRewriter(this, var2::getNewEntityId);
      this.tagRewriter.register(Mo.TAGS);
      c();
      var2.getClass();
      (new StatisticsRewriter(this, var2::getNewEntityId)).register(Mo.STATISTICS);
      this.b(a66.LOGIN, 2, 2, new Protocol1_16To1_15_2$1(this));
      this.b(a66.STATUS, 0, 0, new aVm(this));
      TranslationMappings var3 = new TranslationMappings(this);
      this.a(Mo.CHAT_MESSAGE, new Protocol1_16To1_15_2$3(this, var3));
      var3.b((ClientboundPacketType)Mo.BOSSBAR);
      var3.d(Mo.TITLE);
      var3.c(Mo.COMBAT_EVENT);
      SoundRewriter var4 = new SoundRewriter(this);
      var4.registerSound(Mo.SOUND);
      var4.registerSound(Mo.ENTITY_SOUND);
      this.a(sM.INTERACT_ENTITY, new aVS(this));
      if(Via.getConfig().isIgnoreLong1_16ChannelNames()) {
         this.a(sM.PLUGIN_MESSAGE, new aVF(this));
      }

      this.a(sM.PLAYER_ABILITIES, new Protocol1_16To1_15_2$6(this));
      this.cancelIncoming(sM.GENERATE_JIGSAW);
      this.cancelIncoming(sM.UPDATE_JIGSAW_BLOCK);
      if(acE.b() == null) {
         a(new acE[1]);
      }

   }

   protected void onMappingDataLoaded() {
      c();
      int[] var2 = new int[47];
      int var3 = 0;
      var2[var3++] = 140;
      var2[var3++] = 179;
      var2[var3++] = 264;
      int var4 = 153;
      if(var4 <= 158) {
         var2[var3++] = var4++;
      }

      var4 = 163;
      if(var4 <= 168) {
         var2[var3++] = var4++;
      }

      var4 = 408;
      if(var4 <= 439) {
         var2[var3++] = var4++;
      }

      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wall_post_override", var2);
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:beacon_base_blocks", new int[]{133, 134, 148, 265});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:climbable", new int[]{160, 241, 658});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fire", new int[]{142});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:campfires", new int[]{679});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fence_gates", new int[]{242, 467, 468, 469, 470, 471});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:unstable_bottom_center", new int[]{242, 467, 468, 469, 470, 471});
      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wooden_trapdoors", new int[]{193, 194, 195, 196, 197, 198});
      this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:wooden_trapdoors", new int[]{215, 216, 217, 218, 219, 220});
      this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:beacon_payment_items", new int[]{529, 530, 531, 760});
      this.tagRewriter.addTag(RegistryType.ENTITY, "minecraft:impact_projectiles", new int[]{2, 72, 71, 37, 69, 79, 83, 15, 93});
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:guarded_by_piglins");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_speed_blocks");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_fire_base_blocks");
      this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:non_flammable_wood");
      this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:non_flammable_wood");
      this.tagRewriter.addEmptyTags(RegistryType.BLOCK, new String[]{"minecraft:bamboo_plantable_on", "minecraft:beds", "minecraft:bee_growables", "minecraft:beehives", "minecraft:coral_plants", "minecraft:crops", "minecraft:dragon_immune", "minecraft:flowers", "minecraft:portals", "minecraft:shulker_boxes", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:underwater_bonemeals", "minecraft:wither_immune", "minecraft:wooden_fences", "minecraft:wooden_trapdoors"});
      this.tagRewriter.addEmptyTags(RegistryType.ENTITY, new String[]{"minecraft:arrows", "minecraft:beehive_inhabitors", "minecraft:raiders", "minecraft:skeletons"});
      this.tagRewriter.addEmptyTags(RegistryType.ITEM, new String[]{"minecraft:beds", "minecraft:coals", "minecraft:fences", "minecraft:flowers", "minecraft:lectern_books", "minecraft:music_discs", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:walls", "minecraft:wooden_fences"});
   }

   public void init(UserConnection var1) {
      var1.a((cA)(new EntityTracker1_16(var1)));
      var1.a((cA)(new ch(var1)));
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   static UUID access$000() {
      return ZERO_UUID;
   }

   static {
      a((acE[])null);
   }

   public static void a(acE[] var0) {
      l = var0;
   }

   public static acE[] c() {
      return l;
   }
}
