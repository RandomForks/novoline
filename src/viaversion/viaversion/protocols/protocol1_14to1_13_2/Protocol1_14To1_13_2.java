package viaversion.viaversion.protocols.protocol1_14to1_13_2;

import net.aTM;
import net.aWU;
import net.acE;
import net.ahW;
import net.awj;
import net.cA;
import net.cN;
import net.cT;
import net.q1;
import net.uN;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.data.ComponentRewriter1_14;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.data.MappingData;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.EntityPackets;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.InventoryPackets;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.PlayerPackets;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.WorldPackets;

public class Protocol1_14To1_13_2 extends Protocol {
   public static final MappingData MAPPINGS = new MappingData();

   public Protocol1_14To1_13_2() {
      super(q1.class, awj.class, uN.class, ahW.class);
   }

   protected void registerPackets() {
      aTM var2 = new aTM(this);
      InventoryPackets.register(this);
      EntityPackets.register(this);
      awj.b();
      WorldPackets.register(this);
      PlayerPackets.register(this);
      (new SoundRewriter(this)).registerSound(q1.SOUND);
      var2.getClass();
      (new StatisticsRewriter(this, var2::getNewEntityId)).register(q1.STATISTICS);
      ComponentRewriter1_14 var3 = new ComponentRewriter1_14(this);
      var3.registerChatMessage(q1.CHAT_MESSAGE);
      this.a(q1.TAGS, new aWU(this));
      this.cancelIncoming(ahW.SET_DIFFICULTY);
      this.cancelIncoming(ahW.LOCK_DIFFICULTY);
      this.cancelIncoming(ahW.UPDATE_JIGSAW_BLOCK);
      if(acE.b() == null) {
         awj.b(new int[1]);
      }

   }

   protected void onMappingDataLoaded() {
      WorldPackets.f = this.getMappingData().getBlockStateMappings().getNewId(0);
      WorldPackets.c = this.getMappingData().getBlockStateMappings().getNewId(8591);
      WorldPackets.a = this.getMappingData().getBlockStateMappings().getNewId(8592);
   }

   public void init(UserConnection var1) {
      awj.b();
      var1.a((cA)(new cN(var1)));
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }
}
