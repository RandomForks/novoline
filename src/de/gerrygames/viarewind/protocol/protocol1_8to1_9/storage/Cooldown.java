package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import com.viaversion.viaversion.util.Pair;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.BlockPlaceDestroyTracker;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.EntityTracker;
import de.gerrygames.viarewind.utils.PacketUtil;
import de.gerrygames.viarewind.utils.Tickable;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.UUID;
import net.JM;
import net.aRE;
import net.bY;
import net.bgR;
import net.cA;

public class Cooldown extends cA implements Tickable {
   private double attackSpeed = 4.0D;
   private long lastHit = 0L;
   private final bY c;
   private UUID bossUUID;
   private boolean lastSend;
   private static final int max = 10;

   public Cooldown(bgR var1) {
      super(var1);

      bY var2;
      try {
         var2 = JM.b().a();
      } catch (IllegalArgumentException var4) {
         JM.a().a().warning("Invalid cooldown-indicator setting");
         var2 = bY.DISABLED;
      }

      this.c = var2;
   }

   public void tick() {
      String[] var1 = EntityTracker.d();
      if(!this.hasCooldown()) {
         if(this.lastSend) {
            this.hide();
            this.lastSend = false;
         }

      } else {
         BlockPlaceDestroyTracker var2 = (BlockPlaceDestroyTracker)this.d().b(BlockPlaceDestroyTracker.class);
         if(var2.isMining()) {
            this.lastHit = 0L;
            if(this.lastSend) {
               this.hide();
               this.lastSend = false;
            }

         } else {
            this.showCooldown();
            this.lastSend = true;
         }
      }
   }

   private void showCooldown() {
      String[] var1 = EntityTracker.d();
      if(this.c == bY.TITLE) {
         this.sendTitle("", this.getTitle(), 0, 2, 5);
      }

      if(this.c == bY.ACTION_BAR) {
         this.sendActionBar(this.getTitle());
      }

      if(this.c == bY.BOSS_BAR) {
         this.sendBossBar((float)this.getCooldown());
      }

   }

   private void hide() {
      String[] var1 = EntityTracker.d();
      if(this.c == bY.ACTION_BAR) {
         this.sendActionBar("§r");
      }

      if(this.c == bY.TITLE) {
         this.hideTitle();
      }

      if(this.c == bY.BOSS_BAR) {
         this.hideBossBar();
      }

   }

   private void hideBossBar() {
      if(this.bossUUID != null) {
         PacketWrapperImpl var1 = new PacketWrapperImpl(12, (ByteBuf)null, this.d());
         var1.a(Type.UUID, this.bossUUID);
         var1.a(Type.VAR_INT, Integer.valueOf(1));
         PacketUtil.b(var1, aRE.class, false, true);
         this.bossUUID = null;
      }
   }

   private void sendBossBar(float var1) {
      EntityTracker.d();
      PacketWrapperImpl var3 = new PacketWrapperImpl(12, (ByteBuf)null, this.d());
      if(this.bossUUID == null) {
         this.bossUUID = UUID.randomUUID();
         var3.a(Type.UUID, this.bossUUID);
         var3.a(Type.VAR_INT, Integer.valueOf(0));
         var3.a(Type.STRING, "{\"text\":\"  \"}");
         var3.a(Type.FLOAT, Float.valueOf(var1));
         var3.a(Type.VAR_INT, Integer.valueOf(0));
         var3.a(Type.VAR_INT, Integer.valueOf(0));
         var3.a(Type.M, Short.valueOf((short)0));
      }

      var3.a(Type.UUID, this.bossUUID);
      var3.a(Type.VAR_INT, Integer.valueOf(2));
      var3.a(Type.FLOAT, Float.valueOf(var1));
      PacketUtil.b(var3, aRE.class, false, true);
   }

   private void hideTitle() {
      PacketWrapperImpl var1 = new PacketWrapperImpl(69, (ByteBuf)null, this.d());
      var1.a(Type.VAR_INT, Integer.valueOf(3));
      PacketUtil.b(var1, aRE.class);
   }

   private void sendTitle(String var1, String var2, int var3, int var4, int var5) {
      PacketWrapperImpl var6 = new PacketWrapperImpl(69, (ByteBuf)null, this.d());
      var6.a(Type.VAR_INT, Integer.valueOf(2));
      var6.a(Type.I, Integer.valueOf(var3));
      var6.a(Type.I, Integer.valueOf(var4));
      var6.a(Type.I, Integer.valueOf(var5));
      PacketWrapperImpl var7 = new PacketWrapperImpl(69, (ByteBuf)null, this.d());
      var7.a(Type.VAR_INT, Integer.valueOf(0));
      var7.a(Type.STRING, var1);
      PacketWrapperImpl var8 = new PacketWrapperImpl(69, (ByteBuf)null, this.d());
      var8.a(Type.VAR_INT, Integer.valueOf(1));
      var8.a(Type.STRING, var2);
      PacketUtil.b(var7, aRE.class);
      PacketUtil.b(var8, aRE.class);
      PacketUtil.b(var6, aRE.class);
   }

   private void sendActionBar(String var1) {
      PacketWrapperImpl var2 = new PacketWrapperImpl(2, (ByteBuf)null, this.d());
      var2.a(Type.STRING, var1);
      var2.a(Type.k, Byte.valueOf((byte)2));
      PacketUtil.b(var2, aRE.class);
   }

   public boolean hasCooldown() {
      EntityTracker.d();
      long var2 = System.currentTimeMillis() - this.lastHit;
      double var4 = this.a((double)var2 * this.attackSpeed / 1000.0D, 0.0D, 1.5D);
      return var4 > 0.1D && var4 < 1.1D;
   }

   public double getCooldown() {
      long var1 = System.currentTimeMillis() - this.lastHit;
      return this.a((double)var1 * this.attackSpeed / 1000.0D, 0.0D, 1.0D);
   }

   private double a(double var1, double var3, double var5) {
      String[] var7 = EntityTracker.d();
      return var1 < var3?var3:(var1 > var5?var5:var1);
   }

   private String getTitle() {
      String[] var1 = EntityTracker.d();
      String var2 = this.c == bY.ACTION_BAR?"■":"˙";
      double var3 = this.getCooldown();
      int var5 = (int)Math.floor(10.0D * var3);
      int var6 = 10 - var5;
      StringBuilder var7 = new StringBuilder("§8");
      if(var5-- > 0) {
         var7.append(var2);
      }

      var7.append("§7");
      if(var6-- > 0) {
         var7.append(var2);
      }

      return var7.toString();
   }

   public double getAttackSpeed() {
      return this.attackSpeed;
   }

   public void setAttackSpeed(double var1) {
      this.attackSpeed = var1;
   }

   public void setAttackSpeed(double var1, ArrayList var3) {
      EntityTracker.d();
      this.attackSpeed = var1;
      int var5 = 0;
      if(var5 < var3.size()) {
         if(((Byte)((Pair)var3.get(var5)).getKey()).byteValue() == 0) {
            this.attackSpeed += ((Double)((Pair)var3.get(var5)).getValue()).doubleValue();
            var3.remove(var5--);
         }

         ++var5;
      }

      var5 = 0;
      if(var5 < var3.size()) {
         if(((Byte)((Pair)var3.get(var5)).getKey()).byteValue() == 1) {
            this.attackSpeed += var1 * ((Double)((Pair)var3.get(var5)).getValue()).doubleValue();
            var3.remove(var5--);
         }

         ++var5;
      }

      var5 = 0;
      if(var5 < var3.size()) {
         if(((Byte)((Pair)var3.get(var5)).getKey()).byteValue() == 2) {
            this.attackSpeed *= 1.0D + ((Double)((Pair)var3.get(var5)).getValue()).doubleValue();
            var3.remove(var5--);
         }

         ++var5;
      }

   }

   public void hit() {
      this.lastHit = System.currentTimeMillis();
   }

   public void setLastHit(long var1) {
      this.lastHit = var1;
   }

   private static IllegalArgumentException a(IllegalArgumentException var0) {
      return var0;
   }
}
