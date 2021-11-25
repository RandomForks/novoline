package viaversion.viabackwards.protocol.protocol1_13to1_13_1;

import net.aRw;
import net.ao6;
import net.aoG;
import net.aoI;
import net.aoX;
import net.aoe;
import net.aqN;
import net.ayd;
import net.ayk;
import net.cA;
import net.cQ;
import net.cT;
import net.q1;
import net.uN;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter;
import viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets.InventoryPackets1_13_1;
import viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets.WorldPackets1_13_1;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;

public class Protocol1_13To1_13_1 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings("1.13.2", "1.13", aRw.class, true);

   public Protocol1_13To1_13_1() {
      super(q1.class, q1.class, uN.class, uN.class);
   }

   protected void registerPackets() {
      BackwardsMappings var10002 = MAPPINGS;
      MAPPINGS.getClass();
      this.a(aRw.class, var10002::load);
      (new aqN(this)).f();
      ayk.b();
      InventoryPackets1_13_1.register(this);
      WorldPackets1_13_1.register(this);
      TranslatableRewriter var2 = new TranslatableRewriter(this, "1.13.1");
      var2.registerChatMessage(q1.CHAT_MESSAGE);
      var2.registerLegacyOpenWindow(q1.OPEN_WINDOW);
      var2.c(q1.COMBAT_EVENT);
      var2.registerDisconnect(q1.DISCONNECT);
      var2.registerTabList(q1.TAB_LIST);
      var2.d(q1.TITLE);
      var2.registerPing();
      this.a(uN.TAB_COMPLETE, new aoI(this));
      this.a(uN.EDIT_BOOK, new ao6(this));
      this.a(q1.TAB_COMPLETE, new aoe(this));
      this.a(q1.BOSSBAR, new aoX(this, var2));
      this.a(q1.ADVANCEMENTS, new aoG(this));
      (new TagRewriter(this, (IdRewriteFunction)null)).register(q1.TAGS);
      (new StatisticsRewriter(this, (IdRewriteFunction)null)).register(q1.STATISTICS);
   }

   public void init(UserConnection var1) {
      String[] var2 = ayk.b();
      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      ((cQ)var1.b(cQ.class)).b(this);
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }
}
