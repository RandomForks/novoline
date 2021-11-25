package de.gerrygames.viarewind.utils;

import com.viaversion.viaversion.api.Via;
import de.gerrygames.viarewind.utils.Tickable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.bgR;

public class Ticker {
   private static boolean init = false;

   public static void init() {
      // $FF: Couldn't be decompiled
   }

   private static void lambda$init$1() {
      Via.b().h().values().forEach(Ticker::lambda$null$0);
   }

   private static void lambda$null$0(bgR var0) {
      Stream var10000 = var0.a().values().stream();
      Tickable.class.getClass();
      var10000 = var10000.filter(Tickable.class::isInstance);
      Tickable.class.getClass();
      var10000.map(Tickable.class::cast).forEach(Tickable::tick);
   }
}
