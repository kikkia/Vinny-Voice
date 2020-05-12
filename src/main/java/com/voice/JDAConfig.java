package com.voice;

import com.sedmelluq.discord.lavaplayer.jdaudp.NativeAudioSendFactory;
import com.voice.configuration.properties.DiscordProperties;
import com.voice.event.VoiceEventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumSet;


@Configuration
public class JDAConfig {


    @Bean
    public ShardManager shards(DiscordProperties discordProperties) throws Exception {
        return DefaultShardManagerBuilder.create(EnumSet.of(GatewayIntent.GUILD_VOICE_STATES))
                .setToken(discordProperties.getToken())
                .setShardsTotal(discordProperties.getTotalShards())
                .setAudioSendFactory(new NativeAudioSendFactory())
                .setMemberCachePolicy(MemberCachePolicy.VOICE)
                .disableCache(EnumSet.of(CacheFlag.ACTIVITY,
                        CacheFlag.EMOTE,
                        CacheFlag.CLIENT_STATUS))
                .addEventListeners(new VoiceEventListener())
                .build();
    }

}
