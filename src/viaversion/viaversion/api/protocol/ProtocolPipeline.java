package viaversion.viaversion.api.protocol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import net.a66;
import net.acE;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.api.platform.ViaPlatform;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.protocol.ProtocolRegistry;
import viaversion.viaversion.api.protocol.SimpleProtocol;
import viaversion.viaversion.packets.Direction;
import viaversion.viaversion.protocols.base.ProtocolInfo;

public class ProtocolPipeline extends SimpleProtocol {
   private List protocolList;
   private UserConnection userConnection;

   public ProtocolPipeline(UserConnection var1) {
      this.init(var1);
   }

   protected void registerPackets() {
      this.protocolList = new CopyOnWriteArrayList();
      this.protocolList.add(ProtocolRegistry.BASE_PROTOCOL);
   }

   public void init(UserConnection var1) {
      this.userConnection = var1;
      ProtocolInfo var3 = new ProtocolInfo(var1);
      Protocol.h();
      var3.setPipeline(this);
      var1.setProtocolInfo(var3);
      Iterator var4 = this.protocolList.iterator();
      if(var4.hasNext()) {
         Protocol var5 = (Protocol)var4.next();
         var5.init(var1);
      }

   }

   public void add(Protocol var1) {
      acE[] var2 = Protocol.h();
      if(this.protocolList != null) {
         this.protocolList.add(var1);
         var1.init(this.userConnection);
         ArrayList var3 = new ArrayList();
         Iterator var4 = this.protocolList.iterator();
         if(var4.hasNext()) {
            Protocol var5 = (Protocol)var4.next();
            if(ProtocolRegistry.isBaseProtocol(var5)) {
               var3.add(var5);
            }
         }

         this.protocolList.removeAll(var3);
         this.protocolList.addAll(var3);
      }

      throw new NullPointerException("Tried to add protocol too early");
   }

   public void a(Direction var1, a66 var2, PacketWrapper var3) throws Exception {
      Protocol.h();
      int var5 = var3.getId();
      var3.a(var1, var2, 0, (List)this.protocolList, var1 == Direction.OUTGOING);
      super.a(var1, var2, var3);
      if(Via.getManager().isDebug()) {
         this.a(var1, var2, var3, var5);
      }

   }

   private void a(Direction var1, a66 var2, PacketWrapper var3, int var4) {
      Protocol.h();
      int var6 = this.userConnection.getProtocolInfo().getProtocolVersion();
      ViaPlatform var7 = Via.getPlatform();
      String var8 = var3.user().getProtocolInfo().getUsername();
      String var9 = var8 != null?var8 + " ":"";
      var7.getLogger().log(Level.INFO, "{0}{1} {2}: {3} (0x{4}) -> {5} (0x{6}) [{7}] {8}", new Object[]{var9, var1, var2, Integer.valueOf(var4), Integer.toHexString(var4), Integer.valueOf(var3.getId()), Integer.toHexString(var3.getId()), Integer.toString(var6), var3});
   }

   public boolean contains(Class var1) {
      Protocol.h();
      Iterator var3 = this.protocolList.iterator();
      if(var3.hasNext()) {
         Protocol var4 = (Protocol)var3.next();
         if(var4.getClass() == var1) {
            return true;
         }
      }

      return false;
   }

   public Protocol getProtocol(Class var1) {
      Protocol.h();
      Iterator var3 = this.protocolList.iterator();
      if(var3.hasNext()) {
         Protocol var4 = (Protocol)var3.next();
         if(var4.getClass() == var1) {
            return var4;
         }
      }

      return null;
   }

   public boolean filter(Object var1, List var2) throws Exception {
      Protocol.h();
      Iterator var4 = this.protocolList.iterator();
      if(var4.hasNext()) {
         Protocol var5 = (Protocol)var4.next();
         if(var5.isFiltered(var1.getClass())) {
            var5.filterPacket(this.userConnection, var1, var2);
            return true;
         }
      }

      return false;
   }

   public List pipes() {
      return this.protocolList;
   }

   public void cleanPipes() {
      this.pipes().clear();
      this.registerPackets();
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
