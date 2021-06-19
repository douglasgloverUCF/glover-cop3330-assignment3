package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {
    Website web = new Website();
    @Test
    void generateSite_returns_correct_file_path() {
        File expected = new File("output/website/awesomeco");
        File results = web.generateSite("awesomeco");
        assertEquals(expected, results);
    }
    @Test
    void generateIndex_returns_correct_file_path() {
        File website = new File("output/website/awesomeco");
        File expected = new File("output/website/awesomeco/index.html");
        File results = web.generateIndex(website, "awesomeco", "Max Power");
        assertEquals(expected, results);
    }
    @Test
    void generateHtml_returns_correct_string() {
        String expected = """
        <!DOCTYPE html>
        <html>
            <title>
                awesomeco
            </title>
            <meta name = "author" content = "Max Power"/>
        </html>
        """;
        String results = web.generateHtml("awesomeco", "Max Power");
        assertEquals(expected, results);
    }
    @Test
    void generateFolder_returns_correct_file_path() {
        File website = new File("output/website/awesomeco");
        File expected = new File("output/website/awesomeco/js");
        File results = web.generateFolder(website, "js");
        assertEquals(expected, results);
    }
}