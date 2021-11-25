package viaversion.viabackwards.api.entities.storage;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.cQ;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.minecraft.metadata.Metadata;

public class MetaStorage {
   private List metaDataList;

   public MetaStorage(List var1) {
      this.metaDataList = var1;
   }

   public boolean has(Metadata var1) {
      return this.metaDataList.contains(var1);
   }

   public void delete(Metadata var1) {
      this.metaDataList.remove(var1);
   }

   public void delete(int var1) {
      this.metaDataList.removeIf(MetaStorage::lambda$delete$0);
   }

   public void add(Metadata var1) {
      this.metaDataList.add(var1);
   }

   @Nullable
   public Metadata get(int var1) {
      cQ.d();
      Iterator var3 = this.metaDataList.iterator();
      if(var3.hasNext()) {
         Metadata var4 = (Metadata)var3.next();
         if(var1 == var4.getId()) {
            return var4;
         }
      }

      return null;
   }

   public Metadata getOrDefault(int var1, Metadata var2) {
      return this.getOrDefault(var1, false, var2);
   }

   public Metadata getOrDefault(int var1, boolean var2, Metadata var3) {
      cQ.a();
      Metadata var5 = this.get(var1);
      if(var5 != null) {
         this.delete(var5);
      }

      return var5 != null?var5:var3;
   }

   public List getMetaDataList() {
      return this.metaDataList;
   }

   public void setMetaDataList(List var1) {
      this.metaDataList = var1;
   }

   public String toString() {
      return "MetaStorage{metaDataList=" + this.metaDataList + '}';
   }

   private static boolean lambda$delete$0(int var0, Metadata var1) {
      boolean var2 = cQ.a();
      return var1.getId() == var0;
   }
}
