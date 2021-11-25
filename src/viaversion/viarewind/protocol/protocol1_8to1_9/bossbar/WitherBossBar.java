package viaversion.viarewind.protocol.protocol1_8to1_9.bossbar;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import net.aRE;
import net.acE;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.boss.BossBar;
import viaversion.viaversion.api.boss.BossColor;
import viaversion.viaversion.api.boss.BossFlag;
import viaversion.viaversion.api.boss.BossStyle;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.metadata.Metadata;
import viaversion.viaversion.api.minecraft.metadata.types.MetaType1_8;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_8;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public class WitherBossBar extends BossBar {
   private static int highestId = 2147473647;
   private final UUID uuid;
   private String title;
   private float health;
   private boolean visible = false;
   private UserConnection connection;
   private final int entityId;
   private double locX;
   private double locY;
   private double locZ;
   private static String k;

   public WitherBossBar(UserConnection var1, UUID var2, String var3, float var4) {
      d();
      this.entityId = highestId++;
      this.connection = var1;
      this.uuid = var2;
      this.title = var3;
      this.health = var4;
      if(acE.b() == null) {
         b("IkiEf");
      }

   }

   public String getTitle() {
      return this.title;
   }

   public BossBar setTitle(String var1) {
      d();
      this.title = var1;
      if(this.visible) {
         this.updateMetadata();
      }

      return this;
   }

   public float getHealth() {
      return this.health;
   }

   public BossBar setHealth(float var1) {
      d();
      this.health = var1;
      if(this.health <= 0.0F) {
         this.health = 1.0E-4F;
      }

      if(this.visible) {
         this.updateMetadata();
      }

      return this;
   }

   public BossColor getColor() {
      return null;
   }

   public BossBar setColor(BossColor var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " does not support color");
   }

   public BossStyle getStyle() {
      return null;
   }

   public BossBar setStyle(BossStyle var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " does not support styles");
   }

   public BossBar b(UUID var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
   }

   public BossBar addConnection(UserConnection var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
   }

   public BossBar a(UUID var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
   }

   public BossBar removeConnection(UserConnection var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
   }

   public BossBar addFlag(BossFlag var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " does not support flags");
   }

   public BossBar removeFlag(BossFlag var1) {
      throw new UnsupportedOperationException(this.getClass().getName() + " does not support flags");
   }

   public boolean hasFlag(BossFlag var1) {
      return false;
   }

   public Set getPlayers() {
      return Collections.singleton(((ProtocolInfo)this.connection.b(ProtocolInfo.class)).getUuid());
   }

   public Set getConnections() {
      throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
   }

   public BossBar show() {
      String var1 = d();
      if(!this.visible) {
         this.visible = true;
         this.spawnWither();
      }

      return this;
   }

   public BossBar hide() {
      String var1 = d();
      if(this.visible) {
         this.visible = false;
         this.despawnWither();
      }

      return this;
   }

   public boolean isVisible() {
      return this.visible;
   }

   public UUID getId() {
      return this.uuid;
   }

   public void setLocation(double var1, double var3, double var5) {
      this.locX = var1;
      this.locY = var3;
      this.locZ = var5;
      this.updateLocation();
   }

   private void spawnWither() {
      PacketWrapper var1 = new PacketWrapper(15, (ByteBuf)null, this.connection);
      var1.write(Type.VAR_INT, Integer.valueOf(this.entityId));
      var1.write(Type.UNSIGNED_BYTE, Short.valueOf((short)64));
      var1.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
      var1.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
      var1.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.SHORT, Short.valueOf((short)0));
      var1.write(Type.SHORT, Short.valueOf((short)0));
      var1.write(Type.SHORT, Short.valueOf((short)0));
      ArrayList var2 = new ArrayList();
      var2.add(new Metadata(0, MetaType1_8.Byte, Byte.valueOf((byte)32)));
      var2.add(new Metadata(2, MetaType1_8.String, this.title));
      var2.add(new Metadata(3, MetaType1_8.Byte, Byte.valueOf((byte)1)));
      var2.add(new Metadata(6, MetaType1_8.Float, Float.valueOf(this.health * 300.0F)));
      var1.write(Types1_8.METADATA_LIST, var2);
      PacketUtil.sendPacket(var1, aRE.class, true, true);
   }

   private void updateLocation() {
      PacketWrapper var1 = new PacketWrapper(24, (ByteBuf)null, this.connection);
      var1.write(Type.VAR_INT, Integer.valueOf(this.entityId));
      var1.write(Type.INT, Integer.valueOf((int)(this.locX * 32.0D)));
      var1.write(Type.INT, Integer.valueOf((int)(this.locY * 32.0D)));
      var1.write(Type.INT, Integer.valueOf((int)(this.locZ * 32.0D)));
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.BYTE, Byte.valueOf((byte)0));
      var1.write(Type.BOOLEAN, Boolean.valueOf(false));
      PacketUtil.sendPacket(var1, aRE.class, true, true);
   }

   private void updateMetadata() {
      PacketWrapper var1 = new PacketWrapper(28, (ByteBuf)null, this.connection);
      var1.write(Type.VAR_INT, Integer.valueOf(this.entityId));
      ArrayList var2 = new ArrayList();
      var2.add(new Metadata(2, MetaType1_8.String, this.title));
      var2.add(new Metadata(6, MetaType1_8.Float, Float.valueOf(this.health * 300.0F)));
      var1.write(Types1_8.METADATA_LIST, var2);
      PacketUtil.sendPacket(var1, aRE.class, true, true);
   }

   private void despawnWither() {
      PacketWrapper var1 = new PacketWrapper(19, (ByteBuf)null, this.connection);
      var1.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[]{this.entityId});
      PacketUtil.sendPacket(var1, aRE.class, true, true);
   }

   public void setPlayerLocation(double var1, double var3, double var5, float var7, float var8) {
      double var10 = Math.toRadians((double)var7);
      d();
      double var12 = Math.toRadians((double)var8);
      var1 = var1 - Math.cos(var12) * Math.sin(var10) * 48.0D;
      var3 = var3 - Math.sin(var12) * 48.0D;
      var5 = var5 + Math.cos(var12) * Math.cos(var10) * 48.0D;
      this.setLocation(var1, var3, var5);
   }

   static {
      b((String)null);
   }

   public static void b(String var0) {
      k = var0;
   }

   public static String d() {
      return k;
   }

   private static UnsupportedOperationException a(UnsupportedOperationException var0) {
      return var0;
   }
}
