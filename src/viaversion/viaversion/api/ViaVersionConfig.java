package viaversion.viaversion.api;

import it.unimi.dsi.fastutil.ints.IntSet;

public interface ViaVersionConfig {
   boolean isCheckForUpdates();

   void setCheckForUpdates(boolean var1);

   boolean isPreventCollision();

   boolean isNewEffectIndicator();

   boolean isShowNewDeathMessages();

   boolean isSuppressMetadataErrors();

   boolean isShieldBlocking();

   boolean isHologramPatch();

   boolean isPistonAnimationPatch();

   boolean isBossbarPatch();

   boolean isBossbarAntiflicker();

   double getHologramYOffset();

   boolean isAutoTeam();

   int getMaxPPS();

   String getMaxPPSKickMessage();

   int getTrackingPeriod();

   int getWarningPPS();

   int getMaxWarnings();

   String getMaxWarningsKickMessage();

   boolean w();

   boolean isSendSupportedVersions();

   boolean isSimulatePlayerTick();

   boolean isItemCache();

   boolean isNMSPlayerTicking();

   boolean isReplacePistons();

   int getPistonReplacementId();

   boolean isForceJsonTransform();

   boolean is1_12NBTArrayFix();

   boolean is1_13TeamColourFix();

   boolean is1_12QuickMoveActionFix();

   IntSet getBlockedProtocols();

   String getBlockedDisconnectMsg();

   String getReloadDisconnectMsg();

   boolean isSuppressConversionWarnings();

   boolean isDisable1_13AutoComplete();

   boolean isMinimizeCooldown();

   boolean isServersideBlockConnections();

   String getBlockConnectionMethod();

   boolean isReduceBlockStorageMemory();

   boolean isStemWhenBlockAbove();

   boolean isVineClimbFix();

   boolean isSnowCollisionFix();

   boolean isInfestedBlocksFix();

   int get1_13TabCompleteDelay();

   boolean isTruncate1_14Books();

   boolean isLeftHandedHandling();

   boolean q();

   boolean L();

   boolean isNonFullBlockLightFix();

   boolean is1_14HealthNaNFix();

   boolean is1_15InstantRespawn();

   boolean isIgnoreLong1_16ChannelNames();
}
