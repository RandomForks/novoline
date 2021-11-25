package viaversion.viaversion.api.remapper;

import viaversion.viaversion.api.PacketWrapper;

@FunctionalInterface
public interface ValueWriter {
   void write(PacketWrapper var1, Object var2) throws Exception;
}
