package viaversion.viaversion.api.protocol;

import net.a66;
import net.acE;
import viaversion.viaversion.api.protocol.Protocol;

public class Protocol$Packet {
   private final a66 a;
   private final int packetId;

   public Protocol$Packet(a66 var1, int var2) {
      this.a = var1;
      this.packetId = var2;
   }

   public a66 a() {
      return this.a;
   }

   public int getPacketId() {
      return this.packetId;
   }

   public String toString() {
      return "Packet{state=" + this.a + ", packetId=" + this.packetId + '}';
   }

   public boolean equals(Object var1) {
      acE[] var2 = Protocol.h();
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Protocol$Packet var3 = (Protocol$Packet)var1;
         return this.packetId == var3.packetId && this.a == var3.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      acE[] var1 = Protocol.h();
      int var2 = this.a != null?this.a.hashCode():0;
      var2 = 31 * var2 + this.packetId;
      return var2;
   }
}
