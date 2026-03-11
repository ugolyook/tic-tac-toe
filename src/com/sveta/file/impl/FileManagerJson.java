package com.sveta.file.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sveta.file.FileManager;
import com.sveta.file.HistoryManager;
import com.sveta.model.GameResultDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerJson implements FileManager {

    public static final String FILE_NAME = "game_data.json";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public void saveData(GameResultDto dto) {
        System.out.println("\nStart saving game (JSON)...");

        List<GameResultDto> games = readData();
        if (games == null) {
            games = new ArrayList<>();
        }

        HistoryManager history = new HistoryManager();
        games = history.update(games, dto, 10);

        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(games, writer);
            System.out.println("Game successfully saved!");
        } catch (IOException e) {
            System.out.println("Error saving JSON: " + e.getMessage());
        }
    }

    @Override
    public List<GameResultDto> readData() {
        System.out.println("Start reading JSON...");

        try (Reader reader = new FileReader(FILE_NAME)) {
            GameResultDto[] dto = gson.fromJson(reader, GameResultDto[].class);

            if (dto == null) {
                return new ArrayList<>();
            }

            System.out.println("JSON successfully read!");
            return new ArrayList<>(List.of(dto));
        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
