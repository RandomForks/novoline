package viaversion.viabackwards.api.rewriters;

import java.util.List;
import net.acE;
import net.aqr;
import net.aqu;
import viaversion.viabackwards.api.entities.storage.MetaStorage;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.remapper.PacketHandler;
import viaversion.viaversion.api.type.Type;

class LegacyEntityRewriter$3 extends acE {
   final Type val$oldMetaType;
   final Type val$newMetaType;
   final aqr e;

   LegacyEntityRewriter$3(aqr var1, Type var2, Type var3) {
      this.e = var1;
      this.val$oldMetaType = var2;
      this.val$newMetaType = var3;
   }

   public void registerMap() {
      aqu.d();
      this.a(Type.VAR_INT);
      if(this.val$oldMetaType != null) {
         this.a(this.val$oldMetaType, this.val$newMetaType);
      }

      this.a(this.val$newMetaType);
      this.a(this::lambda$registerMap$0);
   }

   private void lambda$registerMap$0(Type var1, PacketWrapper var2) throws Exception {
      List var3 = (List)var2.get(var1, 0);
      var2.set(var1, 0, this.e.handleMeta(var2.user(), ((Integer)var2.get(Type.VAR_INT, 0)).intValue(), new MetaStorage(var3)).getMetaDataList());
   }
}
