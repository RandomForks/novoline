package viaversion.viabackwards.api.data;

import net.dr;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Nullable;
import viaversion.viabackwards.api.data.MappedLegacyBlockItem$BlockEntityHandler;

public class MappedLegacyBlockItem {
   private final int id;
   private final short data;
   private final String name;
   private final dr e;
   private MappedLegacyBlockItem$BlockEntityHandler blockEntityHandler;

   public MappedLegacyBlockItem(int var1, short var2, @Nullable String var3, boolean var4) {
      this.id = var1;
      this.data = var2;
      this.name = ChatColor.RESET + var3;
      this.e = new dr(var1, var2);
   }

   public int getId() {
      return this.id;
   }

   public short getData() {
      return this.data;
   }

   public String getName() {
      return this.name;
   }

   public boolean isBlock() {
      return this.e != null;
   }

   public dr g() {
      return this.e;
   }

   public boolean hasBlockEntityHandler() {
      return this.blockEntityHandler != null;
   }

   @Nullable
   public MappedLegacyBlockItem$BlockEntityHandler getBlockEntityHandler() {
      return this.blockEntityHandler;
   }

   public void setBlockEntityHandler(@Nullable MappedLegacyBlockItem$BlockEntityHandler var1) {
      this.blockEntityHandler = var1;
   }
}
