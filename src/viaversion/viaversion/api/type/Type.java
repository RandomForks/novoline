package viaversion.viaversion.api.type;

import net.a26;
import net.acE;
import viaversion.viaversion.api.type.ByteBufReader;
import viaversion.viaversion.api.type.ByteBufWriter;
import viaversion.viaversion.api.type.types.ArrayType;
import viaversion.viaversion.api.type.types.BooleanType;
import viaversion.viaversion.api.type.types.ByteArrayType;
import viaversion.viaversion.api.type.types.ByteType;
import viaversion.viaversion.api.type.types.ComponentType;
import viaversion.viaversion.api.type.types.DoubleType;
import viaversion.viaversion.api.type.types.FloatType;
import viaversion.viaversion.api.type.types.IntType;
import viaversion.viaversion.api.type.types.LongType;
import viaversion.viaversion.api.type.types.RemainingBytesType;
import viaversion.viaversion.api.type.types.ShortType;
import viaversion.viaversion.api.type.types.StringType;
import viaversion.viaversion.api.type.types.UUIDIntArrayType;
import viaversion.viaversion.api.type.types.UUIDType;
import viaversion.viaversion.api.type.types.UnsignedByteType;
import viaversion.viaversion.api.type.types.UnsignedShortType;
import viaversion.viaversion.api.type.types.VarIntArrayType;
import viaversion.viaversion.api.type.types.VarIntType;
import viaversion.viaversion.api.type.types.VarLongType;
import viaversion.viaversion.api.type.types.VoidType;
import viaversion.viaversion.api.type.types.minecraft.BlockChangeRecordType;
import viaversion.viaversion.api.type.types.minecraft.EulerAngleType;
import viaversion.viaversion.api.type.types.minecraft.FlatItemArrayType;
import viaversion.viaversion.api.type.types.minecraft.FlatItemType;
import viaversion.viaversion.api.type.types.minecraft.FlatVarIntItemArrayType;
import viaversion.viaversion.api.type.types.minecraft.FlatVarIntItemType;
import viaversion.viaversion.api.type.types.minecraft.ItemArrayType;
import viaversion.viaversion.api.type.types.minecraft.ItemType;
import viaversion.viaversion.api.type.types.minecraft.NBTType;
import viaversion.viaversion.api.type.types.minecraft.OptPosition1_14Type;
import viaversion.viaversion.api.type.types.minecraft.OptPositionType;
import viaversion.viaversion.api.type.types.minecraft.OptUUIDType;
import viaversion.viaversion.api.type.types.minecraft.OptionalComponentType;
import viaversion.viaversion.api.type.types.minecraft.OptionalVarIntType;
import viaversion.viaversion.api.type.types.minecraft.Position1_14Type;
import viaversion.viaversion.api.type.types.minecraft.PositionType;
import viaversion.viaversion.api.type.types.minecraft.VarLongBlockChangeRecordType;
import viaversion.viaversion.api.type.types.minecraft.VectorType;
import viaversion.viaversion.api.type.types.minecraft.VillagerDataType;

public abstract class Type implements ByteBufReader, ByteBufWriter {
   public static final Type BYTE;
   /** @deprecated */
   @Deprecated
   public static final Type BYTE_ARRAY;
   public static final Type BYTE_ARRAY_PRIMITIVE;
   public static final Type REMAINING_BYTES;
   public static final Type UNSIGNED_BYTE;
   /** @deprecated */
   @Deprecated
   public static final Type UNSIGNED_BYTE_ARRAY;
   public static final Type BOOLEAN;
   /** @deprecated */
   @Deprecated
   public static final Type BOOLEAN_ARRAY;
   public static final Type INT;
   /** @deprecated */
   @Deprecated
   public static final Type INT_ARRAY;
   public static final Type DOUBLE;
   /** @deprecated */
   @Deprecated
   public static final Type DOUBLE_ARRAY;
   public static final Type LONG;
   /** @deprecated */
   @Deprecated
   public static final Type LONG_ARRAY;
   public static final FloatType FLOAT;
   /** @deprecated */
   @Deprecated
   public static final Type FLOAT_ARRAY;
   public static final ShortType SHORT;
   /** @deprecated */
   @Deprecated
   public static final Type SHORT_ARRAY;
   public static final Type UNSIGNED_SHORT;
   /** @deprecated */
   @Deprecated
   public static final Type UNSIGNED_SHORT_ARRAY;
   public static final Type COMPONENT;
   public static final Type STRING;
   public static final Type STRING_ARRAY;
   public static final Type UUID;
   public static final Type UUID_INT_ARRAY;
   public static final Type UUID_ARRAY;
   public static final VarIntType VAR_INT;
   /** @deprecated */
   @Deprecated
   public static final Type VAR_INT_ARRAY;
   public static final Type VAR_INT_ARRAY_PRIMITIVE;
   public static final Type OPTIONAL_VAR_INT;
   public static final VarLongType VAR_LONG;
   /** @deprecated */
   @Deprecated
   public static final Type VAR_LONG_ARRAY;
   public static final Type NOTHING;
   public static final Type POSITION;
   public static final Type POSITION1_14;
   public static final Type ROTATION;
   public static final Type VECTOR;
   public static final Type NBT;
   public static final Type NBT_ARRAY;
   public static final Type OPTIONAL_UUID;
   public static final Type OPTIONAL_COMPONENT;
   public static final Type OPTIONAL_POSITION;
   public static final Type OPTIONAL_POSITION_1_14;
   public static final Type ITEM;
   public static final Type ITEM_ARRAY;
   public static final Type BLOCK_CHANGE_RECORD;
   public static final Type BLOCK_CHANGE_RECORD_ARRAY;
   public static final Type VAR_LONG_BLOCK_CHANGE_RECORD;
   public static final Type VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY;
   public static final Type VILLAGER_DATA;
   public static final Type FLAT_ITEM;
   public static final Type FLAT_VAR_INT_ITEM;
   public static final Type FLAT_ITEM_ARRAY;
   public static final Type FLAT_VAR_INT_ITEM_ARRAY;
   public static final Type FLAT_ITEM_ARRAY_VAR_INT;
   public static final Type FLAT_VAR_INT_ITEM_ARRAY_VAR_INT;
   private final Class outputClass;
   private final String typeName;
   private static acE[] N;

   public Type(String var1, Class var2) {
      this.outputClass = var2;
      this.typeName = var1;
   }

   public Class getOutputClass() {
      return this.outputClass;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Class getBaseClass() {
      return this.getClass();
   }

   public String toString() {
      acE[] var1 = a26.b();
      String var10000 = "Type|" + this.typeName;
      if(acE.b() == null) {
         a26.b(new acE[5]);
      }

      return var10000;
   }

   static {
      if(b() != null) {
         b(new acE[4]);
      }

      BYTE = new ByteType();
      BYTE_ARRAY = new ArrayType(BYTE);
      BYTE_ARRAY_PRIMITIVE = new ByteArrayType();
      REMAINING_BYTES = new RemainingBytesType();
      UNSIGNED_BYTE = new UnsignedByteType();
      UNSIGNED_BYTE_ARRAY = new ArrayType(UNSIGNED_BYTE);
      BOOLEAN = new BooleanType();
      BOOLEAN_ARRAY = new ArrayType(BOOLEAN);
      INT = new IntType();
      INT_ARRAY = new ArrayType(INT);
      DOUBLE = new DoubleType();
      DOUBLE_ARRAY = new ArrayType(DOUBLE);
      LONG = new LongType();
      LONG_ARRAY = new ArrayType(LONG);
      FLOAT = new FloatType();
      FLOAT_ARRAY = new ArrayType(FLOAT);
      SHORT = new ShortType();
      SHORT_ARRAY = new ArrayType(SHORT);
      UNSIGNED_SHORT = new UnsignedShortType();
      UNSIGNED_SHORT_ARRAY = new ArrayType(UNSIGNED_SHORT);
      COMPONENT = new ComponentType();
      STRING = new StringType();
      STRING_ARRAY = new ArrayType(STRING);
      UUID = new UUIDType();
      UUID_INT_ARRAY = new UUIDIntArrayType();
      UUID_ARRAY = new ArrayType(UUID);
      VAR_INT = new VarIntType();
      VAR_INT_ARRAY = new ArrayType(VAR_INT);
      VAR_INT_ARRAY_PRIMITIVE = new VarIntArrayType();
      OPTIONAL_VAR_INT = new OptionalVarIntType();
      VAR_LONG = new VarLongType();
      VAR_LONG_ARRAY = new ArrayType(VAR_LONG);
      NOTHING = new VoidType();
      POSITION = new PositionType();
      POSITION1_14 = new Position1_14Type();
      ROTATION = new EulerAngleType();
      VECTOR = new VectorType();
      NBT = new NBTType();
      NBT_ARRAY = new ArrayType(NBT);
      OPTIONAL_UUID = new OptUUIDType();
      OPTIONAL_COMPONENT = new OptionalComponentType();
      OPTIONAL_POSITION = new OptPositionType();
      OPTIONAL_POSITION_1_14 = new OptPosition1_14Type();
      ITEM = new ItemType();
      ITEM_ARRAY = new ItemArrayType();
      BLOCK_CHANGE_RECORD = new BlockChangeRecordType();
      BLOCK_CHANGE_RECORD_ARRAY = new ArrayType(BLOCK_CHANGE_RECORD);
      VAR_LONG_BLOCK_CHANGE_RECORD = new VarLongBlockChangeRecordType();
      VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY = new ArrayType(VAR_LONG_BLOCK_CHANGE_RECORD);
      VILLAGER_DATA = new VillagerDataType();
      FLAT_ITEM = new FlatItemType();
      FLAT_VAR_INT_ITEM = new FlatVarIntItemType();
      FLAT_ITEM_ARRAY = new FlatItemArrayType();
      FLAT_VAR_INT_ITEM_ARRAY = new FlatVarIntItemArrayType();
      FLAT_ITEM_ARRAY_VAR_INT = new ArrayType(FLAT_ITEM);
      FLAT_VAR_INT_ITEM_ARRAY_VAR_INT = new ArrayType(FLAT_VAR_INT_ITEM);
   }

   public static void b(acE[] var0) {
      N = var0;
   }

   public static acE[] b() {
      return N;
   }
}
