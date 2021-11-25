package viaversion.viaversion.api.rewriters;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.PacketWrapper;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.rewriters.RegistryType;
import viaversion.viaversion.api.rewriters.TagRewriter$1;
import viaversion.viaversion.api.rewriters.TagRewriter$2;
import viaversion.viaversion.api.rewriters.TagRewriter$TagData;
import viaversion.viaversion.api.type.Type;

public class TagRewriter {
   private static final int[] EMPTY_ARRAY = new int[0];
   private final Protocol protocol;
   private final IdRewriteFunction entityRewriter;
   private final List newBlockTags = new ArrayList();
   private final List newItemTags = new ArrayList();
   private final List newEntityTags = new ArrayList();

   public TagRewriter(Protocol var1, @Nullable IdRewriteFunction var2) {
      this.protocol = var1;
      this.entityRewriter = var2;
   }

   public void addEmptyTag(RegistryType var1, String var2) {
      this.getNewTags(var1).add(new TagRewriter$TagData(var2, EMPTY_ARRAY, (TagRewriter$1)null));
   }

   public void addEmptyTags(RegistryType var1, String... var2) {
      MetadataRewriter.c();
      List var4 = this.getNewTags(var1);
      int var6 = var2.length;
      int var7 = 0;
      if(var7 < var6) {
         String var8 = var2[var7];
         var4.add(new TagRewriter$TagData(var8, EMPTY_ARRAY, (TagRewriter$1)null));
         ++var7;
      }

   }

   public void addTag(RegistryType var1, String var2, int... var3) {
      MetadataRewriter.e();
      List var5 = this.getNewTags(var1);
      IdRewriteFunction var6 = this.getRewriter(var1);
      int var7 = 0;
      if(var7 < var3.length) {
         int var8 = var3[var7];
         var3[var7] = var6.rewrite(var8);
         ++var7;
      }

      var5.add(new TagRewriter$TagData(var2, var3, (TagRewriter$1)null));
   }

   public void register(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new TagRewriter$1(this));
   }

   private void handle(PacketWrapper var1, IdRewriteFunction var2, List var3) throws Exception {
      MetadataRewriter.c();
      int var5 = ((Integer)var1.read(Type.VAR_INT)).intValue();
      var1.write(Type.VAR_INT, Integer.valueOf(var5 + var3.size()));
      int var6 = 0;
      if(var6 < var5) {
         var1.passthrough(Type.STRING);
         int[] var7 = (int[])var1.read(Type.VAR_INT_ARRAY_PRIMITIVE);
         IntArrayList var8 = new IntArrayList(var7.length);
         int var10 = var7.length;
         int var11 = 0;
         if(var11 < var10) {
            int var12 = var7[var11];
            int var13 = var2.rewrite(var12);
            if(var13 != -1) {
               var8.add(var13);
            }

            ++var11;
         }

         var1.write(Type.VAR_INT_ARRAY_PRIMITIVE, var8.toArray(EMPTY_ARRAY));
         var1.write(Type.VAR_INT_ARRAY_PRIMITIVE, var7);
         ++var6;
      }

      if(var3 != null && !var3.isEmpty()) {
         Iterator var15 = var3.iterator();
         if(var15.hasNext()) {
            TagRewriter$TagData var16 = (TagRewriter$TagData)var15.next();
            var1.write(Type.STRING, TagRewriter$TagData.access$700(var16));
            var1.write(Type.VAR_INT_ARRAY_PRIMITIVE, TagRewriter$TagData.access$800(var16));
         }
      }

   }

   private List getNewTags(RegistryType var1) {
      switch(TagRewriter$2.$SwitchMap$viaversion$viaversion$api$rewriters$RegistryType[var1.ordinal()]) {
      case 1:
         return this.newBlockTags;
      case 2:
         return this.newItemTags;
      case 3:
         return this.newEntityTags;
      case 4:
      default:
         return null;
      }
   }

   @Nullable
   private IdRewriteFunction getRewriter(RegistryType var1) {
      boolean var2 = MetadataRewriter.e();
      switch(TagRewriter$2.$SwitchMap$viaversion$viaversion$api$rewriters$RegistryType[var1.ordinal()]) {
      case 1:
         return this.protocol.getMappingData().getBlockMappings() != null?this::lambda$getRewriter$0:null;
      case 2:
         return this.protocol.getMappingData().getItemMappings() != null?this::lambda$getRewriter$1:null;
      case 3:
         return this.entityRewriter;
      case 4:
      default:
         return null;
      }
   }

   private int lambda$getRewriter$1(int var1) {
      return this.protocol.getMappingData().getNewItemId(var1);
   }

   private int lambda$getRewriter$0(int var1) {
      return this.protocol.getMappingData().getNewBlockId(var1);
   }

   static Protocol access$100(TagRewriter var0) {
      return var0.protocol;
   }

   static List access$200(TagRewriter var0) {
      return var0.newBlockTags;
   }

   static void access$300(TagRewriter var0, PacketWrapper var1, IdRewriteFunction var2, List var3) throws Exception {
      var0.handle(var1, var2, var3);
   }

   static List access$400(TagRewriter var0) {
      return var0.newItemTags;
   }

   static IdRewriteFunction access$500(TagRewriter var0) {
      return var0.entityRewriter;
   }

   static List access$600(TagRewriter var0) {
      return var0.newEntityTags;
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
