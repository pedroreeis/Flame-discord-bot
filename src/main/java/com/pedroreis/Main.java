package com.pedroreis;

import com.pedroreis.Database.Database;
import com.pedroreis.Database.providers.MySQL;
import com.pedroreis.Listeners.ReadyListener;
import com.pedroreis.Managers.GuildManager;
import com.pedroreis.Managers.UserManager;
import com.pedroreis.Process.GuildProcess;
import com.pedroreis.Process.UserProcess;
import lombok.Getter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


@Getter
public class Main {

    @Getter
    private static Main main;
    private static Database database;

    private static GuildManager guildManager;
    private static UserManager userManager;

    private GuildProcess guildProcess;
    private UserProcess userProcess;

    public static void main(String[] args) {

        new ReadyListener();

        database = new MySQL();
        database.open();

        guildManager = new GuildManager();
        userManager = new UserManager();

        GuildProcess.loadGuilds();
        UserProcess.loadUsers();
    }

    public Database getDatabase() {
        return database;
    }
}