package viaversion.viabackwards.protocol.protocol1_10to1_11;

import net.Wx;
import net.acE;
import net.agN;
import net.aqT;
import net.aqp;
import net.ayd;
import net.cA;
import net.cQ;
import net.cT;
import net.co;
import viaversion.viabackwards.api.data.BackwardsMappings;
import viaversion.viabackwards.api.rewriters.SoundRewriter;
import viaversion.viabackwards.protocol.protocol1_10to1_11.packets.PlayerPackets1_11;
import viaversion.viaversion.api.data.UserConnection;

public class Protocol1_10To1_11 extends ayd {
   public static final BackwardsMappings MAPPINGS = new BackwardsMappings("1.11", "1.10", (Class)null, true);
   private aqp m;
   private aqT l;
   private static String k;

   public Protocol1_10To1_11() {
      super(agN.class, agN.class, Wx.class, Wx.class);
   }

   protected void registerPackets() {
      a();
      (this.m = new aqp(this)).f();
      (new PlayerPackets1_11()).register(this);
      (this.l = new aqT(this)).f();
      SoundRewriter var2 = new SoundRewriter(this);
      var2.registerNamedSound(agN.NAMED_SOUND);
      var2.registerSound(agN.SOUND);
   }

   public void init(UserConnection var1) {
      String var2 = a();
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

      if(!var1.has(cQ.class)) {
         var1.a((cA)(new cQ(var1)));
      }

      if(!var1.has(co.class)) {
         var1.a((cA)(new co(var1)));
      }

      ((cQ)var1.b(cQ.class)).b(this);
      if(acE.b() == null) {
         b("LebTuc");
      }

   }

   public aqp b() {
      return this.m;
   }

   public aqT c() {
      return this.l;
   }

   public BackwardsMappings getMappingData() {
      return MAPPINGS;
   }

   public boolean hasMappingDataToLoad() {
      return true;
   }

   static {
      b("iqnIw");
   }

   public static void b(String var0) {
      k = var0;
   }

   public static String a() {
      return k;
   }
}
