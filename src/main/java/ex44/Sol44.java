/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Sol44 {
    static Sol44 app = new Sol44();
    static Scanner in = new Scanner(System.in);
    static class Product {
        String name;
        double price;
        int quantity;
    }
    public static void main(String[] args) {
        //convert data
        ArrayList<Product> products = app.getData();
        //prompt question
        Product product = app.getProduct(products);
        //print results
        app.printData(product);
    }
    ArrayList<Product> getData()
    {
        ArrayList<Product> products = new ArrayList<>();
        File input = new File("input/exercise44_input.json");
        Product newProduct;
        JsonElement json = null;
        try {
            json = JsonParser.parseReader(new FileReader(input));
        }
        catch (Exception e){
            System.out.print("File not found.");
            System.exit(-1);
        }
        JsonObject data = json.getAsJsonObject();
        JsonArray jsonArray = data.get("products").getAsJsonArray();
        for(JsonElement element : jsonArray)
        {
            JsonObject object = element.getAsJsonObject();
            newProduct = new Product();
            newProduct.name = object.get("name").getAsString();
            newProduct.price = object.get("price").getAsDouble();
            newProduct.quantity = object.get("quantity").getAsInt();
            products.add(newProduct);
        }
        return products;
    }
    Product getProduct(ArrayList<Product> products)
    {
        String input;
        while (true) {
            System.out.print("What is the product name? ");
            input = in.nextLine();
            for (Product product : products)
                if(input.equals(product.name))
                    return product;
            System.out.println("Sorry, that product was not found in our inventory.");
        }
    }
    void printData(Product product)
    {
        System.out.printf("""
        Name: %s
        Price: %.2f
        Quantity: %d
        """, product.name, product.price, product.quantity);
    }
}
