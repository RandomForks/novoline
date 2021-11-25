package viaversion.viafabric.util;

import java.util.concurrent.Future;
import viaversion.viaversion.api.platform.TaskId;

public class FutureTaskId implements TaskId {
   private final Future object;

   public FutureTaskId(Future var1) {
      this.object = var1;
   }

   public Future getObject() {
      return this.object;
   }
}
