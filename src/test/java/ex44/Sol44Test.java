package ex44;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Sol44Test {
    Sol44 app = new Sol44();
    @Test
    void getData_correctly_extracts_from_json() {
        ArrayList<Sol44.Product> expected = new ArrayList<>();
        Sol44.Product product = new Sol44.Product();
        product.name = "Widget";
        expected.add(product);
        ArrayList<Sol44.Product> results = app.getData();
        assertEquals(expected.get(0).name, results.get(0).name);
    }
}