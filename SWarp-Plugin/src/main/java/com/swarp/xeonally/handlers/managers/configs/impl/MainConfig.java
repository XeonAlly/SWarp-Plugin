package com.swarp.xeonally.handlers.managers.configs.impl;

import com.swarp.xeonally.handlers.managers.configs.Config;

public class MainConfig extends Config {

    private String _path = "config-settings.";

    public MainConfig(String path) {
        super(path);

        saveConfig();

        if (!find(_path + "systems.prefix")) setString(_path + "systems.prefix", "&a[워프시스템] &r&f");
    }
}
