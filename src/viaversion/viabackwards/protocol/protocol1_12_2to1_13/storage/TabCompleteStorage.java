package viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage;

import java.util.HashMap;
import java.util.Map;
import net.acE;
import net.cA;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.BackwardsBlockStorage;
import viaversion.viaversion.api.data.UserConnection;

public class TabCompleteStorage extends cA {
   public int lastId;
   public String lastRequest;
   public boolean lastAssumeCommand;
   public Map usernames;

   public TabCompleteStorage(UserConnection var1) {
      super(var1);
      BackwardsBlockStorage.e();
      this.usernames = new HashMap();
      if(acE.b() == null) {
         BackwardsBlockStorage.a(false);
      }

   }
}
