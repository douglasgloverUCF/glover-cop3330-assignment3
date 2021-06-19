package ex41;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Sol41Test {
    Sol41 app = new Sol41();
    @Test
    void readFile_correctly_breaks_file_into_string_arraylist() {
        File input = new File("input/exercise41_input.txt");
        ArrayList<String> results = app.readFile(input);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Ling, Mai");
        expected.add("Johnson, Jim");
        expected.add("Zarnecki, Sabrina");
        expected.add("Jones, Chris");
        expected.add("Jones, Aaron");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");
        assertEquals(expected, results);
    }

    @Test
    void sortPeople_correctly_sorts_alphabetically() {
        ArrayList<String> results = new ArrayList<>();
        results.add("Ling, Mai");
        results.add("Johnson, Jim");
        results.add("Zarnecki, Sabrina");
        results.add("Jones, Chris");
        results.add("Jones, Aaron");
        results.add("Swift, Geoffrey");
        results.add("Xiong, Fong");
        app.sortPeople(results);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Johnson, Jim");
        expected.add("Jones, Aaron");
        expected.add("Jones, Chris");
        expected.add("Ling, Mai");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");
        expected.add("Zarnecki, Sabrina");
        assertEquals(expected, results);
    }
}