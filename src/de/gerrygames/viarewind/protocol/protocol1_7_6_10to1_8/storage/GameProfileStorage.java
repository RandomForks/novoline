package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.GameProfileStorage$Property;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import net.aZu;
import net.bgR;
import net.cA;
import net.cf;

public class GameProfileStorage extends cA {
   private final Map properties = new HashMap();

   public GameProfileStorage(bgR var1) {
      super(var1);
   }

   public aZu a(UUID var1, String var2) {
      aZu var3 = new aZu(var1, var2);
      this.properties.put(var1, var3);
      return var3;
   }

   public void putProperty(UUID var1, GameProfileStorage$Property var2) {
      ((aZu)this.properties.computeIfAbsent(var1, GameProfileStorage::lambda$putProperty$0)).d.add(var2);
   }

   public void putProperty(UUID var1, String var2, String var3, String var4) {
      this.putProperty(var1, new GameProfileStorage$Property(var2, var3, var4));
   }

   public aZu a(UUID var1) {
      return (aZu)this.properties.get(var1);
   }

   public aZu a(String var1, boolean var2) {
      String var3 = cf.b();
      var1 = var1.toLowerCase();

      for(aZu var5 : this.properties.values()) {
         if(var5.e != null) {
            String var6 = var5.e.toLowerCase();
            if(var6.equals(var1)) {
               return var5;
            }
            break;
         }
      }

      return null;
   }

   public List getAllWithPrefix(String var1, boolean var2) {
      String var3 = cf.b();
      var1 = var1.toLowerCase();
      ArrayList var4 = new ArrayList();

      for(aZu var6 : this.properties.values()) {
         if(var6.e != null) {
            String var7 = var6.e.toLowerCase();
            if(var7.startsWith(var1)) {
               var4.add(var6);
            }
            break;
         }
      }

      return var4;
   }

   public aZu b(UUID var1) {
      return (aZu)this.properties.remove(var1);
   }

   private static aZu lambda$putProperty$0(UUID var0, UUID var1) {
      return new aZu(var0, (String)null);
   }
}
