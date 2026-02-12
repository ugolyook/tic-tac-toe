package com.sveta.impl;

import com.sveta.model.GameResultDto;

public interface FileImpl {
    void saveData(GameResultDto dto);
    GameResultDto readData();
}
