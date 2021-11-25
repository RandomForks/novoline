package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

enum WorldBorder$Side {
   NORTH(0, -1),
   EAST(1, 0),
   SOUTH(0, 1),
   WEST(-1, 0);

   private int modX;
   private int modZ;
   private static final WorldBorder$Side[] $VALUES = new WorldBorder$Side[]{NORTH, EAST, SOUTH, WEST};

   private WorldBorder$Side(int var3, int var4) {
      this.modX = var3;
      this.modZ = var4;
   }

   static int access$000(WorldBorder$Side var0) {
      return var0.modX;
   }

   static int access$100(WorldBorder$Side var0) {
      return var0.modZ;
   }
}
