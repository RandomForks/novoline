package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.Dk;
import net.aRi;
import net.acE;
import net.cA;
import net.t4;
import viaversion.viarewind.replacement.EntityReplacement;
import viaversion.viarewind.utils.PacketUtil;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.ExternalJoinGameListener;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.item.Item;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_8;

public class EntityTracker extends cA implements ExternalJoinGameListener {
   private final Map clientEntityTypes = new ConcurrentHashMap();
   private final Map metadataBuffer = new ConcurrentHashMap();
   private final Map vehicles;
   private final Map entityReplacements;
   private final Map playersByEntityId;
   private final Map playersByUniqueId;
   private final Map playerEquipment;
   private int f;
   private int playerId;
   private int spectating;
   private int c;
   private static String n;

   public EntityTracker(UserConnection var1) {
      super(var1);
      b();
      this.vehicles = new ConcurrentHashMap();
      this.entityReplacements = new ConcurrentHashMap();
      this.playersByEntityId = new HashMap();
      this.playersByUniqueId = new HashMap();
      this.playerEquipment = new HashMap();
      this.f = 0;
      this.playerId = -1;
      this.spectating = -1;
      this.c = 0;
      if(acE.b() == null) {
         b("SLmDAb");
      }

   }

   public void removeEntity(int var1) {
      b();
      this.clientEntityTypes.remove(Integer.valueOf(var1));
      if(this.entityReplacements.containsKey(Integer.valueOf(var1))) {
         ((EntityReplacement)this.entityReplacements.remove(Integer.valueOf(var1))).despawn();
      }

      if(this.playersByEntityId.containsKey(Integer.valueOf(var1))) {
         this.playersByUniqueId.remove(this.playersByEntityId.remove(Integer.valueOf(var1)));
      }

   }

   public void addPlayer(Integer var1, UUID var2) {
      this.playersByUniqueId.put(var2, var1);
      this.playersByEntityId.put(var1, var2);
   }

   public UUID getPlayerUUID(int var1) {
      return (UUID)this.playersByEntityId.get(Integer.valueOf(var1));
   }

   public int getPlayerEntityId(UUID var1) {
      return ((Integer)this.playersByUniqueId.getOrDefault(var1, Integer.valueOf(-1))).intValue();
   }

   public Item[] getPlayerEquipment(UUID var1) {
      return (Item[])this.playerEquipment.get(var1);
   }

   public void setPlayerEquipment(UUID var1, Item[] var2) {
      this.playerEquipment.put(var1, var2);
   }

   public Map getClientEntityTypes() {
      return this.clientEntityTypes;
   }

   public void addMetadataToBuffer(int var1, List var2) {
      String var3 = b();
      if(this.metadataBuffer.containsKey(Integer.valueOf(var1))) {
         ((List)this.metadataBuffer.get(Integer.valueOf(var1))).addAll(var2);
      }

      if(!var2.isEmpty()) {
         this.metadataBuffer.put(Integer.valueOf(var1), var2);
      }

   }

   public void addEntityReplacement(EntityReplacement var1) {
      this.entityReplacements.put(Integer.valueOf(var1.getEntityId()), var1);
   }

   public EntityReplacement getEntityReplacement(int var1) {
      return (EntityReplacement)this.entityReplacements.get(Integer.valueOf(var1));
   }

   public List getBufferedMetadata(int var1) {
      return (List)this.metadataBuffer.get(Integer.valueOf(var1));
   }

   public void sendMetadataBuffer(int var1) {
      String var2 = b();
      if(this.metadataBuffer.containsKey(Integer.valueOf(var1))) {
         if(this.entityReplacements.containsKey(Integer.valueOf(var1))) {
            ((EntityReplacement)this.entityReplacements.get(Integer.valueOf(var1))).updateMetadata((List)this.metadataBuffer.remove(Integer.valueOf(var1)));
         }

         t4 var3 = (t4)this.getClientEntityTypes().get(Integer.valueOf(var1));
         PacketWrapper var4 = new PacketWrapper(28, (ByteBuf)null, this.d());
         var4.write(Type.VAR_INT, Integer.valueOf(var1));
         var4.write(Types1_8.METADATA_LIST, this.metadataBuffer.get(Integer.valueOf(var1)));
         Dk.a(var3, (List)this.metadataBuffer.get(Integer.valueOf(var1)));
         if(!((List)this.metadataBuffer.get(Integer.valueOf(var1))).isEmpty()) {
            PacketUtil.sendPacket(var4, aRi.class);
         }

         this.metadataBuffer.remove(Integer.valueOf(var1));
      }
   }

   public int getVehicle(int var1) {
      b();
      Iterator var3 = this.vehicles.entrySet().iterator();
      if(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(((Integer)var4.getValue()).intValue() == var1) {
            return ((Integer)var4.getValue()).intValue();
         }
      }

      return -1;
   }

   public int getPassenger(int var1) {
      return ((Integer)this.vehicles.getOrDefault(Integer.valueOf(var1), Integer.valueOf(-1))).intValue();
   }

   public void setPassenger(int var1, int var2) {
      String var3 = b();
      if(var1 == this.spectating && this.spectating != this.playerId) {
         try {
            PacketWrapper var4 = new PacketWrapper(11, (ByteBuf)null, this.d());
            var4.write(Type.VAR_INT, Integer.valueOf(this.playerId));
            var4.write(Type.VAR_INT, Integer.valueOf(0));
            var4.write(Type.VAR_INT, Integer.valueOf(0));
            PacketWrapper var5 = new PacketWrapper(11, (ByteBuf)null, this.d());
            var5.write(Type.VAR_INT, Integer.valueOf(this.playerId));
            var5.write(Type.VAR_INT, Integer.valueOf(1));
            var5.write(Type.VAR_INT, Integer.valueOf(0));
            PacketUtil.sendToServer(var4, aRi.class, true, true);
            this.setSpectating(this.playerId);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

      if(var1 == -1) {
         int var7 = this.getVehicle(var2);
         this.vehicles.remove(Integer.valueOf(var7));
      }

      if(var2 == -1) {
         this.vehicles.remove(Integer.valueOf(var1));
      }

      this.vehicles.put(Integer.valueOf(var1), Integer.valueOf(var2));
   }

   public int getSpectating() {
      return this.spectating;
   }

   public boolean setSpectating(int var1) {
      String var2 = b();
      if(var1 != this.playerId && this.getPassenger(var1) != -1) {
         PacketWrapper var6 = new PacketWrapper(11, (ByteBuf)null, this.d());
         var6.write(Type.VAR_INT, Integer.valueOf(this.playerId));
         var6.write(Type.VAR_INT, Integer.valueOf(0));
         var6.write(Type.VAR_INT, Integer.valueOf(0));
         PacketWrapper var4 = new PacketWrapper(11, (ByteBuf)null, this.d());
         var4.write(Type.VAR_INT, Integer.valueOf(this.playerId));
         var4.write(Type.VAR_INT, Integer.valueOf(1));
         var4.write(Type.VAR_INT, Integer.valueOf(0));
         PacketUtil.sendToServer(var6, aRi.class, true, true);
         this.setSpectating(this.playerId);
         return false;
      } else {
         if(this.spectating != var1 && this.spectating != this.playerId) {
            PacketWrapper var3 = new PacketWrapper(27, (ByteBuf)null, this.d());
            var3.write(Type.INT, Integer.valueOf(this.playerId));
            var3.write(Type.INT, Integer.valueOf(-1));
            var3.write(Type.BOOLEAN, Boolean.valueOf(false));
            PacketUtil.sendPacket(var3, aRi.class);
         }

         this.spectating = var1;
         if(var1 != this.playerId) {
            PacketWrapper var5 = new PacketWrapper(27, (ByteBuf)null, this.d());
            var5.write(Type.INT, Integer.valueOf(this.playerId));
            var5.write(Type.INT, Integer.valueOf(this.spectating));
            var5.write(Type.BOOLEAN, Boolean.valueOf(false));
            PacketUtil.sendPacket(var5, aRi.class);
         }

         return true;
      }
   }

   public int a() {
      return this.f;
   }

   public void k(int var1) {
      this.f = var1;
   }

   public int getPlayerId() {
      return this.playerId;
   }

   public void setPlayerId(int var1) {
      String var2 = b();
      if(this.playerId != -1) {
         throw new IllegalStateException("playerId was already set!");
      } else {
         this.playerId = this.spectating = var1;
      }
   }

   public void clearEntities() {
      this.clientEntityTypes.clear();
      this.entityReplacements.clear();
      this.vehicles.clear();
      this.metadataBuffer.clear();
   }

   public int f() {
      return this.c;
   }

   public void c(int var1) {
      this.c = var1;
   }

   public void onExternalJoinGame(int var1) {
      String var2 = b();
      if(this.spectating == this.playerId) {
         this.spectating = var1;
      }

      this.clientEntityTypes.remove(Integer.valueOf(this.playerId));
      this.playerId = var1;
      this.clientEntityTypes.put(Integer.valueOf(this.playerId), t4.ENTITY_HUMAN);
   }

   public static void b(String var0) {
      n = var0;
   }

   public static String b() {
      return n;
   }

   private static Exception a(Exception var0) {
      return var0;
   }

   static {
      if(b() == null) {
         b("vOaim");
      }

   }
}
