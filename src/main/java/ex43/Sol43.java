/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Douglas Glover
 */
package ex43;
import java.io.File;
import java.util.Scanner;

public class Sol43 {
    static Scanner in = new Scanner(System.in);
    static Website web = new Website();
    public static void main(String[] args) {
        Sol43 app = new Sol43();
        //prompt for site name
        String name = app.promptString("Site name: ");
        //prompt for author name
        String author = app.promptString("Author: ");
        //prompt folders
        boolean js = app.promptBoolean("Do you want a folder for JavaScript? ");
        boolean css = app.promptBoolean("Do you want a folder for CSS? ");
        //generate site
        File website = web.generateSite(name);
        //generate index
        web.generateIndex(website, name, author);
        //generate folders
        app.getFolders(website, js, css);
    }
    String promptString(String prompt)
    {
        System.out.print(prompt);
        return in.nextLine();
    }
    boolean promptBoolean(String prompt)
    {
        while(true) {
            System.out.print(prompt);
            String response = in.next();
            if(response.equals("Y") || response.equals("y"))
                return true;
            if(response.equals("N") || response.equals("n"))
                return false;
        }
    }
    void getFolders(File website, boolean js, boolean css)
    {
        if (js)
            web.generateFolder(website, "js");
        if (css)
            web.generateFolder(website, "css");
    }
}
