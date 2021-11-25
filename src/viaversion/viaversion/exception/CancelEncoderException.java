package viaversion.viaversion.exception;

import io.netty.handler.codec.EncoderException;
import net.aAu;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.exception.CancelEncoderException$1;

public class CancelEncoderException extends EncoderException implements aAu {
   public static final CancelEncoderException CACHED = new CancelEncoderException$1("This packet is supposed to be cancelled; If you have debug enabled, you can ignore these");

   public CancelEncoderException() {
   }

   public CancelEncoderException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public CancelEncoderException(String var1) {
      super(var1);
   }

   public CancelEncoderException(Throwable var1) {
      super(var1);
   }

   public static CancelEncoderException generate(Throwable var0) {
      return Via.getManager().isDebug()?new CancelEncoderException(var0):CACHED;
   }

   private static CancelEncoderException a(CancelEncoderException var0) {
      return var0;
   }
}
