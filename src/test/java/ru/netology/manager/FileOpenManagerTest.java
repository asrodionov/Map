package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileOpenManagerTest {

    private FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    public void setUp() {
        manager.add(".html", "Google Chrome");
        manager.add(".rar", "Win Rar");
        manager.add(".psd", "Adobe Photoshop");
        manager.add(".PSD", "Adobe Photoshop");
    }

    @Test
    public void shouldAddAndGetMapApplication() {
        Map<String, String> expected = new HashMap<>();

        expected.put(".html", "Google Chrome");
        expected.put(".rar", "Win Rar");
        expected.put(".psd", "Adobe Photoshop");

        Map<String, String> actual = manager.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApplicationName() {

        String expected = "Adobe Photoshop";
        String actual = manager.getApplicationByExpansion(".psd");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldUnregisterApplication() {
        Map<String, String> expected = new HashMap<>();

        expected.put(".html", "Google Chrome");
        expected.put(".psd", "Adobe Photoshop");

        manager.unregisteredApplication(".rar");

        Map<String, String> actual = manager.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApplicationList() {
        Set<String> expected = new HashSet<>();

        expected.add("Adobe Photoshop");
        expected.add("Google Chrome");
        expected.add("Win Rar");

        Set<String> actual = manager.getApplicationList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetExtensionList() {
        Set<String> expected = new HashSet<>();

        expected.add(".html");
        expected.add(".rar");
        expected.add(".psd");

        Set<String> actual = manager.getExtensionList();

        assertEquals(expected, actual);
    }
}