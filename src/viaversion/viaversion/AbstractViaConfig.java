package viaversion.viaversion;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.io.File;
import viaversion.viaversion.ViaManager;
import viaversion.viaversion.api.ViaVersionConfig;
import viaversion.viaversion.util.Config;

public abstract class AbstractViaConfig extends Config implements ViaVersionConfig {
   private boolean checkForUpdates;
   private boolean preventCollision;
   private boolean useNewEffectIndicator;
   private boolean useNewDeathmessages;
   private boolean suppressMetadataErrors;
   private boolean shieldBlocking;
   private boolean hologramPatch;
   private boolean pistonAnimationPatch;
   private boolean bossbarPatch;
   private boolean bossbarAntiFlicker;
   private double hologramOffset;
   private int maxPPS;
   private String maxPPSKickMessage;
   private int trackingPeriod;
   private int warningPPS;
   private int maxPPSWarnings;
   private String maxPPSWarningsKickMessage;
   private boolean sendSupportedVersions;
   private boolean simulatePlayerTick;
   private boolean itemCache;
   private boolean nmsPlayerTicking;
   private boolean replacePistons;
   private int pistonReplacementId;
   private boolean autoTeam;
   private boolean forceJsonTransform;
   private boolean nbtArrayFix;
   private IntSet blockedProtocols;
   private String blockedDisconnectMessage;
   private String reloadDisconnectMessage;
   private boolean suppressConversionWarnings;
   private boolean disable1_13TabComplete;
   private boolean minimizeCooldown;
   private boolean teamColourFix;
   private boolean serversideBlockConnections;
   private boolean reduceBlockStorageMemory;
   private boolean flowerStemWhenBlockAbove;
   private boolean vineClimbFix;
   private boolean snowCollisionFix;
   private boolean infestedBlocksFix;
   private int tabCompleteDelay;
   private boolean truncate1_14Books;
   private boolean leftHandedHandling;
   private boolean fullBlockLightFix;
   private boolean healthNaNFix;
   private boolean instantRespawn;
   private boolean ignoreLongChannelNames;

   protected AbstractViaConfig(File var1) {
      super(var1);
   }

   public void reloadConfig() {
      super.reloadConfig();
      this.loadFields();
   }

   protected void loadFields() {
      this.checkForUpdates = this.getBoolean("checkforupdates", true);
      this.preventCollision = this.getBoolean("prevent-collision", true);
      this.useNewEffectIndicator = this.getBoolean("use-new-effect-indicator", true);
      this.useNewDeathmessages = this.getBoolean("use-new-deathmessages", true);
      this.suppressMetadataErrors = this.getBoolean("suppress-metadata-errors", false);
      this.shieldBlocking = this.getBoolean("shield-blocking", true);
      this.hologramPatch = this.getBoolean("hologram-patch", false);
      this.pistonAnimationPatch = this.getBoolean("piston-animation-patch", false);
      this.bossbarPatch = this.getBoolean("bossbar-patch", true);
      this.bossbarAntiFlicker = this.getBoolean("bossbar-anti-flicker", false);
      this.hologramOffset = this.getDouble("hologram-y", -0.96D);
      this.maxPPS = this.getInt("max-pps", 800);
      ViaManager.n();
      this.maxPPSKickMessage = this.getString("max-pps-kick-msg", "Sending packets too fast? lag?");
      this.trackingPeriod = this.getInt("tracking-period", 6);
      this.warningPPS = this.getInt("tracking-warning-pps", 120);
      this.maxPPSWarnings = this.getInt("tracking-max-warnings", 3);
      this.maxPPSWarningsKickMessage = this.getString("tracking-max-kick-msg", "You are sending too many packets, :(");
      this.sendSupportedVersions = this.getBoolean("send-supported-versions", false);
      this.simulatePlayerTick = this.getBoolean("simulate-pt", true);
      this.itemCache = this.getBoolean("item-cache", true);
      this.nmsPlayerTicking = this.getBoolean("nms-player-ticking", true);
      this.replacePistons = this.getBoolean("replace-pistons", false);
      this.pistonReplacementId = this.getInt("replacement-piston-id", 0);
      this.autoTeam = this.getBoolean("auto-team", true);
      this.forceJsonTransform = this.getBoolean("force-json-transform", false);
      this.nbtArrayFix = this.getBoolean("chat-nbt-fix", true);
      this.blockedProtocols = new IntOpenHashSet(this.getIntegerList("block-protocols"));
      this.blockedDisconnectMessage = this.getString("block-disconnect-msg", "You are using an unsupported Minecraft version!");
      this.reloadDisconnectMessage = this.getString("reload-disconnect-msg", "Server reload, please rejoin!");
      this.minimizeCooldown = this.getBoolean("minimize-cooldown", true);
      this.teamColourFix = this.getBoolean("team-colour-fix", true);
      this.suppressConversionWarnings = this.getBoolean("suppress-conversion-warnings", false);
      this.disable1_13TabComplete = this.getBoolean("disable-1_13-auto-complete", false);
      this.serversideBlockConnections = this.getBoolean("serverside-blockconnections", true);
      this.reduceBlockStorageMemory = this.getBoolean("reduce-blockstorage-memory", false);
      this.flowerStemWhenBlockAbove = this.getBoolean("flowerstem-when-block-above", false);
      this.vineClimbFix = this.getBoolean("vine-climb-fix", false);
      this.snowCollisionFix = this.getBoolean("fix-low-snow-collision", false);
      this.infestedBlocksFix = this.getBoolean("fix-infested-block-breaking", true);
      this.tabCompleteDelay = this.getInt("1_13-tab-complete-delay", 0);
      this.truncate1_14Books = this.getBoolean("truncate-1_14-books", false);
      this.leftHandedHandling = this.getBoolean("left-handed-handling", true);
      this.fullBlockLightFix = this.getBoolean("fix-non-full-blocklight", false);
      this.healthNaNFix = this.getBoolean("fix-1_14-health-nan", true);
      this.instantRespawn = this.getBoolean("use-1_15-instant-respawn", false);
      this.ignoreLongChannelNames = this.getBoolean("ignore-long-1_16-channel-names", true);
   }

   public boolean isCheckForUpdates() {
      return this.checkForUpdates;
   }

   public void setCheckForUpdates(boolean var1) {
      this.checkForUpdates = var1;
      this.set("checkforupdates", Boolean.valueOf(var1));
   }

   public boolean isPreventCollision() {
      return this.preventCollision;
   }

   public boolean isNewEffectIndicator() {
      return this.useNewEffectIndicator;
   }

   public boolean isShowNewDeathMessages() {
      return this.useNewDeathmessages;
   }

   public boolean isSuppressMetadataErrors() {
      return this.suppressMetadataErrors;
   }

   public boolean isShieldBlocking() {
      return this.shieldBlocking;
   }

   public boolean isHologramPatch() {
      return this.hologramPatch;
   }

   public boolean isPistonAnimationPatch() {
      return this.pistonAnimationPatch;
   }

   public boolean isBossbarPatch() {
      return this.bossbarPatch;
   }

   public boolean isBossbarAntiflicker() {
      return this.bossbarAntiFlicker;
   }

   public double getHologramYOffset() {
      return this.hologramOffset;
   }

   public int getMaxPPS() {
      return this.maxPPS;
   }

   public String getMaxPPSKickMessage() {
      return this.maxPPSKickMessage;
   }

   public int getTrackingPeriod() {
      return this.trackingPeriod;
   }

   public int getWarningPPS() {
      return this.warningPPS;
   }

   public int getMaxWarnings() {
      return this.maxPPSWarnings;
   }

   public String getMaxWarningsKickMessage() {
      return this.maxPPSWarningsKickMessage;
   }

   public boolean w() {
      return false;
   }

   public boolean isSendSupportedVersions() {
      return this.sendSupportedVersions;
   }

   public boolean isSimulatePlayerTick() {
      return this.simulatePlayerTick;
   }

   public boolean isItemCache() {
      return this.itemCache;
   }

   public boolean isNMSPlayerTicking() {
      return this.nmsPlayerTicking;
   }

   public boolean isReplacePistons() {
      return this.replacePistons;
   }

   public int getPistonReplacementId() {
      return this.pistonReplacementId;
   }

   public boolean isAutoTeam() {
      boolean var1 = ViaManager.i();
      return this.preventCollision && this.autoTeam;
   }

   public boolean isForceJsonTransform() {
      return this.forceJsonTransform;
   }

   public boolean is1_12NBTArrayFix() {
      return this.nbtArrayFix;
   }

   public boolean is1_12QuickMoveActionFix() {
      return false;
   }

   public IntSet getBlockedProtocols() {
      return this.blockedProtocols;
   }

   public String getBlockedDisconnectMsg() {
      return this.blockedDisconnectMessage;
   }

   public String getReloadDisconnectMsg() {
      return this.reloadDisconnectMessage;
   }

   public boolean isMinimizeCooldown() {
      return this.minimizeCooldown;
   }

   public boolean is1_13TeamColourFix() {
      return this.teamColourFix;
   }

   public boolean isSuppressConversionWarnings() {
      return this.suppressConversionWarnings;
   }

   public boolean isDisable1_13AutoComplete() {
      return this.disable1_13TabComplete;
   }

   public boolean isServersideBlockConnections() {
      return this.serversideBlockConnections;
   }

   public String getBlockConnectionMethod() {
      return "packet";
   }

   public boolean isReduceBlockStorageMemory() {
      return this.reduceBlockStorageMemory;
   }

   public boolean isStemWhenBlockAbove() {
      return this.flowerStemWhenBlockAbove;
   }

   public boolean isVineClimbFix() {
      return this.vineClimbFix;
   }

   public boolean isSnowCollisionFix() {
      return this.snowCollisionFix;
   }

   public boolean isInfestedBlocksFix() {
      return this.infestedBlocksFix;
   }

   public int get1_13TabCompleteDelay() {
      return this.tabCompleteDelay;
   }

   public boolean isTruncate1_14Books() {
      return this.truncate1_14Books;
   }

   public boolean isLeftHandedHandling() {
      return this.leftHandedHandling;
   }

   public boolean q() {
      return false;
   }

   public boolean L() {
      return false;
   }

   public boolean isNonFullBlockLightFix() {
      return this.fullBlockLightFix;
   }

   public boolean is1_14HealthNaNFix() {
      return this.healthNaNFix;
   }

   public boolean is1_15InstantRespawn() {
      return this.instantRespawn;
   }

   public boolean isIgnoreLong1_16ChannelNames() {
      return this.ignoreLongChannelNames;
   }
}
