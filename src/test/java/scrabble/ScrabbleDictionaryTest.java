package scrabble;

import dictionary.ScrabbleDictionary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleDictionaryTest {

    @Test
    public void isWord_fragment() {
        //given
       ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertFalse(dictionary.isWord("happ"));
    }

    @Test
    public void isWord_false() {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertFalse(dictionary.isWord("hapy"));
    }

    @Test
    public void isWord_true() {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when

        //then
        assertTrue(dictionary.isWord("ZOOGEOGRAPHICAL"));
    }

    @Test
    public void getDefinition() {
        //given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();

        //when
        String definition = dictionary.getDefinition("spaces");

        //then
        assertEquals("<space=v> [v]", definition);
    }



}