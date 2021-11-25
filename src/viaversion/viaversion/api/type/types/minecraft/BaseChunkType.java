package viaversion.viaversion.api.type.types.minecraft;

import viaversion.viaversion.api.minecraft.chunks.Chunk;
import viaversion.viaversion.api.type.Type;

public abstract class BaseChunkType extends Type {
   public BaseChunkType() {
      super("Chunk", Chunk.class);
   }

   public BaseChunkType(String var1) {
      super(var1, Chunk.class);
   }

   public Class getBaseClass() {
      return BaseChunkType.class;
   }
}
