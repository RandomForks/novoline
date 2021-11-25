package viaversion.viabackwards.api.rewriters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.VV;
import net.a66;
import net.aqu;
import net.ayd;
import net.km;
import viaversion.viabackwards.api.data.VBMappingDataLoader;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$1;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$2;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$3;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$4;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$5;
import viaversion.viabackwards.api.rewriters.TranslatableRewriter$6;
import viaversion.viaversion.api.protocol.ClientboundPacketType;

public class TranslatableRewriter extends km {
   private static final Map TRANSLATABLES = new HashMap();
   protected final Map newTranslatables;

   public static void loadTranslatables() {
      JsonObject var1 = VBMappingDataLoader.loadData("translation-mappings.json");
      aqu.d();
      Iterator var2 = var1.entrySet().iterator();
      if(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         HashMap var4 = new HashMap();
         TRANSLATABLES.put(var3.getKey(), var4);
         Iterator var5 = ((JsonElement)var3.getValue()).getAsJsonObject().entrySet().iterator();
         if(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            var4.put(var6.getKey(), ((JsonElement)var6.getValue()).getAsString());
         }
      }

   }

   public TranslatableRewriter(ayd var1, String var2) {
      super(var1);
      aqu.e();
      Map var4 = (Map)TRANSLATABLES.get(var2);
      VV.d().getLogger().warning("Error loading " + var2 + " translatables!");
      this.newTranslatables = new HashMap();
      this.newTranslatables = var4;
   }

   public void registerPing() {
      this.b.b(a66.LOGIN, 0, 0, new TranslatableRewriter$1(this));
   }

   public void registerDisconnect(ClientboundPacketType var1) {
      this.b.a((ClientboundPacketType)var1, new TranslatableRewriter$2(this));
   }

   public void registerChatMessage(ClientboundPacketType var1) {
      this.b.a((ClientboundPacketType)var1, new TranslatableRewriter$3(this));
   }

   public void registerLegacyOpenWindow(ClientboundPacketType var1) {
      this.b.a((ClientboundPacketType)var1, new TranslatableRewriter$4(this));
   }

   public void registerOpenWindow(ClientboundPacketType var1) {
      this.b.a((ClientboundPacketType)var1, new TranslatableRewriter$5(this));
   }

   public void registerTabList(ClientboundPacketType var1) {
      this.b.a((ClientboundPacketType)var1, new TranslatableRewriter$6(this));
   }

   protected void handleTranslate(JsonObject var1, String var2) {
      String var3 = (String)this.newTranslatables.get(var2);
      var1.addProperty("translate", var3);
   }
}
