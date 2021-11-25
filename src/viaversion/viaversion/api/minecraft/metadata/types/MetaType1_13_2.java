package viaversion.viaversion.api.minecraft.metadata.types;

import viaversion.viaversion.api.minecraft.metadata.MetaType;
import viaversion.viaversion.api.type.Type;
import viaversion.viaversion.api.type.types.version.Types1_13_2;

public enum MetaType1_13_2 implements MetaType {
   Byte(0, Type.BYTE),
   VarInt(1, Type.VAR_INT),
   Float(2, Type.FLOAT),
   String(3, Type.STRING),
   Chat(4, Type.COMPONENT),
   OptChat(5, Type.OPTIONAL_COMPONENT),
   Slot(6, Type.FLAT_VAR_INT_ITEM),
   Boolean(7, Type.BOOLEAN),
   Vector3F(8, Type.ROTATION),
   Position(9, Type.POSITION),
   OptPosition(10, Type.OPTIONAL_POSITION),
   Direction(11, Type.VAR_INT),
   OptUUID(12, Type.OPTIONAL_UUID),
   BlockID(13, Type.VAR_INT),
   NBTTag(14, Type.NBT),
   PARTICLE(15, Types1_13_2.PARTICLE),
   Discontinued(99, (Type)null);

   private final int typeID;
   private final Type type;

   private MetaType1_13_2(int var3, Type var4) {
      this.typeID = var3;
      this.type = var4;
   }

   public static MetaType1_13_2 byId(int var0) {
      return values()[var0];
   }

   public int getTypeID() {
      return this.typeID;
   }

   public Type getType() {
      return this.type;
   }
}
