package com.solvd.itcompany.readtext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;


public class ReadTextFromFile {

    private static final Logger logger = LogManager.getLogger(ReadTextFromFile.class);

    public static void main(String[] args) throws IOException {
            String text = FileUtils.readFileToString(new File("/Users/parisamory/Desktop/ShortStory.txt"), ("UTF-8"));
            List<String> wordsArray = Arrays.asList(text.replaceAll("[,.]", "").split(" "));
            Map<String, Integer> wordCount = new HashMap<>();
            wordsArray.forEach(w -> { if(!wordCount.containsKey(w)) wordCount.put(w, 1); else wordCount.put(w, wordCount.get(w) + 1);});
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/parisamory/Desktop/Java" + "DuplicateWords.txt"));
            wordCount.forEach((word, count) -> { try { writer.write(word + ":" + count);} catch (IOException ex) { throw new RuntimeException(ex);}});
    }
}

