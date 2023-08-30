package com.pedroreis.Managers;

import com.pedroreis.Models.GuildModel;

import java.util.HashMap;

public class GuildManager {

    public HashMap<String, GuildModel> guilds;

    public GuildManager() {
        this.guilds = new HashMap<>();
    }

    public GuildModel createGuild(String serverId, String serverPrefix, String serverChannel_announce, String serverIdRoleAdd) {
        GuildModel guild = new GuildModel(serverId, serverPrefix, serverChannel_announce, serverIdRoleAdd);
        this.guilds.put(serverId, guild);
        return guild;
    }

    public GuildModel getGuild(String serverId) {
        if(this.guilds.containsKey(serverId)) {
            return this.guilds.get(serverId);
        }
        return null;
    }

    public GuildModel deleteGuild(String serverId) {
        if(this.guilds.containsKey(serverId)) {
            return this.guilds.remove(serverId);
        }

        return null;
    }
}
