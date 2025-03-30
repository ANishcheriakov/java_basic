package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для (де)сериализации University в JSON-файлы.
 */
public class JsonManager {

    // Можно при желании настроить Gson (например, добавить адаптеры).
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Сериализовать University в строку JSON.
     */
    public static String toJson(University university) {
        return gson.toJson(university);
    }

    /**
     * Десериализовать University из строки JSON.
     */
    public static University fromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    /**
     * Записать University в файл (JSON).
     */
    public static void writeToFile(University university, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Прочитать University из JSON-файла.
     */
    public static University readFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
