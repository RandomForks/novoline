package viaversion.viarewind.utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import viaversion.viarewind.utils.Tickable;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;

public class Ticker {
   private static boolean init = false;

   public static void init() {
      // $FF: Couldn't be decompiled
   }

   private static void lambda$init$1() {
      Via.getManager().getPortedPlayers().values().forEach(Ticker::lambda$null$0);
   }

   private static void lambda$null$0(UserConnection var0) {
      Stream var10000 = var0.getStoredObjects().values().stream();
      Tickable.class.getClass();
      var10000 = var10000.filter(Tickable.class::isInstance);
      Tickable.class.getClass();
      var10000.map(Tickable.class::cast).forEach(Tickable::tick);
   }
}
