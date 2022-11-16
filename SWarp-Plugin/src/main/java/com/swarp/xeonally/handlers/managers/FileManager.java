package com.swarp.xeonally.handlers.managers;

import com.swarp.xeonally.SWarp;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;
import java.util.Set;

public class FileManager {

    private String path;
    private File file;
    private SWarp main;
    private YamlConfiguration config;

    public FileManager(String path) {
        this.path = path;
        this.main = SWarp.getPlugin(SWarp.class);
        this.file = new File(this.main.getDataFolder() + "/" + this.path);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void saveFile() {
        if (!(this.file.exists())) {
            try {
                this.file.createNewFile();
                this.config.save(this.file);
            } catch (Exception e) {return;}
        }
    }

    public void saveFolder() {
        if (!(this.file.exists())) {
            this.file.mkdir();
        }
    }

    public boolean delete() {
        return this.file.delete();
    }

    public void setHeader(String header) {
        this.config.options().header(header);
    }

    public void setString(String name, String value) {
        this.config.set(name, value);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public void set(String name, Object value) {
        this.config.set(name, value);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public void setList(String name, List<String> list) {
        this.config.set(name, list);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public String getString(String name) {
        return this.config.getString(name);
    }

    public Object get(String name) {
        return this.config.get(name);
    }

    public int getInt(String name) {
        return this.config.getInt(name);
    }

    public boolean isBoolean(String name) {
        return this.config.isBoolean(name);
    }

    public List getList(String name) {
        return this.config.getList(name);
    }

    public boolean contains(String name) {
        return this.config.contains(name);
    }

    public boolean isExists() {
        return this.file.exists();
    }

    public Set<String> getStrList(String name) {
        return this.config.getConfigurationSection(name).getKeys(false);
    }

}
