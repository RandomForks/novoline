package viaversion.viaversion.api.protocol;

import net.a66;
import net.acE;
import org.jetbrains.annotations.Nullable;

public class Protocol$ProtocolPacket {
   private final a66 c;
   private final int oldID;
   private final int newID;
   private final acE a;

   public Protocol$ProtocolPacket(a66 var1, int var2, int var3, @Nullable acE var4) {
      this.c = var1;
      this.oldID = var2;
      this.newID = var3;
      this.a = var4;
   }

   public a66 c() {
      return this.c;
   }

   public int getOldID() {
      return this.oldID;
   }

   public int getNewID() {
      return this.newID;
   }

   @Nullable
   public acE b() {
      return this.a;
   }
}
