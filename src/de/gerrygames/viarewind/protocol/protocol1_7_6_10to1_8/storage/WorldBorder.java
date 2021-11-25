package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.PlayerPosition;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.WorldBorder$Side;
import de.gerrygames.viarewind.utils.PacketUtil;
import de.gerrygames.viarewind.utils.Tickable;
import io.netty.buffer.ByteBuf;
import net.aRi;
import net.bgR;
import net.cA;
import net.cf;

public class WorldBorder extends cA implements Tickable {
   private double x;
   private double z;
   private double oldDiameter;
   private double newDiameter;
   private long lerpTime;
   private long lerpStartTime;
   private int portalTeleportBoundary;
   private int warningTime;
   private int warningBlocks;
   private boolean init = false;
   private final int VIEW_DISTANCE = 16;

   public WorldBorder(bgR var1) {
      super(var1);
   }

   public void tick() {
      String var1 = cf.b();
      if(this.isInit()) {
         this.sendPackets();
      }
   }

   private void sendPackets() {
      cf.b();
      PlayerPosition var2 = (PlayerPosition)this.d().b(PlayerPosition.class);
      double var3 = this.getSize() / 2.0D;
      WorldBorder$Side[] var5 = WorldBorder$Side.values();
      int var6 = var5.length;
      int var7 = 0;
      if(var7 < var6) {
         WorldBorder$Side var8 = var5[var7];
         if(WorldBorder$Side.access$000(var8) != 0) {
            double var11 = var2.e();
            double var13 = this.z;
            Math.abs(this.x + var3 * (double)WorldBorder$Side.access$000(var8) - var2.g());
         }

         double var35 = this.x;
         double var34 = var2.g();
         double var9 = Math.abs(this.z + var3 * (double)WorldBorder$Side.access$100(var8) - var2.e());
         if(var9 < 16.0D) {
            double var15 = Math.sqrt(256.0D - var9 * var9);
            double var17 = Math.ceil(var34 - var15);
            double var19 = Math.floor(var34 + var15);
            double var21 = Math.ceil(var2.f() - var15);
            double var23 = Math.floor(var2.f() + var15);
            if(var17 < var35 - var3) {
               var17 = Math.ceil(var35 - var3);
            }

            if(var19 > var35 + var3) {
               var19 = Math.floor(var35 + var3);
            }

            if(var21 < 0.0D) {
               var21 = 0.0D;
            }

            double var25 = (var17 + var19) / 2.0D;
            double var27 = (var21 + var23) / 2.0D;
            int var29 = (int)Math.floor((var19 - var17) * (var23 - var21) * 0.5D);
            double var30 = 2.5D;
            PacketWrapperImpl var32 = new PacketWrapperImpl(42, (ByteBuf)null, this.d());
            var32.a(Type.STRING, "fireworksSpark");
            var32.a(Type.FLOAT, Float.valueOf((float)(WorldBorder$Side.access$000(var8) != 0?this.x + var3 * (double)WorldBorder$Side.access$000(var8):var25)));
            var32.a(Type.FLOAT, Float.valueOf((float)var27));
            var32.a(Type.FLOAT, Float.valueOf((float)(WorldBorder$Side.access$000(var8) == 0?this.z + var3 * (double)WorldBorder$Side.access$100(var8):var25)));
            var32.a(Type.FLOAT, Float.valueOf((float)(WorldBorder$Side.access$000(var8) != 0?0.0D:(var19 - var17) / var30)));
            var32.a(Type.FLOAT, Float.valueOf((float)((var23 - var21) / var30)));
            var32.a(Type.FLOAT, Float.valueOf((float)(WorldBorder$Side.access$000(var8) == 0?0.0D:(var19 - var17) / var30)));
            var32.a(Type.FLOAT, Float.valueOf(0.0F));
            var32.a(Type.I, Integer.valueOf(var29));
            PacketUtil.b(var32, aRi.class, true, true);
         }

         ++var7;
      }

   }

   private boolean isInit() {
      return this.init;
   }

   public void init(double var1, double var3, double var5, double var7, long var9, int var11, int var12, int var13) {
      this.x = var1;
      this.z = var3;
      this.oldDiameter = var5;
      this.newDiameter = var7;
      this.lerpTime = var9;
      this.portalTeleportBoundary = var11;
      this.warningTime = var12;
      this.warningBlocks = var13;
      this.init = true;
   }

   public double getX() {
      return this.x;
   }

   public double getZ() {
      return this.z;
   }

   public void setCenter(double var1, double var3) {
      this.x = var1;
      this.z = var3;
   }

   public double getOldDiameter() {
      return this.oldDiameter;
   }

   public double getNewDiameter() {
      return this.newDiameter;
   }

   public long getLerpTime() {
      return this.lerpTime;
   }

   public void lerpSize(double var1, double var3, long var5) {
      this.oldDiameter = var1;
      this.newDiameter = var3;
      this.lerpTime = var5;
      this.lerpStartTime = System.currentTimeMillis();
   }

   public void setSize(double var1) {
      this.oldDiameter = var1;
      this.newDiameter = var1;
      this.lerpTime = 0L;
   }

   public double getSize() {
      String var1 = cf.b();
      if(this.lerpTime == 0L) {
         return this.newDiameter;
      } else {
         long var2 = System.currentTimeMillis() - this.lerpStartTime;
         double var4 = (double)var2 / (double)this.lerpTime;
         if(var4 > 1.0D) {
            var4 = 1.0D;
         }

         if(var4 < 0.0D) {
            var4 = 0.0D;
         }

         return this.oldDiameter + (this.newDiameter - this.oldDiameter) * var4;
      }
   }

   public int getPortalTeleportBoundary() {
      return this.portalTeleportBoundary;
   }

   public void setPortalTeleportBoundary(int var1) {
      this.portalTeleportBoundary = var1;
   }

   public int getWarningTime() {
      return this.warningTime;
   }

   public void setWarningTime(int var1) {
      this.warningTime = var1;
   }

   public int getWarningBlocks() {
      return this.warningBlocks;
   }

   public void setWarningBlocks(int var1) {
      this.warningBlocks = var1;
   }
}
