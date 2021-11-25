package de.gerrygames.viarewind.protocol.protocol1_8to1_9.entityreplacement;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import de.gerrygames.viarewind.replacement.EntityReplacement;
import de.gerrygames.viarewind.utils.PacketUtil;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import net.aFs;
import net.aRE;
import net.bgR;

public class ShulkerBulletReplacement implements EntityReplacement {
   private int entityId;
   private List datawatcher = new ArrayList();
   private double locX;
   private double locY;
   private double locZ;
   private float yaw;
   private float pitch;
   private float headYaw;
   private bgR h;

   public ShulkerBulletReplacement(int var1, bgR var2) {
      this.entityId = var1;
      this.h = var2;
      this.spawn();
   }

   public void setLocation(double var1, double var3, double var5) {
      boolean var7 = aFs.d();
      if(var1 != this.locX || var3 != this.locY || var5 != this.locZ) {
         this.locX = var1;
         this.locY = var3;
         this.locZ = var5;
         this.updateLocation();
      }

   }

   public void relMove(double var1, double var3, double var5) {
      boolean var7 = aFs.e();
      if(var1 != 0.0D || var3 != 0.0D || var5 != 0.0D) {
         this.locX += var1;
         this.locY += var3;
         this.locZ += var5;
         this.updateLocation();
      }
   }

   public void setYawPitch(float var1, float var2) {
      boolean var3 = aFs.e();
      if(this.yaw != var1 && this.pitch != var2) {
         this.yaw = var1;
         this.pitch = var2;
         this.updateLocation();
      }

   }

   public void setHeadYaw(float var1) {
      this.headYaw = var1;
   }

   public void updateMetadata(List var1) {
   }

   public void updateLocation() {
      PacketWrapperImpl var2 = new PacketWrapperImpl(24, (ByteBuf)null, this.h);
      var2.a(Type.VAR_INT, Integer.valueOf(this.entityId));
      aFs.d();
      var2.a(Type.I, Integer.valueOf((int)(this.locX * 32.0D)));
      var2.a(Type.I, Integer.valueOf((int)(this.locY * 32.0D)));
      var2.a(Type.I, Integer.valueOf((int)(this.locZ * 32.0D)));
      var2.a(Type.k, Byte.valueOf((byte)((int)(this.yaw / 360.0F * 256.0F))));
      var2.a(Type.k, Byte.valueOf((byte)((int)(this.pitch / 360.0F * 256.0F))));
      var2.a(Type.c, Boolean.valueOf(true));
      PacketWrapperImpl var3 = new PacketWrapperImpl(25, (ByteBuf)null, this.h);
      var3.a(Type.VAR_INT, Integer.valueOf(this.entityId));
      var3.a(Type.k, Byte.valueOf((byte)((int)(this.headYaw / 360.0F * 256.0F))));
      PacketUtil.b(var2, aRE.class, true, true);
      PacketUtil.b(var3, aRE.class, true, true);
   }

   public void spawn() {
      PacketWrapperImpl var1 = new PacketWrapperImpl(14, (ByteBuf)null, this.h);
      var1.a(Type.VAR_INT, Integer.valueOf(this.entityId));
      var1.a(Type.k, Byte.valueOf((byte)66));
      var1.a(Type.I, Integer.valueOf(0));
      var1.a(Type.I, Integer.valueOf(0));
      var1.a(Type.I, Integer.valueOf(0));
      var1.a(Type.k, Byte.valueOf((byte)0));
      var1.a(Type.k, Byte.valueOf((byte)0));
      var1.a(Type.I, Integer.valueOf(0));
      PacketUtil.b(var1, aRE.class, true, true);
   }

   public void despawn() {
      PacketWrapperImpl var1 = new PacketWrapperImpl(19, (ByteBuf)null, this.h);
      var1.a(Type.VAR_INT_ARRAY_PRIMITIVE, new int[]{this.entityId});
      PacketUtil.b(var1, aRE.class, true, true);
   }

   public int getEntityId() {
      return this.entityId;
   }
}
