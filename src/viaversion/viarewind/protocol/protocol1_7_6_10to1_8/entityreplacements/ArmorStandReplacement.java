package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.Dk;
import net.aRi;
import net.axZ;
import net.t4;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements.ArmorStandReplacement$State;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.MetaType1_7_6_10;
import viaversion.viarewind.replacement.EntityReplacement;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viarewind.utils.math.AABB;
import viaversion.viarewind.utils.math.Vector3d;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_8;
import viaversion.viaversion.api.type.Type;

public class ArmorStandReplacement implements EntityReplacement {
   private final int entityId;
   private final List datawatcher = new ArrayList();
   private int[] entityIds = null;
   private double locX;
   private double locY;
   private double locZ;
   private ArmorStandReplacement$State currentState = null;
   private boolean invisible = false;
   private boolean nameTagVisible = false;
   private String name = null;
   private final UserConnection user;
   private float yaw;
   private float pitch;
   private float headYaw;
   private boolean small = false;
   private boolean marker = false;
   private static int ENTITY_ID = 2147467647;
   private static boolean m;

   public ArmorStandReplacement(int var1, UserConnection var2) {
      this.entityId = var1;
      this.user = var2;
   }

   public void setLocation(double var1, double var3, double var5) {
      boolean var7 = a();
      if(var1 != this.locX || var3 != this.locY || var5 != this.locZ) {
         this.locX = var1;
         this.locY = var3;
         this.locZ = var5;
         this.updateLocation();
      }

   }

   public void relMove(double var1, double var3, double var5) {
      boolean var7 = f();
      if(var1 != 0.0D || var3 != 0.0D || var5 != 0.0D) {
         this.locX += var1;
         this.locY += var3;
         this.locZ += var5;
         this.updateLocation();
      }
   }

   public void setYawPitch(float var1, float var2) {
      boolean var3 = a();
      if(this.yaw != var1 && this.pitch != var2 || this.headYaw != var1) {
         this.yaw = var1;
         this.headYaw = var1;
         this.pitch = var2;
         this.updateLocation();
      }

   }

   public void setHeadYaw(float var1) {
      boolean var2 = f();
      if(this.headYaw != var1) {
         this.headYaw = var1;
         this.updateLocation();
      }

   }

   public void updateMetadata(List var1) {
      f();
      Iterator var3 = var1.iterator();
      if(var3.hasNext()) {
         Metadata var4 = (Metadata)var3.next();
         this.datawatcher.removeIf(ArmorStandReplacement::lambda$updateMetadata$0);
         this.datawatcher.add(var4);
      }

      this.updateState();
   }

   public void updateState() {
      f();
      byte var2 = 0;
      byte var3 = 0;
      Iterator var4 = this.datawatcher.iterator();
      if(var4.hasNext()) {
         label29: {
            Metadata var5 = (Metadata)var4.next();
            if(var5.getId() == 0 && var5.getMetaType() == MetaType1_8.Byte) {
               var2 = ((Byte)var5.getValue()).byteValue();
            }

            if(var5.getId() == 2 && var5.getMetaType() == MetaType1_8.String) {
               this.name = (String)var5.getValue();
               if(!"".equals(this.name)) {
                  break label29;
               }

               this.name = null;
            }

            if(var5.getId() == 10 && var5.getMetaType() == MetaType1_8.Byte) {
               var3 = ((Byte)var5.getValue()).byteValue();
            }

            if(var5.getId() == 3 && var5.getMetaType() == MetaType1_8.Byte) {
               this.nameTagVisible = (byte)var5.getId() != 0;
            }
         }
      }

      this.invisible = (var2 & 32) != 0;
      this.small = (var3 & 1) != 0;
      this.marker = (var3 & 16) != 0;
      ArmorStandReplacement$State var6 = this.currentState;
      if(this.invisible && this.name != null) {
         this.currentState = ArmorStandReplacement$State.HOLOGRAM;
      }

      this.currentState = ArmorStandReplacement$State.ZOMBIE;
      if(this.currentState != var6) {
         this.despawn();
         this.spawn();
      }

      this.updateMetadata();
      this.updateLocation();
   }

   public void updateLocation() {
      boolean var1 = a();
      if(this.entityIds != null) {
         if(this.currentState == ArmorStandReplacement$State.ZOMBIE) {
            PacketWrapper var2 = new PacketWrapper(24, (ByteBuf)null, this.user);
            var2.write(Type.INT, Integer.valueOf(this.entityId));
            var2.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
            var2.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
            var2.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
            var2.write(Type.BYTE, Byte.valueOf((byte)((int)(this.yaw / 360.0F * 256.0F))));
            var2.write(Type.BYTE, Byte.valueOf((byte)((int)(this.pitch / 360.0F * 256.0F))));
            PacketWrapper var3 = new PacketWrapper(25, (ByteBuf)null, this.user);
            var3.write(Type.INT, Integer.valueOf(this.entityId));
            var3.write(Type.BYTE, Byte.valueOf((byte)((int)(this.headYaw / 360.0F * 256.0F))));
            PacketUtil.sendPacket(var2, aRi.class, true, true);
            PacketUtil.sendPacket(var3, aRi.class, true, true);
         }

         if(this.currentState == ArmorStandReplacement$State.HOLOGRAM) {
            PacketWrapper var6 = new PacketWrapper(27, (ByteBuf)null, this.user);
            var6.write(Type.INT, Integer.valueOf(this.entityIds[1]));
            var6.write(Type.INT, Integer.valueOf(-1));
            var6.write(Type.BOOLEAN, Boolean.valueOf(false));
            PacketWrapper var7 = new PacketWrapper(24, (ByteBuf)null, this.user);
            var7.write(Type.INT, Integer.valueOf(this.entityIds[0]));
            var7.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
            var7.write(Type.INT, Integer.valueOf((int)((this.locY + (this.marker?54.85D:(this.small?56.0D:57.0D))) * 32.0D)));
            var7.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
            var7.write(Type.BYTE, Byte.valueOf((byte)0));
            var7.write(Type.BYTE, Byte.valueOf((byte)0));
            PacketWrapper var4 = new PacketWrapper(24, (ByteBuf)null, this.user);
            var4.write(Type.INT, Integer.valueOf(this.entityIds[1]));
            var4.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
            var4.write(Type.INT, Integer.valueOf((int)((this.locY + 56.75D) * 32.0D)));
            var4.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
            var4.write(Type.BYTE, Byte.valueOf((byte)0));
            var4.write(Type.BYTE, Byte.valueOf((byte)0));
            PacketWrapper var5 = new PacketWrapper(27, (ByteBuf)null, this.user);
            var5.write(Type.INT, Integer.valueOf(this.entityIds[1]));
            var5.write(Type.INT, Integer.valueOf(this.entityIds[0]));
            var5.write(Type.BOOLEAN, Boolean.valueOf(false));
            PacketUtil.sendPacket(var6, aRi.class, true, true);
            PacketUtil.sendPacket(var7, aRi.class, true, true);
            PacketUtil.sendPacket(var4, aRi.class, true, true);
            PacketUtil.sendPacket(var5, aRi.class, true, true);
         }

      }
   }

   public void updateMetadata() {
      boolean var1 = f();
      if(this.entityIds != null) {
         PacketWrapper var2 = new PacketWrapper(28, (ByteBuf)null, this.user);
         if(this.currentState == ArmorStandReplacement$State.ZOMBIE) {
            var2.write(Type.INT, Integer.valueOf(this.entityIds[0]));
            ArrayList var3 = new ArrayList();

            for(Metadata var5 : this.datawatcher) {
               if(var5.getId() >= 0 && var5.getId() <= 9) {
                  var3.add(new Metadata(var5.getId(), var5.getMetaType(), var5.getValue()));
                  break;
               }
            }

            if(this.small) {
               var3.add(new Metadata(12, MetaType1_8.Byte, Byte.valueOf((byte)1)));
            }

            Dk.a(t4.ZOMBIE, var3);
            var2.write(axZ.j, var3);
         }

         if(this.currentState == ArmorStandReplacement$State.HOLOGRAM) {
            var2.write(Type.INT, Integer.valueOf(this.entityIds[1]));
            ArrayList var6 = new ArrayList();
            var6.add(new Metadata(12, MetaType1_7_6_10.Int, Integer.valueOf(-1700000)));
            var6.add(new Metadata(10, MetaType1_7_6_10.String, this.name));
            var6.add(new Metadata(11, MetaType1_7_6_10.Byte, Byte.valueOf((byte)1)));
            var2.write(axZ.j, var6);
         }

      }
   }

   public void spawn() {
      boolean var1 = f();
      if(this.entityIds != null) {
         this.despawn();
      }

      if(this.currentState == ArmorStandReplacement$State.ZOMBIE) {
         PacketWrapper var2 = new PacketWrapper(15, (ByteBuf)null, this.user);
         var2.write(Type.VAR_INT, Integer.valueOf(this.entityId));
         var2.write(Type.UNSIGNED_BYTE, Short.valueOf((short)54));
         var2.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
         var2.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
         var2.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
         var2.write(Type.BYTE, Byte.valueOf((byte)0));
         var2.write(Type.BYTE, Byte.valueOf((byte)0));
         var2.write(Type.BYTE, Byte.valueOf((byte)0));
         var2.write(Type.SHORT, Short.valueOf((short)0));
         var2.write(Type.SHORT, Short.valueOf((short)0));
         var2.write(Type.SHORT, Short.valueOf((short)0));
         var2.write(axZ.j, new ArrayList());
         PacketUtil.sendPacket(var2, aRi.class, true, true);
         this.entityIds = new int[]{this.entityId};
      }

      if(this.currentState == ArmorStandReplacement$State.HOLOGRAM) {
         int[] var5 = new int[]{this.entityId, ENTITY_ID--};
         PacketWrapper var3 = new PacketWrapper(14, (ByteBuf)null, this.user);
         var3.write(Type.VAR_INT, Integer.valueOf(var5[0]));
         var3.write(Type.BYTE, Byte.valueOf((byte)66));
         var3.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
         var3.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
         var3.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
         var3.write(Type.BYTE, Byte.valueOf((byte)0));
         var3.write(Type.BYTE, Byte.valueOf((byte)0));
         var3.write(Type.INT, Integer.valueOf(0));
         PacketWrapper var4 = new PacketWrapper(15, (ByteBuf)null, this.user);
         var4.write(Type.VAR_INT, Integer.valueOf(var5[1]));
         var4.write(Type.UNSIGNED_BYTE, Short.valueOf((short)100));
         var4.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
         var4.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
         var4.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
         var4.write(Type.BYTE, Byte.valueOf((byte)0));
         var4.write(Type.BYTE, Byte.valueOf((byte)0));
         var4.write(Type.BYTE, Byte.valueOf((byte)0));
         var4.write(Type.SHORT, Short.valueOf((short)0));
         var4.write(Type.SHORT, Short.valueOf((short)0));
         var4.write(Type.SHORT, Short.valueOf((short)0));
         var4.write(axZ.j, new ArrayList());
         PacketUtil.sendPacket(var3, aRi.class, true, true);
         PacketUtil.sendPacket(var4, aRi.class, true, true);
         this.entityIds = var5;
      }

      this.updateMetadata();
      this.updateLocation();
   }

   public AABB getBoundingBox() {
      double var1 = this.small?0.25D:0.5D;
      double var3 = this.small?0.9875D:1.975D;
      Vector3d var5 = new Vector3d(this.locX - var1 / 2.0D, this.locY, this.locZ - var1 / 2.0D);
      Vector3d var6 = new Vector3d(this.locX + var1 / 2.0D, this.locY + var3, this.locZ + var1 / 2.0D);
      return new AABB(var5, var6);
   }

   public void despawn() {
      boolean var1 = a();
      if(this.entityIds != null) {
         PacketWrapper var2 = new PacketWrapper(19, (ByteBuf)null, this.user);
         var2.write(Type.BYTE, Byte.valueOf((byte)this.entityIds.length));
         int[] var3 = this.entityIds;
         int var4 = var3.length;
         int var5 = 0;
         if(var5 < var4) {
            int var6 = var3[var5];
            var2.write(Type.INT, Integer.valueOf(var6));
            ++var5;
         }

         this.entityIds = null;
         PacketUtil.sendPacket(var2, aRi.class, true, true);
      }
   }

   public int getEntityId() {
      return this.entityId;
   }

   private static boolean lambda$updateMetadata$0(Metadata var0, Metadata var1) {
      boolean var2 = f();
      return var1.getId() == var0.getId();
   }

   static {
      b(true);
   }

   public static void b(boolean var0) {
      m = var0;
   }

   public static boolean f() {
      return m;
   }

   public static boolean a() {
      boolean var0 = f();
      return true;
   }
}
