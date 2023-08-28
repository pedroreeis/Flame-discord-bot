package com.pedroreis.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class GuildModel {

    private Character serverId;
    private Character serverPrefix;
    private Character serverChannel_announce;
    private Character serverIdRoleAdd;
}
