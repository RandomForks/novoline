package viaversion.viaversion.api.minecraft.metadata.types;

import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.type.Type;

public enum MetaType1_12 implements MetaType {
   Byte(0, Type.BYTE),
   VarInt(1, Type.VAR_INT),
   Float(2, Type.FLOAT),
   String(3, Type.STRING),
   Chat(4, Type.COMPONENT),
   Slot(5, Type.ITEM),
   Boolean(6, Type.BOOLEAN),
   Vector3F(7, Type.ROTATION),
   Position(8, Type.POSITION),
   OptPosition(9, Type.OPTIONAL_POSITION),
   Direction(10, Type.VAR_INT),
   OptUUID(11, Type.OPTIONAL_UUID),
   BlockID(12, Type.VAR_INT),
   NBTTag(13, Type.NBT),
   Discontinued(99, (Type)null);

   private final int typeID;
   private final Type type;

   private MetaType1_12(int var3, Type var4) {
      this.typeID = var3;
      this.type = var4;
   }

   public static MetaType1_12 byId(int var0) {
      return values()[var0];
   }

   public int getTypeID() {
      return this.typeID;
   }

   public Type getType() {
      return this.type;
   }
}
