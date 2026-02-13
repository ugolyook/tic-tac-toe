package com.sveta.file;

import com.sveta.model.GameResultDto;

import java.util.List;

public interface FileManager {
    void saveData(GameResultDto dto);
    List<GameResultDto> readData();
}
