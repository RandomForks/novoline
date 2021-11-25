package viaversion.viafabric.util;

import viaversion.viafabric.util.JLoggerToLog4j;
import viaversion.viaversion.api.protocol.ProtocolVersion;

public class ProtocolUtils {
   public static String getProtocolName(int var0) {
      boolean var1 = JLoggerToLog4j.c();
      return !ProtocolVersion.isRegistered(var0)?Integer.toString(var0):ProtocolVersion.getProtocol(var0).getName();
   }
}
