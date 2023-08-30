package com.pedroreis.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class GuildModel {

    private String serverId;
    private String serverPrefix;
    private String serverChannel_announce;
    private String serverIdRoleAdd;
}
