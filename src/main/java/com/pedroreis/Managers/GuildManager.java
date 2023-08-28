package com.pedroreis.Managers;

import com.pedroreis.Models.GuildModel;

import java.util.HashMap;

public class GuildManager {

    public HashMap<Character, GuildModel> guilds;

    public GuildManager() {
        this.guilds = new HashMap<>();
    }

    public GuildModel createGuild(Character serverId, Character serverPrefix, Character serverChannel_announce, Character serverIdRoleAdd) {
        GuildModel guild = new GuildModel(serverId, serverPrefix, serverChannel_announce, serverIdRoleAdd);
        this.guilds.put(serverId, guild);
        return guild;
    }

    public GuildModel getGuild(Character serverId) {
        if(this.guilds.containsKey(serverId)) {
            return this.guilds.get(serverId);
        }
        return null;
    }

    public GuildModel deleteGuild(Character serverId) {
        if(this.guilds.containsKey(serverId)) {
            return this.guilds.remove(serverId);
        }

        return null;
    }
}
