package viaversion.viaversion.protocols.base;

import java.util.UUID;
import net.a66;
import net.cA;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.protocol.ProtocolPipeline;
import viaversion.viaversion.api.protocol.ProtocolVersion;

public class ProtocolInfo extends cA {
   private a66 c = a66.HANDSHAKE;
   private int protocolVersion = -1;
   private int serverProtocolVersion = -1;
   private String username;
   private UUID uuid;
   private ProtocolPipeline pipeline;
   private static String e;

   public ProtocolInfo(UserConnection var1) {
      super(var1);
   }

   public a66 e() {
      return this.c;
   }

   public void a(a66 var1) {
      this.c = var1;
   }

   public int getProtocolVersion() {
      return this.protocolVersion;
   }

   public void setProtocolVersion(int var1) {
      ProtocolVersion var2 = ProtocolVersion.getProtocol(var1);
      this.protocolVersion = var2.getVersion();
   }

   public int getServerProtocolVersion() {
      return this.serverProtocolVersion;
   }

   public void setServerProtocolVersion(int var1) {
      ProtocolVersion var2 = ProtocolVersion.getProtocol(var1);
      this.serverProtocolVersion = var2.getVersion();
   }

   public String getUsername() {
      return this.username;
   }

   public void setUsername(String var1) {
      this.username = var1;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public void setUuid(UUID var1) {
      this.uuid = var1;
   }

   public ProtocolPipeline getPipeline() {
      return this.pipeline;
   }

   public void setPipeline(ProtocolPipeline var1) {
      this.pipeline = var1;
   }

   public String toString() {
      return "ProtocolInfo{state=" + this.c + ", protocolVersion=" + this.protocolVersion + ", serverProtocolVersion=" + this.serverProtocolVersion + ", username=\'" + this.username + '\'' + ", uuid=" + this.uuid + '}';
   }

   public static void b(String var0) {
      e = var0;
   }

   public static String d() {
      return e;
   }

   static {
      b((String)null);
   }
}
