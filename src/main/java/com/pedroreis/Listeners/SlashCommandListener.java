package com.pedroreis.Listeners;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getGuild() == null) return;

        switch (event.getName()) {
            case "say":
                say(event, event.getOption("content").getAsString());
                break;
            default:
                event.reply("Eu não posso responder nada agora :(").setEphemeral(true).queue();
        }
    }

    private void say(SlashCommandInteractionEvent event, String content) {
        event.reply(content).queue();
    }
}
