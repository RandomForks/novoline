package viaversion.viaversion.api.remapper;

import viaversion.viaversion.api.PacketWrapper;

@FunctionalInterface
public interface ValueReader {
   Object read(PacketWrapper var1) throws Exception;
}
