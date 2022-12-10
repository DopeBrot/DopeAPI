package de.dopebrot.dopeapi.helper;
import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.craftbukkit.v1_18_R2.CraftOfflinePlayer;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class DPPlayer {

	OfflinePlayer offlinePlayer;
	Player player;

	public Player getPlayer() {
		return player;
	}

	public DPPlayer(String name, World world, Location location) {
		this.player = new Player() {
			@Override
			public @NotNull Component displayName() {
				return Component.text(name);
			}
			@Override
			public void displayName(@Nullable Component component) {

			}
			@Override
			public @NotNull String getDisplayName() {
				return name;
			}
			@Override
			public void setDisplayName(@Nullable String s) {

			}
			@Override
			public void playerListName(@Nullable Component component) {

			}
			@Override
			public @NotNull Component playerListName() {
				return Component.text(name);
			}
			@Override
			public @Nullable Component playerListHeader() {
				return null;
			}
			@Override
			public @Nullable Component playerListFooter() {
				return null;
			}
			@Override
			public @NotNull String getPlayerListName() {
				return name;
			}
			@Override
			public void setPlayerListName(@Nullable String s) {

			}
			@Override
			public @Nullable String getPlayerListHeader() {
				return null;
			}
			@Override
			public @Nullable String getPlayerListFooter() {
				return null;
			}
			@Override
			public void setPlayerListHeader(@Nullable String s) {

			}
			@Override
			public void setPlayerListFooter(@Nullable String s) {

			}
			@Override
			public void setPlayerListHeaderFooter(@Nullable String s, @Nullable String s1) {

			}
			@Override
			public void setCompassTarget(@NotNull Location location) {

			}
			@Override
			public @NotNull Location getCompassTarget() {
				return location;
			}
			@Override
			public @Nullable InetSocketAddress getAddress() {
				return null;
			}
			@Override
			public void sendRawMessage(@NotNull String s) {

			}
			@Override
			public void kickPlayer(@Nullable String s) {

			}
			@Override
			public void kick() {

			}
			@Override
			public void kick(@Nullable Component component) {

			}
			@Override
			public void kick(@Nullable Component component, PlayerKickEvent.@NotNull Cause cause) {

			}
			@Override
			public void chat(@NotNull String s) {

			}
			@Override
			public boolean performCommand(@NotNull String s) {
				return false;
			}
			@Override
			public boolean isOnGround() {
				return false;
			}
			@Override
			public boolean isSneaking() {
				return false;
			}
			@Override
			public void setSneaking(boolean b) {

			}
			@Override
			public boolean isSprinting() {
				return false;
			}
			@Override
			public void setSprinting(boolean b) {

			}
			@Override
			public void saveData() {

			}
			@Override
			public void loadData() {

			}
			@Override
			public void setSleepingIgnored(boolean b) {

			}
			@Override
			public boolean isSleepingIgnored() {
				return false;
			}
			@Override
			public @Nullable Location getBedSpawnLocation() {
				return null;
			}
			@Override
			public void setBedSpawnLocation(@Nullable Location location) {

			}
			@Override
			public void setBedSpawnLocation(@Nullable Location location, boolean b) {

			}
			@Override
			public void playNote(@NotNull Location location, byte b, byte b1) {

			}
			@Override
			public void playNote(@NotNull Location location, @NotNull Instrument instrument, @NotNull Note note) {

			}
			@Override
			public void playSound(@NotNull Location location, @NotNull Sound sound, float v, float v1) {

			}
			@Override
			public void playSound(@NotNull Location location, @NotNull String s, float v, float v1) {

			}
			@Override
			public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory soundCategory, float v, float v1) {

			}
			@Override
			public void playSound(@NotNull Location location, @NotNull String s, @NotNull SoundCategory soundCategory, float v, float v1) {

			}
			@Override
			public void playSound(@NotNull Entity entity, @NotNull Sound sound, float v, float v1) {

			}
			@Override
			public void playSound(@NotNull Entity entity, @NotNull Sound sound, @NotNull SoundCategory soundCategory, float v, float v1) {

			}
			@Override
			public void stopSound(@NotNull Sound sound) {

			}
			@Override
			public void stopSound(@NotNull String s) {

			}
			@Override
			public void stopSound(@NotNull Sound sound, @Nullable SoundCategory soundCategory) {

			}
			@Override
			public void stopSound(@NotNull String s, @Nullable SoundCategory soundCategory) {

			}
			@Override
			public void stopAllSounds() {

			}
			@Override
			public void playEffect(@NotNull Location location, @NotNull Effect effect, int i) {

			}
			@Override
			public <T> void playEffect(@NotNull Location location, @NotNull Effect effect, @Nullable T t) {

			}
			@Override
			public boolean breakBlock(@NotNull Block block) {
				return false;
			}
			@Override
			public void sendBlockChange(@NotNull Location location, @NotNull Material material, byte b) {

			}
			@Override
			public void sendBlockChange(@NotNull Location location, @NotNull BlockData blockData) {

			}
			@Override
			public void sendBlockDamage(@NotNull Location location, float v) {

			}
			@Override
			public void sendMultiBlockChange(@NotNull Map<Location, BlockData> map, boolean b) {

			}
			@Override
			public void sendEquipmentChange(@NotNull LivingEntity livingEntity, @NotNull EquipmentSlot equipmentSlot, @NotNull ItemStack itemStack) {

			}
			@Override
			public void sendSignChange(@NotNull Location location, @Nullable List<Component> list, @NotNull DyeColor dyeColor, boolean b) throws IllegalArgumentException {

			}
			@Override
			public void sendSignChange(@NotNull Location location, @Nullable String[] strings) throws IllegalArgumentException {

			}
			@Override
			public void sendSignChange(@NotNull Location location, @Nullable String[] strings, @NotNull DyeColor dyeColor) throws IllegalArgumentException {

			}
			@Override
			public void sendSignChange(@NotNull Location location, @Nullable String[] strings, @NotNull DyeColor dyeColor, boolean b) throws IllegalArgumentException {

			}
			@Override
			public void sendMap(@NotNull MapView mapView) {

			}
			@Override
			public void sendActionBar(@NotNull String s) {

			}
			@Override
			public void sendActionBar(char c, @NotNull String s) {

			}
			@Override
			public void sendActionBar(@NotNull BaseComponent... baseComponents) {

			}
			@Override
			public void setPlayerListHeaderFooter(@Nullable BaseComponent[] baseComponents, @Nullable BaseComponent[] baseComponents1) {

			}
			@Override
			public void setPlayerListHeaderFooter(@Nullable BaseComponent baseComponent, @Nullable BaseComponent baseComponent1) {

			}
			@Override
			public void setTitleTimes(int i, int i1, int i2) {

			}
			@Override
			public void setSubtitle(BaseComponent[] baseComponents) {

			}
			@Override
			public void setSubtitle(BaseComponent baseComponent) {

			}
			@Override
			public void showTitle(@Nullable BaseComponent[] baseComponents) {

			}
			@Override
			public void showTitle(@Nullable BaseComponent baseComponent) {

			}
			@Override
			public void showTitle(@Nullable BaseComponent[] baseComponents, @Nullable BaseComponent[] baseComponents1, int i, int i1, int i2) {

			}
			@Override
			public void showTitle(@Nullable BaseComponent baseComponent, @Nullable BaseComponent baseComponent1, int i, int i1, int i2) {

			}
			@Override
			public void sendTitle(@NotNull Title title) {

			}
			@Override
			public void updateTitle(@NotNull Title title) {

			}
			@Override
			public void hideTitle() {

			}
			@Override
			public void updateInventory() {

			}
			@Override
			public @Nullable GameMode getPreviousGameMode() {
				return null;
			}
			@Override
			public void setPlayerTime(long l, boolean b) {

			}
			@Override
			public long getPlayerTime() {
				return 0;
			}
			@Override
			public long getPlayerTimeOffset() {
				return 0;
			}
			@Override
			public boolean isPlayerTimeRelative() {
				return false;
			}
			@Override
			public void resetPlayerTime() {

			}
			@Override
			public void setPlayerWeather(@NotNull WeatherType weatherType) {

			}
			@Override
			public @Nullable WeatherType getPlayerWeather() {
				return null;
			}
			@Override
			public void resetPlayerWeather() {

			}
			@Override
			public void giveExp(int i, boolean b) {

			}
			@Override
			public int applyMending(int i) {
				return 0;
			}
			@Override
			public void giveExpLevels(int i) {

			}
			@Override
			public float getExp() {
				return 0;
			}
			@Override
			public void setExp(float v) {

			}
			@Override
			public int getLevel() {
				return 0;
			}
			@Override
			public void setLevel(int i) {

			}
			@Override
			public int getTotalExperience() {
				return 0;
			}
			@Override
			public void setTotalExperience(int i) {

			}
			@Override
			public void sendExperienceChange(float v) {

			}
			@Override
			public void sendExperienceChange(float v, int i) {

			}
			@Override
			public boolean getAllowFlight() {
				return false;
			}
			@Override
			public void setAllowFlight(boolean b) {

			}
			@Override
			public void hidePlayer(@NotNull Player player) {

			}
			@Override
			public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player) {

			}
			@Override
			public void showPlayer(@NotNull Player player) {

			}
			@Override
			public void showPlayer(@NotNull Plugin plugin, @NotNull Player player) {

			}
			@Override
			public boolean canSee(@NotNull Player player) {
				return false;
			}
			@Override
			public void hideEntity(@NotNull Plugin plugin, @NotNull Entity entity) {

			}
			@Override
			public void showEntity(@NotNull Plugin plugin, @NotNull Entity entity) {

			}
			@Override
			public boolean canSee(@NotNull Entity entity) {
				return false;
			}
			@Override
			public boolean isFlying() {
				return false;
			}
			@Override
			public void setFlying(boolean b) {

			}
			@Override
			public void setFlySpeed(float v) throws IllegalArgumentException {

			}
			@Override
			public void setWalkSpeed(float v) throws IllegalArgumentException {

			}
			@Override
			public float getFlySpeed() {
				return 0;
			}
			@Override
			public float getWalkSpeed() {
				return 0;
			}
			@Override
			public void setTexturePack(@NotNull String s) {

			}
			@Override
			public void setResourcePack(@NotNull String s) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @Nullable byte[] bytes) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @Nullable byte[] bytes, @Nullable String s1) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @Nullable byte[] bytes, boolean b) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @Nullable byte[] bytes, @Nullable String s1, boolean b) {

			}
			@Override
			public void setResourcePack(@NotNull String s, byte @Nullable [] bytes, @Nullable Component component, boolean b) {

			}
			@Override
			public @NotNull Scoreboard getScoreboard() {
				return null;
			}
			@Override
			public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

			}
			@Override
			public @Nullable WorldBorder getWorldBorder() {
				return null;
			}
			@Override
			public void setWorldBorder(@Nullable WorldBorder worldBorder) {

			}
			@Override
			public boolean isHealthScaled() {
				return false;
			}
			@Override
			public void setHealthScaled(boolean b) {

			}
			@Override
			public void setHealthScale(double v) throws IllegalArgumentException {

			}
			@Override
			public double getHealthScale() {
				return 0;
			}
			@Override
			public void sendHealthUpdate(double v, int i, float v1) {

			}
			@Override
			public void sendHealthUpdate() {

			}
			@Override
			public @Nullable Entity getSpectatorTarget() {
				return null;
			}
			@Override
			public void setSpectatorTarget(@Nullable Entity entity) {

			}
			@Override
			public void sendTitle(@Nullable String s, @Nullable String s1) {

			}
			@Override
			public void sendTitle(@Nullable String s, @Nullable String s1, int i, int i1, int i2) {

			}
			@Override
			public void resetTitle() {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i) {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, @Nullable T t) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, @Nullable T t) {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2) {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, @Nullable T t) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, @Nullable T t) {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3) {

			}
			@Override
			public void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int i, double v, double v1, double v2, double v3, @Nullable T t) {

			}
			@Override
			public <T> void spawnParticle(@NotNull Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t) {

			}
			// change
			@Override
			public @NotNull AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement) {
				return null;
			}
			@Override
			public int getClientViewDistance() {
				return 0;
			}
			@Override
			public @NotNull Locale locale() {
				return Locale.US;
			}
			@Override
			public int getPing() {
				return 0;
			}
			@Override
			public @NotNull String getLocale() {
				return Locale.US.getDisplayName();
			}
			@Override
			public boolean getAffectsSpawning() {
				return false;
			}
			@Override
			public void setAffectsSpawning(boolean b) {

			}
			@Override
			public int getViewDistance() {
				return 5;
			}
			@Override
			public void setViewDistance(int i) {

			}
			@Override
			public int getSimulationDistance() {
				return 5;
			}
			@Override
			public void setSimulationDistance(int i) {

			}
			@Override
			public int getNoTickViewDistance() {
				return 0;
			}
			@Override
			public void setNoTickViewDistance(int i) {

			}
			@Override
			public int getSendViewDistance() {
				return 0;
			}
			@Override
			public void setSendViewDistance(int i) {

			}
			@Override
			public void updateCommands() {

			}
			@Override
			public void openBook(@NotNull ItemStack itemStack) {

			}
			@Override
			public void openSign(@NotNull Sign sign) {

			}
			@Override
			public void showDemoScreen() {

			}
			@Override
			public boolean isAllowingServerListings() {
				return false;
			}
			@Override
			public void setResourcePack(@NotNull String s, @NotNull String s1) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @NotNull String s1, boolean b) {

			}
			@Override
			public void setResourcePack(@NotNull String s, @NotNull String s1, boolean b, @Nullable Component component) {

			}
			@Override
			public PlayerResourcePackStatusEvent.@Nullable Status getResourcePackStatus() {
				return null;
			}
			@Override
			public @Nullable String getResourcePackHash() {
				return null;
			}
			@Override
			public boolean hasResourcePack() {
				return false;
			}
			@Override
			public @NotNull PlayerProfile getPlayerProfile() {
				return new PlayerProfile() {
					@Override
					public @Nullable String getName() {
						return name;
					}

					@Deprecated(forRemoval = true)
					@Override
					public @NotNull String setName(@Nullable String s) {
						return name;
					}
					@Override
					public @Nullable UUID getId() {
						return UUID.randomUUID();
					}
					@Deprecated(forRemoval = true)
					@Override
					public @Nullable UUID setId(@Nullable UUID uuid) {
						return uuid;
					}
					@Override
					public @NotNull PlayerTextures getTextures() {
						return new PlayerTextures() {
							@Override
							public boolean isEmpty() {
								return false;
							}
							@Override
							public void clear() {

							}
							@Override
							public @Nullable URL getSkin() {
								return null;
							}
							@Override
							public void setSkin(@Nullable URL url) {

							}
							@Override
							public void setSkin(@Nullable URL url, @Nullable SkinModel skinModel) {

							}
							@Override
							public @NotNull SkinModel getSkinModel() {
								return SkinModel.CLASSIC;
							}
							@Override
							public @Nullable URL getCape() {
								return null;
							}
							@Override
							public void setCape(@Nullable URL url) {

							}
							@Override
							public long getTimestamp() {
								return 0;
							}
							@Override
							public boolean isSigned() {
								return false;
							}
						};
					}
					@Override
					public void setTextures(@Nullable PlayerTextures playerTextures) {

					}
					@Override
					public @NotNull Set<ProfileProperty> getProperties() {
						return new HashSet<>();
					}
					@Override
					public boolean hasProperty(@Nullable String s) {
						return false;
					}
					@Override
					public void setProperty(@NotNull ProfileProperty profileProperty) {

					}
					@Override
					public void setProperties(@NotNull Collection<ProfileProperty> collection) {

					}
					@Override
					public boolean removeProperty(@Nullable String s) {
						return false;
					}
					@Override
					public void clearProperties() {

					}
					@Override
					public boolean isComplete() {
						return false;
					}
					@Override
					public boolean completeFromCache() {
						return false;
					}
					@Override
					public boolean completeFromCache(boolean b) {
						return false;
					}
					@Override
					public boolean completeFromCache(boolean b, boolean b1) {
						return false;
					}
					@Override
					public boolean complete(boolean b) {
						return false;
					}
					@Override
					public boolean complete(boolean b, boolean b1) {
						return false;
					}
					@Override
					public @Nullable UUID getUniqueId() {
						return null;
					}
					@Override
					public @NotNull CompletableFuture<org.bukkit.profile.PlayerProfile> update() {
						return null;
					}
					@Override
					public org.bukkit.profile.@NotNull PlayerProfile clone() {
						return this;
					}
					@Override
					public @NotNull Map<String, Object> serialize() {
						return null;
					}
				};
			}
			@Override
			public void setPlayerProfile(@NotNull PlayerProfile playerProfile) {

			}
			@Override
			public float getCooldownPeriod() {
				return 0;
			}
			@Override
			public float getCooledAttackStrength(float v) {
				return 0;
			}
			@Override
			public void resetCooldown() {

			}
			@Override
			public <T> @NotNull T getClientOption(@NotNull ClientOption<T> clientOption) {
				return null;
			}
			@Override
			public @Nullable Firework boostElytra(@NotNull ItemStack itemStack) {
				return null;
			}
			@Override
			public void sendOpLevel(byte b) {

			}
			@Override
			public @Nullable String getClientBrandName() {
				return null;
			}
			@Override
			public @NotNull Spigot spigot() {
				return this.spigot();
			}
			@Override
			public int getProtocolVersion() {
				return 0;
			}
			@Override
			public @Nullable InetSocketAddress getVirtualHost() {
				return null;
			}
			@Override
			public boolean isOnline() {
				return true;
			}
			@Override
			public boolean isBanned() {
				return false;
			}
			@Override
			public boolean isWhitelisted() {
				return false;
			}
			@Override
			public void setWhitelisted(boolean b) {

			}
			@Override
			public @Nullable Player getPlayer() {
				return null;
			}
			@Override
			public long getFirstPlayed() {
				return 0;
			}
			@Override
			public long getLastPlayed() {
				return 0;
			}
			@Override
			public boolean hasPlayedBefore() {
				return true;
			}
			@Override
			public long getLastLogin() {
				return 0;
			}
			@Override
			public long getLastSeen() {
				return 0;
			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {

			}
			@Override
			public void setStatistic(@NotNull Statistic statistic, int i) throws IllegalArgumentException {

			}
			@Override
			public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
				return 0;
			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

			}
			@Override
			public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
				return 0;
			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {

			}
			@Override
			public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int i) throws IllegalArgumentException {

			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

			}
			@Override
			public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
				return 0;
			}
			@Override
			public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) throws IllegalArgumentException {

			}
			@Override
			public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {

			}
			@Override
			public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int i) {

			}
			@Override
			public @NotNull Map<String, Object> serialize() {
				return null;
			}
			@Override
			public boolean isConversing() {
				return false;
			}
			@Override
			public void acceptConversationInput(@NotNull String s) {

			}
			@Override
			public boolean beginConversation(@NotNull Conversation conversation) {
				return false;
			}
			@Override
			public void abandonConversation(@NotNull Conversation conversation) {

			}
			@Override
			public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent conversationAbandonedEvent) {

			}
			@Override
			public void sendRawMessage(@Nullable UUID uuid, @NotNull String s) {

			}
			@Override
			public @NotNull EntityEquipment getEquipment() {
				return null;
			}
			@Override
			public @NotNull String getName() {
				return name;
			}
			@Override
			public @NotNull PlayerInventory getInventory() {
				return new PlayerInventory() {
					@Override
					public @Nullable ItemStack @NotNull [] getArmorContents() {
						return new ItemStack[0];
					}
					@Override
					public @Nullable ItemStack @NotNull [] getExtraContents() {
						return new ItemStack[0];
					}
					@Override
					public @Nullable ItemStack getHelmet() {
						return null;
					}
					@Override
					public @Nullable ItemStack getChestplate() {
						return null;
					}
					@Override
					public @Nullable ItemStack getLeggings() {
						return null;
					}
					@Override
					public @Nullable ItemStack getBoots() {
						return null;
					}
					@Override
					public void setItem(int i, @Nullable ItemStack itemStack) {

					}
					@Override
					public void setItem(@NotNull EquipmentSlot equipmentSlot, @Nullable ItemStack itemStack) {

					}
					@Override
					public @NotNull ItemStack getItem(@NotNull EquipmentSlot equipmentSlot) {
						return null;
					}
					@Override
					public void setArmorContents(@Nullable ItemStack[] itemStacks) {

					}
					@Override
					public void setExtraContents(@Nullable ItemStack[] itemStacks) {

					}
					@Override
					public void setHelmet(@Nullable ItemStack itemStack) {

					}
					@Override
					public void setChestplate(@Nullable ItemStack itemStack) {

					}
					@Override
					public void setLeggings(@Nullable ItemStack itemStack) {

					}
					@Override
					public void setBoots(@Nullable ItemStack itemStack) {

					}
					@Override
					public @NotNull ItemStack getItemInMainHand() {
						return new ItemStack(Material.STICK);
					}
					@Override
					public void setItemInMainHand(@Nullable ItemStack itemStack) {

					}
					@Override
					public @NotNull ItemStack getItemInOffHand() {
						return new ItemStack(Material.STICK);
					}
					@Override
					public void setItemInOffHand(@Nullable ItemStack itemStack) {

					}
					@Override
					public @NotNull ItemStack getItemInHand() {
						return new ItemStack(Material.STICK);

					}
					@Override
					public void setItemInHand(@Nullable ItemStack itemStack) {

					}
					@Override
					public int getHeldItemSlot() {
						return 0;
					}
					@Override
					public void setHeldItemSlot(int i) {

					}
					@Override
					public @Nullable HumanEntity getHolder() {
						return null;
					}
					@Override
					public int getSize() {
						return 0;
					}
					@Override
					public int getMaxStackSize() {
						return 0;
					}
					@Override
					public void setMaxStackSize(int i) {

					}
					@Override
					public @Nullable ItemStack getItem(int i) {
						return null;
					}
					@Override
					public @NotNull HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
						return null;
					}
					@Override
					public @NotNull HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
						return null;
					}
					@Override
					public @NotNull HashMap<Integer, ItemStack> removeItemAnySlot(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
						return null;
					}
					@Override
					public @Nullable ItemStack @NotNull [] getContents() {
						return new ItemStack[0];
					}
					@Override
					public void setContents(@Nullable ItemStack @NotNull [] itemStacks) throws IllegalArgumentException {

					}
					@Override
					public @Nullable ItemStack @NotNull [] getStorageContents() {
						return new ItemStack[0];
					}
					@Override
					public void setStorageContents(@Nullable ItemStack @NotNull [] itemStacks) throws IllegalArgumentException {

					}
					@Override
					public boolean contains(@NotNull Material material) throws IllegalArgumentException {
						return false;
					}
					@Override
					public boolean contains(@Nullable ItemStack itemStack) {
						return false;
					}
					@Override
					public boolean contains(@NotNull Material material, int i) throws IllegalArgumentException {
						return false;
					}
					@Override
					public boolean contains(@Nullable ItemStack itemStack, int i) {
						return false;
					}
					@Override
					public boolean containsAtLeast(@Nullable ItemStack itemStack, int i) {
						return false;
					}
					@Override
					public @NotNull HashMap<Integer, ? extends ItemStack> all(@NotNull Material material) throws IllegalArgumentException {
						return null;
					}
					@Override
					public @NotNull HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack itemStack) {
						return null;
					}
					@Override
					public int first(@NotNull Material material) throws IllegalArgumentException {
						return 0;
					}
					@Override
					public int first(@NotNull ItemStack itemStack) {
						return 0;
					}
					@Override
					public int firstEmpty() {
						return 0;
					}
					@Override
					public boolean isEmpty() {
						return false;
					}
					@Override
					public void remove(@NotNull Material material) throws IllegalArgumentException {

					}
					@Override
					public void remove(@NotNull ItemStack itemStack) {

					}
					@Override
					public void clear(int i) {

					}
					@Override
					public void clear() {

					}
					@Override
					public int close() {
						return 0;
					}
					@Override
					public @NotNull List<HumanEntity> getViewers() {
						return null;
					}
					@Override
					public @NotNull InventoryType getType() {
						return null;
					}
					@Override
					public @Nullable InventoryHolder getHolder(boolean b) {
						return null;
					}
					@Override
					public @NotNull ListIterator<ItemStack> iterator() {
						return null;
					}
					@Override
					public @NotNull ListIterator<ItemStack> iterator(int i) {
						return null;
					}
					@Override
					public @Nullable Location getLocation() {
						return location;
					}
				};
			}
			@Override
			public @NotNull Inventory getEnderChest() {
				return null;
			}
			@Override
			public @NotNull MainHand getMainHand() {
				return null;
			}
			@Override
			public boolean setWindowProperty(InventoryView.@NotNull Property property, int i) {
				return false;
			}
			@Override
			public @NotNull InventoryView getOpenInventory() {
				return null;
			}
			@Override
			public @Nullable InventoryView openInventory(@NotNull Inventory inventory) {
				return null;
			}
			@Override
			public @Nullable InventoryView openWorkbench(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openEnchanting(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public void openInventory(@NotNull InventoryView inventoryView) {

			}
			@Override
			public @Nullable InventoryView openMerchant(@NotNull Villager villager, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openMerchant(@NotNull Merchant merchant, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openAnvil(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openCartographyTable(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openGrindstone(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openLoom(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openSmithingTable(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public @Nullable InventoryView openStonecutter(@Nullable Location location, boolean b) {
				return null;
			}
			@Override
			public void closeInventory() {

			}
			@Override
			public void closeInventory(InventoryCloseEvent.@NotNull Reason reason) {

			}
			@Override
			public @NotNull ItemStack getItemInHand() {
				return null;
			}
			@Override
			public void setItemInHand(@Nullable ItemStack itemStack) {

			}
			@Override
			public @NotNull ItemStack getItemOnCursor() {
				return null;
			}
			@Override
			public void setItemOnCursor(@Nullable ItemStack itemStack) {

			}
			@Override
			public boolean hasCooldown(@NotNull Material material) {
				return false;
			}
			@Override
			public int getCooldown(@NotNull Material material) {
				return 0;
			}
			@Override
			public void setCooldown(@NotNull Material material, int i) {

			}
			@Override
			public boolean isDeeplySleeping() {
				return false;
			}
			@Override
			public int getSleepTicks() {
				return 0;
			}
			@Override
			public @Nullable Location getPotentialBedLocation() {
				return null;
			}
			@Override
			public boolean sleep(@NotNull Location location, boolean b) {
				return false;
			}
			@Override
			public void wakeup(boolean b) {

			}
			@Override
			public @NotNull Location getBedLocation() {
				return null;
			}
			@Override
			public @NotNull GameMode getGameMode() {
				return null;
			}
			@Override
			public void setGameMode(@NotNull GameMode gameMode) {

			}
			@Override
			public boolean isBlocking() {
				return false;
			}
			@Override
			public boolean isHandRaised() {
				return false;
			}
			@Override
			public @Nullable ItemStack getItemInUse() {
				return null;
			}
			@Override
			public int getExpToLevel() {
				return 0;
			}
			@Override
			public @Nullable Entity releaseLeftShoulderEntity() {
				return null;
			}
			@Override
			public @Nullable Entity releaseRightShoulderEntity() {
				return null;
			}
			@Override
			public float getAttackCooldown() {
				return 0;
			}
			@Override
			public boolean discoverRecipe(@NotNull NamespacedKey namespacedKey) {
				return false;
			}
			@Override
			public int discoverRecipes(@NotNull Collection<NamespacedKey> collection) {
				return 0;
			}
			@Override
			public boolean undiscoverRecipe(@NotNull NamespacedKey namespacedKey) {
				return false;
			}
			@Override
			public int undiscoverRecipes(@NotNull Collection<NamespacedKey> collection) {
				return 0;
			}
			@Override
			public boolean hasDiscoveredRecipe(@NotNull NamespacedKey namespacedKey) {
				return false;
			}
			@Override
			public @NotNull Set<NamespacedKey> getDiscoveredRecipes() {
				return null;
			}
			@Override
			public @Nullable Entity getShoulderEntityLeft() {
				return null;
			}
			@Override
			public void setShoulderEntityLeft(@Nullable Entity entity) {

			}
			@Override
			public @Nullable Entity getShoulderEntityRight() {
				return null;
			}
			@Override
			public void setShoulderEntityRight(@Nullable Entity entity) {

			}
			@Override
			public boolean dropItem(boolean b) {
				return false;
			}
			@Override
			public float getExhaustion() {
				return 0;
			}
			@Override
			public void setExhaustion(float v) {

			}
			@Override
			public float getSaturation() {
				return 0;
			}
			@Override
			public void setSaturation(float v) {

			}
			@Override
			public int getFoodLevel() {
				return 0;
			}
			@Override
			public void setFoodLevel(int i) {

			}
			@Override
			public int getSaturatedRegenRate() {
				return 0;
			}
			@Override
			public void setSaturatedRegenRate(int i) {

			}
			@Override
			public int getUnsaturatedRegenRate() {
				return 0;
			}
			@Override
			public void setUnsaturatedRegenRate(int i) {

			}
			@Override
			public int getStarvationRate() {
				return 0;
			}
			@Override
			public void setStarvationRate(int i) {

			}
			@Override
			public double getEyeHeight() {
				return 0;
			}
			@Override
			public double getEyeHeight(boolean b) {
				return 0;
			}
			@Override
			public @NotNull Location getEyeLocation() {
				return null;
			}
			@Override
			public @NotNull List<Block> getLineOfSight(@Nullable Set<Material> set, int i) {
				return null;
			}
			@Override
			public @NotNull Block getTargetBlock(@Nullable Set<Material> set, int i) {
				return null;
			}
			@Override
			public @Nullable Block getTargetBlock(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}
			@Override
			public @Nullable BlockFace getTargetBlockFace(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}
			@Override
			public @Nullable TargetBlockInfo getTargetBlockInfo(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}
			@Override
			public @Nullable Entity getTargetEntity(int i, boolean b) {
				return null;
			}
			@Override
			public @Nullable TargetEntityInfo getTargetEntityInfo(int i, boolean b) {
				return null;
			}
			@Override
			public @NotNull List<Block> getLastTwoTargetBlocks(@Nullable Set<Material> set, int i) {
				return null;
			}
			@Override
			public @Nullable Block getTargetBlockExact(int i) {
				return null;
			}
			@Override
			public @Nullable Block getTargetBlockExact(int i, @NotNull FluidCollisionMode fluidCollisionMode) {
				return null;
			}
			@Override
			public @Nullable RayTraceResult rayTraceBlocks(double v) {
				return null;
			}
			@Override
			public @Nullable RayTraceResult rayTraceBlocks(double v, @NotNull FluidCollisionMode fluidCollisionMode) {
				return null;
			}
			@Override
			public int getRemainingAir() {
				return 0;
			}
			@Override
			public void setRemainingAir(int i) {

			}
			@Override
			public int getMaximumAir() {
				return 0;
			}
			@Override
			public void setMaximumAir(int i) {

			}
			@Override
			public int getArrowCooldown() {
				return 0;
			}
			@Override
			public void setArrowCooldown(int i) {

			}
			@Override
			public int getArrowsInBody() {
				return 0;
			}
			@Override
			public void setArrowsInBody(int i) {

			}
			@Override
			public int getBeeStingerCooldown() {
				return 0;
			}
			@Override
			public void setBeeStingerCooldown(int i) {

			}
			@Override
			public int getBeeStingersInBody() {
				return 0;
			}
			@Override
			public void setBeeStingersInBody(int i) {

			}
			@Override
			public int getMaximumNoDamageTicks() {
				return 0;
			}
			@Override
			public void setMaximumNoDamageTicks(int i) {

			}
			@Override
			public double getLastDamage() {
				return 0;
			}
			@Override
			public void setLastDamage(double v) {

			}
			@Override
			public int getNoDamageTicks() {
				return 0;
			}
			@Override
			public void setNoDamageTicks(int i) {

			}
			@Override
			public @Nullable Player getKiller() {
				return null;
			}
			@Override
			public void setKiller(@Nullable Player player) {

			}
			@Override
			public boolean addPotionEffect(@NotNull PotionEffect potionEffect) {
				return false;
			}
			@Override
			public boolean addPotionEffect(@NotNull PotionEffect potionEffect, boolean b) {
				return false;
			}
			@Override
			public boolean addPotionEffects(@NotNull Collection<PotionEffect> collection) {
				return false;
			}
			@Override
			public boolean hasPotionEffect(@NotNull PotionEffectType potionEffectType) {
				return false;
			}
			@Override
			public @Nullable PotionEffect getPotionEffect(@NotNull PotionEffectType potionEffectType) {
				return null;
			}
			@Override
			public void removePotionEffect(@NotNull PotionEffectType potionEffectType) {

			}
			@Override
			public @NotNull Collection<PotionEffect> getActivePotionEffects() {
				return null;
			}
			@Override
			public boolean hasLineOfSight(@NotNull Entity entity) {
				return false;
			}
			@Override
			public boolean hasLineOfSight(@NotNull Location location) {
				return false;
			}
			@Override
			public boolean getRemoveWhenFarAway() {
				return false;
			}
			@Override
			public void setRemoveWhenFarAway(boolean b) {

			}
			@Override
			public void setCanPickupItems(boolean b) {

			}
			@Override
			public boolean getCanPickupItems() {
				return false;
			}
			@Override
			public boolean isLeashed() {
				return false;
			}
			@Override
			public @NotNull Entity getLeashHolder() throws IllegalStateException {
				return null;
			}
			@Override
			public boolean setLeashHolder(@Nullable Entity entity) {
				return false;
			}
			@Override
			public boolean isGliding() {
				return false;
			}
			@Override
			public void setGliding(boolean b) {

			}
			@Override
			public boolean isSwimming() {
				return false;
			}
			@Override
			public void setSwimming(boolean b) {

			}
			@Override
			public boolean isRiptiding() {
				return false;
			}
			@Override
			public boolean isSleeping() {
				return false;
			}
			@Override
			public boolean isClimbing() {
				return false;
			}
			@Override
			public void setAI(boolean b) {

			}
			@Override
			public boolean hasAI() {
				return false;
			}
			@Override
			public void attack(@NotNull Entity entity) {

			}
			@Override
			public void swingMainHand() {

			}
			@Override
			public void swingOffHand() {

			}
			@Override
			public void setCollidable(boolean b) {

			}
			@Override
			public boolean isCollidable() {
				return false;
			}
			@Override
			public @NotNull Set<UUID> getCollidableExemptions() {
				return null;
			}
			@Override
			public <T> @Nullable T getMemory(@NotNull MemoryKey<T> memoryKey) {
				return null;
			}
			@Override
			public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @Nullable T t) {

			}
			@Override
			public @NotNull EntityCategory getCategory() {
				return null;
			}
			@Override
			public void setInvisible(boolean b) {

			}
			@Override
			public boolean isInvisible() {
				return false;
			}
			@Override
			public int getArrowsStuck() {
				return 0;
			}
			@Override
			public void setArrowsStuck(int i) {

			}
			@Override
			public int getShieldBlockingDelay() {
				return 0;
			}
			@Override
			public void setShieldBlockingDelay(int i) {

			}
			@Override
			public @Nullable ItemStack getActiveItem() {
				return null;
			}
			@Override
			public void clearActiveItem() {

			}
			@Override
			public int getItemUseRemainingTime() {
				return 0;
			}
			@Override
			public int getHandRaisedTime() {
				return 0;
			}
			@Override
			public @NotNull EquipmentSlot getHandRaised() {
				return null;
			}
			@Override
			public boolean isJumping() {
				return false;
			}
			@Override
			public void setJumping(boolean b) {

			}
			@Override
			public void playPickupItemAnimation(@NotNull Item item, int i) {

			}
			@Override
			public float getHurtDirection() {
				return 0;
			}
			@Override
			public void setHurtDirection(float v) {

			}
			@Override
			public @Nullable AttributeInstance getAttribute(@NotNull Attribute attribute) {
				return null;
			}
			@Override
			public void registerAttribute(@NotNull Attribute attribute) {

			}
			@Override
			public void damage(double v) {

			}
			@Override
			public void damage(double v, @Nullable Entity entity) {

			}
			@Override
			public double getHealth() {
				return 0;
			}
			@Override
			public void setHealth(double v) {

			}
			@Override
			public double getAbsorptionAmount() {
				return 0;
			}
			@Override
			public void setAbsorptionAmount(double v) {

			}
			@Override
			public double getMaxHealth() {
				return 0;
			}
			@Override
			public void setMaxHealth(double v) {

			}
			@Override
			public void resetMaxHealth() {

			}
			@Override
			public @NotNull Location getLocation() {
				return location;
			}
			@Override
			public @Nullable Location getLocation(@Nullable Location location) {
				return location;
			}
			@Override
			public void setVelocity(@NotNull Vector vector) {

			}
			@Override
			public @NotNull Vector getVelocity() {
				return new Vector();
			}
			@Override
			public double getHeight() {
				return 0;
			}
			@Override
			public double getWidth() {
				return 0;
			}
			@Override
			public @NotNull BoundingBox getBoundingBox() {
				return new BoundingBox(-0.1,-0.1,-0.1,0.1,0.1,0.1);
			}
			@Override
			public boolean isInWater() {
				return false;
			}
			@Override
			public @NotNull World getWorld() {
				return world;
			}
			@Override
			public void setRotation(float v, float v1) {

			}
			@Override
			public boolean teleport(@NotNull Location location) {
				return false;
			}
			@Override
			public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
				return false;
			}
			@Override
			public boolean teleport(@NotNull Entity entity) {
				return false;
			}
			@Override
			public boolean teleport(@NotNull Entity entity, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
				return false;
			}
			@Override
			public @NotNull List<Entity> getNearbyEntities(double v, double v1, double v2) {
				return new ArrayList<>();
			}
			@Override
			public int getEntityId() {
				return 0;
			}
			@Override
			public int getFireTicks() {
				return 0;
			}
			@Override
			public int getMaxFireTicks() {
				return 0;
			}
			@Override
			public void setFireTicks(int i) {

			}
			@Override
			public void setVisualFire(boolean b) {

			}
			@Override
			public boolean isVisualFire() {
				return false;
			}
			@Override
			public int getFreezeTicks() {
				return 0;
			}
			@Override
			public int getMaxFreezeTicks() {
				return 0;
			}
			@Override
			public void setFreezeTicks(int i) {

			}
			@Override
			public boolean isFrozen() {
				return false;
			}
			@Override
			public boolean isFreezeTickingLocked() {
				return false;
			}
			@Override
			public void lockFreezeTicks(boolean b) {

			}
			@Override
			public void remove() {

			}
			@Override
			public boolean isDead() {
				return false;
			}
			@Override
			public boolean isValid() {
				return true;
			}
			@Override
			public @NotNull Server getServer() {
				return Bukkit.getServer();
			}
			@Override
			public boolean isPersistent() {
				return false;
			}
			@Override
			public void setPersistent(boolean b) {

			}
			@Override
			public @Nullable Entity getPassenger() {
				return null;
			}
			@Override
			public boolean setPassenger(@NotNull Entity entity) {
				return false;
			}
			@Override
			public @NotNull List<Entity> getPassengers() {
				return new ArrayList<>();
			}
			@Override
			public boolean addPassenger(@NotNull Entity entity) {
				return false;
			}
			@Override
			public boolean removePassenger(@NotNull Entity entity) {
				return false;
			}
			@Override
			public boolean isEmpty() {
				return false;
			}
			@Override
			public boolean eject() {
				return false;
			}
			@Override
			public float getFallDistance() {
				return 0;
			}
			@Override
			public void setFallDistance(float v) {

			}
			@Override
			public void setLastDamageCause(@Nullable EntityDamageEvent entityDamageEvent) {

			}
			@Override
			public @Nullable EntityDamageEvent getLastDamageCause() {
				return null;
			}
			@Override
			public @NotNull UUID getUniqueId() {
				return new UUID(UUID.randomUUID().getMostSignificantBits(), UUID.randomUUID().getLeastSignificantBits());
			}
			@Override
			public int getTicksLived() {
				return 0;
			}
			@Override
			public void setTicksLived(int i) {

			}
			@Override
			public void playEffect(@NotNull EntityEffect entityEffect) {

			}
			@Override
			public @NotNull EntityType getType() {
				return EntityType.PLAYER;
			}
			@Override
			public boolean isInsideVehicle() {
				return false;
			}
			@Override
			public boolean leaveVehicle() {
				return false;
			}
			@Override
			public @Nullable Entity getVehicle() {
				return null;
			}
			@Override
			public void setCustomNameVisible(boolean b) {

			}
			@Override
			public boolean isCustomNameVisible() {
				return false;
			}
			@Override
			public void setGlowing(boolean b) {

			}
			@Override
			public boolean isGlowing() {
				return false;
			}
			@Override
			public void setInvulnerable(boolean b) {

			}
			@Override
			public boolean isInvulnerable() {
				return false;
			}
			@Override
			public boolean isSilent() {
				return false;
			}
			@Override
			public void setSilent(boolean b) {

			}
			@Override
			public boolean hasGravity() {
				return false;
			}
			@Override
			public void setGravity(boolean b) {

			}
			@Override
			public int getPortalCooldown() {
				return 0;
			}
			@Override
			public void setPortalCooldown(int i) {

			}
			@Override
			public @NotNull Set<String> getScoreboardTags() {
				return null;
			}
			@Override
			public boolean addScoreboardTag(@NotNull String s) {
				return false;
			}
			@Override
			public boolean removeScoreboardTag(@NotNull String s) {
				return false;
			}
			@Override
			public @NotNull PistonMoveReaction getPistonMoveReaction() {
				return null;
			}
			@Override
			public @NotNull BlockFace getFacing() {
				return null;
			}
			@Override
			public @NotNull Pose getPose() {
				return null;
			}
			@Override
			public @NotNull SpawnCategory getSpawnCategory() {
				return null;
			}
			@Override
			public @NotNull Component teamDisplayName() {
				return null;
			}
			@Override
			public @Nullable Location getOrigin() {
				return null;
			}
			@Override
			public boolean fromMobSpawner() {
				return false;
			}
			@Override
			public CreatureSpawnEvent.@NotNull SpawnReason getEntitySpawnReason() {
				return null;
			}
			@Override
			public boolean isInRain() {
				return false;
			}
			@Override
			public boolean isInBubbleColumn() {
				return false;
			}
			@Override
			public boolean isInWaterOrRain() {
				return false;
			}
			@Override
			public boolean isInWaterOrBubbleColumn() {
				return false;
			}
			@Override
			public boolean isInWaterOrRainOrBubbleColumn() {
				return false;
			}
			@Override
			public boolean isInLava() {
				return false;
			}
			@Override
			public boolean isTicking() {
				return true;
			}
			@Override
			public @NotNull Set<Player> getTrackedPlayers() {
				return null;
			}
			@Override
			public boolean spawnAt(@NotNull Location location, CreatureSpawnEvent.@NotNull SpawnReason spawnReason) {
				return true;
			}
			@Override
			public boolean isInPowderedSnow() {
				return false;
			}
			@Override
			public void sendMessage(@NotNull String s) {

			}
			@Override
			public void sendMessage(@NotNull String... strings) {

			}
			@Override
			public void sendMessage(@Nullable UUID uuid, @NotNull String s) {

			}
			@Override
			public void sendMessage(@Nullable UUID uuid, @NotNull String... strings) {

			}
			@Override
			public @NotNull Component name() {
				return null;
			}
			@Override
			public @Nullable Component customName() {
				return null;
			}
			@Override
			public void customName(@Nullable Component component) {

			}
			@Override
			public @Nullable String getCustomName() {
				return null;
			}
			@Override
			public void setCustomName(@Nullable String s) {

			}
			@Override
			public void setMetadata(@NotNull String s, @NotNull MetadataValue metadataValue) {

			}
			@Override
			public @NotNull List<MetadataValue> getMetadata(@NotNull String s) {
				return null;
			}
			@Override
			public boolean hasMetadata(@NotNull String s) {
				return false;
			}
			@Override
			public void removeMetadata(@NotNull String s, @NotNull Plugin plugin) {

			}
			@Override
			public boolean isPermissionSet(@NotNull String s) {
				return false;
			}
			@Override
			public boolean isPermissionSet(@NotNull Permission permission) {
				return false;
			}
			@Override
			public boolean hasPermission(@NotNull String s) {
				return false;
			}
			@Override
			public boolean hasPermission(@NotNull Permission permission) {
				return false;
			}
			@Override
			public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b) {
				return null;
			}
			@Override
			public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
				return null;
			}
			@Override
			public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b, int i) {
				return null;
			}
			@Override
			public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int i) {
				return null;
			}
			@Override
			public void removeAttachment(@NotNull PermissionAttachment permissionAttachment) {

			}
			@Override
			public void recalculatePermissions() {

			}
			@Override
			public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
				return null;
			}
			@Override
			public boolean isOp() {
				return false;
			}
			@Override
			public void setOp(boolean b) {

			}
			@Override
			public @NotNull PersistentDataContainer getPersistentDataContainer() {
				return null;
			}
			@Override
			public void sendPluginMessage(@NotNull Plugin plugin, @NotNull String s, @NotNull byte[] bytes) {

			}
			@Override
			public @NotNull Set<String> getListeningPluginChannels() {
				return null;
			}
			@Override
			public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass) {
				return null;
			}
			@Override
			public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass, @Nullable Vector vector) {
				return null;
			}
		};
	}

}
