package viaversion.viaversion.boss;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.aRY;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.boss.BossBar;
import viaversion.viaversion.api.boss.BossColor;
import viaversion.viaversion.api.boss.BossFlag;
import viaversion.viaversion.api.boss.BossStyle;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.boss.CommonBoss$UpdateAction;

public abstract class CommonBoss extends BossBar {
   private final UUID uuid;
   private final Set connections;
   private final Set flags;
   private String title;
   private float health;
   private BossColor color;
   private BossStyle style;
   private boolean visible;
   private static acE[] c;

   public CommonBoss(String var1, float var2, BossColor var3, BossStyle var4) {
      d();
      super();
      Preconditions.checkNotNull(var1, "Title cannot be null");
      Preconditions.checkArgument(var2 >= 0.0F && var2 <= 1.0F, "Health must be between 0 and 1");
      this.uuid = UUID.randomUUID();
      this.title = var1;
      this.health = var2;
      this.color = var3 == null?BossColor.PURPLE:var3;
      this.style = var4 == null?BossStyle.SOLID:var4;
      this.connections = Collections.newSetFromMap(new WeakHashMap());
      this.flags = new HashSet();
      this.visible = true;
   }

   public BossBar setTitle(String var1) {
      Preconditions.checkNotNull(var1);
      this.title = var1;
      this.sendPacket(CommonBoss$UpdateAction.UPDATE_TITLE);
      return this;
   }

   public BossBar setHealth(float var1) {
      acE[] var2 = d();
      Preconditions.checkArgument(var1 >= 0.0F && var1 <= 1.0F, "Health must be between 0 and 1");
      this.health = var1;
      this.sendPacket(CommonBoss$UpdateAction.UPDATE_HEALTH);
      if(acE.b() == null) {
         a(new acE[5]);
      }

      return this;
   }

   public BossColor getColor() {
      return this.color;
   }

   public BossBar setColor(BossColor var1) {
      Preconditions.checkNotNull(var1);
      this.color = var1;
      this.sendPacket(CommonBoss$UpdateAction.UPDATE_STYLE);
      return this;
   }

   public BossBar setStyle(BossStyle var1) {
      Preconditions.checkNotNull(var1);
      this.style = var1;
      this.sendPacket(CommonBoss$UpdateAction.UPDATE_STYLE);
      return this;
   }

   public BossBar b(UUID var1) {
      return this.addConnection(Via.getManager().getConnection(var1));
   }

   public BossBar addConnection(UserConnection var1) {
      acE[] var2 = d();
      if(this.connections.add(var1) && this.visible) {
         this.sendPacketConnection(var1, this.getPacket(CommonBoss$UpdateAction.ADD, var1));
      }

      return this;
   }

   public BossBar a(UUID var1) {
      return this.removeConnection(Via.getManager().getConnection(var1));
   }

   public BossBar removeConnection(UserConnection var1) {
      acE[] var2 = d();
      if(this.connections.remove(var1)) {
         this.sendPacketConnection(var1, this.getPacket(CommonBoss$UpdateAction.REMOVE, var1));
      }

      return this;
   }

   public BossBar addFlag(BossFlag var1) {
      d();
      Preconditions.checkNotNull(var1);
      if(!this.hasFlag(var1)) {
         this.flags.add(var1);
      }

      this.sendPacket(CommonBoss$UpdateAction.UPDATE_FLAGS);
      return this;
   }

   public BossBar removeFlag(BossFlag var1) {
      d();
      Preconditions.checkNotNull(var1);
      if(this.hasFlag(var1)) {
         this.flags.remove(var1);
      }

      this.sendPacket(CommonBoss$UpdateAction.UPDATE_FLAGS);
      return this;
   }

   public boolean hasFlag(BossFlag var1) {
      Preconditions.checkNotNull(var1);
      return this.flags.contains(var1);
   }

   public Set getPlayers() {
      return (Set)this.connections.stream().map(CommonBoss::lambda$getPlayers$0).filter(Objects::nonNull).collect(Collectors.toSet());
   }

   public Set getConnections() {
      return Collections.unmodifiableSet(this.connections);
   }

   public BossBar show() {
      this.setVisible(true);
      return this;
   }

   public BossBar hide() {
      this.setVisible(false);
      return this;
   }

   public boolean isVisible() {
      return this.visible;
   }

   private void setVisible(boolean var1) {
      acE[] var2 = d();
      if(this.visible != var1) {
         this.visible = var1;
         this.sendPacket(CommonBoss$UpdateAction.ADD);
      }

   }

   public UUID getId() {
      return this.uuid;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public String getTitle() {
      return this.title;
   }

   public float getHealth() {
      return this.health;
   }

   public BossStyle getStyle() {
      return this.style;
   }

   public Set getFlags() {
      return this.flags;
   }

   private void sendPacket(CommonBoss$UpdateAction var1) {
      d();
      Iterator var3 = (new ArrayList(this.connections)).iterator();
      if(var3.hasNext()) {
         UserConnection var4 = (UserConnection)var3.next();
         PacketWrapper var5 = this.getPacket(var1, var4);
         this.sendPacketConnection(var4, var5);
      }

   }

   private void sendPacketConnection(UserConnection var1, PacketWrapper var2) {
      acE[] var3 = d();
      if(var1.getProtocolInfo() != null && var1.getProtocolInfo().getPipeline().contains(aRY.class)) {
         PacketWrapper var10000 = var2;
         Class var10001 = aRY.class;

         try {
            var10000.send(var10001);
         } catch (Exception var5) {
            var5.printStackTrace();
         }

      } else {
         this.connections.remove(var1);
      }
   }

   private PacketWrapper getPacket(CommonBoss$UpdateAction param1, UserConnection param2) {
      // $FF: Couldn't be decompiled
   }

   private int flagToBytes() {
      d();
      int var2 = 0;
      Iterator var3 = this.flags.iterator();
      if(var3.hasNext()) {
         BossFlag var4 = (BossFlag)var3.next();
         var2 |= var4.getId();
      }

      return var2;
   }

   private static UUID lambda$getPlayers$0(UserConnection var0) {
      return Via.getManager().getConnectedClientId(var0);
   }

   public static void a(acE[] var0) {
      c = var0;
   }

   public static acE[] d() {
      return c;
   }

   private static Exception a(Exception var0) {
      return var0;
   }

   static {
      a(new acE[2]);
   }
}
