package viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.cA;
import net.cq;
import viaversion.viaversion.api.Pair;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.minecraft.Position;

public class CommandBlockStorage extends cA {
   private final Map storedCommandBlocks = new ConcurrentHashMap();
   private boolean permissions = false;

   public CommandBlockStorage(UserConnection var1) {
      super(var1);
   }

   public void unloadChunk(int var1, int var2) {
      Pair var3 = new Pair(Integer.valueOf(var1), Integer.valueOf(var2));
      this.storedCommandBlocks.remove(var3);
   }

   public void addOrUpdateBlock(Position var1, CompoundTag var2) {
      cq.c();
      Pair var4 = this.getChunkCoords(var1);
      if(!this.storedCommandBlocks.containsKey(var4)) {
         this.storedCommandBlocks.put(var4, new ConcurrentHashMap());
      }

      Map var5 = (Map)this.storedCommandBlocks.get(var4);
      if(!var5.containsKey(var1) || !((CompoundTag)var5.get(var1)).equals(var2)) {
         var5.put(var1, var2);
      }
   }

   private Pair getChunkCoords(Position var1) {
      int var2 = Math.floorDiv(var1.getX(), 16);
      int var3 = Math.floorDiv(var1.getZ(), 16);
      return new Pair(Integer.valueOf(var2), Integer.valueOf(var3));
   }

   public Optional getCommandBlock(Position var1) {
      cq.c();
      Pair var3 = this.getChunkCoords(var1);
      Map var4 = (Map)this.storedCommandBlocks.get(var3);
      if(var4 == null) {
         return Optional.empty();
      } else {
         CompoundTag var5 = (CompoundTag)var4.get(var1);
         if(var5 == null) {
            return Optional.empty();
         } else {
            var5 = var5.clone();
            var5.put(new ByteTag("powered", (byte)0));
            var5.put(new ByteTag("auto", (byte)0));
            var5.put(new ByteTag("conditionMet", (byte)0));
            return Optional.of(var5);
         }
      }
   }

   public void unloadChunks() {
      this.storedCommandBlocks.clear();
   }

   public boolean isPermissions() {
      return this.permissions;
   }

   public void setPermissions(boolean var1) {
      this.permissions = var1;
   }
}
