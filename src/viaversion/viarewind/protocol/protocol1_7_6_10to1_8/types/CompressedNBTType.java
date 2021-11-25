package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.github.steveice10.opennbt.NBTIO;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.acE;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types.Particle;
import viaversion.viaversion.api.type.Type;

public class CompressedNBTType extends Type {
   public CompressedNBTType() {
      super("CompoundTag", CompoundTag.class);
   }

   public CompoundTag read(ByteBuf param1) {
      // $FF: Couldn't be decompiled
   }

   public void write(ByteBuf var1, CompoundTag var2) throws Exception {
      acE[] var3 = Particle.b();
      var1.writeShort(-1);
      ByteBuf var4 = var1.alloc().buffer();
      ByteBufOutputStream var5 = new ByteBufOutputStream(var4);
      DataOutputStream var6 = new DataOutputStream(var5);
      NBTIO.writeTag(var6, var2);
      var6.close();
      byte[] var7 = new byte[var4.readableBytes()];
      var4.readBytes(var7);
      var4.release();
      byte[] var8 = compress(var7);
      var1.writeShort(var8.length);
      var1.writeBytes(var8);
   }

   public static byte[] compress(byte[] var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();

      try {
         GZIPOutputStream var2 = new GZIPOutputStream(var1);
         var2.write(var0);
         var2.close();
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }

      return var1.toByteArray();
   }

   public static byte[] decompress(byte[] var0) {
      Particle.b();
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();

      try {
         GZIPInputStream var3 = new GZIPInputStream(new ByteArrayInputStream(var0));
         if(var3.available() > 0) {
            var2.write(var3.read());
         }
      } catch (IOException var4) {
         throw new RuntimeException(var4);
      }

      return var2.toByteArray();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
