package com.swarp.xeonally.handlers.managers.configs;

import com.swarp.xeonally.handlers.managers.FileManager;

import java.util.List;
import java.util.Set;

public class Config {

    private FileManager file;

    public Config(String path) {
        file = new FileManager(path);
    }

    public void saveConfig() {
        file.saveFile();
    }

    public boolean deleteConfig() {
        return file.delete();
    }

    public void setObject(String _path, Object _obj) {
        file.set(_path, _obj);
    }

    public void setString(String _path, String _str) {
        file.setString(_path, _str);
    }

    public void setInt(String _path, int _int) {
        file.set(_path, _int);
    }

    public void setList(String _path, List _list) {
        file.setList(_path, _list);
    }

    public Object getObject(String _path) {
        return file.get(_path);
    }

    public String getString(String _path) {
        return file.getString(_path);
    }

    public int getInt(String _path) {
        return file.getInt(_path);
    }

    public List getList(String _path) {
        return file.getList(_path);
    }

    public Set<String> getArrays(String _path) {
        return file.getStrList(_path);
    }

    public boolean isBoolean(String _path) {
        return file.isBoolean(_path);
    }

    public boolean find(String _path) {
        return file.contains(_path);
    }

}
