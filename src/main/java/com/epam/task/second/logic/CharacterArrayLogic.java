package com.epam.task.second.logic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CharacterArrayLogic extends TextLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String replaceLetterInWordByCharacter(String word, int indexOfPosition, char character)
            throws StringLogicException {
        LOGGER.log(Level.INFO,"replaceLetterInWordByCharacter method started");
        if (indexOfPosition >= word.length() || indexOfPosition < 0) {
            throw new StringLogicException("index of position > than length of a word or negative");
        }
        char[] chars = word.toCharArray();
        chars[indexOfPosition] = character;

        return String.valueOf(chars);
    }


    @Override
    public String replaceWordsWithGivenLengthBySubstring(String text, int lengthOfWords, String substring) {
        LOGGER.log(Level.INFO,"replaceWordsWithGivenLengthBySubstring method started");
        List<String> words = toWords(text);
        for (String word : words) {
            char[] charsInWord = word.toCharArray();
            if (charsInWord.length == lengthOfWords) {
                int index = words.indexOf(word);
                charsInWord = substring.toCharArray();
                String newWord = String.valueOf(charsInWord);
                words.set(index, newWord);
            }

        }
        return concatenate(words);
    }
}
