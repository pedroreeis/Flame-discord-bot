package com.pedroreis;

import com.pedroreis.Database.Database;
import com.pedroreis.Database.providers.MySQL;
import com.pedroreis.Managers.GuildManager;
import com.pedroreis.Managers.UserManager;
import com.pedroreis.Process.GuildProcess;
import com.pedroreis.Process.UserProcess;
import com.pedroreis.Utils.ClientConstructor;
import lombok.Getter;



public class Main {

    @Getter
    private static Main main;

    private static GuildManager guildManager;
    private static UserManager userManager;

    private static Database database;

    public static void main(String[] args) {

        database = new MySQL();
        database.open();

        new ClientConstructor("");

        guildManager = new GuildManager();
        userManager = new UserManager();

        /*GuildProcess.loadGuilds();
        UserProcess.loadUsers();*/
    }

    public Database getDatabase() {
        return database;
    }

    public GuildManager getGuildManager() {
        return guildManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}