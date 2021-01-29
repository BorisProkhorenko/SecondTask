import com.epam.task.second.logic.PyreStringLogic;
import com.epam.task.second.logic.StringLogicException;
import org.junit.Assert;
import org.junit.Test;

public class testPyreStringLogic {

    private static final PyreStringLogic STRING_LOGIC = new PyreStringLogic();

    @Test
    public void testReplaceLetterInWordByCharacterWhenIndexOfPositionLessThanWordLength()
            throws StringLogicException {
        //given
        String word = "Hello!";
        int indexOfPosition = 4;
        char character = 'a';
        String expected = "Hella!";

        //when
        String actual = STRING_LOGIC.replaceLetterInWordByCharacter(word, indexOfPosition, character);

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = StringLogicException.class)
    public void testReplaceLetterInWordByCharacterWhenIndexOfPositionMoreThanWordLength()
            throws StringLogicException {
        //given
        String word = "Hello!";
        int indexOfPosition = 6;
        char character = 'a';

        //when
        String actual = STRING_LOGIC.replaceLetterInWordByCharacter(word, indexOfPosition, character);

    }

    @Test(expected = StringLogicException.class)
    public void testReplaceLetterInWordByCharacterWhenIndexOfPositionIsNegative()
            throws StringLogicException {
        //given
        String word = "Hello!";
        int indexOfPosition = -6;
        char character = 'a';

        //when
        String actual = STRING_LOGIC.replaceLetterInWordByCharacter(word, indexOfPosition, character);

    }

    @Test
    public void testReplaceWordsWithGivenLengthBySubstring() {
        //given
        String text = "Hello world! I like writing Java programs";
        int lengthOfWords = 4;
        String substring = "test";
        String expected = "Hello world! I test writing test programs";

        //when
        String actual = STRING_LOGIC.replaceWordsWithGivenLengthBySubstring(text, lengthOfWords, substring);

        //given
        Assert.assertEquals(actual, expected);
    }
}
