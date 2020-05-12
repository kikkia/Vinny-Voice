package com.voice.event;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VoiceEventListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Started shard " + event.getJDA().getShardInfo().getShardId() +
                " over " + event.getGuildTotalCount() + " guilds");
    }

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        System.out.println("got voice leave event");
    }

    @Override
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        System.out.println("got voice move event");
    }

}
