package viaversion.viabackwards.protocol.protocol1_14_4to1_15;

import net.Mo;
import net.acE;
import net.ahW;
import net.aq3;
import net.aqF;
import net.awj;
import net.ayd;
import net.cA;
import net.cQ;
import net.cW;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.Protocol1_14_4To1_15$1;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.data.EntityTypeMapping;
import viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets.BlockItemPackets1_15;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;
import viaversion.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;

public class Protocol1_14_4To1_15 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings("1.15", "1.14", Protocol1_15To1_14_4.class, true);
   private BlockItemPackets1_15 blockItemPackets;

   public Protocol1_14_4To1_15() {
      super(Mo.class, awj.class, ahW.class, ahW.class);
   }

   protected void registerPackets() {
      BackwardsMappings var10002 = MAPPINGS;
      MAPPINGS.getClass();
      this.a(Protocol1_15To1_14_4.class, var10002::load);
      TranslatableRewriter var2 = new TranslatableRewriter(this, "1.15");
      var2.b(Mo.BOSSBAR);
      var2.registerChatMessage(Mo.CHAT_MESSAGE);
      var2.c(Mo.COMBAT_EVENT);
      var2.registerDisconnect(Mo.DISCONNECT);
      var2.registerOpenWindow(Mo.OPEN_WINDOW);
      var2.registerTabList(Mo.TAB_LIST);
      var2.d(Mo.TITLE);
      var2.registerPing();
      (this.blockItemPackets = new BlockItemPackets1_15(this, var2)).f();
      (new aq3(this)).f();
      SoundRewriter var3 = new SoundRewriter(this);
      aqF.b();
      var3.registerSound(Mo.SOUND);
      var3.registerSound(Mo.ENTITY_SOUND);
      var3.registerNamedSound(Mo.NAMED_SOUND);
      var3.registerStopSound(Mo.STOP_SOUND);
      this.a(Mo.EXPLOSION, new Protocol1_14_4To1_15$1(this));
      (new TagRewriter(this, EntityTypeMapping::getOldEntityId)).register(Mo.TAGS);
      (new StatisticsRewriter(this, EntityTypeMapping::getOldEntityId)).register(Mo.STATISTICS);
   }

   public void init(UserConnection var1) {
      acE[] var2 = aqF.b();
      if(!var1.has(cW.class)) {
         var1.a((cA)(new cW(var1)));
      }

      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      ((cQ)var1.b(cQ.class)).b(this);
      if(acE.b() == null) {
         aqF.b(new acE[3]);
      }

   }

   public BlockItemPackets1_15 getBlockItemPackets() {
      return this.blockItemPackets;
   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }
}
