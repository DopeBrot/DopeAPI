package de.dopebrot.dopeapi.discord;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public abstract class DiscordManager extends ListenerAdapter {

	public final JDA jda;

	public DiscordManager(JDABuilder builder) {
		this.jda = builder.build();
		this.onEnable();
	}

	public abstract void onEnable();

	public abstract void onDisable();

	public JDA jda() {
		return jda;
	}

	public static JDABuilder getDefault(String discordToken) {
		return JDABuilder.create(discordToken, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
				.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER, CacheFlag.SCHEDULED_EVENTS)
				.setChunkingFilter(ChunkingFilter.ALL)
				.setMemberCachePolicy(MemberCachePolicy.ALL)
				.enableCache(CacheFlag.ONLINE_STATUS);
	}


}
