package viaversion.viaversion.api.rewriters;

import viaversion.viaversion.api.rewriters.TagRewriter$1;

final class TagRewriter$TagData {
   private final String identifier;
   private final int[] entries;

   private TagRewriter$TagData(String var1, int[] var2) {
      this.identifier = var1;
      this.entries = var2;
   }

   TagRewriter$TagData(String var1, int[] var2, TagRewriter$1 var3) {
      this(var1, var2);
   }

   static String access$700(TagRewriter$TagData var0) {
      return var0.identifier;
   }

   static int[] access$800(TagRewriter$TagData var0) {
      return var0.entries;
   }
}
