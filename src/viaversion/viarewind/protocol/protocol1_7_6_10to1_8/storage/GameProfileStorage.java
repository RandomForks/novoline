package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import net.cA;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage$GameProfile;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage$Property;
import viaversion.viaversion.api.data.UserConnection;

public class GameProfileStorage extends cA {
   private final Map properties = new HashMap();

   public GameProfileStorage(UserConnection var1) {
      super(var1);
   }

   public GameProfileStorage$GameProfile put(UUID var1, String var2) {
      GameProfileStorage$GameProfile var3 = new GameProfileStorage$GameProfile(var1, var2);
      this.properties.put(var1, var3);
      return var3;
   }

   public void putProperty(UUID var1, GameProfileStorage$Property var2) {
      ((GameProfileStorage$GameProfile)this.properties.computeIfAbsent(var1, GameProfileStorage::lambda$putProperty$0)).properties.add(var2);
   }

   public void putProperty(UUID var1, String var2, String var3, String var4) {
      this.putProperty(var1, new GameProfileStorage$Property(var2, var3, var4));
   }

   public GameProfileStorage$GameProfile get(UUID var1) {
      return (GameProfileStorage$GameProfile)this.properties.get(var1);
   }

   public GameProfileStorage$GameProfile get(String var1, boolean var2) {
      String var3 = EntityTracker.b();
      var1 = var1.toLowerCase();

      for(GameProfileStorage$GameProfile var5 : this.properties.values()) {
         if(var5.name != null) {
            String var6 = var5.name.toLowerCase();
            if(var6.equals(var1)) {
               return var5;
            }
            break;
         }
      }

      return null;
   }

   public List getAllWithPrefix(String var1, boolean var2) {
      String var3 = EntityTracker.b();
      var1 = var1.toLowerCase();
      ArrayList var4 = new ArrayList();

      for(GameProfileStorage$GameProfile var6 : this.properties.values()) {
         if(var6.name != null) {
            String var7 = var6.name.toLowerCase();
            if(var7.startsWith(var1)) {
               var4.add(var6);
            }
            break;
         }
      }

      return var4;
   }

   public GameProfileStorage$GameProfile remove(UUID var1) {
      return (GameProfileStorage$GameProfile)this.properties.remove(var1);
   }

   private static GameProfileStorage$GameProfile lambda$putProperty$0(UUID var0, UUID var1) {
      return new GameProfileStorage$GameProfile(var0, (String)null);
   }
}
