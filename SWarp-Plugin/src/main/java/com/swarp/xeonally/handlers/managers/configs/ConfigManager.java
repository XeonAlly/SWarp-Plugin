package com.swarp.xeonally.handlers.managers.configs;

import com.swarp.xeonally.handlers.managers.configs.impl.MainConfig;
import com.swarp.xeonally.handlers.managers.configs.impl.WarpConfig;

import java.util.ArrayList;

public class ConfigManager {

    private ArrayList<Config> configs = new ArrayList<>();

    public ConfigManager() {
        addConfig(new MainConfig("config.yml"));
        addConfig(new WarpConfig("warp.yml"));
    }

    private void addConfig(Config config) {
        configs.add(config);
    }

}
