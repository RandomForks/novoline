package viaversion.viarewind.protocol.protocol1_7_6_10to1_8.types;

import net.axZ;
import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.type.Type;

public enum MetaType1_7_6_10 implements MetaType {
   Byte(0, Type.BYTE),
   Short(1, Type.SHORT),
   Int(2, Type.INT),
   Float(3, Type.FLOAT),
   String(4, Type.STRING),
   Slot(5, axZ.c),
   Position(6, Type.VECTOR),
   NonExistent(-1, Type.NOTHING);

   private final int typeID;
   private final Type type;

   public static MetaType1_7_6_10 byId(int var0) {
      return values()[var0];
   }

   private MetaType1_7_6_10(int var3, Type var4) {
      this.typeID = var3;
      this.type = var4;
   }

   public int getTypeID() {
      return this.typeID;
   }

   public Type getType() {
      return this.type;
   }
}
