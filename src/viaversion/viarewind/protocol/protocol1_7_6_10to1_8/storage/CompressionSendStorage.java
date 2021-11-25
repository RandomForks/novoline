package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.Objects;
import net.cA;
import viaversion.viarewind.protocol.protocol1_7_6_10to1_8.storage.EntityTracker;
import viaversion.viaversion.api.data.UserConnection;

public class CompressionSendStorage extends cA {
   private boolean compressionSend = false;

   public CompressionSendStorage(UserConnection var1) {
      super(var1);
   }

   public CompressionSendStorage(UserConnection var1, boolean var2) {
      super(var1);
      this.compressionSend = var2;
   }

   public boolean isCompressionSend() {
      return this.compressionSend;
   }

   public void setCompressionSend(boolean var1) {
      this.compressionSend = var1;
   }

   public boolean equals(Object var1) {
      String var2 = EntityTracker.b();
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof CompressionSendStorage)) {
         return false;
      } else {
         CompressionSendStorage var3 = (CompressionSendStorage)var1;
         return this.compressionSend == var3.compressionSend;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{Boolean.valueOf(this.compressionSend)});
   }

   public String toString() {
      return "CompressionSendStorage{compressionSend=" + this.compressionSend + '}';
   }
}
