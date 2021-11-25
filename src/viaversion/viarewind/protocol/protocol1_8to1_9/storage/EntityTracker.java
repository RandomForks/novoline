package viaversion.viarewind.protocol.protocol1_8to1_9.storage;

import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import net.aRE;
import net.arP;
import net.cA;
import net.t4;
import viaversion.viarewind.replacement.EntityReplacement;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.ExternalJoinGameListener;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Vector;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_8;

public class EntityTracker extends cA implements ExternalJoinGameListener {
   private final Map vehicleMap = new ConcurrentHashMap();
   private final Map clientEntityTypes = new ConcurrentHashMap();
   private final Map metadataBuffer = new ConcurrentHashMap();
   private final Map entityReplacements = new ConcurrentHashMap();
   private final Map entityOffsets = new ConcurrentHashMap();
   private int playerId;
   private int playerGamemode = 0;
   private static String[] h;

   public EntityTracker(UserConnection var1) {
      super(var1);
   }

   public void setPlayerId(int var1) {
      this.playerId = var1;
   }

   public int getPlayerId() {
      return this.playerId;
   }

   public int getPlayerGamemode() {
      return this.playerGamemode;
   }

   public void setPlayerGamemode(int var1) {
      this.playerGamemode = var1;
   }

   public void removeEntity(int var1) {
      d();
      this.vehicleMap.remove(Integer.valueOf(var1));
      this.vehicleMap.forEach(EntityTracker::lambda$removeEntity$0);
      this.vehicleMap.entrySet().removeIf(EntityTracker::lambda$removeEntity$1);
      this.clientEntityTypes.remove(Integer.valueOf(var1));
      this.entityOffsets.remove(Integer.valueOf(var1));
      if(this.entityReplacements.containsKey(Integer.valueOf(var1))) {
         ((EntityReplacement)this.entityReplacements.remove(Integer.valueOf(var1))).despawn();
      }

   }

   public void resetEntityOffset(int var1) {
      this.entityOffsets.remove(Integer.valueOf(var1));
   }

   public Vector getEntityOffset(int var1) {
      return (Vector)this.entityOffsets.computeIfAbsent(Integer.valueOf(var1), EntityTracker::lambda$getEntityOffset$2);
   }

   public void addToEntityOffset(int var1, short var2, short var3, short var4) {
      this.entityOffsets.compute(Integer.valueOf(var1), EntityTracker::lambda$addToEntityOffset$3);
   }

   public void setEntityOffset(int var1, short var2, short var3, short var4) {
      this.entityOffsets.compute(Integer.valueOf(var1), EntityTracker::lambda$setEntityOffset$4);
   }

   public void setEntityOffset(int var1, Vector var2) {
      this.entityOffsets.put(Integer.valueOf(var1), var2);
   }

   public List getPassengers(int var1) {
      return (List)this.vehicleMap.getOrDefault(Integer.valueOf(var1), new ArrayList());
   }

   public void setPassengers(int var1, List var2) {
      this.vehicleMap.put(Integer.valueOf(var1), var2);
   }

   public void addEntityReplacement(EntityReplacement var1) {
      this.entityReplacements.put(Integer.valueOf(var1.getEntityId()), var1);
   }

   public EntityReplacement getEntityReplacement(int var1) {
      return (EntityReplacement)this.entityReplacements.get(Integer.valueOf(var1));
   }

   public Map getClientEntityTypes() {
      return this.clientEntityTypes;
   }

   public void addMetadataToBuffer(int var1, List var2) {
      String[] var3 = d();
      if(this.metadataBuffer.containsKey(Integer.valueOf(var1))) {
         ((List)this.metadataBuffer.get(Integer.valueOf(var1))).addAll(var2);
      }

      if(!var2.isEmpty()) {
         this.metadataBuffer.put(Integer.valueOf(var1), var2);
      }

   }

   public List getBufferedMetadata(int var1) {
      return (List)this.metadataBuffer.get(Integer.valueOf(var1));
   }

   public boolean isInsideVehicle(int var1) {
      d();
      Iterator var3 = this.vehicleMap.values().iterator();
      if(var3.hasNext()) {
         List var4 = (List)var3.next();
         if(var4.contains(Integer.valueOf(var1))) {
            return true;
         }
      }

      return false;
   }

   public int getVehicle(int var1) {
      d();
      Iterator var3 = this.vehicleMap.entrySet().iterator();
      if(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(((List)var4.getValue()).contains(Integer.valueOf(var1))) {
            return ((Integer)var4.getKey()).intValue();
         }
      }

      return -1;
   }

   public boolean isPassenger(int var1, int var2) {
      String[] var3 = d();
      return this.vehicleMap.containsKey(Integer.valueOf(var1)) && ((List)this.vehicleMap.get(Integer.valueOf(var1))).contains(Integer.valueOf(var2));
   }

   public void sendMetadataBuffer(int var1) {
      String[] var2 = d();
      if(this.metadataBuffer.containsKey(Integer.valueOf(var1))) {
         if(this.entityReplacements.containsKey(Integer.valueOf(var1))) {
            ((EntityReplacement)this.entityReplacements.get(Integer.valueOf(var1))).updateMetadata((List)this.metadataBuffer.remove(Integer.valueOf(var1)));
         }

         PacketWrapper var3 = new PacketWrapper(28, (ByteBuf)null, this.d());
         var3.write(Type.VAR_INT, Integer.valueOf(var1));
         var3.write(Types1_8.METADATA_LIST, this.metadataBuffer.get(Integer.valueOf(var1)));
         arP.a((t4)this.getClientEntityTypes().get(Integer.valueOf(var1)), (List)this.metadataBuffer.get(Integer.valueOf(var1)));
         if(!((List)this.metadataBuffer.get(Integer.valueOf(var1))).isEmpty()) {
            PacketWrapper var10000 = var3;
            Class var10001 = aRE.class;

            try {
               var10000.send(var10001);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }

         this.metadataBuffer.remove(Integer.valueOf(var1));
      }
   }

   public void onExternalJoinGame(int var1) {
      this.clientEntityTypes.remove(Integer.valueOf(this.playerId));
      this.playerId = var1;
      this.clientEntityTypes.put(Integer.valueOf(this.playerId), t4.ENTITY_HUMAN);
   }

   private static Vector lambda$setEntityOffset$4(short var0, short var1, short var2, Integer var3, Vector var4) {
      String[] var5 = d();
      if(var4 == null) {
         return new Vector(var0, var1, var2);
      } else {
         var4.c(var0);
         var4.b(var1);
         var4.a(var2);
         return var4;
      }
   }

   private static Vector lambda$addToEntityOffset$3(short var0, short var1, short var2, Integer var3, Vector var4) {
      String[] var5 = d();
      if(var4 == null) {
         return new Vector(var0, var1, var2);
      } else {
         var4.c(var4.c() + var0);
         var4.b(var4.a() + var1);
         var4.a(var4.b() + var2);
         return var4;
      }
   }

   private static Vector lambda$getEntityOffset$2(Integer var0) {
      return new Vector(0, 0, 0);
   }

   private static boolean lambda$removeEntity$1(Entry var0) {
      return ((List)var0.getValue()).isEmpty();
   }

   private static void lambda$removeEntity$0(int var0, Integer var1, List var2) {
      var2.remove(Integer.valueOf(var0));
   }

   public static void b(String[] var0) {
      h = var0;
   }

   public static String[] d() {
      return h;
   }

   private static Exception a(Exception var0) {
      return var0;
   }

   static {
      if(d() != null) {
         b(new String[1]);
      }

   }
}
