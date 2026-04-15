package com.solvd.railway.utils;

import com.solvd.railway.enums.Keyword;
import com.solvd.railway.generics.Printer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class KeywordCounter {

    private static final Printer<String> logsPrinter = new Printer<>();

    public void countKeywords(File inputFile, File outputFile) throws IOException {
        String text = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
        text = StringUtils.lowerCase(text);

        String[] words = StringUtils.split(text, " ,.!?;:-\n\r\t");
        StringBuilder result = new StringBuilder();

        for (Keyword keyword : Keyword.values()) {
            int count = 0;
            String keywordText = keyword.name().toLowerCase();

            if (words != null) {
                for (String word : words) {
                    if (word.equals(keywordText)) {
                        count++;
                    }
                }
            }

            String line = keywordText + ": " + count;
            logsPrinter.info(line);
            result.append(line).append("\n");
        }



        FileUtils.writeStringToFile(outputFile, result.toString(), StandardCharsets.UTF_8, true);
    }
}
