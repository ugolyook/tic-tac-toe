package com.sveta.file;

import com.sveta.model.GameResultDto;

import java.io.*;
import java.util.*;

public class HistoryManager {

    public List<GameResultDto> update(List<GameResultDto> list,
                                      GameResultDto newGame,
                                      int maxSize) {

        List<GameResultDto> result = new ArrayList<>(list);
        result.add(newGame);

        while (result.size() > maxSize) {
            result.remove(0);
        }

        return result;
    }
}
