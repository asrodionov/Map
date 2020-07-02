package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    public void shouldGetApplicationForName() {

        String expected = "Adobe Photoshop";
        String actual = manager.getApplicationByExpansion(".psd");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldUnregisterApplication() {
        List<String> expected = new ArrayList<>();

        expected.add("Adobe Photoshop");
        expected.add("Google Chrome");

        manager.unregisteredApplication(".rar");

        List<String> actual = manager.getApplicationList();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApplicationList() {
        List<String> expected = new ArrayList<>();

        expected.add("Adobe Photoshop");
        expected.add("Google Chrome");
        expected.add("Win Rar");

        List<String> actual = manager.getApplicationList();

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