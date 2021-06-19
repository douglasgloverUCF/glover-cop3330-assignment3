/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex42;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sol42 {
    static class Person {
        String lName;
        String fName;
        int salary = 0;
    }
    public static void main(String[] args) {
        Sol42 app = new Sol42();
        //get input
        File file = new File("input/exercise42_input.txt");
        //convert to a list of Persons with names and salaries
        ArrayList<Person> people = app.readFile(file);
        //convert to table
        String table = app.makeTable(people);
        //output as file
        app.outputMessage(table);
    }
    ArrayList<Person> readFile(File input)
    {
        //read and output file as arraylist of persons
        ArrayList<Person> people = new  ArrayList<>();
        String line;
        String[] lineSplit;
        Person newPerson;
        try {
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine())
            {
                line = sc.nextLine();
                lineSplit = line.split(",");
                newPerson = new Person();
                newPerson.lName = lineSplit[0];
                newPerson.fName = lineSplit[1];
                newPerson.salary = Integer.parseInt(lineSplit[2]);
                people.add(newPerson);
            }
        }
        catch (Exception e)
        {
            System.out.print("File error.");
            System.exit(-1);
        }
        return people;
    }
    String makeTable(ArrayList<Person> people)
    {
        //convert people data into a table
        String table;
        String tableLine;
        table = """
        Last      First     Salary
        --------------------------
        """;
        for(Person person : people)
        {
            tableLine = String.format("%-9s %-9s %d\n", person.lName, person.fName, person.salary);
            table = table.concat(tableLine);
        }
        return table;
    }
    void outputMessage(String message)
    {
        //output file
        try {
            File output = new File("output/exercise42_output.txt");
            FileWriter myWriter = new FileWriter(output);
            myWriter.write(message);
            myWriter.close();
        }
        catch(Exception e) {
            System.out.print("Output failed.");
            System.exit(-1);
        }
        //System.out.print(message);
    }
}
