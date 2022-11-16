package com.swarp.xeonally;

import com.swarp.xeonally.handlers.cmds.WarpCommand;
import com.swarp.xeonally.handlers.events.EventManager;
import com.swarp.xeonally.handlers.managers.configs.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SWarp extends JavaPlugin {

    private ConfigManager configManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {

        configManager = new ConfigManager();
        eventManager = new EventManager();

        getCommand("워프추가").setExecutor(new WarpCommand());
        getCommand("워프삭제").setExecutor(new WarpCommand());

    }

    @Override
    public void onDisable() {

    }
}
