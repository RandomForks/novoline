package viaversion.viaversion.api.protocol;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import net.aR0;
import net.aR1;
import net.aR2;
import net.aR3;
import net.aRG;
import net.aRI;
import net.aRL;
import net.aRN;
import net.aRU;
import net.aRX;
import net.aRY;
import net.aRb;
import net.aRe;
import net.aRh;
import net.aRp;
import net.aRq;
import net.aRr;
import net.aRw;
import net.aRy;
import net.acE;
import org.jetbrains.annotations.Nullable;
import viaversion.viaversion.api.Pair;
import viaversion.viaversion.api.Via;
import viaversion.viaversion.api.data.MappingDataLoader;
import viaversion.viaversion.api.protocol.Protocol;
import viaversion.viaversion.api.protocol.ProtocolVersion;
import viaversion.viaversion.protocols.base.BaseProtocol;
import viaversion.viaversion.protocols.base.BaseProtocol1_16;
import viaversion.viaversion.protocols.base.BaseProtocol1_7;
import viaversion.viaversion.protocols.protocol1_10to1_9_3.Protocol1_10To1_9_3_4;
import viaversion.viaversion.protocols.protocol1_11to1_10.Protocol1_11To1_10;
import viaversion.viaversion.protocols.protocol1_12_1to1_12.Protocol1_12_1To1_12;
import viaversion.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import viaversion.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import viaversion.viaversion.protocols.protocol1_15to1_14_4.Protocol1_15To1_14_4;
import viaversion.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;
import viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.Protocol1_9_3To1_9_1_2;

public class ProtocolRegistry {
   public static final Protocol BASE_PROTOCOL = new BaseProtocol();
   public static int SERVER_PROTOCOL = -1;
   public static int maxProtocolPathSize = 50;
   private static final Int2ObjectMap registryMap = new Int2ObjectOpenHashMap(32);
   private static final Map protocols = new HashMap();
   private static final Map pathCache = new ConcurrentHashMap();
   private static final Set supportedVersions = new HashSet();
   private static final List baseProtocols = Lists.newCopyOnWriteArrayList();
   private static final List registerList = new ArrayList();
   private static final Object MAPPING_LOADER_LOCK = new Object();
   private static Map mappingLoaderFutures = new HashMap();
   private static ThreadPoolExecutor mappingLoaderExecutor;
   private static boolean mappingsLoaded;

   public static void init() {
   }

   public static void registerProtocol(Protocol var0, ProtocolVersion var1, ProtocolVersion var2) {
      registerProtocol(var0, Collections.singletonList(Integer.valueOf(var1.getVersion())), var2.getVersion());
   }

   public static void registerProtocol(Protocol var0, List var1, int var2) {
      if(!pathCache.isEmpty()) {
         pathCache.clear();
      }

      protocols.put(var0.getClass(), var0);
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         int var4 = ((Integer)var3.next()).intValue();
         Int2ObjectMap var5 = (Int2ObjectMap)registryMap.computeIfAbsent(var4, ProtocolRegistry::lambda$registerProtocol$0);
         var5.put(var2, var0);
      }

      if(Via.getPlatform().isPluginEnabled()) {
         var0.a(Via.getManager().f());
         refreshVersions();
      } else {
         registerList.add(var0);
      }

      if(var0.hasMappingDataToLoad()) {
         if(mappingLoaderExecutor != null) {
            addMappingLoaderFuture(var0.getClass(), var0::loadMappingData);
         } else {
            var0.loadMappingData();
         }
      }

   }

   public static void registerBaseProtocol(Protocol var0, Range var1) {
      baseProtocols.add(new Pair(var1, var0));
      if(Via.getPlatform().isPluginEnabled()) {
         var0.a(Via.getManager().f());
         refreshVersions();
      } else {
         registerList.add(var0);
      }

   }

   public static void refreshVersions() {
      supportedVersions.clear();
      supportedVersions.add(Integer.valueOf(SERVER_PROTOCOL));

      for(ProtocolVersion var1 : ProtocolVersion.getProtocols()) {
         List var2 = getProtocolPath(var1.getVersion(), SERVER_PROTOCOL);
      }

   }

   public static SortedSet getSupportedVersions() {
      return Collections.unmodifiableSortedSet(new TreeSet(supportedVersions));
   }

   public static boolean isWorkingPipe() {
      Protocol.h();
      ObjectIterator var1 = registryMap.values().iterator();
      if(var1.hasNext()) {
         Int2ObjectMap var2 = (Int2ObjectMap)var1.next();
         if(var2.containsKey(SERVER_PROTOCOL)) {
            return true;
         }
      }

      return false;
   }

   public static void onServerLoaded() {
      Protocol.h();
      Iterator var1 = registerList.iterator();
      if(var1.hasNext()) {
         Protocol var2 = (Protocol)var1.next();
         var2.a(Via.getManager().f());
      }

      registerList.clear();
   }

   @Nullable
   private static List a(List var0, int var1, int var2) {
      if(var1 == var2) {
         return null;
      } else if(var0.size() > maxProtocolPathSize) {
         return null;
      } else {
         Int2ObjectMap var3 = (Int2ObjectMap)registryMap.get(var1);
         return null;
      }
   }

   @Nullable
   public static List getProtocolPath(int var0, int var1) {
      Pair var2 = new Pair(Integer.valueOf(var0), Integer.valueOf(var1));
      List var3 = (List)pathCache.get(var2);
      return var3;
   }

   @Nullable
   public static Protocol getProtocol(Class var0) {
      return (Protocol)protocols.get(var0);
   }

   public static Protocol getBaseProtocol(int var0) {
      Protocol.h();
      Iterator var2 = Lists.reverse(baseProtocols).iterator();
      if(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         if(((Range)var3.getKey()).contains(Integer.valueOf(var0))) {
            return (Protocol)var3.getValue();
         }
      }

      throw new IllegalStateException("No Base Protocol for " + var0);
   }

   public static boolean isBaseProtocol(Protocol var0) {
      Protocol.h();
      Iterator var2 = baseProtocols.iterator();
      if(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         if(var3.getValue() == var0) {
            return true;
         }
      }

      return false;
   }

   public static void completeMappingDataLoading(Class var0) throws Exception {
      acE[] var1 = Protocol.h();
      if(!mappingsLoaded) {
         CompletableFuture var2 = getMappingLoaderFuture(var0);
         if(var2 != null) {
            var2.get();
         }
      }
   }

   public static boolean checkForMappingCompletion() {
      // $FF: Couldn't be decompiled
   }

   private static void shutdownLoaderExecutor() {
      Via.getPlatform().getLogger().info("Finished mapping loading, shutting down loader executor!");
      mappingsLoaded = true;
      mappingLoaderExecutor.shutdown();
      Protocol.h();
      mappingLoaderExecutor = null;
      mappingLoaderFutures.clear();
      mappingLoaderFutures = null;
      if(MappingDataLoader.isCacheJsonMappings()) {
         MappingDataLoader.getMappingsCache().clear();
      }

   }

   public static void addMappingLoaderFuture(Class param0, Runnable param1) {
      // $FF: Couldn't be decompiled
   }

   public static void addMappingLoaderFuture(Class param0, Class param1, Runnable param2) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public static CompletableFuture getMappingLoaderFuture(Class param0) {
      // $FF: Couldn't be decompiled
   }

   private static Void lambda$addMappingLoaderFuture$3(Class var0, Throwable var1) {
      Via.getPlatform().getLogger().severe("Error during mapping loading of " + var0.getCanonicalName());
      var1.printStackTrace();
      return null;
   }

   private static void lambda$addMappingLoaderFuture$2(Runnable var0, Void var1, Throwable var2) {
      var0.run();
   }

   private static Void lambda$addMappingLoaderFuture$1(Class var0, Throwable var1) {
      Via.getPlatform().getLogger().severe("Error during mapping loading of " + var0.getCanonicalName());
      var1.printStackTrace();
      return null;
   }

   private static Int2ObjectMap lambda$registerProtocol$0(int var0) {
      return new Int2ObjectOpenHashMap(2);
   }

   static {
      ThreadFactory var7 = (new ThreadFactoryBuilder()).setNameFormat("Via-Mappingloader-%d").build();
      mappingLoaderExecutor = new ThreadPoolExecutor(5, 16, 45L, TimeUnit.SECONDS, new SynchronousQueue(), var7);
      mappingLoaderExecutor.allowCoreThreadTimeOut(true);
      registerBaseProtocol(BASE_PROTOCOL, Range.lessThan(Integer.valueOf(Integer.MIN_VALUE)));
      registerBaseProtocol(new BaseProtocol1_7(), Range.lessThan(Integer.valueOf(ProtocolVersion.v1_16.getVersion())));
      registerBaseProtocol(new BaseProtocol1_16(), Range.atLeast(Integer.valueOf(ProtocolVersion.v1_16.getVersion())));
      registerProtocol(new aRY(), ProtocolVersion.v1_9, ProtocolVersion.v1_8);
      registerProtocol(new aRy(), Arrays.asList(new Integer[]{Integer.valueOf(ProtocolVersion.v1_9_1.getVersion()), Integer.valueOf(ProtocolVersion.v1_9_2.getVersion())}), ProtocolVersion.v1_9.getVersion());
      registerProtocol(new Protocol1_9_3To1_9_1_2(), ProtocolVersion.v1_9_3, ProtocolVersion.v1_9_2);
      registerProtocol(new aR2(), ProtocolVersion.v1_9, ProtocolVersion.v1_9_2);
      registerProtocol(new aR0(), Arrays.asList(new Integer[]{Integer.valueOf(ProtocolVersion.v1_9_1.getVersion()), Integer.valueOf(ProtocolVersion.v1_9_2.getVersion())}), ProtocolVersion.v1_9_3.getVersion());
      registerProtocol(new Protocol1_10To1_9_3_4(), ProtocolVersion.v1_10, ProtocolVersion.v1_9_3);
      registerProtocol(new Protocol1_11To1_10(), ProtocolVersion.v1_11, ProtocolVersion.v1_10);
      registerProtocol(new aR3(), ProtocolVersion.v1_11_1, ProtocolVersion.v1_11);
      registerProtocol(new aRp(), ProtocolVersion.v1_12, ProtocolVersion.v1_11_1);
      registerProtocol(new Protocol1_12_1To1_12(), ProtocolVersion.v1_12_1, ProtocolVersion.v1_12);
      registerProtocol(new aRr(), ProtocolVersion.v1_12_2, ProtocolVersion.v1_12_1);
      registerProtocol(new Protocol1_13To1_12_2(), ProtocolVersion.v1_13, ProtocolVersion.v1_12_2);
      registerProtocol(new aRw(), ProtocolVersion.v1_13_1, ProtocolVersion.v1_13);
      registerProtocol(new aRL(), ProtocolVersion.v1_13_2, ProtocolVersion.v1_13_1);
      registerProtocol(new Protocol1_14To1_13_2(), ProtocolVersion.v1_14, ProtocolVersion.v1_13_2);
      registerProtocol(new aRb(), ProtocolVersion.v1_14_1, ProtocolVersion.v1_14);
      registerProtocol(new aRN(), ProtocolVersion.v1_14_2, ProtocolVersion.v1_14_1);
      registerProtocol(new aRU(), ProtocolVersion.v1_14_3, ProtocolVersion.v1_14_2);
      registerProtocol(new aR1(), ProtocolVersion.v1_14_4, ProtocolVersion.v1_14_3);
      registerProtocol(new Protocol1_15To1_14_4(), ProtocolVersion.v1_15, ProtocolVersion.v1_14_4);
      registerProtocol(new aRq(), ProtocolVersion.v1_15_1, ProtocolVersion.v1_15);
      registerProtocol(new aRI(), ProtocolVersion.v1_15_2, ProtocolVersion.v1_15_1);
      registerProtocol(new Protocol1_16To1_15_2(), ProtocolVersion.v1_16, ProtocolVersion.v1_15_2);
      registerProtocol(new aRe(), ProtocolVersion.v1_16_1, ProtocolVersion.v1_16);
      registerProtocol(new aRX(), ProtocolVersion.v1_16_2, ProtocolVersion.v1_16_1);
      registerProtocol(new aRG(), ProtocolVersion.v1_16_3, ProtocolVersion.v1_16_2);
      registerProtocol(new aRh(), ProtocolVersion.v1_16_4, ProtocolVersion.v1_16_3);
   }

   private static Exception a(Exception var0) {
      return var0;
   }
}
