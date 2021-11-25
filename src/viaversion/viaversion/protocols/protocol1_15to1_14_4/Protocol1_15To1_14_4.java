package viaversion.viaversion.protocols.protocol1_15to1_14_4;

import net.Mo;
import net.Q3;
import net.aTZ;
import net.acE;
import net.aeS;
import net.ahW;
import net.ai4;
import net.awA;
import net.awj;
import net.cA;
import net.cU;
import net.vs;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.RegistryType;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.rewriters.StatisticsRewriter;
import viaversion.viaversion.api.rewriters.TagRewriter;
import viaversion.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4$1;

public class Protocol1_15To1_14_4 extends Protocol {
   public static final ai4 j = new ai4();
   private TagRewriter tagRewriter;

   public Protocol1_15To1_14_4() {
      super(awj.class, Mo.class, ahW.class, ahW.class);
   }

   protected void registerPackets() {
      aTZ var2 = new aTZ(this);
      awA.a(this);
      vs.a(this);
      aeS.a(this);
      Q3.a(this);
      Mo.b();
      SoundRewriter var3 = new SoundRewriter(this);
      var3.registerSound(awj.ENTITY_SOUND);
      var3.registerSound(awj.SOUND);
      var2.getClass();
      (new StatisticsRewriter(this, var2::getNewEntityId)).register(awj.STATISTICS);
      this.a(ahW.EDIT_BOOK, new Protocol1_15To1_14_4$1(this));
      this.tagRewriter = new TagRewriter(this, awA::a);
      this.tagRewriter.register(awj.TAGS);
   }

   protected void onMappingDataLoaded() {
      Mo.b();
      int[] var2 = new int[17];
      short var3 = 501;
      int var4 = 0;
      if(var4 < 17) {
         var2[var4] = var3 + var4;
         ++var4;
      }

      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:shulker_boxes", var2);
      if(acE.b() == null) {
         Mo.b(new String[3]);
      }

   }

   public void init(UserConnection var1) {
      var1.a((cA)(new cU(var1)));
   }

   public ai4 a() {
      return j;
   }
}
