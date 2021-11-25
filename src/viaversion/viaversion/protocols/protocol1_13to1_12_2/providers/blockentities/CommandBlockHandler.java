package viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import com.google.gson.JsonElement;
import net.aYj;
import viaversion.viaversion.api.data.UserConnection;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.ChatRewriter;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.BlockEntityProvider$BlockEntityHandler;
import viaversion.viaversion.util.GsonUtil;

public class CommandBlockHandler implements BlockEntityProvider$BlockEntityHandler {
   public int transform(UserConnection var1, CompoundTag var2) {
      aYj.a();
      Tag var4 = var2.get("CustomName");
      if(var4 instanceof StringTag) {
         ((StringTag)var4).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)var4).getValue()));
      }

      Tag var5 = var2.get("LastOutput");
      if(var5 instanceof StringTag) {
         JsonElement var6 = GsonUtil.getJsonParser().parse(((StringTag)var5).getValue());
         ChatRewriter.processTranslate(var6);
         ((StringTag)var5).setValue(var6.toString());
      }

      return -1;
   }
}
