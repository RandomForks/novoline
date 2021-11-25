package viaversion.viabackwards.protocol.protocol1_13_2to1_14;

import net.aSG;
import net.acE;
import net.ahW;
import net.aoA;
import net.aoJ;
import net.aq6;
import net.awj;
import net.ayd;
import net.cA;
import net.cK;
import net.cQ;
import net.cT;
import net.q1;
import net.uN;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.EntityPackets1_14;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.PlayerPackets1_14;
import viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.SoundPackets1_14;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;

public class Protocol1_13_2To1_14 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings("1.14", "1.13.2", Protocol1_14To1_13_2.class, true);
   private aq6 j;
   private EntityPackets1_14 entityPackets;

   public Protocol1_13_2To1_14() {
      super(awj.class, q1.class, ahW.class, uN.class);
   }

   protected void registerPackets() {
      BackwardsMappings var10002 = MAPPINGS;
      MAPPINGS.getClass();
      this.a(Protocol1_14To1_13_2.class, var10002::load);
      TranslatableRewriter var2 = new TranslatableRewriter(this, "1.14");
      var2.b(awj.BOSSBAR);
      var2.registerChatMessage(awj.CHAT_MESSAGE);
      var2.c(awj.COMBAT_EVENT);
      var2.registerDisconnect(awj.DISCONNECT);
      var2.registerTabList(awj.TAB_LIST);
      var2.d(awj.TITLE);
      aSG.b();
      var2.registerPing();
      this.j = new aq6(this, var2);
      this.j.f();
      this.entityPackets = new EntityPackets1_14(this);
      this.entityPackets.f();
      (new PlayerPackets1_14(this)).f();
      (new SoundPackets1_14(this)).f();
      EntityPackets1_14 var10004 = this.entityPackets;
      this.entityPackets.getClass();
      (new StatisticsRewriter(this, var10004::getOldEntityId)).register(awj.STATISTICS);
      this.cancelOutgoing(awj.UPDATE_VIEW_POSITION);
      this.cancelOutgoing(awj.UPDATE_VIEW_DISTANCE);
      this.cancelOutgoing(awj.ACKNOWLEDGE_PLAYER_DIGGING);
      this.a(awj.TAGS, new aoJ(this));
      this.a(awj.UPDATE_LIGHT, (ClientboundPacketType)null, new aoA(this));
   }

   public void init(UserConnection var1) {
      acE[] var2 = aSG.b();
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      ((cQ)var1.b(cQ.class)).b(this);
      if(!var1.has(cK.class)) {
         var1.a((cA)(new cK(var1)));
      }

   }

   public aq6 b() {
      return this.j;
   }

   public EntityPackets1_14 getEntityPackets() {
      return this.entityPackets;
   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }
}
