package ru.netology.manager;

import java.util.*;

public class FileOpenManager {

    Map<String, String> applications = new HashMap<>();

    public void add(String key, String value) {
        applications.put(key.toLowerCase(), value);
    }

    public String getApplicationByExpansion(String expansion) {

        return applications.get(expansion.toLowerCase());
    }

    public void unregisteredApplication(String expansion) {

        applications.remove(expansion.toLowerCase());
    }

    public List<String> getApplicationList() {

        List<String> apps = new ArrayList<>(applications.values());
        Collections.sort(apps);
        return apps;
    }

    public Set<String> getExtensionList() {

        return applications.keySet();
    }
}
