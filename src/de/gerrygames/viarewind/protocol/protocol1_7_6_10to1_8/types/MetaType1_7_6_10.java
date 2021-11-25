package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.minecraft.metadata.MetaType;
import com.viaversion.viaversion.api.type.Type;
import net.axZ;

public enum MetaType1_7_6_10 implements MetaType {
   Byte(0, Type.k),
   Short(1, Type.SHORT),
   Int(2, Type.I),
   Float(3, Type.FLOAT),
   String(4, Type.STRING),
   Slot(5, axZ.c),
   Position(6, Type.VECTOR),
   NonExistent(-1, Type.af);

   private final int typeID;
   private final Type type;

   public static MetaType1_7_6_10 byId(int var0) {
      return values()[var0];
   }

   private MetaType1_7_6_10(int var3, Type var4) {
      this.typeID = var3;
      this.type = var4;
   }

   public int typeId() {
      return this.typeID;
   }

   public Type type() {
      return this.type;
   }
}
