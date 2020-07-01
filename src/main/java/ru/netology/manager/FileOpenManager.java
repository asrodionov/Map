package ru.netology.manager;

import java.util.*;

public class FileOpenManager {

    Map<String, String> applications = new HashMap<>();

    public void add(String key, String value) {
        applications.put(key, value);
    }

    public Map<String, String> getAll() {

        Map<String, String> tmp = new HashMap<>();

        for (Map.Entry<String, String> application : applications.entrySet()) {
            tmp.put(application.getKey().toLowerCase(), application.getValue());
        }
        return tmp;
    }

    public String getApplicationByExpansion(String expansion) {

        for (Map.Entry<String, String> application : applications.entrySet())
            if (application.getKey().equals(expansion)) {
                return application.getValue();
            }
        return null;
    }

    public void unregisteredApplication(String expansion) {

        applications.entrySet().removeIf(application -> application.getKey().equals(expansion));
    }

    public Set<String> getApplicationList() {

        Set<String> names = new HashSet<>();

        for (Map.Entry<String, String> application : applications.entrySet()) {
            names.add(application.getValue());
        }
        return names;
    }

    public Set<String> getExtensionList() {

        Set<String> extension = new HashSet<>();

        for (Map.Entry<String, String> application : applications.entrySet()) {
            extension.add(application.getKey().toLowerCase());
        }
        return extension;
    }
}
