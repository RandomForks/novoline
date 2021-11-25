package viamcp.utils;

import java.util.concurrent.Future;
import net.NG;

public class FutureTaskId implements NG {
   private final Future object;

   public FutureTaskId(Future var1) {
      this.object = var1;
   }

   public Future getObject() {
      return this.object;
   }
}
