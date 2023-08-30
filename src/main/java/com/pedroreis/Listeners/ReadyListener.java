package com.pedroreis.Listeners;

import com.pedroreis.Database.Database;
import com.pedroreis.Database.providers.MySQL;
import com.pedroreis.Main;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import static net.dv8tion.jda.api.interactions.commands.OptionType.STRING;

public class ReadyListener implements EventListener {


    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof ReadyEvent) {
            System.out.println("[BOT] Bot is ready!" + "\n" + "Guilds:" + ((ReadyEvent) event).getGuildTotalCount());
            event.getJDA().getPresence().setActivity(Activity.playing("FLAME"));

            CommandListUpdateAction commands = event.getJDA().updateCommands();

            commands.addCommands(
                    Commands.slash("say", "Faça o bot dizer algo")
                            .addOption(STRING, "content", "O que vc quer dizer", true)
            );


        }
    }
}
