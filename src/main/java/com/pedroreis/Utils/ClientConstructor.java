package com.pedroreis.Utils;

import com.pedroreis.Listeners.ReadyListener;
import com.pedroreis.Listeners.ShutdownListener;
import com.pedroreis.Listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class ClientConstructor {


    private static String token;
    private static JDA client;
    public ClientConstructor(String token) {
        this.token = token;

        this.client = JDABuilder.createDefault(token)
                .addEventListeners(new ReadyListener())
                .addEventListeners(new ShutdownListener())
                .addEventListeners(new SlashCommandListener())
                .setBulkDeleteSplittingEnabled(false).build();
    }

    public JDA getClient() {
        return client;
    }

    public String getToken() {
        return token;
    }
}
