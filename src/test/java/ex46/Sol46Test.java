package ex46;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Sol46Test {
    Sol46 app = new Sol46();
    @Test
    void getHistogram_correctly_organizes_data() {
        ArrayList<Sol46.WordData> wordList = new ArrayList<>();
        Sol46.WordData newWord = new Sol46.WordData();
        newWord.word = "badger";
        newWord.wordCount = 7;
        wordList.add(newWord);
        String results = app.getHistogram(wordList);

        String expected = """
        badger:    *******
        """;
        assertEquals(expected, results);
    }

    @Test
    void countWords_organizes_input_as_list_of_wordData()
    {
        ArrayList<Sol46.WordData> expected = new ArrayList<>();
        Sol46.WordData newWord = new Sol46.WordData();
        newWord.word = "badger";
        newWord.wordCount = 5;
        expected.add(newWord);

        String input = "badger badger badger badger badger";
        ArrayList<Sol46.WordData> results = app.countWords(input);
        assertEquals(expected.get(0).wordCount, results.get(0).wordCount);
    }

}