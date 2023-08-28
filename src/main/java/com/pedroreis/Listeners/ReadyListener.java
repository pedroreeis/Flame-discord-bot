package com.pedroreis.Listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ReadyListener implements EventListener {

    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault(args[0])
                .addEventListeners(new ReadyListener())
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.playing("FLAME"))
                .build();

        jda.awaitReady();
    }

    @Override
    public void onEvent(GenericEvent event) {
        if(event instanceof ReadyEvent) {
            System.out.println("[BOT] Bot is ready!");
        }
    }
}
