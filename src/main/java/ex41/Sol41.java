/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex41;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Sol41 {
    public static void main(String[] args) {
        Sol41 app = new Sol41();
        //get input
        File file = new File("input/exercise41_input.txt");
        //convert to a list of strings
        ArrayList<String> people = app.readFile(file);
        //reorder this list to alphabetical order
        app.sortPeople(people);
        //print new list to file
        app.outputPeople(people);
    }
    ArrayList<String> readFile(File input)
    {
        ArrayList<String> people = new ArrayList<>();
        String fullName;
        //read string from file one at a time
        try {
            Scanner sc = new Scanner(input);
            while(sc.hasNextLine()) {
                fullName = sc.nextLine();
                people.add(fullName);
            }
            return people;
        }
        catch(Exception e)
        {
            System.out.print("File not found.");
            System.exit(-1);
            return null;
        }
    }
    void sortPeople(ArrayList<String> people)
    {
        //sort by last name
        Collections.sort(people);
    }
    void outputPeople(ArrayList<String> people)
    {
        //organize message as table
        String message;
        int size = people.size();
        message = String.format("""
        Total of %d names
        -----------------
        """, size);
        for(String person : people) {
            message = message.concat(person + "\n");
        }
        //output file
        try {
            File output = new File("output/exercise41_output.txt");
            FileWriter myWriter = new FileWriter(output);
            myWriter.write(message);
            myWriter.close();
        }
        catch(Exception e) {
            System.out.print("Output failed.");
            System.exit(-1);
        }
        //System.out.println(message);
    }
}
