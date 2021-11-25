package viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.List;
import net.aci;
import net.ayk;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.ParticleMapping$1;
import viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.ParticleMapping$ParticleHandler;
import viaversion.viaversion.api.PacketWrapper;

public final class ParticleMapping$ParticleData {
   private final int historyId;
   private final ParticleMapping$ParticleHandler handler;

   private ParticleMapping$ParticleData(int var1, ParticleMapping$ParticleHandler var2) {
      this.historyId = var1;
      this.handler = var2;
   }

   private ParticleMapping$ParticleData(int var1) {
      this(var1, (ParticleMapping$ParticleHandler)null);
   }

   public int[] a(ayk var1, PacketWrapper var2) throws Exception {
      String[] var3 = aci.b();
      return this.handler == null?null:this.handler.a(var1, var2);
   }

   public int[] a(ayk var1, List var2) {
      String[] var3 = aci.b();
      return this.handler == null?null:this.handler.a(var1, var2);
   }

   public int getHistoryId() {
      return this.historyId;
   }

   public ParticleMapping$ParticleHandler getHandler() {
      return this.handler;
   }

   ParticleMapping$ParticleData(int var1, ParticleMapping$1 var2) {
      this(var1);
   }

   ParticleMapping$ParticleData(int var1, ParticleMapping$ParticleHandler var2, ParticleMapping$1 var3) {
      this(var1, var2);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
