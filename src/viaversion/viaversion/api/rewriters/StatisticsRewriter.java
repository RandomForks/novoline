package viaversion.viaversion.api.rewriters;

import net.a76;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.protocol.ClientboundPacketType;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.rewriters.IdRewriteFunction;
import viaversion.viaversion.api.rewriters.MetadataRewriter;
import viaversion.viaversion.api.rewriters.RegistryType;
import viaversion.viaversion.api.rewriters.StatisticsRewriter$2;

public class StatisticsRewriter {
   private final Protocol protocol;
   private final IdRewriteFunction entityRewriter;
   private final int customStatsCategory = 8;

   public StatisticsRewriter(Protocol var1, @Nullable IdRewriteFunction var2) {
      this.protocol = var1;
      this.entityRewriter = var2;
   }

   public void register(ClientboundPacketType var1) {
      this.protocol.a((ClientboundPacketType)var1, new a76(this));
   }

   @Nullable
   protected IdRewriteFunction getRewriter(RegistryType var1) {
      boolean var2 = MetadataRewriter.e();
      switch(StatisticsRewriter$2.$SwitchMap$viaversion$viaversion$api$rewriters$RegistryType[var1.ordinal()]) {
      case 1:
         return this.protocol.getMappingData().getBlockMappings() != null?this::lambda$getRewriter$0:null;
      case 2:
         return this.protocol.getMappingData().getItemMappings() != null?this::lambda$getRewriter$1:null;
      case 3:
         return this.entityRewriter;
      default:
         throw new IllegalArgumentException("Unknown registry type in statistics packet: " + var1);
      }
   }

   @Nullable
   public RegistryType getRegistryTypeForStatistic(int var1) {
      switch(var1) {
      case 0:
         return RegistryType.BLOCK;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
         return RegistryType.ITEM;
      case 6:
      case 7:
         return RegistryType.ENTITY;
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

   static Protocol access$000(StatisticsRewriter var0) {
      return var0.protocol;
   }

   private static IllegalArgumentException a(IllegalArgumentException var0) {
      return var0;
   }
}
