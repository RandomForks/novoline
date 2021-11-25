package viaversion.viabackwards.protocol.protocol1_15_2to1_16;

import net.C4;
import net.Mo;
import net.a0V;
import net.a66;
import net.acE;
import net.ahW;
import net.an7;
import net.an9;
import net.anC;
import net.ann;
import net.aqX;
import net.ayd;
import net.cA;
import net.cM;
import net.cQ;
import net.cT;
import net.cV;
import net.kF;
import net.sM;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16$2;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16$4;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.Protocol1_15_2To1_16$7;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.data.BackwardsMappings;
import viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets.EntityPackets1_16;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;

public class Protocol1_15_2To1_16 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings();
   private aqX j;
   private TranslatableRewriter translatableRewriter;

   public Protocol1_15_2To1_16() {
      super(C4.class, Mo.class, sM.class, ahW.class);
   }

   protected void registerPackets() {
      BackwardsMappings var10002 = MAPPINGS;
      MAPPINGS.getClass();
      this.a(Protocol1_16To1_15_2.class, var10002::load);
      this.translatableRewriter = new kF(this, "1.16");
      this.translatableRewriter.b(C4.BOSSBAR);
      this.translatableRewriter.c(C4.COMBAT_EVENT);
      this.translatableRewriter.registerDisconnect(C4.DISCONNECT);
      this.translatableRewriter.registerTabList(C4.TAB_LIST);
      this.translatableRewriter.d(C4.TITLE);
      a0V.b();
      this.translatableRewriter.registerPing();
      (this.j = new aqX(this, this.translatableRewriter)).f();
      EntityPackets1_16 var2 = new EntityPackets1_16(this);
      var2.f();
      this.b(a66.STATUS, 0, 0, new anC(this));
      this.a(C4.CHAT_MESSAGE, new Protocol1_15_2To1_16$2(this));
      this.a(C4.OPEN_WINDOW, new ann(this));
      SoundRewriter var3 = new SoundRewriter(this);
      var3.registerSound(C4.SOUND);
      var3.registerSound(C4.ENTITY_SOUND);
      var3.registerNamedSound(C4.NAMED_SOUND);
      var3.registerStopSound(C4.STOP_SOUND);
      this.b(a66.LOGIN, 2, 2, new Protocol1_15_2To1_16$4(this));
      var2.getClass();
      (new TagRewriter(this, var2::getOldEntityId)).register(C4.TAGS);
      var2.getClass();
      (new StatisticsRewriter(this, var2::getOldEntityId)).register(C4.STATISTICS);
      this.a(ahW.ENTITY_ACTION, new an9(this));
      this.a(ahW.INTERACT_ENTITY, new an7(this));
      this.a(ahW.PLAYER_ABILITIES, new Protocol1_15_2To1_16$7(this));
      this.cancelIncoming(ahW.UPDATE_JIGSAW_BLOCK);
   }

   public void init(UserConnection var1) {
      acE[] var2 = a0V.b();
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      var1.a((cA)(new cM(var1)));
      var1.a((cA)(new cV(var1)));
      ((cQ)var1.b(cQ.class)).b(this);
      if(acE.b() == null) {
         a0V.b(new acE[1]);
      }

   }

   public aqX c() {
      return this.j;
   }

   public TranslatableRewriter getTranslatableRewriter() {
      return this.translatableRewriter;
   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }

   static TranslatableRewriter access$000(Protocol1_15_2To1_16 var0) {
      return var0.translatableRewriter;
   }
}
