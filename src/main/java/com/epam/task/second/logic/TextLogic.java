package com.epam.task.second.logic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public abstract class TextLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    public String replaceLetterInEachWordByCharacter(String text, int indexOfPosition, char character) {
        LOGGER.log(Level.INFO,"replaceLetterInEachWordByCharacter method started");
        List<String> words = toWords(text);
        for (String word : words) {
            try {
                word = replaceLetterInWordByCharacter(word, indexOfPosition, character);
            } catch (StringLogicException e) {
                LOGGER.log(Level.ERROR, "index of position > than length of a word," +
                        " so it is no replace in word: " + word);
            }
        }

        return concatenate(words);
    }

    public String concatenate(List<String> strings) {
        LOGGER.log(Level.INFO,"concatenate method started");
        String text = "";
        for (String string : strings) {
            text += string + " ";
        }
        return text.trim();
    }

    public List<String> toWords(String text) {
        LOGGER.log(Level.INFO,"toWords method started");
        String[] stringArray = text.split(" ");
        return Arrays.asList(stringArray);
    }

    abstract String replaceLetterInWordByCharacter(String word, int indexOfPosition, char character)
            throws StringLogicException;


    abstract String replaceWordsWithGivenLengthBySubstring(String text, int lengthOfWords, String substring);
}
