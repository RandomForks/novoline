package viaversion.viabackwards.api.rewriters;

import net.aqu;
import net.ayd;
import viaversion.viabackwards.api.rewriters.SoundRewriter$1;
import viaversion.viabackwards.api.rewriters.SoundRewriter$2;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

public class SoundRewriter extends viaversion.viaversion.api.rewriters.SoundRewriter {
   private final ayd c;

   public SoundRewriter(ayd var1) {
      super(var1);
      this.c = var1;
   }

   public void registerNamedSound(ClientboundPacketType var1) {
      this.c.a(var1, new SoundRewriter$1(this));
   }

   public void registerStopSound(ClientboundPacketType var1) {
      this.c.a(var1, new SoundRewriter$2(this));
   }

   public PacketHandler getNamedSoundHandler() {
      return this::lambda$getNamedSoundHandler$0;
   }

   public PacketHandler getStopSoundHandler() {
      return this::lambda$getStopSoundHandler$1;
   }

   private void lambda$getStopSoundHandler$1(PacketWrapper var1) throws Exception {
      aqu.e();
      byte var3 = ((Byte)var1.passthrough(Type.BYTE)).byteValue();
      if((var3 & 2) != 0) {
         if((var3 & 1) != 0) {
            var1.passthrough(Type.VAR_INT);
         }

         String var4 = (String)var1.read(Type.STRING);
         if(var4.startsWith("minecraft:")) {
            var4 = var4.substring(10);
         }

         String var5 = this.c.getMappingData().getMappedNamedSound(var4);
         if(var5 == null) {
            var1.write(Type.STRING, var4);
         } else {
            if(!var5.isEmpty()) {
               var1.write(Type.STRING, var5);
            }

            var1.cancel();
         }
      }
   }

   private void lambda$getNamedSoundHandler$0(PacketWrapper var1) throws Exception {
      aqu.d();
      String var3 = (String)var1.get(Type.STRING, 0);
      if(var3.startsWith("minecraft:")) {
         var3 = var3.substring(10);
      }

      String var4 = this.c.getMappingData().getMappedNamedSound(var3);
      if(var4 != null) {
         if(!var4.isEmpty()) {
            var1.set(Type.STRING, 0, var4);
         }

         var1.cancel();
      }
   }

   private static Exception b(Exception var0) {
      return var0;
   }
}
