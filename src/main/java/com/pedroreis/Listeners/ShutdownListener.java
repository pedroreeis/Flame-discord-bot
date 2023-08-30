package com.pedroreis.Listeners;

import com.pedroreis.Process.GuildProcess;
import com.pedroreis.Process.UserProcess;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ShutdownListener implements EventListener {
    @Override
    public void onEvent(GenericEvent event) {
        if(event instanceof ShutdownEvent) {
            GuildProcess.saveGuilds();
            UserProcess.saveUsers();
        }
    }
}
