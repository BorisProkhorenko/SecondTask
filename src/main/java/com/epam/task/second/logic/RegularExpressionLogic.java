package com.epam.task.second.logic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionLogic extends TextLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String replaceLetterInWordByCharacter(String word, int indexOfPosition, char character)
            throws StringLogicException {
        LOGGER.log(Level.INFO,"replaceLetterInWordByCharacter method started");
        if (indexOfPosition >= word.length() || indexOfPosition < 0) {
            throw new StringLogicException("index of position > than length of a word or negative");
        }

        String indexExpression = ".{" + --indexOfPosition + "}.";
        Pattern pattern = Pattern.compile(indexExpression);
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            int expressionLastCharacterIndex = matcher.end();
            char oldCharacter = word.charAt(expressionLastCharacterIndex);
            return word.replace(oldCharacter, character);
        } else {
            throw new StringLogicException("Incorrect regular exception in body of this method");
        }
    }

    @Override
    public String replaceWordsWithGivenLengthBySubstring(String text, int lengthOfWords, String substring) {
        LOGGER.log(Level.INFO,"replaceWordsWithGivenLengthBySubstring method started");
        List<String> words = toWords(text);
        String lengthExpression = ".{" + lengthOfWords + "}.{0}";
        for (String word : words) {
            if (Pattern.matches(lengthExpression, word)) {
                int index = words.indexOf(word);
                words.set(index, substring);
            }
        }
        return concatenate(words);
    }

}
