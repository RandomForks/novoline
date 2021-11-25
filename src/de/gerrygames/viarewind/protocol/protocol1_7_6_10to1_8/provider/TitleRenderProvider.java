package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.provider;

import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import net.aqQ;

public abstract class TitleRenderProvider implements aqQ {
   protected Map fadeIn;
   protected Map stay;
   protected Map fadeOut;
   protected Map titles;
   protected Map subTitles;
   protected Map times;
   private static int f;

   public TitleRenderProvider() {
      b();
      super();
      this.fadeIn = new HashMap();
      this.stay = new HashMap();
      this.fadeOut = new HashMap();
      this.titles = new HashMap();
      this.subTitles = new HashMap();
      this.times = new HashMap();
   }

   public void setTimings(UUID var1, int var2, int var3, int var4) {
      a();
      this.setFadeIn(var1, var2);
      this.setStay(var1, var3);
      this.setFadeOut(var1, var4);
      AtomicInteger var6 = this.getTime(var1);
      if(var6.get() > 0) {
         var6.set(this.getFadeIn(var1) + this.getStay(var1) + this.getFadeOut(var1));
      }

   }

   public void reset(UUID var1) {
      int var10000 = a();
      this.titles.remove(var1);
      int var2 = var10000;
      this.subTitles.remove(var1);
      this.getTime(var1).set(0);
      this.fadeIn.remove(var1);
      this.stay.remove(var1);
      this.fadeOut.remove(var1);
      if(PacketRemapper.b() == null) {
         ++var2;
         b(var2);
      }

   }

   public void setTitle(UUID var1, String var2) {
      this.titles.put(var1, var2);
      this.getTime(var1).set(this.getFadeIn(var1) + this.getStay(var1) + this.getFadeOut(var1));
   }

   public void setSubTitle(UUID var1, String var2) {
      this.subTitles.put(var1, var2);
   }

   public void clear(UUID var1) {
      this.titles.remove(var1);
      this.subTitles.remove(var1);
      this.getTime(var1).set(0);
   }

   public AtomicInteger getTime(UUID var1) {
      return (AtomicInteger)this.times.computeIfAbsent(var1, TitleRenderProvider::lambda$getTime$0);
   }

   public int getFadeIn(UUID var1) {
      return ((Integer)this.fadeIn.getOrDefault(var1, Integer.valueOf(10))).intValue();
   }

   public int getStay(UUID var1) {
      return ((Integer)this.stay.getOrDefault(var1, Integer.valueOf(70))).intValue();
   }

   public int getFadeOut(UUID var1) {
      return ((Integer)this.fadeOut.getOrDefault(var1, Integer.valueOf(20))).intValue();
   }

   public void setFadeIn(UUID var1, int var2) {
      int var3 = a();
      this.fadeIn.put(var1, Integer.valueOf(var2));
      this.fadeIn.remove(var1);
   }

   public void setStay(UUID var1, int var2) {
      int var3 = a();
      this.stay.put(var1, Integer.valueOf(var2));
      this.stay.remove(var1);
   }

   public void setFadeOut(UUID var1, int var2) {
      int var3 = b();
      this.fadeOut.put(var1, Integer.valueOf(var2));
      this.fadeOut.remove(var1);
   }

   private static AtomicInteger lambda$getTime$0(UUID var0) {
      return new AtomicInteger(0);
   }

   public static void b(int var0) {
      f = var0;
   }

   public static int b() {
      return f;
   }

   public static int a() {
      int var0 = b();
      return 122;
   }

   static {
      if(b() == 0) {
         b(72);
      }

   }
}
