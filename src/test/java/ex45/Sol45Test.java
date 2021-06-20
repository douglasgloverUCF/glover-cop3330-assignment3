package ex45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol45Test {
    Sol45 app = new Sol45();
    @Test
    void replace_returns_string_with_words_replaced() {
        String input = """
        One should never utilize the word "utilize" in writing. Use "use" instead.
        For example, "She uses an IDE to write her Java programs" instead of "She
        utilizes an IDE to write her Java programs".
        """;
        String result = app.replace(input, "utilize", "use");
        String expected = """
        One should never use the word "use" in writing. Use "use" instead.
        For example, "She uses an IDE to write her Java programs" instead of "She
        uses an IDE to write her Java programs".
        """;
        assertEquals(expected, result);
    }
}