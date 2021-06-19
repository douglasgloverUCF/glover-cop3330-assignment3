package ex42;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Sol42Test {
    Sol42 app = new Sol42();
    @Test
    void makeTable_returns_correctly_formatted_string() {
        ArrayList<Sol42.Person> input = new ArrayList<>();

        Sol42.Person person = new Sol42.Person();
        person.lName = "Ling";
        person.fName = "Mai";
        person.salary = 55900;
        input.add(person);

        String results = app.makeTable(input);
        String expected = """
        Last      First     Salary
        --------------------------
        Ling      Mai       55900
        """;
        assertEquals(expected, results);
    }
}