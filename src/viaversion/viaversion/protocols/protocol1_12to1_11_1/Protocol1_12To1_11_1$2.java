package viaversion.viaversion.protocols.protocol1_12to1_11_1;

import net.aRp;
import net.acE;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_12;

class Protocol1_12To1_11_1$2 extends acE {
   final MetadataRewriter val$metadataRewriter;
   final aRp d;

   Protocol1_12To1_11_1$2(aRp var1, MetadataRewriter var2) {
      this.d = var1;
      this.val$metadataRewriter = var2;
   }

   public void registerMap() {
      this.a(Type.VAR_INT);
      aRp.a();
      this.a(Type.UUID);
      this.a(Type.VAR_INT);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.DOUBLE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.BYTE);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Type.SHORT);
      this.a(Types1_12.METADATA_LIST);
      this.a(this.val$metadataRewriter.getTrackerAndRewriter(Types1_12.METADATA_LIST));
      if(acE.b() == null) {
         aRp.a(new acE[1]);
      }

   }
}
