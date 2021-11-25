package viaversion.viaversion.protocols.protocol1_13to1_12_2.storage;

import io.netty.buffer.ByteBuf;
import net.cA;
import net.cX;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;

public class TabCompleteTracker extends cA {
   private int transactionId;
   private String input;
   private String lastTabComplete;
   private long timeToSend;

   public TabCompleteTracker(UserConnection var1) {
      super(var1);
   }

   public void sendPacketToServer() {
      String[] var1 = cX.a();
      if(this.lastTabComplete != null && this.timeToSend <= System.currentTimeMillis()) {
         PacketWrapper var2 = new PacketWrapper(1, (ByteBuf)null, this.d());
         var2.write(Type.STRING, this.lastTabComplete);
         var2.write(Type.BOOLEAN, Boolean.valueOf(false));
         var2.write(Type.OPTIONAL_POSITION, (Object)null);
         PacketWrapper var10000 = var2;
         Class var10001 = Protocol1_13To1_12_2.class;

         try {
            var10000.sendToServer(var10001);
         } catch (Exception var4) {
            var4.printStackTrace();
         }

         this.lastTabComplete = null;
      }
   }

   public int getTransactionId() {
      return this.transactionId;
   }

   public void setTransactionId(int var1) {
      this.transactionId = var1;
   }

   public String getInput() {
      return this.input;
   }

   public void setInput(String var1) {
      this.input = var1;
   }

   public String getLastTabComplete() {
      return this.lastTabComplete;
   }

   public void setLastTabComplete(String var1) {
      this.lastTabComplete = var1;
   }

   public long getTimeToSend() {
      return this.timeToSend;
   }

   public void setTimeToSend(long var1) {
      this.timeToSend = var1;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
