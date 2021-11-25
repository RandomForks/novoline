package viaversion.viabackwards.api.entities.storage;

import java.util.function.Supplier;
import net.VV;
import net.acE;
import net.cQ;
import viaversion.viabackwards.api.entities.storage.EntityPositionStorage;
import viaversion.viabackwards.api.entities.storage.EntityTracker$StoredEntity;
import viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.type.Type;

public class EntityPositionHandler {
   public static final double RELATIVE_MOVE_FACTOR = 4096.0D;
   private final EntityRewriterBase entityRewriter;
   private final Class storageClass;
   private final Supplier d;
   private boolean warnedForMissingEntity;

   public EntityPositionHandler(EntityRewriterBase var1, Class var2, Supplier var3) {
      this.entityRewriter = var1;
      this.storageClass = var2;
      this.d = var3;
   }

   public void cacheEntityPosition(PacketWrapper var1, boolean var2, boolean var3) throws Exception {
      this.cacheEntityPosition(var1, ((Double)var1.get(Type.DOUBLE, 0)).doubleValue(), ((Double)var1.get(Type.DOUBLE, 1)).doubleValue(), ((Double)var1.get(Type.DOUBLE, 2)).doubleValue(), var2, var3);
   }

   public void cacheEntityPosition(PacketWrapper var1, double var2, double var4, double var6, boolean var8, boolean var9) throws Exception {
      cQ.a();
      int var11 = ((Integer)var1.get(Type.VAR_INT, 0)).intValue();
      EntityTracker$StoredEntity var12 = this.entityRewriter.getEntityTracker(var1.user()).getEntity(var11);
      if(Via.getManager().isDebug()) {
         VV.d().getLogger().warning("Stored entity with id " + var11 + " missing at position: " + var2 + " - " + var4 + " - " + var6 + " in " + this.storageClass.getCanonicalName());
         if(var11 == -1 && var2 == 0.0D && var4 == 0.0D && var6 == 0.0D) {
            VV.d().getLogger().warning("DO NOT REPORT THIS TO VIA, THIS IS A PLUGIN ISSUE");
         }

         if(!this.warnedForMissingEntity) {
            this.warnedForMissingEntity = true;
            VV.d().getLogger().warning("This is very likely caused by a plugin sending a teleport packet for an entity outside of the player\'s range.");
         }
      }

   }

   public EntityPositionStorage getStorage(UserConnection var1, int var2) {
      cQ.d();
      EntityTracker$StoredEntity var4 = ((cQ)var1.b(cQ.class)).a(this.entityRewriter.c()).getEntity(var2);
      EntityPositionStorage var5;
      if((var5 = (EntityPositionStorage)var4.get(EntityPositionStorage.class)) == null) {
         VV.d().getLogger().warning("Untracked entity with id " + var2 + " in " + this.storageClass.getCanonicalName());
         return null;
      } else {
         return var5;
      }
   }

   public static void writeFacingAngles(PacketWrapper var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      cQ.d();
      double var14 = var7 - var1;
      double var16 = var9 - var3;
      double var18 = var11 - var5;
      double var20 = Math.sqrt(var14 * var14 + var16 * var16 + var18 * var18);
      double var22 = -Math.atan2(var14, var18) / 3.141592653589793D * 180.0D;
      if(var22 < 0.0D) {
         var22 += 360.0D;
      }

      double var24 = -Math.asin(var16 / var20) / 3.141592653589793D * 180.0D;
      var0.write(Type.BYTE, Byte.valueOf((byte)((int)(var22 * 256.0D / 360.0D))));
      var0.write(Type.BYTE, Byte.valueOf((byte)((int)(var24 * 256.0D / 360.0D))));
   }

   public static void writeFacingDegrees(PacketWrapper var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      cQ.a();
      double var14 = var7 - var1;
      double var16 = var9 - var3;
      double var18 = var11 - var5;
      double var20 = Math.sqrt(var14 * var14 + var16 * var16 + var18 * var18);
      double var22 = -Math.atan2(var14, var18) / 3.141592653589793D * 180.0D;
      if(var22 < 0.0D) {
         var22 += 360.0D;
      }

      double var24 = -Math.asin(var16 / var20) / 3.141592653589793D * 180.0D;
      var0.write(Type.FLOAT, Float.valueOf((float)var22));
      var0.write(Type.FLOAT, Float.valueOf((float)var24));
      if(acE.b() == null) {
         cQ.a(false);
      }

   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
