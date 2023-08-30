package com.pedroreis.Process;

import com.pedroreis.Database.Database;
import com.pedroreis.Listeners.ReadyListener;
import com.pedroreis.Main;
import com.pedroreis.Managers.GuildManager;
import com.pedroreis.Models.GuildModel;
import com.pedroreis.Utils.ClientConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuildProcess {

    private static Database database = Main.getMain().getDatabase();
    private static GuildManager manager = Main.getMain().getGuildManager();

    public static void loadGuilds() {
        try {
            PreparedStatement stm = database.getConnection().prepareStatement(
                    "select * from discordbot_guilds"
            );

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String serverId = rs.getString("serverId");
                String serverPrefix = rs.getString("serverPrefix");
                String serverChannel_announce = rs.getString("serverChannel_announce");
                String serverIdRoleAdd = rs.getString("serverIdRoleAdd");

                manager.createGuild(serverId, serverPrefix, serverChannel_announce, serverIdRoleAdd);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean containsGuildsSQL(String serverId) {
        try {
            PreparedStatement stm = database.getConnection().prepareStatement(
                    "select * from discordbot_guilds where serverId = ?"
            );
            stm.setString(1, serverId);
            return stm.executeQuery().next();
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void saveGuilds() {
        PreparedStatement stm;
        try {
            for(GuildModel guild : manager.guilds.values()) {
                if(containsGuildsSQL(guild.getServerId())) {
                    stm = database.getConnection().prepareStatement(
                            "update discordbot_guilds set serverPrefix = ?, serverChannel_announce = ?, serverIdRoleAdd = ? where serverId = ?"
                    );

                    stm.setString(1, guild.getServerPrefix());
                    stm.setString(2, guild.getServerChannel_announce());
                    stm.setString(3, guild.getServerIdRoleAdd());
                    stm.setString(4, guild.getServerId());

                    stm.executeUpdate();
                }else {
                    stm = database.getConnection().prepareStatement(
                            "insert into discordbot_guilds(serverId,serverPrefix,serverChannel_announce,serverIdRoleAdd) VALUES(?,?,?,?)"
                    );

                    stm.setString(1, guild.getServerId());
                    stm.setString(2, guild.getServerPrefix());
                    stm.setString(3, guild.getServerChannel_announce());
                    stm.setString(4, guild.getServerIdRoleAdd());

                    stm.executeUpdate();
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
