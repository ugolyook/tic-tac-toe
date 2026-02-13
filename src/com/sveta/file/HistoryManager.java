package com.sveta.file;

import java.io.*;
import java.util.*;

public class HistoryManager {
    public void updateFile(String fileName, List<String> newlines,int maxBlocks) throws IOException {
        List<String> lines = new ArrayList<>();

        File file = new File(fileName);

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        lines.addAll(newlines);

        int blockCount = countBlocks(lines);

        while (blockCount > maxBlocks) {
            removeFirstBlock(lines);
            blockCount--;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) {
            writer.write(l);
            writer.newLine();
        }
    }

    private int countBlocks(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            if (line.trim().equals("{"))
                count++;
        }
        return count;
    }

    private void removeFirstBlock(List<String> lines) {

        int start = -1;
        int end = -1;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).trim().equals("{")) {
                start = i;
                break;
            }
        }

        if (start == -1) return;

        for (int i = start; i < lines.size(); i++) {
            if (lines.get(i).trim().equals("}")) {
                end = i;
                break;
            }
        }

        if (end == -1) return;

        for (int i = end; i >= start; i--) {
            lines.remove(i);
        }
    }
}
