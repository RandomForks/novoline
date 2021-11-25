package viaversion.viaversion.protocols.protocol1_11to1_10;

import net.Wx;
import net.a75;
import net.a7_;
import net.a7d;
import net.a7k;
import net.aKA;
import net.aKJ;
import net.aKQ;
import net.aKc;
import net.aKg;
import net.aSx;
import net.aT9;
import net.agN;
import net.cA;
import net.cT;
import net.cw;
import net.rX;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.remapper.ValueTransformer;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.SoundRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_11to1_10.EntityIdRewriter;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10$1;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10$10;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10$11;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10$13;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10$2;

public class Protocol1_11To1_10 extends Protocol {
   private static final ValueTransformer toOldByte = new Protocol1_11To1_10$1(Type.UNSIGNED_BYTE);

   public Protocol1_11To1_10() {
      super(agN.class, agN.class, Wx.class, Wx.class);
   }

   protected void registerPackets() {
      aT9 var2 = new aT9(this);
      aSx.a(this);
      this.a(agN.SPAWN_ENTITY, new Protocol1_11To1_10$2(this, var2));
      this.a(agN.SPAWN_MOB, new a75(this, var2));
      (new SoundRewriter(this, this::a)).registerSound(agN.SOUND);
      this.a(agN.COLLECT_ITEM, new a7k(this));
      var2.registerMetadataRewriter(agN.ENTITY_METADATA, rX.a);
      this.a(agN.ENTITY_TELEPORT, new aKg(this));
      var2.registerEntityDestroy(agN.DESTROY_ENTITIES);
      this.a(agN.TITLE, new aKJ(this));
      EntityIdRewriter.b();
      this.a(agN.BLOCK_ACTION, new aKA(this));
      this.a(agN.BLOCK_ENTITY_DATA, new aKQ(this));
      this.a(agN.CHUNK_DATA, new aKc(this));
      this.a(agN.JOIN_GAME, new Protocol1_11To1_10$10(this));
      this.a(agN.RESPAWN, new Protocol1_11To1_10$11(this));
      this.a(agN.EFFECT, new a7d(this));
      this.a(Wx.PLAYER_BLOCK_PLACEMENT, new Protocol1_11To1_10$13(this));
      this.a(Wx.CHAT_MESSAGE, new a7_(this));
   }

   private int a(int var1) {
      String[] var2 = EntityIdRewriter.b();
      if(var1 == 196) {
         return -1;
      } else {
         if(var1 >= 85) {
            var1 += 2;
         }

         if(var1 >= 176) {
            ++var1;
         }

         if(var1 >= 197) {
            var1 += 8;
         }

         if(var1 >= 207) {
            --var1;
         }

         if(var1 >= 279) {
            var1 += 9;
         }

         if(var1 >= 296) {
            ++var1;
         }

         if(var1 >= 390) {
            var1 += 4;
         }

         if(var1 >= 400) {
            var1 += 3;
         }

         if(var1 >= 450) {
            ++var1;
         }

         if(var1 >= 455) {
            ++var1;
         }

         if(var1 >= 470) {
            ++var1;
         }

         return var1;
      }
   }

   public void init(UserConnection var1) {
      EntityIdRewriter.b();
      var1.a((cA)(new cw(var1)));
      if(!var1.has(cT.class)) {
         var1.a((cA)(new cT(var1)));
      }

   }

   static ValueTransformer access$000() {
      return toOldByte;
   }
}
