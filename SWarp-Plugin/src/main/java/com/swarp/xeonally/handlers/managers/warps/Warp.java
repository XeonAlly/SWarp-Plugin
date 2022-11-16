package com.swarp.xeonally.handlers.managers.warps;

import com.swarp.xeonally.handlers.managers.configs.Config;
import org.bukkit.Location;

import java.util.Set;

public class Warp {

    private String _path = "warp-settings.";
    private Config file = new Config("warp.yml");

    public Warp() {
        file.saveConfig();
    }

    public void saveWarp(String name, Location location) {
        if (!file.find(_path + name + ".loc")) file.setObject(_path + name + ".loc", location);
    }

    public void deleteWarp(String name) {
        file.setObject(_path + name, null);
    }

    public boolean isWarp(String name) {
        return file.find(_path + name);
    }

    public void setLocation(String name, Location location) {
        file.setObject(_path + name + ".loc", location);
    }

    public Location getLocation(String name) {
        return (Location) file.getObject(_path + name + ".loc");
    }

    public Set<String> getWarps() {
        return file.getArrays("warp-settings");
    }

}
