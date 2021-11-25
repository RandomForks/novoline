package viaversion.viabackwards.protocol.protocol1_16_1to1_16_2;

import net.C4;
import net.UN;
import net.aRX;
import net.aYz;
import net.anS;
import net.anu;
import net.aqG;
import net.ayd;
import net.cA;
import net.cQ;
import net.lx;
import net.sM;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.EntityPackets1_16_2;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;

public class Protocol1_16_1To1_16_2 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings("1.16.2", "1.16", aRX.class, true);
   private aqG k;
   private TranslatableRewriter translatableRewriter;

   public Protocol1_16_1To1_16_2() {
      super(UN.class, C4.class, lx.class, sM.class);
   }

   protected void registerPackets() {
      BackwardsMappings var10002 = MAPPINGS;
      MAPPINGS.getClass();
      this.a(aRX.class, var10002::load);
      this.translatableRewriter = new TranslatableRewriter(this, "1.16.2");
      this.translatableRewriter.b(UN.BOSSBAR);
      this.translatableRewriter.c(UN.COMBAT_EVENT);
      this.translatableRewriter.registerDisconnect(UN.DISCONNECT);
      this.translatableRewriter.registerTabList(UN.TAB_LIST);
      this.translatableRewriter.d(UN.TITLE);
      this.translatableRewriter.registerOpenWindow(UN.OPEN_WINDOW);
      aYz.b();
      this.translatableRewriter.registerPing();
      (this.k = new aqG(this, this.translatableRewriter)).f();
      EntityPackets1_16_2 var2 = new EntityPackets1_16_2(this);
      var2.f();
      SoundRewriter var3 = new SoundRewriter(this);
      var3.registerSound(UN.SOUND);
      var3.registerSound(UN.ENTITY_SOUND);
      var3.registerNamedSound(UN.NAMED_SOUND);
      var3.registerStopSound(UN.STOP_SOUND);
      this.a(UN.CHAT_MESSAGE, new anu(this));
      this.a(sM.RECIPE_BOOK_DATA, new anS(this));
      var2.getClass();
      (new TagRewriter(this, var2::getOldEntityId)).register(UN.TAGS);
      var2.getClass();
      (new StatisticsRewriter(this, var2::getOldEntityId)).register(UN.STATISTICS);
   }

   public void init(UserConnection var1) {
      String[] var2 = aYz.b();
      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      ((cQ)var1.b(cQ.class)).b(this);
   }

   public aqG a() {
      return this.k;
   }

   public TranslatableRewriter getTranslatableRewriter() {
      return this.translatableRewriter;
   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }

   static TranslatableRewriter access$000(Protocol1_16_1To1_16_2 var0) {
      return var0.translatableRewriter;
   }
}
