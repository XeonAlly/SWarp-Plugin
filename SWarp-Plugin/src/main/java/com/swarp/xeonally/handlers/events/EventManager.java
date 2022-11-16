package com.swarp.xeonally.handlers.events;

import com.swarp.xeonally.SWarp;
import com.swarp.xeonally.handlers.events.impl.EventInventory;
import com.swarp.xeonally.handlers.events.impl.EventNPCHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<Listener> events = new ArrayList<>();

    public EventManager() {
        addEvent(new EventInventory());
        addEvent(new EventNPCHandler());

        for (Listener l : events) {
            SWarp.getPlugin(SWarp.class).getServer().getPluginManager().registerEvents(l, SWarp.getPlugin(SWarp.class));
        }
    }

    private void addEvent(Listener listener) {
        events.add(listener);
    }

}
